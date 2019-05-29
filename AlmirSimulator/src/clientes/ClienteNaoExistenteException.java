package clientes;

public class ClienteNaoExistenteException extends Exception {
	public ClienteNaoExistenteException() {
		super("Cliente não existente");
	}
}
