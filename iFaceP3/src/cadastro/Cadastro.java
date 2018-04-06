package iFaceP3;

import java.util.ArrayList;
import java.util.Scanner;

public class Cadastro {
	private String login;
	private String password;
	private String name;
	private Amizade friendships;
	private ArrayList<Mensagem> mensagens;
	private ArrayList<Comunidade> minhasComunidades;
	
	
	
	public Cadastro(String login, String password, String name)
	{
		this.login = login;
		this.password = password;
		this.name = name;
		this.friendships = new Amizade();
		this.mensagens = null;
		this.minhasComunidades = null;
	}
	public static Cadastro novoCadastro(ArrayList<Cadastro> usuarios)
	{
		System.out.println("Digite seu nome:");
		Scanner input = new Scanner(System.in);
		String nome = input.nextLine();
		System.out.println("Digite como deseja que seja seu login:");
		String login = input.nextLine();
		System.out.println("Digite como deseja que seja sua senha:");
		String senha = input.nextLine();
		
		for (int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getName().equals(nome))
			{
				System.out.println("Nome já utilizado! Tente novamente.");
				return null;
			}
			if(usuarios.get(i).getLogin().equals(login))
			{
				System.out.println("Login já utilizado! Tente novamente.");
				return null;
			}
			if(usuarios.get(i).getPassword().equals(senha))
			{
				System.out.println("Senha já utilizada! Tente novamente.");
				return null;
			}
		
		}
		
		return new Cadastro(login, senha, nome);
		
	}
	
	public static Cadastro fazerLogin(ArrayList<Cadastro> usuarios)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Digite seu login:");
		String login = input.nextLine();
		System.out.println("Digite sua senha:");
		String senha = input.nextLine();
		for (int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getLogin().equals(login) && usuarios.get(i).getPassword().equals(senha))
			{
				System.out.println("Login efetuado com sucesso");
				return usuarios.get(i);
			}
		}
		System.out.println("Cadastro não encontrado!");
		return null;
	
	
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
		return this.password;
	}
	public void setLogin(String login)
	{
		this.login = login;
	}
	public String getLogin()
	{
		return this.login;
	}
	
	public Amizade getFriendships()
	{
		return this.friendships;
	}

	public void setMensagens(ArrayList<Mensagem> mensagens)
	{
		this.mensagens = mensagens;
	}
	public ArrayList<Mensagem> getMensagens()
	{
		return this.mensagens;
	}
	
	public ArrayList<Comunidade> getMinhasComunidades()
	{
		return this.minhasComunidades;
	}
	
	public void setMinhasComunidades(ArrayList<Comunidade> comunidades)
	{
		this.minhasComunidades = comunidades;
	}
	
	public void editCadastro(Cadastro usuario){
		System.out.println("Opicao de Edicao de cadastro selecionada:");
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
	
	public boolean loginExistente(ArrayList<Cadastro> users, Cadastro user)
	{
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).getLogin().equals(user.getLogin()))
			{
				return true;
			}
			
		}
		return false;
	}
	public boolean NameExistente(ArrayList<Cadastro> users, Cadastro user)
	{
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).getName().equals(user.getName()))
			{
				return true;
			}
			
		}
		return false;
	}
	public void displayPedidos(Cadastro user)
	{
		if(user.friendships.getRequested().size() == 0)
		{
			System.out.println("Nao ha novos pedidos de amizade.");
		}
		else
		{
			boolean control;
			Scanner input = new Scanner(System.in);
			for (int i = 0; i < user.friendships.getRequested().size(); i++) {
				System.out.printf("%s deseja te adicionar como amigo. Deseja aceitar? (true - se sim ou false - se nao)", user.friendships.getRequested().get(i).getRequestedBy());
				control = input.nextBoolean();
				if(control)
				{
					user.getFriendships().aceitarPedido(user.getFriendships().getRequested().get(i));
					user.getFriendships().excluirPedido(i);
				}
				else
				{
					System.out.println("Deseja ecluir o pedido? (true - se sim ou false - se nao)");
					control = input.nextBoolean();
					if (control) {
						user.getFriendships().excluirPedido(i);
						System.out.println("Pedido de amizade excluido");
					}
				}
			}
		}
	}
	public void displayMensagens(Cadastro user)
	{
		if(user.mensagens.size() == 0)
		{
			System.out.println("Nao existem mensagens.");
		}
		else
		{
			boolean control;
			Scanner input = new Scanner(System.in);
			for (int i = 0; i < user.mensagens.size(); i++) {
				if (user.getMensagens().get(i).getSendToCommunity() == null) {
					System.out.printf("Mensagem de %s para %s: %s\n Deseja excluir?(true - se sim ou false - se nao)", user.mensagens.get(i).getSendBy(), user.mensagens.get(i).getSendToUser(), user.mensagens.get(i).getMessage());
					control = input.nextBoolean();
					if(control)
					{
						user.getMensagens().remove(i);
					}
				}
			
				else
				{
					System.out.printf("Mensagem de %s para %s: %s\n Deseja excluir?(true - se sim ou false - se nao)", user.mensagens.get(i).getSendBy(), user.mensagens.get(i).getSendToCommunity(), user.mensagens.get(i).getMessage());
					control = input.nextBoolean();
					if(control)
					{
						user.getMensagens().remove(i);
					}
				}
			}
		}
	}
}
