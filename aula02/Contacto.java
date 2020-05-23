public class Contacto{
  private String nome;
  private String telefone;
  private String email;
  
  //construtores
  public Contacto () {
	  this.nome = "";
	  this.telefone = "";
	  this.email = "";
	}
  
  //Contactos com nome e telefone
  public Contacto (String nome, String num) {
	  this.nome = nome;
	  this.telefone = num;
	  this.email= "";  //o email fica em branco qdo nao tem cada 
	}

  //Contactos com tudo
  public Contacto (String nome, String num, String email) {
	  this.nome = nome;
	  this.telefone = num;
	  this.email = email;
	}
	
  public String nome () {
	  return this.nome;
	}
	
  public String telefone () {
	  return this.telefone;
	}
	
  public String eMail () {
	  return this.email;
	}
}
