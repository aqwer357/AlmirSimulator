package pratos;

import pedidos.Pedido;
import ingredientes.*;

public class CadastroPratos {
	private RepositorioPratos repositorio;
	
	public CadastroPratos(RepositorioPratos repositorio) {
		this.repositorio = repositorio;
	}
	public void inserir(Prato prato, Pedido pedido, RepositorioIngredientes ingredientes) throws PJFIException, IIException, IngredienteNaoEncontradoException {
		String[] arrayIngredientes = pedido.getRefeicao();
		
		for (int i = 0; i < pedido.getTamanhoArray(); i++) {
			prato.inserirIngrediente(ingredientes.procurar(arrayIngredientes[i]));
		}
		
		if (repositorio.existe(prato.getNome()))
			throw new PJFIException();
		else
			this.repositorio.inserir(prato);
	}
	
	public void atualizar(Prato prato) throws PNEException {
		if (!repositorio.existe(prato.getNome()))
			throw new PNEException();
		else
			this.repositorio.atualizar(prato);
	}
	
	public void remover(String nome) throws PNEException {
		if (!repositorio.existe(nome))
			throw new PNEException();
		else
			this.repositorio.remover(nome);
	}
	
	public Prato procurar(String nome) throws PNEException {
		if (!repositorio.existe(nome))
			throw new PNEException();
		else
			return this.repositorio.procurar(nome);
	}
	
	public boolean existe(String nome) {
		return this.repositorio.existe(nome);
	}
}
