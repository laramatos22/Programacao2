/*ContainerStack que implementa uma pilha de contentores usando um vector (array) de
dimensão fixa.*/

//NMEC: 95228
//NOME: Lara Catarina da Silva Matos
import static java.lang.System.*;

public class ContainerStack {
  private Container[] array;
  private int size;  
  
  public ContainerStack(int maxSize) {
    assert maxSize >= 0;
    array = new Container[maxSize];
    //size = 0;
    assert isEmpty();
  }
  
  public void push(Container e) {
    assert !isFull();
    array[size] = e;
    size++;
    e.incrementOps();
    assert !isEmpty() && top() == e;
  }
  
  public void pop() {
    assert !isEmpty();
    --size;
    array[size] = null;
    assert !isFull();
  }
  
  public Container top() {
    assert !isEmpty();
    return array[size-1];
  }
  
  public boolean isEmpty() { return size==0; }
  
  public boolean isFull() { return size==array.length; }
  
  public int size() { return size; }
  
  public void clear() {
    size = 0;
    array = new Container[array.length];
    assert isEmpty();
  }
  
  /**
   * Search for a container with a given type of cargo.
   * @param type the type of cargo we're looking for
   * @return 0 if the desired container is on the top,
   *         1 if it is under 1 container, etc
   *        -1 if not found
   */
  public int search(String type) {
    for (int i = 0; i < size; i++) {
      if (array[size-1-i].contains(type)) return i;
    }
    return -1;
  }
  
  
  /**
   * Merge two sorted subvectors: a[start..middle[ with a[middle..end[
   */
  private static void mergeSubarrays(Container[] a,int start,int middle,int end) 
  {
    Container[] b = new Container[end-start];
    int i1 = start;
    int i2 = middle;
    int j = 0;
    while(i1 < middle && i2 < end) {
      if (a[i1].id < a[i2].id)
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

  //...
  
  /*Crie uma função toString() na classe ContainerStack que devolva uma string
representando os contentores da pilha, do mais antigo (bottom) ao mais recente
(top). Repare que a classe Container já tem um método análogo para representar
cada contentor.*/
  public String toString() {
	  String str = "";
	  for (int i = 0; i < size; i++)
	  {
		  str += array[i].toString();
		  if (i < size-1)
		  {
			  str += ",";
		  }
	  }
	  return str;	  
  }
  
  /*A classe ContainerStack já inclui uma função search(type) que procura um con-
tentor de certo tipo e devolve um inteiro que indica a sua posição relativa na pilha, a
contar do topo, ou −1 se não encontrar. Faça uma função equivalente searchRec(type)
que use um algoritmo recursivo. Pode ser necessário criar uma função auxiliar para
resolver o problema.*/
  public int searchRec (String type) {
	  return searchRec(type, array.length-1);
  }
	
		private int searchRec(String type, int i) {
			//Didn't find the container
			if (i < 0)
			{
				return -1;
			}
			
			if (array[i].contains(type))
			{
				return array.length -1 -i;
			}
			
			return searchRec(type, i-1);
		}

/*Implemente na classe ContainerStack um método estático sort(a, start, end)
que, dado um vector a e os limites start e end de um subvector, tal como usado nas
aulas, proceda à ordenação por fusão do vector. Para fundir subvectores ordenados,
pode usar a função mergeSubarrays(a, start, middle, end) já disponibilizada
na classe. Caso não consiga implementar a ordenação por fusão, pode obter metade
da cotação implementando outro algoritmo de ordenação.*/
  public void sort (Container[] a, int start, int end) {
	  if (end - start < 1)
	  {
		  int middle = (end + start) / 2;
		  sort(a, start, middle);
		  sort(a, middle, end);
		  mergeSubarrays(a, start, middle, end);
	  }
  }
  
  /*Implemente um método containersInStack() na classe ContainerStack que de-
volve um vector com todos os contentores da pilha, ordenados por ordem crescente
dos respetivos identificadores.*/
  public Container[] containersInStack() {
	  Container[] temp = new Container[array.length];
	  System.arraycopy(array, 0, temp, 0, size);
	  sort(temp, 0, temp,length);
	  return temp;
  }

}

