
public class MyStack<T> {

  MyCircularLinkedList<T> list;

  MyStack() {
    list = new MyCircularLinkedList<T>();
  }

  public boolean push(T item) {
    return list.add(item);
  }

  public T pop() {
    return list.remove(1);
  }

  public T peek() {
    return list.get(1);
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }

  public int search(T item) {
    return list.indexOf(item);
  }
}
