public class Pilha {
	
	static final int CAPACIDADE_PILHA = 128;
	char dados[];
	int contador;

  Pilha(){
    this(CAPACIDADE_PILHA);
  }
  
	Pilha(int capacidade){
		dados = new char[capacidade];
		contador = 0;
	}
	
	public void push(char valor) {
		if(isFull()){
      System.out.println("Pilha cheia, não é possível inserir um novo valor");
      return;
    }
    
		dados[contador] = valor;
		++contador;
	}
	
	public char pop(){
		if (isEmpty()){
      System.out.println("A sequência de caracteres não está correta.");
      return '\0'; //nem sempre é a melhor solução, mas essa função precisa sempre retornar um char
    }
		--contador;
		char topo = dados[contador];
		dados[contador] = '\0'; // se for um objeto, atribuir null.
		return topo;
	}
	
	public char top() {
    if (isEmpty()){
      System.out.println("Pilha vazia, nenhum elemento a ser removido.");
      return '\0';
    }
    return dados[contador -1];
	}
  
  public boolean isFull(){
    return contador == dados.length;
  }
  public boolean isEmpty(){
    return contador == 0;
  }

  public int size(){
    return dados.length;
  }

  public int count(){
    return contador;
  }

  public void clear(){
    while(!isEmpty()){
      pop();
    }
  }
}