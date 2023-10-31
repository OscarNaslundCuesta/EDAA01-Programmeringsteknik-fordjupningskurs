 public class Queue<E> {
    private Node<E> first;  // reference to the first element
    private Node<E> last;   // reference to the last element

    public Queue() {
        first = last = null;
    }

  /** Inserts the specified element at the end of this queue. */
   public void add(E x) {
       Node<E> newNode = new Node<>(x);

       if (first == null) {
           first = last = newNode;

        } else {
            last.next = newNode;
            last = newNode;
        }
   }

   /** Removes and returns the first element in this queue.
       Returns null if this dequeue is empty. */
   public E remove() {
        if (first == null) {
           return null;
        }
        Node<E> temp = first;
        first = first.next;

        if (first == null) {
            last = null;
        }

        return temp.element;
    }
   }

    private static class Node<E> {
        private E element;
        private Node<E> next;

        private Node(E element) {
            this.element = element;
            next = null;
        }
    }
}