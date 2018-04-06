package iFaceP3;

import java.util.ArrayList;

public class Amizade {
	private ArrayList<Cadastro> friends;
	private ArrayList<PedidosDeAmizade> requested;
	
	
	public Amizade() {
		this.friends = new ArrayList<Cadastro>();
		this.requested = new ArrayList<PedidosDeAmizade>();
	}
	public ArrayList<Cadastro> getFriends()
	{
		return this.friends;
	}
	public void setFriends(ArrayList<Cadastro> friends)
	{
		this.friends = friends;
	}
	public void addFriends(Cadastro friend)
	{
		this.friends.add(friend);
	}
	
	public ArrayList<PedidosDeAmizade> getRequested()
	{
		return this.requested;
	}
	public void setRequested(ArrayList<PedidosDeAmizade> pedido)
	{
		this.requested = pedido;
	}
	public void addRequest(PedidosDeAmizade request)
	{
		this.requested.add(request);
	}
	
	public void aceitarPedido(PedidosDeAmizade pedido)
	{
		pedido.getRequestedBy().getFriendships().addFriends(pedido.getRequestedBy());
		pedido.getRequestedTo().getFriendships().addFriends(pedido.getRequestedBy());
		System.out.printf("Agora %s e %s s�o amigos", pedido.getRequestedTo().getName(), pedido.getRequestedBy().getName());
	}
	public void excluirPedido(int i)
	{
		this.requested.remove(i);
		System.out.println("Pedido de amizade removido");
	}

}
