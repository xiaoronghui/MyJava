package 设计模式.行为型设计模式.解释器模式;

//抽象表达式，定义一个解释操作
public interface Expression {

 //解释运行上下文,这就是表达式需要做的事情
  void interpreter(Context context);
  
}
