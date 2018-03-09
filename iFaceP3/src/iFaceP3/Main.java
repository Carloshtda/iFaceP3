package iFaceP3;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		ArrayList<Cadastro> usuarios = new ArrayList<Cadastro>();
		ArrayList<Comunidade> comunidades = new ArrayList<Comunidade>();
	
		System.out.println("Bem vindo ao iFace!");
		System.out.println("O que desejas fazer:");
		System.out.println("    1. Cadastrar-se");
		System.out.println("    2. Fazer login");
		System.out.println("    3. Editar cadastro");
		System.out.println("    4. Criar uma comunidade");
		System.out.println("    5. Enviar mensagem");
		System.out.println("    6. Mostrar sua mensagens");
		System.out.println("    7. Pedidos de amizade");
		System.out.println("    8. Entrar em uma comunidade");
		System.out.println("    0. Encerrar o programa");
		Scanner input = new Scanner(System.in);
		int control = input.nextInt();
		String aux = new String();
		Cadastro user = null;
		while(control != 0)
		{
			switch(control)
			{
				case 1:
					usuarios.add(Cadastro.novoCadastro(usuarios));
					break;
				case 2:
					user = Cadastro.fazerLogin(usuarios);
					break;
				case 3:
					if(user == null)
						System.out.println("Faça login antes de utilizar essa opcao!");
					else
						user.editCadastro(user);
					break;
				case 4:
					if(user == null)
						System.out.println("Faça login antes de utilizar essa opcao!");
					else
						comunidades.add(Comunidade.createComunidade(user));
					break;
				case 5:
					if(user == null)
						System.out.println("Faça login antes de utilizar essa opcao!");
					else{
						System.out.println("Digite 1 para mandar mensagem para um usuario ou 2 para mandar para uma comunidade.");
						control = input.nextInt();
						if(control == 1)
							Mensagem.enviarMensagemP(user, usuarios);
					
						else if(control == 2)
							Mensagem.enviarMensagemC(user, comunidades);
						else
							System.out.println("Comando invalido.");
					}
					break;
				case 6:
					if(user == null)
						System.out.println("Faça login antes de utilizar essa opcao!");
					else
						user.displayMensagens(user);
				case 7:
					if(user == null)
						System.out.println("Faça login antes de utilizar essa opcao!");
					else
						user.displayPedidos(user);
				case 8:
					if(user == null)
						System.out.println("Faça login antes de utilizar essa opcao!");
					else
						System.out.println("Qual comunidade desejas entrar?");
						aux = input.nextLine();
						for (int i = 0; i < comunidades.size(); i++) {
							if(comunidades.get(i).getName().equals(aux))
								comunidades.get(i).addMember(comunidades.get(i), user);
								break;
						}
						System.out.println("Não foi possivel achar a comunidade desejada");
						break;
			}
			System.out.println("Proxima acao desejada:");
			System.out.println("   	1. Cadastrar-se");
			System.out.println("    2. Fazer login");
			System.out.println("    3. Editar cadastro");
			System.out.println("    4. Criar uma comunidade");
			System.out.println("    5. Enviar mensagem");
			System.out.println("    6. Mostrar sua mensagens");
			System.out.println("    7. Pedidos de amizade");
			System.out.println("    8. Entrar em uma comunidade");
			System.out.println("    0. Encerrar o programa");
			control = input.nextInt();
		}
	
	}
}
