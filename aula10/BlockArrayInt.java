// Altere esta classe para implementar um tipo de dados abstrato que funciona
// como um array, com métodos de put e get.
// A implementação fornecida cria um único array, mas queremos substituí-lo
// por uma lista de blocos (arrays de tamanho blocksize), que poderá crescer
// juntando progressivamente mais blocos à lista.

import p2utils.*;

public class BlockArrayInt
{
  public BlockArrayInt(int blockSize, int numBlocks) {
    assert blockSize > 0;
    assert numBlocks > 0;

    this.numberOfBlocks = numBlocks;
    this.blockSize = blockSize;
    
    blockList = new LinkedList<Integer[]>();
    
    for (int i = 0; i < numBlocks; i++)
	{
		Integer[] block = new Integer[blockSize];
		blockList.addLast(block);
	}
	
  }

  //Colocar um elemento numa posição
  public int get(int index) {
    assert validIndex(index);
    
    int blockIndex = index / blockSize;
    Integer[] block = blockList.get(blockIndex);
    
    int pos = index % blockSize;
    return block[pos];
  }

  //Buscar o bloco de uma posição
  public void put(int elem, int index) {
    assert validIndex(index);

    int blockIndex = index / blockSize;
    Integer[] block = blockList.get(blockIndex);
    
    int pos = index % blockSize;
    block[pos] = elem;
  }

  public void incrementNumberOfBlocks() {
    blockList.addLast(new Integer[blockSize]);
    numberOfBlocks++;
  }

  public int size() {
    return this.numberOfBlocks * this.blockSize;
  }

  public int numberOfBlocks() {
    return this.numberOfBlocks;
  }

  public int blockSize() {
    return this.blockSize;
  }

  public boolean validIndex(int index) {
    return index >= 0 && index < size();
  }

  private LinkedList<Integer[]> blockList;
  private int numberOfBlocks;
  private int blockSize;
}

