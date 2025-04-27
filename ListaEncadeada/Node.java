package ListaEncadeada;
public class Node {
    private char data;
    private Node next;
  
    public Node(){
      this('\0', null);
    }
  
    public Node(char data, Node next){
      this.data = data;
      this.next = next;
    }
  
    public char getData() {
      return data;
  }
    public void setData(char data) {
      this.data = data;
  }
    public Node getNext() {
      return next;
  }
    public void setNext(Node next) {
      this.next = next;
  }
  
    @Override
    public String toString(){
      return "[ data: " + data + "| next: " + next + "]";
    }
  }