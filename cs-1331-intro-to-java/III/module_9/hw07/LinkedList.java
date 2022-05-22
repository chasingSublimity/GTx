import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {
  private Node<E> head; 
  private Node<E> tail;
  private int size;

  public LinkedList() {
      head = null;
      tail = null;
      size = 0;
  }

  public Node<E> getHead() {
    return head;
  }

  public Node<E> getTail() {
    return tail;
  }

  public void addAtIndex(E data, int index) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException ("Your index is out of the list bounds");
    } else if (data == null) {
      throw new IllegalArgumentException ("You cannot add null data to the list");
    }


    if (index == 0) {
      head = new Node<E>(data, head);
      if (size == 0) tail = head;
    } else {
      int currentIdx = 0;
      Node<E> curr = head;
  
      while (currentIdx != index - 1) {
        curr = curr.getNext();
        currentIdx++;
      }

      Node<E> newNext = curr.getNext() != null ? curr.getNext().getNext() : null;

      curr.setNext(new Node<E>(data, newNext));
      if (index == (size - 1)) {
        tail = curr.getNext();
      }
    }
    size++;
  }

  public E getAtIndex(int index) {
    if (index < 0 || index > size - 1) {
      throw new IllegalArgumentException ("Your index is out of the list bounds");
    }

    if (index == 0) {
      return head.getData();
    } else if (index == (size - 1)) {
      return tail.getData();
    } else {
      Node<E> curr = head;
      int currIdx = 0;
      while (currIdx != index) {
        curr = curr.getNext();
        currIdx++;
      }
      return curr.getData();
    }
  }

  public E removeAtIndex(int index) {
    if (index < 0 || index > size - 1) {
      throw new IllegalArgumentException ("Your index is out of the list bounds");
    }

    if (index == 0) {
      E tmpData = head.getData();
      head = head.getNext();
      return tmpData;
    }
    
    int currentIdx = 0;

    Node<E> curr = head;
    while (currentIdx != index - 1) {
      curr = curr.getNext();
      currentIdx++;
    }
    
    E tmpData = curr.getNext() != null ? curr.getNext().getData() : null;
    if (index == (size - 1)) {
      curr.setNext(null);
    } else {
      curr.setNext(curr.getNext().getNext());
    }

    size--;
    return tmpData;
  }

  public E remove(E data) {
    if (data == null) {
      throw new IllegalArgumentException("You cannot remove null data from the list");
    }

    Node<E> curr = head;
    Node<E> prev = null;
    while (curr != null) {
      if (curr.getData().equals(data)) {
        E foundData = curr.getData();
        if (curr == head) {
          head = head.getNext();
        } else if (curr == tail) {
          tail = prev;
        } else {
          prev.setNext(curr.getNext());
        }
        size--;
        return foundData;
      } else {
        prev = curr;
        curr = curr.getNext();
      }
    }

    // if we make it this far, theres nothing to remove
    throw new NoSuchElementException("The data is not present in the list.");
  }

  public void clear() {
    head = null;
    tail = null;
    size = 0;
  }
  
  public boolean isEmpty() {
    return (head == null);
  }
  
  public int size() {
    return size;
  }

  public String toString() {

      Node<E> current = head; //traversal starts at the front
      String result = ""; //result starts empty

      while (current != null) {  //keep going until there's no more nodes to point to
          result = result + current.getData().toString() + " -> ";
          current = current.getNext(); //move over to next node
      }
      return result + "null";
  }

  public static void main(String[] args) {
      LinkedList<String> favBabySongs = new LinkedList<>();
      favBabySongs.addAtIndex("Hiya", 0);
      favBabySongs.addAtIndex("Hello", 1);
      System.out.println("1: " + favBabySongs);
      favBabySongs.remove("Hello");
      System.out.println("2: " + favBabySongs);
      favBabySongs.addAtIndex("Hello", 1);
      favBabySongs.addAtIndex("Howdy", 2);
      System.out.println("3: " + favBabySongs);
      String removed = favBabySongs.removeAtIndex(0);
      System.out.println("removed: " + removed);
      System.out.println("4: " + favBabySongs);
      String gotten = favBabySongs.getAtIndex(1);
      System.out.println("Should be Howdy: " + gotten);
      favBabySongs.clear();
      System.out.println("5: " + favBabySongs);
  }
}