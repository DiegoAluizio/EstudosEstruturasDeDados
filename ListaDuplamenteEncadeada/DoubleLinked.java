package ListaDuplamenteEncadeada;
class DoubleLinked {

    private Node head;
    private Node tail;
    private int count;
  
    public DoubleLinked() {
      head = null;
      tail = null;
      count = 0;
    }
  
    public boolean isEmpty() {
      return count == 0;
    }
  
    public void insert(char palavra, int numero) {
      if (isEmpty()) {
        Node no = new Node(palavra, numero);
        head = no;
        tail = no;
        no.setNext(no);
        no.setPrevious(no);
        ++count;
      } else {
        Node no = new Node(palavra, numero);
        no.setNext(head);
        no.setPrevious(tail);
        head.setPrevious(no);
        head = no;
        tail.setNext(head);
        ++count;
      }
    }
  
    public void append(char palavra, int numero) {
      if (isEmpty()) {
        Node no = new Node(palavra, numero);
        head = no;
        tail = no;
        no.setNext(no);
        no.setPrevious(no);
        ++count;
      } else {
        Node no = new Node(palavra, numero);
        no.setPrevious(tail);
        no.setNext(head);
        tail.setNext(no);
        tail = no;
        head.setPrevious(tail);
        ++count;
      }
    }
  
    public Node removeHead() {
      if (count == 0) {
        return null;
      }
      Node local = head; // Armazena o nó que estamos removendo
      head = local.getNext();
      head.getPrevious().setNext(null);
      head.getPrevious().setPrevious(null);
      if (head != null) {
        tail.setNext(head);
      } else {
        tail.setNext(null);
      }
      if (tail != null) {
        head.setPrevious(tail);
      } else {
        head.setNext(null);
      }
      --count;
      return local;
    }
  
    public String getHead() {
      if (head == null) {
        return null;
      } else {
        StringBuilder no = new StringBuilder();
        //no.append(head.getPrevious())
            //.append("<- prev ")
            no.append("|")
            .append(head.getPalavra())
            .append("|")
            .append(head.getNumero())
            .append("|");
            //.append(" Prox -> ")
            //.append(head.getNext());
        return no.toString();
      }
    }
  
    public String getNode(int numero) {
      int contadorAux = 0;
      StringBuilder no = new StringBuilder();
      Node local = head;
      while (local.getNumero() != numero) {
        local = local.getNext();
        ++contadorAux;
        if (contadorAux == count) {
          return null;
        }
      }
      no.append("|")
          .append(local.getPalavra())
          .append("|")
          .append(local.getNumero())
          .append("|");
      return local.toString();
    }
  
    public String getTail() {
      if (tail == null) {
        return null;
      } else {
        StringBuilder no = new StringBuilder();
  
        no.append("|")
            .append(tail.getPalavra())
            .append("|")
            .append(tail.getNumero())
            .append("|");
  
        return no.toString();
      }
    }
  
    public Node removeTail() {
      if (count == 0) {
        return null;
      }
      Node local = tail;
      tail = local.getPrevious();
      tail.getNext().setPrevious(null);
      tail.getNext().setNext(null);
      if (tail != null) {
        tail.setNext(head);
      } else {
        tail.setNext(null);
      }
      if (head != null) {
        head.setPrevious(tail);
      } else {
        head.setPrevious(null);
      }
      --count;
      return local;
    }
  
    public Node removeNode(int numero) {
      int contadorAux = 0;
      Node local = head;
      while (local.getNumero() != numero) {
        local = local.getNext();
        ++contadorAux;
        if (contadorAux > count) {
          return null;
        }
      }
      if (contadorAux == 0) {
        return removeHead();
      }
      if (contadorAux == count) {
        return removeTail();
      } else {
        local.getPrevious().setNext(local.getNext());
        local.getNext().setPrevious(local.getPrevious());
        local.setPrevious(null);
        local.setNext(null);
        --count;
        return local;
      }
    }
  
    public int count() {
      return this.count;
    }
  
    public void clear() {
      while (!isEmpty()) {
        removeHead();
      }
    }
  
    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      int contadorAux = 0;
      sb.append("(")
          .append(count)
          .append(")");
      if (count == 0) {
        sb.append("Lista vazia...");
        return sb.toString();
      }
  
      Node local = head; // Variavel Local para percorrer a lista
      while (contadorAux < count) {
        sb.append("|")
            .append(local.getPalavra())
            .append("|")
            .append("|")
            .append(local.getNumero())
            .append("|");
        contadorAux++;
        local = local.getNext();
      }
      return sb.toString();
    }
  }