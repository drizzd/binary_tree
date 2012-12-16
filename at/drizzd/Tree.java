package at.drizzd;

import java.util.Vector;

public class Tree<Value> {
	Node<Value> root;

	Tree() {}
	void addNode(Node<Value> node) {
		root = addNodeRec(root, node);
	}

	Node<Value> addNodeRec(Node<Value> root, Node<Value> node) {
		if (root == null) {
			root = node;
		} else if (node.getKey() == root.getKey()) {
			node.setLeft(root.getLeft());
			node.setRight(root.getRight());
			root = node;
		} else if (node.getKey() < root.getKey()) {
			root.setLeft(addNodeRec(root.getLeft(), node));
		} else {
			root.setRight(addNodeRec(root.getRight(), node));
		}

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
		if (root == null || key == root.getKey())
			return root;
		else if (key < root.getKey())
			return getNodeRec(root.getLeft(), key);
		else
			return getNodeRec(root.getRight(), key);
	}

	private Node<Value> getSmallest(Node<Value> root) {
		while (root.getLeft() != null) {
			root = root.getLeft();
		}
		return root;
	}

	private Node<Value> removeNodeRec(Node<Value> root, int key) {
		if (root == null)
			return null;
		else if (key == root.getKey()) {
			Node<Value> new_root = root.getLeft();
			if (root.getRight() != null) {
				Node<Value> smallestRight = getSmallest(root.getRight());
				smallestRight.setLeft(new_root.getRight());
				new_root.setRight(root.getRight());
			}
			root = new_root;
		} else if (key < root.getKey())
			root.setLeft(removeNodeRec(root.getLeft(), key));
		else
			root.setRight(removeNodeRec(root.getRight(), key));

		return root;
	}

	public void remove(int key) {
		root = removeNodeRec(root, key);
	}

	private void listRec(Vector<Node<Value>> v, Node<Value> root) {
		if (root == null)
			return;

		listRec(v, root.getLeft());
		v.add(root);
		listRec(v, root.getRight());
	}

	public Vector<Node<Value>> list() {
		 Vector<Node<Value>> v = new Vector<Node<Value>>();
		 listRec(v, root);
		 return v;
	}
}
