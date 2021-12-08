package Servidor;

import ThreadServidor.RecebeMensagemCliente;

public class Lista {

	private Node first;
	private int qtd;
	
	public Lista() {
		this.first = null;
	}
	
	public void add(RecebeMensagemCliente mensagem) {
		Node no = new Node(mensagem);
		if (estaVazio()) {
			this.first = no;
			this.qtd++;
		} else {
			addProximo(first, no);
			this.qtd++;
		}
	}
	
	public int size() {
		return this.qtd;
	}
	
	public void addProximo(Node no, Node novo) {
		if (no.getProx() == null) {
			no.setProx(novo);
		} else {
			addProximo(no.getProx(), novo);
		}
	}
	
	 private boolean estaVazio() {
        if (this.qtd == 0) 
        	return true;
        else 
        	return false;
    }

	public Node getFirst() {
		return first;
	}

	public int getQtd() {
		return qtd;
	}
}