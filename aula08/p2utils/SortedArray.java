package p2utils;

public class SortedArray<E extends Comparable<E>>
{
  // variáveis
  private int[] array;

  // construtor
  public SortedArray(int size) { 
	this.array = new int[size];
  }

  /**
   * @return Number of elements in the list
   */
  public int size() { return size; }

  /** Checks if the list is empty.
   * @return  {@code true} if list empty, otherwise {@code false}.
   */
  //a classe deverá ter um método isFull(), que devolve
  //true se o vector estiver cheio e false caso contrário.
  public boolean isFull() {
	  if (array[array.length - 1] == null)
	  {
		  return false;
	  }
	  return true;
  }
   
  public boolean isEmpty() {
	  if (arrray[0] == null)
	  {
		  return true;
	  }
	  return false;
  }

  /**
   * @return  First element in the list
   */
  public E first() {
    return array[0];
  }

  /** Inserts a new element in the list.
   * @param e the element to be inserted
   */
  public void insert(E e) {
    assert !isFull(): "Array is full";
    
    for (int i = 0; i < array.length; i++)
	{
		if (e.compareTo(array[0]) < 0)
		{
			for (int j = array.length-1; j == 1; j--)
			{
				array[j] = array[j-1];
			}
			array[0] = e;
		}
		else if (e.compareTo(array[i]) <= 0 && e.compareTo(array[i-1]) > 0) 
		{
			for (int j = array.length-1; j == i+1; j--)
			{
				array[j] = array[j-1];
			}
			array[i] = e;
		}
	}
  }

  /** Removes the first element in the list.
   */
  public void removeFirst() {
    for (int i = 0; i < array.length-1; i++)
	{
		array[i] = array[i+1];
	}
	array[array.length-1] = null;
  }

  /** Checks if the list is sorted.
   * @return {@code true} if sorted, {@code false} otherwise
   */
  public boolean isSorted() { 
    for (int i = 0; i < array.length-1; i++)
	{
		if (array[i].compareTo(array[i+1]) > 0)
		{
			return false;
		}
	}
	return true;
  }
  
 
	public boolean contains(E e)
	{
		assert e != null: "Element is null";
		
		for (int i = 0; i < array.length; i++)
		{
			if (e.compareTo(array[i]) == 0)
			{
				return true;
			}
		}
		return false;
	}
	
	
	
	public String toString()
	{
		String s = "[";
		
		for (int i = 0; i < array.length; i++)
		{
			if (array[i] != null)
			{
				string += array[i];
			}
		}
		s += "]";
		return s;
	}
	
	
	public SortedArray<E> merge(E[] b)
	{
		SortedArray<E> f = new SortedArray(array.length + b.length);
		
		int i1 = 0;
		int i2 = 0;
		int j = 0;
		
		while (array[i1] != null && b[i2] != null)
		{
			if (array[i1].compareTo(b[i2]) < 0)
			{
				f.array[j++] = array[i1++];
			} else
			{
				f.array[j++] = b[i1++];
			}
		}
		
		while (array[i1] != null)
		{
			f.array[j++] = array[i1++];
		}
		
		while (b[i2] != null)
		{
			f.array[j++] = b[i2++];
		}
		
		return f;
	}
	
	

}
