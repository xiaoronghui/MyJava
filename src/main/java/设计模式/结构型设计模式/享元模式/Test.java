package 设计模式.结构型设计模式.享元模式;

public class Test {
	public static void main(String[] args) {
		
		IgoChessman black1,black2,black3,white1,white2;  
          
        //通过享元工厂获取三颗黑子  
        black1 = IgoChessmanFactory.getIgoChessman("black");  
        black2 = IgoChessmanFactory.getIgoChessman("black");  
        black3 = IgoChessmanFactory.getIgoChessman("black");  
        System.out.println("判断两颗黑子是否相同：" + (black1==black2));  
  
        //通过享元工厂获取两颗白子  
        white1 = IgoChessmanFactory.getIgoChessman("white");  
        white2 = IgoChessmanFactory.getIgoChessman("white");  
        System.out.println("判断两颗白子是否相同：" + (white1==white2));  
  
        //显示棋子，同时设置棋子的坐标位置  
        black1.display(new Coordinate(1,2));  
        black2.display(new Coordinate(3,4));  
        black3.display(new Coordinate(1,3));  
        white1.display(new Coordinate(2,5));  
        white2.display(new Coordinate(2,4));  
		
		
		
	}
}
