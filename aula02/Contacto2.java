public class Contacto2 {
  private String nome;
  private String telefone;
  private String email;
  
  //construtores
  public Contacto2 () {
	  this.nome = "";
	  this.telefone = "";
	  this.email = "";
	}
  
  //Contactos com nome e telefone
  public Contacto2 (String nome, String num) {
	  this.nome = nome;
	  this.telefone = num;
	  this.email= "";  //o email fica em branco
	}

  //Contactos com tudo
  public Contacto2 (String nome, String num, String email) {
	  this.nome = nome;
	  this.telefone = num;
	  this.email = email;
	}
	
  public String nome () {
	  return this.nome.toUpperCase();
	}
	
  public String telefone () {
	  return this.telefone;
	}
	
  public String eMail () {
	  return this.email;
	}
}
