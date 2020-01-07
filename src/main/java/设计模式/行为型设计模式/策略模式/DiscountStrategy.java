package 设计模式.行为型设计模式.策略模式;

//抽象折扣策略
public interface DiscountStrategy {
	
	 /**
     * 计算图书的价格
     * @param booksPrice    图书的原价
     * @return    计算出打折后的价格
     */
    public double calcPrice(double booksPrice);
    
}
