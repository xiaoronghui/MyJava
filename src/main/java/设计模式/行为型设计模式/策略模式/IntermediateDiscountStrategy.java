package 设计模式.行为型设计模式.策略模式;

//中级会员折扣类实现
public class IntermediateDiscountStrategy implements DiscountStrategy {

	@Override
	public double calcPrice(double booksPrice) {
		System.out.println("中级会员打9折");
		return booksPrice * 0.9;
	}

}
