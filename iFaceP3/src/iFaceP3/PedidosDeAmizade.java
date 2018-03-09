package iFaceP3;

import java.util.ArrayList;
import java.util.Scanner;

public class PedidosDeAmizade {
	private Cadastro requestedBy;
	private Cadastro requestedTo;

	public PedidosDeAmizade(Cadastro by, Cadastro to) {
		this.requestedBy = by;
		this.requestedTo = to;
	}

	
	public void enviarPedido(Cadastro user, ArrayList<Cadastro> users)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o nome para quem sera o pedido de amizade");
		String name = input.nextLine();
		int i;
		for (i = 0; i < users.size(); i++) 
		{
			if(users.get(i).getName().equals(name))
			{
				PedidosDeAmizade pedido = new PedidosDeAmizade(user, users.get(i));
				users.get(i).getFriendships().addRequest(pedido);
			}
		}
		if(i == 0)
		{
			System.out.printf("Nao foi possivel enviar um pedido de amizade, pois nao existe usuario cadastrado com o nome de %s", name);
		}
	}
	
	public Cadastro getRequestedBy()
	{
		return this.requestedBy;
	}
	public void setRequestedBy(Cadastro user)
	{
		this.requestedBy = user;
	}
	
	public Cadastro getRequestedTo()
	{
		return this.requestedTo;
	}
	public void setRequestedTo(Cadastro user)
	{
		this.requestedBy = user;
	}
}
