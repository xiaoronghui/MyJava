package 设计模式.行为型设计模式.解释器模式;

//语法解析器（如果按照解释器模式的设计，这些代码应该是在客户端，为了更加清晰，我们添加一个语法解析器）
public class GrammarParser {

  //语法解析
  public void parse(Context context) throws Exception{
      while (context.hasNext()) {
          Expression expression = null;
          
          //每检测一个字符就要根据上下文来验证下语法(这就是上下文的含义和作用)
          switch (context.current()) {
              case '+':
              case '-':
                  checkGrammar(context);
                  expression = new OperatorExpression();
                  break;
              case '0':
              case '1':
              case '2':
              case '3':
              case '4':
              case '5':
              case '6':
              case '7':
              case '8':
              case '9':
                  context.mark();
                  checkGrammar(context, context.current());
                  context.reset();
                  expression = new DigitExpression();
                  break;
              default:
                  throw new RuntimeException("语法错误！");//无效符号
          }
          //表达式解释运行上下文,每个表达式都要解释运行一下
          expression.interpreter(context);
          context.next();
      }
  }
  //检查语法
  private void checkGrammar(Context context,char current){
      context.next();
      if (context.hasNext() && context.current() != '+' && context.current() != '-') {
          throw new RuntimeException("语法错误！");//第5条
      }
      try {
          Integer.valueOf(String.valueOf(current));
      } catch (Exception e) {
          throw new RuntimeException("语法错误！");//第6条
      }
  }
  //检查语法
  private void checkGrammar(Context context){
      if (context.getOperateNumbers().size() == 0) {//第4条
          throw new RuntimeException("语法错误！");
      }
      if (context.current() != '+' && context.current() != '-') {//第7条
          throw new RuntimeException("语法错误！");
      }
  }
  
}
