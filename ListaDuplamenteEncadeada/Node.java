package ListaDuplamenteEncadeada;
public class Node {
    private char palavra;
    private int numero;
    private Node next;
    private Node previous;
  
    public Node() {
      this.palavra = '\0';
      this.numero = 0;
      this.next = null;
      this.previous = null;
    }
  
    public Node(char palavra, int numero) {
      this.palavra = palavra;
      this.numero = numero;
      this.next = null;
      this.previous = null;
    }
  
    public char getPalavra() {
      return this.palavra;
    }
  
    public void setPalavra(char palavra) {
      this.palavra = palavra;
    }
  
    public int getNumero() {
      return numero;
    }
  
    public void setNumero(int numero) {
      this.numero = numero;
    }
  
    public Node getNext() {
      return next;
    }
  
    public void setNext(Node next) {
      this.next = next;
    }
  
    public Node getPrevious() {
      return previous;
    }
  
    public void setPrevious(Node previous) {
      this.previous = previous;
    }
  
    @Override
    public String toString() {
      return "<--- " + "|" +
          palavra + "|" + numero + "| --->";
    }
  
  }
