
public class Pessoa implements Comparable<Pessoa>
{
  // Complete a classe.
  //...
  private String name;
  private Data Birth;
  
  public Pessoa(String name, Data birth) {
	 this.name = name;
	 this.birth = birth;
  }
  
  public String getName() {
	 return this.name;
  }
  
  public data getBirth() {
	 return this.birth;
  }
  
  public String toString() {
	 return this.name + " " + this.birth;
  }
  
  public int compareTo(Pessoa p) {
	 if (this.birth.compareTo(p.getBirth()) > 0)
	 {
		 return 1;
	 } else if (this.birth.compareTo(p.getBirth()) < 0)
	 {
		 return -1;
	 } else
	 {
		 return 0;
	 }
  }
  
}
