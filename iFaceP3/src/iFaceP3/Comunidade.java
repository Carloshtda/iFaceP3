package iFaceP3;

import java.util.ArrayList;
import java.util.Scanner;


public class Comunidade {

	private String name;
	private String description;
	private ArrayList<Cadastro> users;
	private String loginOfOwner;
	private ArrayList<Mensagem> mensagens;

	
	public Comunidade(String name, String description,Cadastro user) {
		this.name = name;
		this.description = description;
		this.users.add(user);
		this.loginOfOwner = user.getLogin();
	}

	public static Comunidade createComunidade(Cadastro user)
	{
		System.out.println("Opcao de criacao de comunidade selecionada:");
		String name = new String();
		String description = new String();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite o nome da nova comunidade:");
		name = input.nextLine();
		
		System.out.println("Digite a descricao da nova comunidade:");
		description = input.nextLine();
		
		Comunidade novaComunidade = new Comunidade(name, description, user);
		
		System.out.println("Comunidade criada com sucesso!");
		user.getMinhasComunidades().add(novaComunidade);
		
		return novaComunidade;
	}
	
	public Comunidade addMember(Comunidade comunidade, Cadastro user)
	{
		if (isMember(comunidade, user))System.out.printf("O usuario ja pertence a comunidade", comunidade.getName());
		else
		{
			comunidade.users.add(user);  
			user.getMinhasComunidades().add(comunidade);
			System.out.printf("Usuario %s adicionado a comunidade %s", user.getName(), comunidade.getName());
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
	public boolean isMember(Comunidade comunidade, Cadastro user)
	{
		for (int i = 0; i < comunidade.users.size(); i++) {
			if(comunidade.users.get(i).getLogin() == user.getLogin())
			{
				return true;
			}
			
		}
		return false;
	}
	public void setMensagens(ArrayList<Mensagem> mensagens)
	{
		this.mensagens = mensagens;
	}
	public ArrayList<Mensagem> getMensagens()
	{
		return this.mensagens;
	}
	
	
	
}
