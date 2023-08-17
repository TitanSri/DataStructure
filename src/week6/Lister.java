package week6;
/**
 * package week5;
 * 
 * 26/3/22
 */
import java.util.Iterator;
public class Lister<E> implements Iterator<E> {
	
	private Node<E> list;
	
	public Lister(Node<E> head) {
		list = head;
	}

	@Override  // part of the Iterator class
	public boolean hasNext() {
		return (list!=null);
	}

	@Override // part of the Iterator class
	public E next() {
		E answer;
		answer = list.getData();
		list = list.getLink();
		return answer;
	}

}