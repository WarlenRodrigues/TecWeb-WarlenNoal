package myPackage;


public class Users {

	private	Integer	id;
	private	String	name;
	private String surname;
	private String username;
	private Integer age;
	private String email;
	
	public String getName(){ return this.name;}
	public void setName(String nome){ this.name = name;}
	
	public	String getSurname(){ return this.surname;}	
	public void setSurname(String surname){	this.surname = surname;}

	public	String getUsername(){ return this.username;}	
	public void setUsername(String username){	this.username = username;}

	public	Integer getAge(){ return this.age;}	
	public void setAge(Integer age){	this.age = age;}

	public	String getEmail(){ return this.email;}	
	public void setEmail(String email){	this.email = email;}

}
