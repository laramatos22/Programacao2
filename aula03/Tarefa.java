import java.lang.System.*;

public class Tarefa {
	
	private String texto=""; Data inicio, fim;
	
	public Data inicio() {
		return inicio;
	}
	
	public Data fim() {
		return fim;
	}
	
	public String texto() {
		return texto;
	}
	
	public Tarefa (Data inic, Data fin, String text) {
		inicio = inic;
		fim = fin;
		texto = text;
	}
	
	public String toString () {
		String in = inicio.toString();
		String end = fim.toString();
		return in+"--"+end+"->"+texto;
	}
	
}
