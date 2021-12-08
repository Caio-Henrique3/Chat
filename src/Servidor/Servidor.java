package Servidor;

import java.net.ServerSocket;
import java.net.Socket;

import ThreadServidor.RecebeMensagemCliente;

public class Servidor {
	
	private Lista clientes = new Lista();

	public static void main(String[] args) {

		Servidor servidor = new Servidor();
		servidor.aguardarConexoes();
	}
	
	public void aguardarConexoes() {
		try (ServerSocket server = new ServerSocket(3333)) {
			while (true) {
				System.out.println("Aguardando conexões...");
				Socket socket = server.accept();
				
				RecebeMensagemCliente recebeMensagemCliente = new RecebeMensagemCliente(socket, this);
				new Thread(recebeMensagemCliente).start();
				
				this.clientes.add(recebeMensagemCliente);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enviarMensagensClientes(String mensagem) {
		Node cliente = clientes.getFirst();
		
		do {
			cliente.getMensagem().enviarMensagem(mensagem);
			cliente = cliente.getProx();
		} while (cliente != null);
	}
}