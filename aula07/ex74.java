import static java.lang.System.*;
import java.io.*;
import java.util.Scanner;
// import java.util.*;   // => "error: reference to LinkedList is ambiguous"
// java.util.LinkedList colide com p2utils.LinkedList!
import p2utils.*;

public class ex74
{
  public static void main(String[] args) throws IOException
  {
    if (args.length != 1) {
      err.printf("Usage: java -ea FilterLines text-file\n");
      exit(1);
    }
    File fil = new File(args[0]);

    // Criar listas para as linhas curtas, médias e longas.
    //LinkedList shortLines = new LinkedList();
	//LinkedList mediumLines = new LinkedList();
	//LinkedList longLines = new LinkedList();
    //...
    
    LinkedList<String> singleList = new LinkedList<String>();

    Scanner sf = new Scanner(fil);
    // exceções poderiam ser intercetadas e mostrar mensagem de erro.
    while (sf.hasNextLine()) {
      String line = sf.nextLine();
      if (line.length() <20)
	  {
		  singleList.addFirst(line);
	  } else
	  {
		  singleList.addLast(line);
	  }
      //...

    }
    sf.close();

    // Escrever conteúdo das listas...
    out.println("Curtas---|---------|---------|---------|---------");
    singleList.print();
    //...

    //out.println("Médias---|---------|---------|---------|---------");
    //mediumLines.print();
    //...

    //out.println("Longas---|---------|---------|---------|---------");
    //longLines.print();
    //...
  }

}

