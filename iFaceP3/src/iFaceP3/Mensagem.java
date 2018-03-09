package iFaceP3;

import java.util.ArrayList;
import java.util.Scanner;

public class Mensagem {
	private Cadastro sendBy;
	private Cadastro sendToUser;
	private Comunidade sendToCommunity;
	private String message;
	public Mensagem(Cadastro sendBy, Cadastro sendTo, String message) {
		this.sendBy = sendBy;
		this.sendToUser = sendTo;
		this.sendToCommunity = null;
		this.message = message;	
	}
	public Mensagem(Cadastro sendBy, Comunidade sendTo, String message) {
		this.sendBy = sendBy;
		this.sendToUser = null;
		this.sendToCommunity = sendTo;
		this.message = message;	
	}

	public Cadastro getSendBy() {
		return this.sendBy;
	}
	public Cadastro getSendToUser() {
		return this.sendToUser;
	}
	public Comunidade getSendToCommunity() {
		return this.sendToCommunity;
	}
	public String getMessage() {
		return this.message;
	}
	public static void enviarMensagemP(Cadastro user, ArrayList<Cadastro> users)
	{

		Scanner input = new Scanner(System.in);
		System.out.println("Digite o nome para quem sera a mensagem");
		String name = input.nextLine();
		String txt;
		int i;
		for (i = 0; i < users.size(); i++) 
		{
			if(users.get(i).getName().equals(name))
			{
				System.out.println("Conteudo da mensagem:");
				txt = input.nextLine();
				Mensagem mensagem = new Mensagem(user, users.get(i), txt);
				users.get(i).getMensagens().add(mensagem);
				user.getMensagens().add(mensagem);
			}
		}
		if(i == 0)
		{
			System.out.printf("Usuario com nome de %s nao encontrado", name);
		}
		
	}
	public static void enviarMensagemC(Cadastro user, ArrayList<Comunidade> comunidades)
	{

		Scanner input = new Scanner(System.in);
		System.out.println("Digite o nome para que comunidade sera a mensagem");
		String name = input.nextLine();
		String txt;
		int i;
		for (i = 0; i < comunidades.size(); i++) 
		{
			if(comunidades.get(i).getName().equals(name))
			{
				System.out.println("Conteudo da mensagem:");
				txt = input.nextLine();
				Mensagem mensagem = new Mensagem(user, comunidades.get(i), txt);
				comunidades.get(i).getMensagens().add(mensagem);
				user.getMensagens().add(mensagem);
			}
		}
		if(i == 0)
		{
			System.out.printf("Usuario com nome de %s nao encontrado", name);
		}
		
	}



}
