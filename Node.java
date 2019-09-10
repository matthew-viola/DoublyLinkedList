package lab2;

public class Node<E> {

	public E element;
	public Node<E> prev;
	public Node<E> next;
	
	public Node(E element, Node<E> prev, Node<E> next) {
		this.element = element;
		this.prev = prev;
		this.next = next;
	}
	
}