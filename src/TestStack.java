
public class TestStack {

  public static void runTest() {

    System.out.println("Creating an integer based stack");
    System.out.println("-------------------------------------");
    MyStack<Integer> stack = new MyStack<Integer>();

    System.out.println("push 2,3,5,6,8,9 to the stack");
    stack.push(2);
    stack.push(3);
    stack.push(5);
    stack.push(6);
    stack.push(8);
    stack.push(9);
    System.out.println("Adding completed");

    System.out.print("\n");
    System.out.println("Printing new sequence of items");
    Integer[] newlist = stack.list.toArray(Integer.class);
    for (int i = 0; i < newlist.length; i++) {
      System.out.print(newlist[i] + ",");
    }
    System.out.print("\n");

    System.out.println("\nChecking isEmtpy() : " + stack.isEmpty());

    System.out.println("\nPeek item : " + stack.peek());

    System.out.println("\npopping an item : " + stack.pop());

    System.out.println("\nsearching for 7 : " + stack.search(7));
    System.out.println("\nsearching for 5 : " + stack.search(5));

    System.out.print("\n");
    System.out.println("Printing new sequence of items");
    newlist = stack.list.toArray(Integer.class);
    for (int i = 0; i < newlist.length; i++) {
      System.out.print(newlist[i] + ",");
    }
    System.out.print("\n");
  }

}
