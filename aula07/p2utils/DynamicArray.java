package p2utils;

/** This class implements a "dynamic" array of elements of generic type.
 * The capacity of a dynamic array grows automatically, as needed.
 * It implements a random access abstract data type, with two main methods:
 * set and get.
 */
 
 //A classe é genérica. O parâmetro de tipo é usado para indicar o tipo dos elementos
 //a armazenar no array dinâmico.
public class DynamicArray<E> {
  
  //O campo array servirá para guardar os elementos introduzidos. O construtor deve
  //criar um array com uma dimensão inicial nula.
  private E[] array;
  private int maxidx = -1;  // maximum index ever set

  private static final int BLOCK = 256;

  // Define the constructor to initialize the fields
  //...
  public DynamicArray() {
	  E[] array = (E[]) new Object[0];
	  this.array = array;
  }

  /** Returns the length of the array.
   * The "length" is defined as 1 plus the maximum index that was set.
   * @return Number of elements in the array
   */
  public int length() { return 1+maxidx; }
  
  /*A operação a.set(n, v) serve para armazenar o valor v na posição n do array
dinâmico a (análogo a a[n] = v). O indı́ce n não pode ser negativo, mas pode ser
maior ou igual a a.length(). Quando isso acontece, o array tem de ser redimensio-
nado para ter um tamanho maior que o ı́ndice. O tamanho deverá aumentar sempre
para um múltiplo da constante BLOCK.*/

  /** Set the element in position idx to given value.
   */
  public void set(int idx, E value) {
    assert idx >= 0;
    //...
    if (idx > this.maxidx)
	{
		this.maxidx = idx;
	}
	if (idx >= this.array.length)
	{
		E[] newArray = (E[]) new Object[((idx + this.BLOCK)/this.BLOCK)*this.BLOCK];
		int i = 0;
		while (i < this.array.length && this.array[i] != null)
		{
			newArray[i] = this.array[i];
			i++;
		}
		this.array = newArray;
		this.array[idx] = value;
	}
	else
	{
		this.array[idx] = value;
	}
  }

/*A operação v = a.get(n) deve devolver o valor que tiver sido armazenado na posição
n de a (análogo a v = a[n], se a fosse um array nativo). Se nenhum valor tiver sido
armazenado nessa posição, deve devolver null.*/

  /** Return the element in a given position in the list.
   * @param idx  the index of the element (0 is the first).
   * @return value at position idx of the array, or null, if not set yet.
   */
  public E get(int idx) {
    assert idx >= 0;
    //...
    if (idx < this.array.length)
	{
		return this.array[idx];
	} else
	{
		return null;
	}
  }

/*A operação v = a.get(n, d) só difere da anterior por devolver o valor d em vez de
null.*/
  // Define the second get method
  //...
  public E get(int idx, E d) {
	  assert idx >= 0;
	  E value = this.get(idx);
	  
	  if (value != null)
	  {
		  return value;
	  } else
	  {
		  return d;
	  }
  }
}
