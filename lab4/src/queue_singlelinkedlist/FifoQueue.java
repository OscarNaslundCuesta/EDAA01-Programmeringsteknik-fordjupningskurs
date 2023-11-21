package queue_singlelinkedlist;

import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		super();
		last = null;
		size = 0;
	}

	/**
	 * Inserts the specified element into this queue, if possible post: The
	 * specified element is added to the rear of this queue
	 * 
	 * @param e the element to insert
	 * @return true if it was possible to add the element to this queue, else false
	 */
	public boolean offer(E e) {
		if (e == null) {
			return false;
		}
		QueueNode<E> newNode = new QueueNode<E>(e);

		if (last == null) {
			last = newNode;
			newNode.next = newNode; // =newNode?
		} else {
			newNode.next = last.next;  // newnode.next = första element
			last.next = newNode;
			last = newNode;
		}
		size++;
		return true;
	}

	/**
	 * Returns the number of elements in this queue
	 * 
	 * @return the number of elements in this queue
	 */
	public int size() {
		return size;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue, returning null if
	 * this queue is empty
	 * 
	 * @return the head element of this queue, or null if this queue is empty
	 */
	public E peek() {
		if (last == null) { // empty queue
			return null;
		}

		return last.next.element;

	}

	/**
	 * Retrieves and removes the head of this queue, or null if this queue is empty.
	 * post: the head of the queue is removed if it was not empty
	 * 
	 * @return the head of this queue, or null if the queue is empty
	 */
	public E poll() {
		if (last == null) { // empty queue
			return null;
		}

		QueueNode<E> firstNode = last.next;

		if (last == last.next) { // only one node in queue
			last = null;  //LAST.NEXT ???
		} else {
			last.next = firstNode.next; // multiple nodes left
		}

		size--;
		return firstNode.element;
	}

	/**
	 * Returns an iterator over the elements in this queue
	 * 
	 * @return an iterator over the elements in this queue
	 */
	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos;
		private QueueNode<E> startPos;
		private boolean atStart;

		/* Konstruktor */
		private QueueIterator() {
			if (last != null) {
				pos = last.next; // initialize pos to first element
				startPos = last.next; // initialize startPos to first element
				atStart = true;
			} else {
				pos = null;
				startPos = null;
			}
		}

		public boolean hasNext() {
			if (last == null || pos == null) {
				return false;
			}
			if (atStart) {
		        return true;  // first element
		    }
		    return pos.next != startPos;
		}

		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			
			if (atStart) {
		        atStart = false;
		        return pos.element;  // no advance
		    }
		    pos = pos.next;
		    return pos.element;
		}
	}
	
	/**
	* Appends the specified queue to this queue
	* post: all elements from the specified queue are appended
	* to this queue. The specified queue (q) is empty after the call.
	* @param q the queue to append
	* @throws IllegalArgumentException if this queue and q are identical
	*/
	public void append(FifoQueue<E> q) {
		if (q == this) {
			throw new IllegalArgumentException();
		}
		
		if (q.last == null || q.size() == 0) {
			return;
		}
		
		if (last == null) { // tom queueu
			this.last = q.last;
		} else {
			QueueNode<E> previousFirst = last.next; //save first node of this
			last.next = q.last.next; //connect last of this to first of q
			last = q.last;  //update last label
			last.next = previousFirst; //connect last of q to first of this
			
		}
		
		this.size += q.size();
		q.last = null;
		q.size = 0;
	}

	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}

}
