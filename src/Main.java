/**
 * @author Kswan creating the entry point and all the methods to be used for
 *         testing each class
 */
public class Main {

  public static void main(String[] args) {

    // knights tour
    System.out.println("-------------------------------------");
    System.out.println("knights tour");
    System.out.println("-------------------------------------");
    KnightsTour tour = new KnightsTour(8);
    tour.solve();

    System.out.println("-------------------------------------");
    System.out.println("Postfix Evaluator");
    System.out.println("-------------------------------------");
    // postfix evaluator, separate by space
    PostfixEvaluator evaluator = new PostfixEvaluator();
    try {
      System.out.println(evaluator.getVal("23 3 + 2 * 150 3 / - 8 /"));
      System.out.println("-------------------------------------");
      System.out.println(evaluator.getVal("3 2 + 2 * 15 2 / - 8 /"));
      System.out.println("-------------------------------------");
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println("-------------------------------------");
    System.out.println("Infix to Postfix");
    System.out.println("-------------------------------------");
    // postfix evaluator, separate by space
    InfixToPostfix converter = new InfixToPostfix();
    try {
      String postfixString = "";

      postfixString = converter.getExpression("12 + 8 * 2 - 6 / 4");
      System.out.println(postfixString);
      System.out.println("-- Evaluating using postfix evaluator --");
      System.out.println(evaluator.getVal(postfixString));
      System.out.println("-------------------------------------");

      postfixString = converter.getExpression("( 12 + 4 ) * 4 - ( 10 / 5 )");
      System.out.println(postfixString);
      System.out.println("-- Evaluating using postfix evaluator --");
      System.out.println(evaluator.getVal(postfixString));

      System.out.println("-------------------------------------");
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
