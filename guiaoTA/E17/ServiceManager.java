//CONJUNTOS DE SERVIÇOS COM BASE NUM VETOR DE INSTANCIAS DE ServiceQueue

import static java.lang.System.*;

public class ServiceManager
{

  public ServiceManager(String [] serviceNames, int maxSize) {

    this.maxSize = maxSize;

    services = new ServiceQueue[serviceNames.length];

    for(int i=0; i<serviceNames.length; i++) {
      services[i] = new ServiceQueue(serviceNames[i], maxSize);
      services[i].beingServed = null;
    }
  }

  // verifica se o nome de um serviço é válido
  public boolean validServiceName(String serviceName) {
    int s = findService(serviceName);
    return s<services.length;
  }

  // verifica se existe um ou mais clientes à espera
  // de atendimento num dado serviço
  public boolean clientPending(String serviceName) {

    int s = findService(serviceName);
    assert s<services.length;

    return clientPending(s);
  }

  private boolean clientPending(int s) {
    return services[s].clientPendingExcept(beingServed());
  }

  // Verifica se a fila de um serviço está cheia
  public boolean serviceFull(String serviceName) {
    int s = findService(serviceName);
    assert s<services.length;

    return services[s].isFull();
  }

  // clear service manager
  public void clear() {
    for(int s=0; s<services.length; s++) {
      services[s].clear();
      services[s].beingServed = null;
    }
    first = null;
  }

  // retorna o índice do serviço no vector de serviços;
  // caso o serviço não exista, retorna o comprimento do vector
  private int findService(String serviceName) {

    int i = 0;
    while ( i<services.length  &&
        !services[i].serviceName().equals(serviceName) ) 
      i++;
    return i;
  }

  // Lista dos clientes que estão a ser servidos nos vários serviços
  private String [] beingServed() {
    int nBeingServed = 0;

    for(int i=0; i<services.length; i++)
      if (services[i].beingServed!=null) nBeingServed++;
    String [] a = new String[nBeingServed];
    int n = 0;
    for(int i=0; i<services.length; i++) {
      if (services[i].beingServed!=null) {
        a[n] = services[i].beingServed;
        n++;
      }
    }
    return a;
  }

  // Acrescentar dados de um serviço ao histórico de serviços
  private void logServiceData(int index, String client, int time) {
    HistoryNode n = new HistoryNode();
    n.time = time;
    n.serviceIndex = index;
    n.client = client;
    n.next = first;
    first = n;
  }

  // verifica se uma cadeia de caracteres existe num vector
  private static boolean inStringArray(String x, String [] a) {
    for(int i=0; i<a.length; i++)
      if (a[i].equals(x)) return true;
    return false;
  }

  // funde dois subvectores ordenados
  private static void mergeSubarrays(String[] a,int start,int middle,int end) {
    String[] b = new String[end-start];
    int i1 = start;
    int i2 = middle;
    int j = 0;
    while(i1 < middle && i2 < end) {
      if (a[i1].compareTo(a[i2]) < 0)
        b[j++] = a[i1++];
      else
        b[j++] = a[i2++];
    }
    while(i1 < middle)
      b[j++] = a[i1++];
    while(i2 < end)
      b[j++] = a[i2++];
    arraycopy(b, 0, a, start, end-start);
  }
  
  //ATRIBUTOS
  
  //Array de serviços
  private ServiceQueue [] services;
  
  private int maxSize;

  private HistoryNode first = null;

  // ----------------- funções pedidas ------------------------

  //...
  
/*Implemente um método queueFor(clientName, serviceName) na classe Service
  Manager que, dado o nome de um cliente e o nome de um serviço, coloca o nome do
  cliente na fila desse serviço. Introduza as asserções (pré-condições, pós-condições ou
  outras) que entenda adequadas neste método.*/
  public void queueFor(String clientName, String serviceName) {
	  assert validServiceName(serviceName);
	  assert !serviceFull(serviceName);
	  services[findService(serviceName)].in(clientName);
  }
  
