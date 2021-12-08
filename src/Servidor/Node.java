package Servidor;

import ThreadServidor.RecebeMensagemCliente;

public class Node {

	private Node prox;
	private RecebeMensagemCliente mensagem;
	
	Node (RecebeMensagemCliente mensagem) {
		this.mensagem = mensagem;
	}

	public Node getProx() {
		return prox;
	}

	public void setProx(Node prox) {
		this.prox = prox;
	}

	public RecebeMensagemCliente getMensagem() {
		return mensagem;
	}

	public void setMensagem(RecebeMensagemCliente mensagem) {
		this.mensagem = mensagem;
	}
	
}