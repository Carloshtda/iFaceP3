import java.util.ArrayList;
import java.util.Scanner;


public class PedidosDeAmizade {
	private Cadastro requestedBy;
	private Cadastro requestedTo;

	public PedidosDeAmizade(Cadastro by, Cadastro to) {
		this.requestedBy = by;
		this.requestedTo = to;
	}

	
	public void EnviarPedido(Cadastro user, ArrayList<Cadastro> users)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o nome para quem será o pedido de amizade");
		String name = input.nextLine();
		Cadastro aux;
		for (int i = 0; i < users.size(); i++)//podemos melhorar se fizermos uma função expecífica para isso. 
		{
			if(users.get(i).getName().equals(name))
			{
				PedidosDeAmizade pedido = new PedidosDeAmizade(user, users.get(i));
				//users.get(i).PEDIDOSDEAMIZADE.ADD(pedido);
			}
		}
		System.out.printf("Não foi possível enviar um pedido de amizade, pois não existe usuário cadastrado com o nome de %s", name);
	
	}
	
	
	
}
