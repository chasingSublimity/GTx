public class Node<E> { //inner class
  private E data;
  private Node<E> next;

  Node(E data, Node<E> next) {
      this.data = data;
      this.next = next;
  }

  Node(E data) {
    this(data, null);
  }

  public E getData() {
    return data;
  }

  public void setData(E data) {
    this.data = data;
  }

  public Node<E> getNext() {
    return next;
  }

  public void setNext(Node<E> next) {
    this.next = next;
  }
}