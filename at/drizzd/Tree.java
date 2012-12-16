package at.drizzd;

public class Tree<Value> {
	Node<Value> root;
	
	Tree() {}
	void addNode(Node<Value> node) {
		root = addNodeRec(root, node);
	}
	
	Node<Value> addNodeRec(Node<Value> root, Node<Value> node) {
		if (root == null)
			root = node;
		else if (node.getKey() < root.getKey())
			root.setLeft(addNodeRec(root.getLeft(), node));
		else
			root.setRight(addNodeRec(root.getRight(), node));

		return root;
	}
	
	public Node<Value> getRoot() {
		return root;
	}

	public void add(int key, Value value) {
		addNode(new Node<Value>(key, value));
	}

	public Value get(int key) {
		Node<Value> node = getNodeRec(root, key);
		if (node == null)
			return null;
		return node.getValue();
	}

	private Node<Value> getNodeRec(Node<Value> root, int key) {
		if (root == null || root.getKey() == key)
			return root;
		else if (key < root.getKey())
			return getNodeRec(root.getLeft(), key);
		else
			return getNodeRec(root.getRight(), key);
	}
}
