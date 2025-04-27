package ListaEncadeada;
public class ListaEncadada {
    private Node head;
    private Node tail;
    private int count;
  
    public ListaEncadada(){
      head = null;
      tail = null;
      count = 0;
    }
    
    public Node getHead() {
      return head;
  }
    public void setHead(Node head) {
      this.head = head;
  }
    public Node getTail() {
      return tail;
  }
    public void setTail(Node tail) {
      this.tail = tail;
  }
    public int count(){
      return count;
    }
    
    public void setCount(int count) {
      this.count = count;
  }
  
    @Override
    public String toString(){
      return "(" + count + ")" + head;
    }
  }