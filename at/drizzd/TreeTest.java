package at.drizzd;
import java.util.Vector;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class TreeTest {
	private static Tree<Object> tree;
	private static Node<Object> first = new Node<Object>(5, "five");
	private static Node<Object> smaller = new Node<Object>(-3, "minus three");
	private static Node<Object> bigger = new Node<Object>(10, "ten");
	private static Node<Object> even_smaller = new Node<Object>(-10, "minus ten");
	private static Node<Object> first_plus_one = new Node<Object>(6, "six");

	@Before
	public void init() {
		tree = new Tree<Object>();
		tree.addNode(first);
		tree.addNode(smaller);
		tree.addNode(bigger);
		tree.addNode(even_smaller);
		tree.addNode(first_plus_one);
	}

	@Test
	public void testEmpty() {
		Tree<Object> empty = new Tree<Object>();
		assertEquals(null, empty.getRoot());
	}

	@Test
	public void testNodes() {
		assertEquals(first, tree.getRoot());
		assertEquals(smaller, tree.getRoot().getLeft());
		assertEquals(null, tree.getRoot().getLeft().getRight());
		assertEquals(bigger, tree.getRoot().getRight());
		assertEquals(even_smaller, tree.getRoot().getLeft().getLeft());
		assertEquals(first_plus_one, tree.getRoot().getRight().getLeft());
	}

	@Test
	public void testGet() {
		assertEquals("minus ten", tree.get(-10));
		assertEquals("minus three", tree.get(-3));
		assertEquals(null, tree.get(4));
		assertEquals("five", tree.get(5));
		assertEquals("six", tree.get(6));
		assertEquals("ten", tree.get(10));
	}

	@Test
	public void testList() {
		Node<Object> prev = null;
		Vector<Node<Object>> v = tree.list();
		for (int i = 0; i < v.size(); i++) {
			if (prev != null)
				assert(v.get(i).getKey() > prev.getKey());
			prev = v.get(i);
		}
	}

	@Test
	public void printList() {
		Vector<Node<Object>> v = tree.list();
		for (int i = 0; i < v.size(); i++) {
			System.out.printf("%d, ", v.get(i).getKey());
		}
		System.out.printf("\n");
	}

	@Test
	public void testRemove() {
		tree.remove(6);
		assertEquals(null, tree.get(6));
	}
}
