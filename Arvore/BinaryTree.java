package Arvore;

// Nome dos Integrantes:
// Caio Alexandre V.B. de Andrade, TIA - 32229690.
// Diego Oliveira Aluizio, TIA - 32247591.
// Nicolas Fernandes Melnik, TIA - 32241720.

// Referências:
// Código feito em aula com o professor.
// Material do moodle sobre árvores binárias. Disponível em: https://graduacao.mackenzie.br/mod/resource/view.php?id=986864.

public class BinaryTree {

	protected Node root;

	public BinaryTree() {
	    
	}
	public BinaryTree(Node root) {
		this.root = root;
	}
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	public Boolean isEmpty() {
		if (root == null) {
			return true;
		}
		return false;
	}
	public int getDegree() {
		return root.getDegree();
	}
	public int getHeight() {
		return root.getHeight();
	}
    public void inOrderTraversal() {
        inOrderTraversal(root);
        System.out.println();
    }
    public void preOrderTraversal() {
        preOrderTraversal(root);
        System.out.println();
    }
    public void postOrderTraversal() {
        postOrderTraversal(root);
        System.out.println();
    }
    protected void inOrderTraversal(Node node) {
        if(isEmpty()){
          System.out.print("A árvore está vazia");
        }
        if (node != null) {
            inOrderTraversal(node.getLeft());
            System.out.print(node);
            inOrderTraversal(node.getRight());
        }
    }
    protected void preOrderTraversal(Node node) {
        if(isEmpty()){
          System.out.print("A árvore está vazia");
        }
        if (node != null) {
            System.out.print(node.getData() + " ");
            preOrderTraversal(node);
            preOrderTraversal(node.getRight());
        }
    }
    protected void postOrderTraversal(Node node) {
        if(isEmpty()){
          System.out.print("A árvore está vazia");
        }
        if (node != null) {
            postOrderTraversal(node.getLeft());
            postOrderTraversal(node);
            System.out.print(node.getData() + " ");
        }
    }
}
