package Java基础.剑侠跑路游戏;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

/**
 * 游戏窗口(需要集成Frame类)
 * @param
 * @author ronghui.xiao
 * @date 2015-1-28
 * @return
 */
public class GameFrame extends Frame {
	private int frameWidth,frameHeight;
	private Toolkit kit = Toolkit.getDefaultToolkit(); //本机工具包,通过该实例可以获取系统的相关信息
	private Dimension screenSize = kit.getScreenSize();//获取屏幕尺寸
	private int screenWidth = screenSize.width;                     
	private int screenHeight = screenSize.height; 
	private List<GameElements> gameElements=new ArrayList<GameElements>();
	private SwordMan swordMan=new SwordMan(200, 200,this);
	Image offScreenImage=null;//声明个图片对象
	private class PaintThread implements Runnable{  //内部线程类,作为一个属性来调用
		public void run() {
			while(true){
				repaint();		//不断的重画游戏界面
				try {
					Thread.sleep(120);//每100ms调用一次
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public GameFrame(){

	}
	
	public GameFrame(int frameWidth,int frameHeight){
		this.frameWidth=frameWidth;
		this.frameHeight=frameHeight;
	}
	//添加要画的游戏元素
	public void addElements(GameElements element){
		gameElements.add(element);
	}
	
	//初始化窗体
	public void initializeFrame(){
		//--------------------------设置窗口属性start-------------------------------------
		 Point point=new Point(screenWidth/2-frameWidth/2,screenHeight/2-frameHeight/2);//窗体左上角的起点坐标
		 this.setBounds(point.x, point.y, frameWidth, frameHeight);
		 this.setBackground(Color.black);
		//--------------------------设置窗口属性end-------------------------------------
		//--------------------------给窗体的关闭按钮绑定事件start---------------------------
		 //窗体受到单击时添加监听事件
		 this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0); //退出程序,从而会关闭窗口
			}
		 });
		 //窗口内有键盘输入的时候触发事件
		 this.addKeyListener(new KeyAdapter() {
			//重写键盘按下事件
			public void keyPressed(KeyEvent e) {
				swordMan.keyPressed(e); //某键被按下让坦克自己根据这个键做相应的处理
			}
		 });
		//--------------------------给窗体的关闭按钮绑定事件end---------------------------
		// gameElements.add(new SwordMan(600,400));//创建个老鼠,老鼠的坐标是相对于frame左上角的坐标为原点的.
		 this.setVisible(true);  //显示窗体
		 new Thread(new PaintThread()).start();	//窗口画完就重画线程
		 //注:在显示窗体的时候,会自动去调用paint方法.因为画窗体的时候肯定有一个画笔,从而会把这个画笔给传给
		 //paint方法
	}
	
	//-------------------------------------画图的方法paint------------------------------------------------
	//重写画图方法
	public void paint(Graphics g) {
		/*
		 	1.此时此刻,我无法知道这个画图的方法怎么用,该怎么画图.
		 	 使用g.drawImage就可以画一幅图片.
		 	2.我搞了一个接口,里面有个draw方法,我要求所有的游戏元素都要实现这个接口.
		 	3.我把所有的要画的游戏元素添加到数组里面,然后遍历循环的画.
		 	4.我现在图已经画出来了,我如何使用上下左右来让图片移动呢?
		 */
		swordMan.draw(g);
	}
	
	//重写update方法,避免在屏幕上用背景色擦除,改为在内存中擦除
	/**
	 *把游戏中的元素先画到图片中,然后再把图片画到屏幕上 
	 */
	public void update(Graphics g) {
		//为null的时候才去新建,省得每次新建浪费空间
		if(offScreenImage==null){
			//在此窗口上新建一个比窗口还要大的图片,返回,让offScreenImage指向它
			offScreenImage=this.createImage(frameWidth,frameHeight);
		}
		Graphics gOffScreen=offScreenImage.getGraphics();//拿到此图片上的画笔
		Color c=gOffScreen.getColor();//获取默认颜色
		gOffScreen.setColor(Color.black);
		gOffScreen.fillRect(0, 0, frameWidth, frameHeight);//1,2参数是相对于该图片的坐标,在图片上用绿颜色方块覆盖
		gOffScreen.setColor(c);//恢复画笔颜色
		paint(gOffScreen);//注意:使用谁的画笔就画在谁身上,调用paint方法,在图片上作画.
		g.drawImage(offScreenImage, 0, 0,null);//把图片画到窗口上,2,3参数是相对于窗口的坐标,4号参数observer表示图片在画的过程中,该参数会根据过程的变化,进行相应的操作,好像是该操作要随图片的变化而变化,在我们这里暂时没什么用
	}
	//--------------------------------------get和set方法--------------------------------------------
	public int getFrameHeight() {
		return frameHeight;
	}

	public void setFrameHeight(int frameHeight) {
		this.frameHeight = frameHeight;
	}

	public int getFrameWidth() {
		return frameWidth;
	}

	public void setFrameWidth(int frameWidth) {
		this.frameWidth = frameWidth;
	}
}

//------------------------------------------不断的重画游戏界面的元素-----------------------------------------------
