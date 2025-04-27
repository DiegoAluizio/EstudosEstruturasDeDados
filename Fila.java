
public class Fila {

    private static final int CAPACIDADE_FILA = 4;
    private int primeiro;
    private int contador;
    private String dados[];
  
    // Construtor executado quando a pessoa instancia um objeto do tipo Fila sem
    // passar
    // parâmetros para o construtor - usa o tamanho padrão (constante
    // CAPACIDADE_FILA).
    // ex.: Fila f1 = new Fila();
    //
    // Perceba que estamos chamando o construtor Fila(int capacidade) { ... } dentro
    // desse construtor, via instrução this(CAPACIDADE_FILA);
    public Fila() {
      this(CAPACIDADE_FILA);
    }
  
    // Construtor executado quando a pessoa instancia um objeto do tipo Fila
    // passando
    // um número inteiro como parâmetro do construtor, definindo o tamanho do vetor
    // usado para armazenar os dados da fila (a capacidade da fila).
    // ex.: Fila f2 = new Fila();
    public Fila(int capacidade) {
      primeiro = 0;
      contador = 0;
      dados = new String[capacidade];
    }
  
    /**
     * enqueue():
     * um elemento inserido na fila sempre será colocado no final da fila.
     */
    public void enqueue(String valor) {
      if (isFull()) {
        System.out.println("Fila cheia, não é possível inserir uma nova tarefa");
        return;
      }
  
      int indiceNovoElemento = (primeiro + contador) % dados.length;
      dados[indiceNovoElemento] = valor;
      ++contador;
    }
  
    /**
     * dequeue():
     * um elemento removido da fila sempre é o primeiro elemento da fila (o que está mais tempo na fila).
     */
    public String dequeue() {
      // fila está vazia?
      if (isEmpty()) {
        return ("Fila vazia. Não há como realizar outra tarefa.");
      }
  
      String frente = dados[primeiro];
      dados[primeiro] = "\0";
      primeiro = (primeiro + 1) % dados.length;
      --contador;
      return frente;
    }
  
    /**
     * front():
     * a pessoa que usa a estrutura da fila só consegue saber quem é o primeiro da
     * fila
     * (operação também conhecida como first() e/ou peek()).
     */
    public String front() {
      if (isEmpty()) {
        System.out.println("Fila vazia. nenhuma tarefa a ser realizada");
        return "\0";
      }
  
      return dados[primeiro];
    }
  
    /**
     * isFull():
     * retorna se a fila está cheia ou não.
     */
    public boolean isFull() {
      return contador == dados.length;
    }
  
    /**
     * isEmpty();
     * retorna se a fila está vazia ou não.
     */
    public boolean isEmpty() {
      return contador == 0;
    }
  
    /**
     * size():
     * retorna a capacidade da fila.
     */
    public int size() {
      return dados.length;
    }
  
    /**
     * count():
     * retorna a quantidade de elementos na fila.
     */
    public int count() {
      return contador;
    }
  
    /**
     * clear():
     * esvazia a fila (remove todos os elementos da fila).
     */
    public void clear() {
      while (!isEmpty()) {
        dequeue();
      }
    }
  
  }