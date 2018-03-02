import java.util.ArrayList;
import java.util.Scanner;


public class Comunidade {

	private String name;
	private String description;
	private ArrayList<Cadastro> users;
	private String loginOfOwner;
	
	public Comunidade(String name, String description,Cadastro user) {
		this.name = name;
		this.description = description;
		this.users.add(user);
		this.loginOfOwner = user.getLogin();
	}

	public Comunidade createComunidade(Cadastro user)
	{
		System.out.println("Opção de criação de comunidade selecionada:");
		String name = new String();
		String description = new String();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite o nome da nova comunidade:");
		name = input.nextLine();
		
		System.out.println("Digite a descrição da nova comunidade:");
		description = input.nextLine();
		
		Comunidade novaComunidade = new Comunidade(name, description, user);
		
		System.out.println("Comunidade criada com sucesso!");
		
		return novaComunidade;
	}
	
	public Comunidade AddMember(Comunidade comunidade, Cadastro user)
	{
		if (IsMember(comunidade, user))System.out.printf("O usuário já pertence a comunidade", comunidade.getName());
		else
		{
			comunidade.users.add(user);  
			System.out.printf("Usuário %s adicionado a comunidade %s", user.getName(), comunidade.getName());
		}
		return comunidade;
	}
	
	public String getName()
	{
		return this.name;
	}
	public String getDescription()
	{
		return this.description;
	}
	public boolean IsMember(Comunidade comunidade, Cadastro user)
	{
		for (int i = 0; i < comunidade.users.size(); i++) {
			if(comunidade.users.get(i).getLogin() == user.getLogin())
			{
				return true;
			}
			
		}
		return false;
	}
	
	
	
}
