package clientes;

public class ClienteJaCadastradoException extends Exception{
	
	public ClienteJaCadastradoException() {
		super("Esse cliente j� foi cadastrado");
	}

}
