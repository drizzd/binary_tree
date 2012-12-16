package at.drizzd;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class TreeTest {
	private static Tree<Object> tree;
	
	@Before
	public void init() {
		tree = new Tree<Object>();
	}

	private void addNodes() {
		Node<Object> first = new Node<Object>(5, "five");
		assertEquals(null, tree.getRoot());
		tree.addNode(first);
		assertEquals(first, tree.getRoot());
		
		Node<Object> smaller = new Node<Object>(-3, "minus three");
		tree.addNode(smaller);
		assertEquals(smaller, tree.getRoot().getLeft());
		assertEquals(null, tree.getRoot().getRight());
		
		Node<Object> bigger = new Node<Object>(10, "ten");
		tree.addNode(bigger);
		assertEquals(bigger, tree.getRoot().getRight());
		
		Node<Object> even_smaller = new Node<Object>(-10, "minus ten");
		tree.addNode(even_smaller);
		assertEquals(even_smaller, tree.getRoot().getLeft().getLeft());
		
		Node<Object> first_plus_one = new Node<Object>(6, "six");
		tree.addNode(first_plus_one);
		assertEquals(first_plus_one, tree.getRoot().getRight().getLeft());
	}
	
	@Test
	public void testAdd() {
		addNodes();
	}

	@Test
	public void testGet() {
		addNodes();
		assertEquals("minus ten", tree.get(-10));
		assertEquals("minus three", tree.get(-3));
		assertEquals(null, tree.get(4));
		assertEquals("five", tree.get(5));
		assertEquals("six", tree.get(6));
		assertEquals("ten", tree.get(10));
	}
}
