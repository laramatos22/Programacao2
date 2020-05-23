import static java.lang.System.*;

public class DatasPassadas {

  public static void main(String[] args) {
    Data atual = new Data();
    //...
    Data natal = new Data(24, 12, 2019);
    
    out.printf("%s\n", natal.extenso());
    
    while (natal.dia() != atual.dia() || natal.mes() != atual.mes())
	{
		natal.seguinte();
		out.printf("%s\n", natal.extenso());
	}
  }

}

