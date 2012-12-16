package at.drizzd;

public class Node<Value>  {
	int key;
	Value value;
	Node<Value> left;
	Node<Value> right;
	
	Node(int key, Value value)
	{
		this.key = key;
		this.value = value;
	}

	public int getKey() {
		return key;
	}

	public Node<Value> getLeft() {
		return left;
	}

	public void setLeft(Node<Value> left) {
		this.left = left;
	}

	public Node<Value> getRight() {
		return right;
	}

	public void setRight(Node<Value> right) {
		this.right = right;
	}

	public Value getValue() {
		return value;
	}
}
