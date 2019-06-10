package pratos;

public class RepositorioPratosArray implements RepositorioPratos{
	private Prato[] arrayPratos;
	private int codigo; 
	
	// codigo serve como identificador para cada prato inserido no repositorio, o primeiro prato eh o prato 1,
	// o segundo eh o 2, o n-esimo eh n
	
	public RepositorioPratosArray() {
		this.arrayPratos = new Prato[1000];
		this.codigo = 0;
	}
	
	public void inserir(Prato prato) {
		boolean inserido = false;
		
		for (int i = 0; !inserido && i < this.arrayPratos.length; i++)
			if (this.arrayPratos[i] == null) {
				this.arrayPratos[i] = prato;
				inserido = true;
			}
	}

	public void atualizar(Prato prato) {
		boolean inserido = false;
		
		for (int i = 0; !inserido && i < this.arrayPratos.length; i++)
			if (this.arrayPratos[i].getNome().equals(prato.getNome())) {
				this.arrayPratos[i] = prato;
				inserido = true;
			}

	}

	public void remover(String nome) {
		boolean removido = false;
		
		for (int i = 0; !removido && i < this.arrayPratos.length; i++)
			if (this.arrayPratos[i].getNome().equals(nome)) {
				this.arrayPratos[i] = null;
				removido = true;
			}
		
	}

	public Prato procurar(String nome) {
		boolean encontrado = false;
		Prato output = null;
		
		for (int i = 0; !encontrado && i < this.arrayPratos.length; i++)
			if (this.arrayPratos[i].getNome().equals(nome)) {
				output = this.arrayPratos[i];
				encontrado = true;
			}
			
		return output;
	}

	public boolean existe(String nome) {
		boolean encontrado = false;
		
		for (int i = 0; !encontrado && i < this.arrayPratos.length; i++)
			if (this.arrayPratos[i].getNome().equals(nome))
				encontrado = true;
		
		return encontrado;
	}
	
	public int getCodigo(){
		return this.codigo;
	}
}
