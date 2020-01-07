package 设计模式.行为型设计模式.解释器模式;

//非终结符表达式，对应number
public class NumberExpression implements Expression{

  public void interpreter(Context context) {
      //设置操作数
      Integer operateNumber = Integer.valueOf(String.valueOf(context.current()));
      if (context.getOperateNumbers().size() == 0) {
          context.setLeftOperateNumber(operateNumber);
          context.setResult(operateNumber);
      }else {
          context.setRightOperateNumber(operateNumber);
          Expression expression = new ArithmeticExpression();//转换成算数表达式
          expression.interpreter(context);
      }
  }

}
