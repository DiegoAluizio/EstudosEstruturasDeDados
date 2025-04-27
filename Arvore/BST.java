package BST;

// Nome dos Integrantes:
// Caio Alexandre V.B. de Andrade, TIA - 32229690.
// Diego Oliveira Aluizio, TIA - 32247591.
// Nicolas Fernandes Melnik, TIA - 32241720.

// Referências:
// Código feito em aula com o professor.

public class BST extends BinaryTree {

    public BST() {
        super();
    }

    public BST(Node root) {
        super(root);
    }

    public Node search(String data) {
        return search(root, data);
    }

    private Node search(Node node, String data) {
        if (node == null) {
          System.out.println("Nó não encontrado");
            return null; // Nó não encontrado na BST
        }

        int compareResult = data.compareTo(node.getData());

        if (compareResult == 0) {
            return node; // Nó encontrado
        } else if (compareResult < 0) {
            return search(node.getLeft(), data); // Procura à esquerda
        } else {
            return search(node.getRight(), data); // Procura à direita
        }
    }


    public void insert(String data) {
        root = insert(root, data, null);
    }

    private Node insert(Node node, String data, Node parent) {
        // se o search der nulo, executar, se não, retornar nulo e
        // uma mensagem
        if (node == null) {
            return new Node(data, parent, null, null);
        }

        if (data.compareTo(node.getData()) < 0) {
          parent = node;
          node.setLeft(insert(node.getLeft(), data, parent));
        } else if (data.compareTo(node.getData()) > 0) {
          parent = node;
          node.setRight(insert(node.getRight(),data, parent));
        }

        return node;
    }

    public void remove(String data) {
        root = remove(root, data);
    }

    private Node remove(Node node, String data) {
        if (node == null) {
            System.out.println("Nó a ser removido não encontrado ");
            return node;
        }

        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(remove(node.getLeft(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(remove(node.getRight(), data));
        } else {
            // Nó com a chave a ser removida foi encontrado

            // Caso 1: Nó folha ou nó com um filho
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            // Caso 2: Nó com dois filhos
            node.setData(minValue(node.getRight()));
            node.setRight(remove(node.getRight(), node.getData()));
        }

        return node;
    }

    private String minValue(Node node) {
        String minValue = node.getData();
        while (node.getLeft() != null) {
            minValue = node.getLeft().getData();
            node = node.getLeft();
        }
        return minValue;
    }
    
    public Node findMin() {
        return findMin(root);
    }

    private Node findMin(Node node) {
        if (node == null) {
            return null; // A árvore está vazia
        }

        while (node.getLeft() != null) {
            node = node.getLeft();
        }

        return node;
    }

    public Node findMax() {
        return findMax(root);
    }

    private Node findMax(Node node) {
        if (node == null) {
            return null; // A árvore está vazia
        }

        while (node.getRight() != null) {
            node = node.getRight();
        }

        return node;
    }

    public Node findPredecessor(String data) {
        Node node = search(data);
        if (node == null) {
            return null; // O nó com a chave 'data' não existe na árvore
        }

        if (node.getLeft() != null) {
            return findMax(node.getLeft());
        }

        Node predecessor = null;
        Node current = root;
        while (current != null) {
            if (data.compareTo(current.getData()) < 0) {
                current = current.getLeft();
            } else if (data.compareTo(current.getData()) > 0) {
                predecessor = current;
                current = current.getRight();
            } else {
                break;
            }
        }

        return predecessor;
    }

    public Node findSuccessor(String data) {
        Node node = search(data);
        if (node == null) {
            return null; // O nó com a chave 'data' não existe na árvore
        }

        if (node.getRight() != null) {
            return findMin(node.getRight());
        }

        Node successor = null;
        Node current = root;
        while (current != null) {
            if (data.compareTo(current.getData()) > 0) {
                current = current.getRight();
            } else if (data.compareTo(current.getData()) < 0) {
                successor = current;
                current = current.getLeft();
            } else {
                break;
            }
        }

        return successor;
    }

    public void clear() {
        root = null; // Remover a referência ao nó raiz limpa toda a árvore
    }
}
