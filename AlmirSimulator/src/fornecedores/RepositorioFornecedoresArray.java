package fornecedores;

public class RepositorioFornecedoresArray implements RepositorioFornecedores {
	private Fornecedor[] fornecedores;
	private int indice;

	// construtor basico
	public RepositorioFornecedoresArray() {
		this.fornecedores = new Fornecedor[20];
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
public boolean existe(int identificador) {
	
	for (int i = 0; i < fornecedores.length;i++) {
		
	if(fornecedores[i] == null) {
		return false;
	}
		
	else if(fornecedores[i].getIdentificador() == identificador) {
		return true;
	}
	
	}
	
	return false;
}


public void remover(int identificador) 
		throws FornecedorNaoEncontradoException {

if(this.existe(identificador) == true) {
	for(int i=0; i<fornecedores.length; i++) {

		if(fornecedores[i].getIdentificador() == identificador) { 	
			fornecedores[i] = null;

			for(int j = i+1;j<fornecedores.length;j++) {
				if(fornecedores[j] == null) {

					j = fornecedores.length;
				} else {

					fornecedores[j-1] = fornecedores[j];
					fornecedores[j] = null;
				}
			}

		}
	}
	} else {
		FornecedorNaoEncontradoException e;
		e = new FornecedorNaoEncontradoException();
		throw e;
	}

}

public void atualizar(Fornecedor fornecedor) 
		throws FornecedorNaoEncontradoException{
	
	if(this.existe(fornecedor.getIdentificador()) == true) {
		
		for(int i=0;i<fornecedores.length;i++) {
			
		if(fornecedores[i].getIdentificador() == fornecedor.getIdentificador()) {
			fornecedores[i] = fornecedor;
			i = fornecedores.length;
		}
		}
	}else {
		FornecedorNaoEncontradoException e;
		e = new FornecedorNaoEncontradoException();
		throw e;
	}
}

public Fornecedor procurar(int identificador) 
		throws FornecedorNaoEncontradoException{

	if(this.existe(identificador) == true) {
		
	Fornecedor retorno = null;
		
	for(int i=0;i<fornecedores.length;i++) {
			
		if(fornecedores[i].getIdentificador() == identificador) {
			retorno = fornecedores[i];
			i = fornecedores.length;
		}	
	}
		
	return retorno;
		
	} else {
		FornecedorNaoEncontradoException e;
		e = new FornecedorNaoEncontradoException();
		throw e;
	}
}

	
	
}
