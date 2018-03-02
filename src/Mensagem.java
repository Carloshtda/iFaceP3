
public class Mensagem {
	private int tipo;//usar enum. Tipo 1: mensagem usuário para usuário. Tipo 2: mensagem usuário para comunidade
	private Cadastro sendBy;
	private Cadastro sendToUser;
	private Cadastro sendToCommunity;
	private String message;
	public Mensagem(int tipo, Cadastro sendBy, Cadastro sendToU, Cadastro sendToC, String message) {
		this.sendBy = sendBy;
		this.sendToUser = sendToU;
		this.sendToCommunity = null;
		this.message = message;	
	}

}
