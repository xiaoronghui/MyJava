package 设计模式.行为型设计模式.策略模式;

//高级会员折扣类实现
public class AdvancedDiscountStrategy implements DiscountStrategy {

	@Override
	public double calcPrice(double booksPrice) {
		System.out.println("高级会员打8折");
		return booksPrice * 0.8;
	}

}
