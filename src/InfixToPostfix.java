public class InfixToPostfix {

  private MyStack<String> expressionStack;

  public InfixToPostfix() {
  }

  public String getExpression(String infixExpression) throws Exception {
    expressionStack = new MyStack<String>();
    String postfixString = "";

    System.out.println("Input infix string - " + infixExpression);

    String token[] = StringUtility.GetTokensFromString(infixExpression, " ");

    if (token.length == 1) {
      throw new Exception("Not enough operators");
    } else {

      for (int index = 0; index < token.length; ++index) {
        String value = token[index];

        if (value.equals("(")) {
          expressionStack.push("(");
        } else if (value.equals(")")) {
          String operator = expressionStack.peek();

          while (!(operator.equals("(")) && !(expressionStack.isEmpty())) {
            expressionStack.pop();
            postfixString += " " + operator;
            if (!expressionStack.isEmpty())
              operator = expressionStack.peek();
          }
          expressionStack.pop();
        } else if (value.equals("+") || value.equals("-")) {

          if (expressionStack.isEmpty()) {
            expressionStack.push(value);
          } else {
            String operator = expressionStack.peek();
            while (!(expressionStack.isEmpty() || operator.equals(("(")) || operator.equals((")")))) {
              operator = expressionStack.pop();
              postfixString += " " + operator;
            }
            expressionStack.push(value);
          }
        } else if (value.equals("*") || value.equals("/")) {
          if (expressionStack.isEmpty()) {
            expressionStack.push(value);
          } else {
            String operator = expressionStack.peek();
            while (!operator.equals(("(")) && !operator.equals(("+")) && !operator.equals(("-"))
                && !expressionStack.isEmpty()) {
              operator = expressionStack.pop();
              postfixString += " " + operator;
            }
            expressionStack.push(value);
          }
        } else {
          int input = 0;

          try {
            input = Integer.parseInt(value);
          } catch (Exception ex) {
            throw new ArithmeticException("Not a valid number - " + value);
          }

          postfixString += " " + input;
        }
      }
    }

    while (!expressionStack.isEmpty()) {
      String operator = expressionStack.peek();
      if (!operator.equals(("("))) {
        expressionStack.pop();
        postfixString += " " + operator;
      }
    }
    return postfixString;
  }

}
