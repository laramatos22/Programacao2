public class Agenda {

	private Tarefa [] arr = new Tarefa [1000]; 
	private int n=0;  //numero de tarefas
	
	//private int numTasks, increment = 100;
	//private Tarefa[] compromissos = new Tarefa[increment];
	
	//VARIAVEIS
	//private int countTarefas = 0;
	//private Tarefa[] tarefas = new Tarefa[0];
	
	//---nova tarefa (cria uma nova tarefa a acrescenta-a ao array tarefas)
	public void novaTarefa (Tarefa task) {
		
		arr[n] = task;
		n++;
		
		if (!(n<2))
		{
			for (int i = 0; i < n-1; i++)
			{
				for (int j = i+1; j < n; j++)
				{
					if (arr[j].inicio.compareTo(arr[i].inicio) < 0)
					{
						Data tmp = arr[j].inicio();
						arr[j].inicio = arr[i].inicio;
						arr[i].inicio = tmp;
					}
				}
			}
		}
		
		//OUTRAS RESOLUÇÕES POSSÍVEIS
		
		//~ numTasks++;
		//~ if (numTasks > compromissos.length)
		//~ {
			//~ Tarefa[] temp = new Tarefa [compromissos.lenght + increment];
			//~ System.arraycopy(compromissos, 0, temp, 0, compromissos.length);
			//~ temp[compromissos.length] = tarefa;
			//~ compromissos = temp;
		//~ } else {
			//~ compromissos[numTasks-1] = tarefa;
		//~ }
		
		
		//~ Tarefa[] temp = new Tarefa [++countTarefas];
		//~ for (int i = 0; i < tarefas.length; i++)
		//~ {
			//~ if (tarefas.length == 0)
			//~ {
				//~ break;
			//~ } else {
				//~ temp[i] = tarefas[i];
			//~ }
		//~ }
		//~ temp[countTarefas - 1] = novaTarefa;
		//~ tarefas = temp;
		
	}
	
	//imprime o array de tarefas, usando o modulo tarefas
	public void escreve () {
		
		for (int i = 0; i < n; i++)
		{
			System.out.println(arr[i].toString());
		}
		
		//~ for (int i = 0; i < tarefas.length; i++)
		//~ {
			//~ tarefas[i].escreve();
		//~ } 		
		
	}
	
	public Agenda filtra (Data d1, Data d2) {
		Tarefa arrln[] = arr;
		Agenda array2 = new Agenda();
		
		for (int i = 0; i < n; i++)
		{
			if ((arrln[i].inicio.compareTo(d1) == 0) || ((arrln[i].fim.compareTo(d2) == 1) && (arrln[i].inicio.compareTo(d1)<=0)))
			{
				array2.novaTarefa(arr[i]);
				array2.n++;
			}
		}
		
		return array2;
		
	}
	
	//cria um array com as tarefas compreendidas entre as datas dadas pelo programa
	//~ public Tarefa[] compromissos (Data d1, Data d2) {
		//~ int count = 0;
		//~ for (int i = 0; j < 0; i < tarefas.length; i++)
		//~ {
			//~ if (tarefas[i].inicio().maiorDoQue(d1) && tarefas[i].inicio.menorDoQue(d2))
			//~ {
				//~ count++;
			//~ }
		//~ }
		
		//~ Tarefa[] compromissos = new Tarefa[count];
		//~ for (int i = 0; j < 0; i < tarefas.length; i++)
		//~ {
			//~ if (tarefas[i].inicio().maiorDoQue(d1) && tarefas[i].inicio.menorDoQue(d2))
			//~ {
				//~ compromissos[j++] = tarefas[i];
			//~ }
		//~ }
		//~ return compromissos;
		
	//~ }

}
