package 设计模式.结构型设计模式.享元模式;

public abstract class IgoChessman {
	
	//共享部分 (内部状态)
	public abstract String getColor();
	
	//不同享部分,根据坐标展示在不同位置(外部状态)
    public void display(Coordinate coordinate){  
        System.out.println("棋子颜色：" + this.getColor() + "，棋子位置：" + coordinate.getX() + "，" + coordinate.getY() );    
    } 
	
}
