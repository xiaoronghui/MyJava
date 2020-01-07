package 设计模式.行为型设计模式.责任链模式;

//分店接口（相当于Hanlder）
public interface Subbranch {

  void setSuccessor(Subbranch subbranch);
  
  boolean handleOrder(Order order);
  
}
