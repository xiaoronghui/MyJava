package 设计模式.行为型设计模式.解释器模式;

//终结符表达式，对应-、+
public class OperatorExpression implements Expression{

  public void interpreter(Context context) {
      context.setOperator(context.current());//设置运算符
  }
  
}
