import java.util.*;

public class PostfixEvaluator {

  private MyStack<String> expressionStack;
  private ArrayList<String> operators = new ArrayList<String>();

  public PostfixEvaluator() {
    operators.add("+");
    operators.add("-");
    operators.add("*");
    operators.add("/");
  }

  public String getVal(String expression) throws Exception {

    expressionStack = new MyStack<String>();

    System.out.println("Input postfix string - " + expression);

    String token[] = StringUtility.GetTokensFromString(expression.trim(), " ");

    if (token.length == 1) {
      throw new Exception("Not enough operator");
    } else {
      for (int k = 0; k < token.length; k++) {

        String letter = token[k];

        if (operators.contains(letter)) {

          float topVal = getNextNumberFromStack();
          float nextVal = getNextNumberFromStack();

          // System.out.println("operator - " + letter);

          switch (letter) {
          case "+":
            expressionStack.push(Float.toString(nextVal + topVal));
            break;
          case "-":
            expressionStack.push(Float.toString(nextVal - topVal));
            break;
          case "*":
            expressionStack.push(Float.toString(nextVal * topVal));
            break;
          case "/":
            if (topVal == 0)
              throw new ArithmeticException(
                  "Dividing by 0 will be undefined. Peek on stack - " + expressionStack.peek());
            expressionStack.push(Float.toString(nextVal / topVal));
            break;
          }

        } else {
          float input = 0;

          try {
            input = Float.parseFloat(letter);
          } catch (Exception ex) {
            throw new ArithmeticException(
                "Not a valid number - " + letter + ". Peek on stack - " + expressionStack.peek());
          }

          expressionStack.push(Float.toString(input));

        }
      }

      String tempString = expressionStack.pop();

      if (expressionStack.isEmpty())
        return tempString;
      else
        throw new Exception("Incorrect postfix expression. Please check again");
    }

  }

  private float getNextNumberFromStack() throws Exception {
    String tempString = "";
    float currNum = 0;

    if (expressionStack.isEmpty())
      throw new Exception("Not a valid expression. Please check again");

    tempString = expressionStack.pop();

    // System.out.println("number - " + tempString);

    try {
      currNum = Float.parseFloat(tempString);
    } catch (Exception ex) {
      throw new ArithmeticException("Not a valid number - " + tempString);
    }

    return currNum;
  }

}
