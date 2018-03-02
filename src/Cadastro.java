import java.util.ArrayList;
import java.util.Scanner;

public class Cadastro {
	private String login;
	private String password;
	private String name;
	
	public Cadastro(String login, String password, String name)//falta fazer uma funçao que cuide do cadastro, se preocupando com nome e login repitidos.
	{
		this.login = login;
		this.password = password;
		this.name = name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPassword()
	{
		return this.name;
	}
	public void setLogin(String login)
	{
		this.login = login;
	}
	public String getLogin()
	{
		return this.login;
	}
	public void editCadastro(Cadastro usuario){
		System.out.println("Opção de Edição de cadastro selecionada:");
		String string = new String();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite o novo login:");
		string = input.nextLine();
		usuario.setLogin(string);
		
		System.out.println("Digite o novo password:");
		string = input.nextLine();
		usuario.setPassword(string);
		
		System.out.println("Digite o novo nome:");
		string = input.nextLine();
		usuario.setName(string);
		
	}
	
	
	
	
	
	
	public boolean LoginExistente(ArrayList<Cadastro> users, Cadastro user)
	{
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).getLogin() == user.getLogin())
			{
				return true;
			}
			
		}
		return false;
	}
	public boolean NameExistente(ArrayList<Cadastro> users, Cadastro user)
	{
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).getName() == user.getName())
			{
				return true;
			}
			
		}
		return false;
	}

}
