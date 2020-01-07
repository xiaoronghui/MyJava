package 设计模式.行为型设计模式.策略模式;

//初级会员折扣类实现
public class PrimaryDiscountStrategy implements DiscountStrategy{

	@Override
	public double calcPrice(double booksPrice) {
		System.out.println("初级会员不打折");
		return booksPrice;
	}

}
