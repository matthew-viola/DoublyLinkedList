package lab2;

public class DoublyLinkedList<E> {

	int size;
	Node<E> firstNode;
	Node<E> lastNode;
	
	public DoublyLinkedList() {
		size = 0;
		firstNode = null;
		lastNode = null;
	}
	
	// Problem 1 (15 pts)
	// Fill in the method below to add a new node at the given index with the given element.
	// If index is out of bounds, you must throw an IndexOutOfBoundsException.
	// You must appropriately update all next and prev's.
	// You must appropriately update the firstNode and lastNode.
	// Hint: It's recommended that you use if statements to split into four or five different cases.
 
	public void add(int index, E element) {
    	if(index < 0 || index > size) {
    		throw new IndexOutOfBoundsException("Invalid Index");
    	}
    	else if(size == 0) {
    		firstNode = new Node<E>(element, null, null);
    		lastNode = firstNode;
    		size++;
    	}
    	else if(index == 0) {
       		firstNode = new Node<E>(element, null, firstNode);
    		firstNode.next.prev = firstNode;
       		size++; 		
    	}
    	else if(index == size) {
    		lastNode = new Node<E>(element, lastNode, null);
    		lastNode.prev.next = lastNode;
    		size++;
    	}
    	else {
    		Node<E> next = getNode(index);
            Node<E> previous = getNode(index - 1);
    		Node<E> temp = new Node<E>(element, previous, next);
    		previous.next = temp;
    		next.prev = temp;
    	    size++;
    	}
	}
	
    // Problem 2 (15 pts)
 	// Fill in the method below to remove a new node at the given index.
 	// If index is out of bounds, you must throw an IndexOutOfBoundsException.
 	// You must appropriately update all next and prev's.
 	// You must appropriately update the firstNode and lastNode.
 	// Hint: It's recommended that you use if statements to split into four or five different cases.
	public E remove(int index) {
		if(index < 0 || index >= size) {
    		throw new IndexOutOfBoundsException("Invalid Index");
    	}
		else if(size == 1) {
			E oldval = firstNode.element;
			firstNode = lastNode = null;
			size--;
			return oldval;
		}
		else if(index == 0) {
			E oldval = firstNode.element;
			firstNode = firstNode.next;
			firstNode.prev = null;
			size--;
			return oldval;
		}
		else if(index == size-1){
			E oldval = lastNode.element;
			lastNode = lastNode.prev;
			lastNode.next = null;
			size--;
			return oldval;
		}
		else{
			Node<E> previous = getNode(index - 1);
			Node<E> next = previous.next;
	        E oldval = next.element;
	        previous.next = next.next;
	        next.next.prev = previous;
			size--;
			return oldval;
		}
	}
	
	// Problem 3 (10 pts)
	// Fill in the getNode, getNodeFromFront, and getNodeFromBack methods below to return the node at the given index.
	// The getNodeFromFront method starts from firstNode going forward.
	// The getNodeFromBack method starts from the lastNode going backwards.
	// The getNode method calls the getNodeFromFront method if index < size / 2 and it calls the getNodeFromBack method otherwise.
	// If index is out of bounds, you must throw an IndexOutOfBoundsException.
	public Node<E> getNode(int index){
		if(index < 0 || index > size-1) {
			throw new IndexOutOfBoundsException("Invalid Index");
		}
		else if(index < size / 2) {
			return getNodeFromFront(index);
		}
		else {
			return getNodeFromBack(index);
		}
	}

	private Node<E> getNodeFromFront(int index) {
		Node<E> temp = firstNode;
		for(int i = 0; i <= index -1; i++) {
			temp = temp.next;
			}
		return temp;
	}
	
	private Node<E> getNodeFromBack(int index) {
		Node<E> temp = lastNode;
		for(int i = size -1; i >= index +1; i--) {
			temp = temp.prev;
		}
		return temp;
	}
	
	// Problem 4 (5 pts)
	// Fill in the reverse method below to return a new DoublyLinkedList consisting of the same elements in reverse order.
	// The reverse method must not modify the original DoublyLinkedList.
	// The reverse method must run in linear time.
	public DoublyLinkedList<E> reverse(){
		Node<E> current = lastNode;
		DoublyLinkedList<E> temp = new DoublyLinkedList<E>();
		for(int i = size-1; i >= 0; i--) {
			temp.add(current.element);
			current = current.prev;
		}
		return temp;
	}
	
	public E get(int index) {
		return getNode(index).element;
	}
	
	public E set(int index, E element) {
		Node<E> tempNode = getNode(index);
		E oldValue = tempNode.element;
		tempNode.element = element;
		return oldValue;
	}
	
	// other add, remove, and get methods
	public void add(E element) {
    	add(size, element);
    }
	
	public void addToFront(E element) {
		add(0, element);
	}
	
	public void addToBack(E element) {
		add(element);
	}
	
	public E removeFromFront() {
		return remove(0);
	}
	
	public E removeFromBack() {
		return remove(size - 1);
	}

	public E getFront() {
		return get(0);
	}
	
	public E getBack() {
		return get(size - 1);
	}
	
	// additional methods
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder("start");
		Node<E> currentNode = firstNode;
		for(int i = 0; i < size; i++) {
			builder.append(" <-> [");
			builder.append(currentNode.element);
			builder.append("]");
			currentNode = currentNode.next;
		}
		builder.append(" <-> end");
		
		return builder.toString();
	}
	
}
