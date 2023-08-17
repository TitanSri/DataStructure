package LinkedQueue;
/**
 * Had to change copy the code from week 5
 * THIS IS NOT THE ORIGNIAL CODE FOR LINKEDQUEUE
 * 
 * THE ORIGINAL CODE IS IN THE LINKEDQUEUE FOLDER
 */

import java.util.Iterator;


public class Lister<E> implements Iterator<E> {
	
	private Node<E> list;
	
	public Lister(Node<E> head) {
		list = head;
	}

	@Override
	public boolean hasNext() {
		return (list!=null);
	}

	@Override
	public E next() {
		E answer;
		answer = list.getData();
		list = list.getLink();
		return answer;
	}

}