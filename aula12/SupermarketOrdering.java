/*O supermercado DaEsquina aceita encomendas e faz as respectivas entregas ao domicı́lio.
O gerente decidiu instalar um sistema automático de processamento de encomendas que
permita, não só registar encomendas recebidas e dar baixa de encomendas entregues, mas
também saber em cada momento quantas unidades de cada produto estão pedidas. As
encomendas, representadas pela classe Order (disponibilizada em anexo), são processa-
das por ordem de chegada. Implemente assim uma classe SupermarketOrdering com os
seguintes métodos:*/

import p2utils.*;
import static java.lang.System.*;

public class SupermarketOrdering {
	
	private int numPedidos = 0;
	private Queue<Order> orders = new Queue<>();
	private HashTable<Integer> produtos = new HashTable<>(10);
	
	//enterOrder(order) - regista uma nova encomenda
	public void enterOrder(Order order) {
		
		//in(): insere um novo elmento (encomenda) na fila
		orders.in(order);
		
		//Aumento do numero de pedidos
		numPedidos++;
		
		//Se a hashTable nao contiver o nome do produto order.prodName que está pedido na encomenda
		if (!produtos.contains(order.prodName))
		{
			//set(): insere um novo elemento order.quantity associado à chave order.prodName
			produtos.set(order.prodName, order.quantity);
		} 
		
		else //caso já exista o produto order.prodName na hashTable
		{
			//set(): atualiza o elemento associado à chave order.prodName
			//Novo elemento da chave = número de produto já existentes + a nova quantidade inserida em 
			//						   order.quantity
			produtos.set(order.prodName, produtos.get(order.prodName) + order.quantity);
		}
	}
		
	//serveOrder() - dá baixa da encomenda mais antiga e devolve-a
	public Order serveOrder() {
		//peek(): retorno do elemento mais antigo (o que está no inicio da fila)
		Order servido = orders.peek();
		
		//Aualização da hashTable produtos
		//key: servido.prodName
		//Elemento associado: numero de produtos associados ao servido - quantidade pretendida pelo 
		//					  cliente servido
		produtos.set(servido.prodName, produtos.get(servido.prodName) - servido.quantity);
		
		//out(): retira o elemento do inicio da fila
		orders.out();
		
		//numero de pedidos diminuem
		numPedidos--;
		
		//return do pedido mais antigo
		return servido;
	}
	
	//query(product) - devolve o número de unidades de um dado produto que estão
    //pedidas nas encomendas actuais;
    public int query(String produto) {
		//get(key): Devolve o elemento associado à chave dada
		//Neste caso, devolve o numero de produtos associados à encomenda
		return produtos.get(produto);
	}
	
	//displayOrders() - imprime a lista de encomendas, por ordem de chegada, e o
    //número total de unidades encomendadas de cada produto;
	public void displayOrders() {
		out.println("Lista de encomendas: " + orders.toString()); //converte em String todos os produtos q existem
		String[] prodEncomen = produtos.keys();
		int servedProducts;
		for(String key : prodEncomen) {
			servedProducts = produtos.get(key);
			if (servedProducts > 0)
			{
				out.print(key + ":" + servedProducts);
				out.println();
				
			}
		}
	}
	
	public int numOrders() {
		return numPedidos;
	}
		
	/*Os métodos enterOrder, serveOrder e query devem ter uma complexidade temporal O(1)
	no número de encomendas. O programa TestSupermarket permite testar a classe pedida.*/
	
}

