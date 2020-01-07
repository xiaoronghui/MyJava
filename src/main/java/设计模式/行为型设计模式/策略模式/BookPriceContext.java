package 设计模式.行为型设计模式.策略模式;

//环境(Context)角色,实际场景中这个类可能还有其它方法,不仅仅只有quote方法.而且算法前后也有一些业务逻辑
public class BookPriceContext {
	
	private DiscountStrategy discountStrategy;

	public BookPriceContext(DiscountStrategy discountStrategy) {
		super();
		this.discountStrategy = discountStrategy;
	}
	
	/**
     * 报价
     * @param booksPrice    图书的原价
     * @return    计算出打折后的价格
     */
    public double quote(double bookPrice){
    	System.out.println("正在计算图书报价");
    	double price = this.discountStrategy.calcPrice(bookPrice);
    	System.out.println("计算图书报价结束");
        return price;
    }
	
}
