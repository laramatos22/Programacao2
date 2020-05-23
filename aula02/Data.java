import static java.lang.System.*;
import java.util.Calendar;

public class Data {
	
  //3 campos inteiros privados para registar o dia, o mês e o ano de uma data
  private int dia, mes, ano;

  //construtor
  /** Inicia esta data com o dia de hoje. */
  public Data() {
    // Aqui usamos a classe Calendar da biblioteca standard para obter a data atual.
    Calendar today = Calendar.getInstance();
    dia = today.get(Calendar.DAY_OF_MONTH);
    mes = today.get(Calendar.MONTH) + 1;
    ano = today.get(Calendar.YEAR);
  }

  /** Inicia a data a partir do dia, mes e ano dados. */
  public Data(int dia, int mes, int ano) {
    //...
    this.dia = dia;
    this.mes = mes;
    this.ano = ano;
  }
  
  public int dia() {
	  return dia;
  }
  
    public int mes() {
	  return mes;
  }
  
    public int ano() {
	  return ano;
  }
  
  //método que devolve a data no formato normalizado "AAAA-MM-DD"
  //print data
  /** Devolve esta data segundo a norma ISO 8601. */
  public String toString() {
    return String.format("%04d-%02d-%02d", ano, mes, dia);
  }

  //método de classe que permite verificar se um ano é bissexto
  /** Indica se ano é bissexto. */
  public static boolean bissexto(int ano) {
    return ano%4 == 0 && ano%100 != 0 || ano%400 == 0;
  }

  // Crie métodos para obter o dia, mes e ano da data.
  //...
  
  /** Dimensões dos meses num ano comum. */
  private static final
  int[] diasMesComum = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  /** Devolve o número de dias do mês dado. */
  public static int diasDoMes(int mes, int ano) {
    //...
    int num =0; //dias de cada mês
	  switch (mes)
	  {
		  case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			  num = 31;
			  break;
		  case 2:
			  if (bissexto(ano))
			  {
				  num = 29;
			  } else
			  {
				  num = 28;
			  }
			  break;
		  case 4: case 6: case 9: case 11:
		      num = 30;
		      break;
		  default:
			  break;
	  }
	  return num;
  }

  /** Devolve o mes da data por extenso. */
  public String mesExtenso() {
    //...
    mes = mes();
    switch (mes)
	{
		case 1:
			return "Janeiro";
		case 2:
			return "Fevereiro";
		case 3:
			return "Março";
		case 4:
			return "Abril";
		case 5:
			return "Maio";
		case 6:
			return "Junho";
		case 7:
			return "Julho";
		case 8:
			return "Agosto";
		case 9:
			return "Setembro";
		case 10:
			return "Outubro";
		case 11:
			return "Novembro";
		case 12:
			return "Dezembro";
		default:
			return "Inválido";
	}
	
  }


  /** Devolve esta data por extenso. */
  public String extenso() {
    return String.format(dia() + " de " + mesExtenso() + " de " + ano());
  }

  /** Indica se um terno (dia, mes, ano) forma uma data válida. */
  public static boolean dataValida(int dia, int mes, int ano) {
    //...
    boolean valida = true;
    if ((dia<=0) || (mes<=0) || (mes>=13) || (ano<=0) || (dia>diasDoMes(mes, ano)))
	{
		valida = false;
	}
	return valida;
  }


  public void seguinte() {
    //...
    if (dia == diasDoMes(mes, ano))
	{
		if (mes == 12)
		{
			dia = 1;
			mes = 1;
			ano = ano+1;
		} else
		{
			dia = 1;
			mes++;
		}
	} else
	{
		dia++;
	}
  }
  
  public Data (String data) {
	  String [] arr = data.split("-");
	  
	  if (arr.length==3)
	  {
		  ano = Integer.parseInt(arr[0]);
		  mes = Integer.parseInt(arr[1]);
		  dia = Integer.parseInt(arr[2]);
	  } else
	  {
		  System.out.println("A data nao tem o formato válido");
		  System.exit(0);
	  }
  }


}

