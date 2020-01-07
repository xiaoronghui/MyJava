package 设计模式.行为型设计模式.策略模式;

public class Test {
	
	public static void main(String[] args) {
		
	   //书本原价
	   double bookPrice = 300;
	
	   //当前是中级会员,采用中级会员打折策略
	   BookPriceContext bookPriceContext = new BookPriceContext(new IntermediateDiscountStrategy());
	   
	   //打折后的价格
	   System.out.println(bookPriceContext.quote(bookPrice));
	   
	}
	
}