  /*Implemente um método serveNext(String serviceName) na classe ServiceManager
que actualize a estrutura de dados por forma a assinalar o inı́cio da prestação do
serviço serviceName ao próximo cliente, retirando-o da respectiva fila. Note, entre-
tanto, que um cliente pode estar em várias filas ao mesmo tempo, mas não pode ser
atendido ao mesmo tempo em dois ou mais serviços. Assim, se no momento em que
este método é chamado o primeiro cliente da fila estiver já a ser atendido noutro
serviço, ele é simplesmente retirado da fila. O mesmo se aplica ao segundo, etc. O
cliente a atender será o primeiro da fila que não esteja já a ser atendido em outro
serviço.*/
  public void serveNext(String serviceName) {
	  
	  //Fila de serviços
	  ServiceQueue queue = services[findService(serviceName)];
	  
	  String[] clients = beingServed(); //Lista de clientes que estão a ser servidos
	  boolean foundNext = false; //Encontrar o proximo cliente para ser servido
	  String nextClient = ""; //proximo cliente
	  while (!foundNext)
	  {
		  foundNext = true;
		  
		  //retorno do cliente que está no inicio da fila para ser atendido no serviço
		  nextClient = queue.peek();
		  
		  //retirar esse cliente do inicio da fila do serviço
		  queue.out();
		  
		  //Verificar se o cliente está a ser servido em mais algum serviço
		  for(String client : clients) {
			  if (client.equals(nextClient))
			  {
				  foundNext = false;
				  break;
			  }
		  }
	  }
	  queue.beingServed = nextClient;
  }
  
  /*Implemente um método endService(serviceName, time) na classe ServiceManager
que, dado o nome de um serviço terminado e o respectivo tempo de atendimento, reg-
iste a conclusão do serviço. Este método deve invocar o método logServiceData(
serviceIndex, client, time) que, dado o ı́ndice de um serviço, o nome de um
cliente e o tempo de atendimento, regista estas informações numa estrutura de
histórico.*/
  public void endService(String serviceName, int time) {
	  int index = findService(serviceName);
	  ServiceQueue queue = services[index];
	  logServiceData(index, queue.beingServed, time);
	  queue.beingServed = null;
  }
  
  /*Implemente um método maxServiceTime() na classe ServiceManager que devolva
o maior tempo de atendimento registado no histórico de serviços. O histórico está im-
plementado como uma lista ligada em que os nós são instâncias da classe HistoryNode,
já disponı́vel. O método logServiceData(...), já referido, acrescenta informação
a esta estrutura. Para cotação total, a implementação de maxServiceTime() deverá
ser recursiva.*/
  public int maxServiceTime() {
	  return maxServiceTime (first, -1);
  }
		
	  private int maxServiceTime(HistoryNode n, int max) {
		  if (n == null)
		  {
			  return max;
		  }
		  if (n.time > max)
		  {
			  max = n.time;
		  }
		  return maxServiceTime(n.next, max);
	  }
	  
  /*A função validServiceName(serviceName), já disponı́vel na classe ServiceManager,
verifica se uma dada cadeia de caracteres é um nome válido de um serviço. Im-
plemente uma função equivalente validServiceNameRec(serviceName) usando um
algoritmo recursivo. Se necessário, a sua solução pode incluir uma função auxiliar
além da função pedida.*/
  public boolean validServiceNameRec(String serviceName) {
	  return findServiceNameRec (serviceName, 0) < services.length;
  }
	 
	  private int findServiceNameRec (String serviceName, int index) {
		  if (index == services.length || services[index].serviceName().equals(serviceName))
		  {
			  return index;
		  }
		  return findServiceNameRec(serviceName, ++index);
	  }
  
  /*Implemente na classe ServiceManager um método estático sort(a, start, end)
que, dado um vector de cadeias de caracteres a e os limites start e end de um subvec-
tor, tal como usado nas aulas, proceda à ordenação por fusão do vector. Para fundir
subvectores ordenados, pode usar a função mergeSubarrays(a, start, middle,
end) já disponibilizada na classe. Caso não consiga implementar a ordenação por
fusão, pode obter metade da cotação implementando outro algoritmo de ordenação.*/
  private void sort (String[] a, int start, int end) {
	  if (end - start > 1)
	  {
		  int middle = (end + start) / 2;
		  sort(a, start, middle);
		  sort(a, middle, end);
		  mergeSubarrays(a, start, middle, end);
	  }
  }
  
  /*Implemente um método alphabeticalClientList(serviceName) na classe Service
Manager que, dado o nome de um serviço, devolve um vector ordenado alfabetica-
mente com os clientes presentemente na fila desse serviço*/
  public String[] alphabeticalClientList(String serviceName) {
	  //Lista de clientes
	  String[] a = services[findService(serviceName)].clientsInQueue();
	  
	  //Ordenação alfabética
	  sort(a, 0, a.length);
	  
	  //Return da lista dos nomes ordenados
	  return a;
  }

}

