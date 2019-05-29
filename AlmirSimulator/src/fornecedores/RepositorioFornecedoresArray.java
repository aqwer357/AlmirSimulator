package fornecedores;

public class RepositorioFornecedoresArray implements RepositorioFornecedores {
	private Fornecedor[] fornecedores;
	private int indice;

	// construtor basico
	public RepositorioFornecedoresArray() {
		this.fornecedores = new Fornecedor[10];
		this.indice = 0;
	}

	// simulando um array dinamico para nao limitar o tamanho da array ao inserir

	public void inserir(Fornecedor fornecedor) {
		if (this.indice < this.fornecedores.length) {
		this.fornecedores[indice] = fornecedor;
		this.indice= this.indice +1;		
	}else {
		Fornecedor[] aux = new Fornecedor[2*fornecedores.length];
		
		for(int i =0; i < fornecedores.length;i++) {
			aux[i] = this.fornecedores[i];
		}
		fornecedores = aux;
		this.fornecedores[indice] = fornecedor;
		this.indice= this.indice +1;
	}
		
	}
}
