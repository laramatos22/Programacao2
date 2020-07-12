/**
 * Uma estrutura de dados baseada numa fila, mas em que só ficam
 * armazenados os últimos N números inseridos.
 * Quando a fila está preenchida (N elementos) a inserção de um novo número
 * implica a saída do primeiro (que deixa de existir).
 */

public class LeakyQueue
{
	//ATRIBUTOS
	
	//Numero de elementos da fila
	private int size=0;
	
	//Array para armazenar os elementos
	private double[] array;
	
	//CONSTRUTOR
	public LeakyQueue(int N) {
		//O tamanho do array é igual ao numero de elementos introduzidos
		array = new double[N];
	}
	
	//MÉTODOS
	
	//isFull: indica se a fila está cheia
	//Para isso, o numero de elementos (size) é igual ao comprimento do array
	public boolean isFull() {
		return size == array.length;
	}
	
	//isEmpty(): verifica se a fila está vazia
	//Para isso, nao pode ter elementos
	public boolean isEmpty() {
		return size == 0;
	}
	
	//size(): return do tamanho atual da fila
	public int size() {
		return size;
	}
	
	//in(): inserir o elemento no final da fila
	public void in (double n) {
		if (!isFull())
		{
			size++;
			System.arraycopy(array, 0, array, 1, array.length-1);
			array[0] = n;
		} else
		{
			System.arraycopy(array, 0, array, 1, array.length-1);
			array[0] = n;
		}
	}
	
	//out(): retira um elemento do inicio da fila
	public void out() {
		//asserção: a lista nao pode estar vazia
		assert !isEmpty();
		//diminui o numero de elementos de size
		size--;
	}
	
	//minimum(): return do valor minimo de todos os argumentos/elmentos do array
	public double minimum() {
		//asserção: a fila nao pode estar vazia
		assert !isEmpty();
		
		//variavel min inicializada no 1º elemento do array array[0]
		double min = array[0];
		
		//Percorrer todos os elementos do array
		for (int i = 0; i < size; i++)
		{
			//Caso haja algum valor em array[i] que seja menor q o q está em mim
			if(array[i] < min) 
				//min toma esse valor array[i]
				min = array[i];
		}
		return min;
	}
	
	//print(): print dos elementos
	public void print() {
		//assert !isEmpty();
		for (int i = size-1; i >= 0; i--)
		{
			System.out.printf("%4.1f", array[i]);
		}
		
	}
	
}

