package Java基础.剑侠跑路游戏;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class 分析 {
	public static void main(String[] args) {
		/*
	 	1.首先我得创建一个游戏窗口.那该用什么类呢?
	 	Frame就是窗口类,我想要800*500的窗口,黑色的背景,从而我得去看API
	 	gameWindow.setBounds(100, 100, 800, 500);无法居中啊,怎么办?
	 	2.我得知道每台电脑屏幕的大小,才能计算出左上角的坐标,那和屏幕相关的类是什么?
	 	   我找到了一个叫Toolkit的类,该类可以的实例可以拿到屏幕的尺寸
	 	Toolkit类的说明:
	 		Toolkit类是一个抽象类，该类的子类用于将各种组件与本机工具包绑定起来，
	 		最常用的方法是getDefaultToolkit()-->返回默认工具包，工具包用来提供一些获取资源的方法
	 	Dimension类 :尺寸 面积的意思.
	 	    getScreenSize返回的高度和宽度封装到了Dimension类中
	 	3.为了让窗体居中显示,也就是根据屏幕的尺寸和窗体的尺寸计算出窗体左上角起始点的坐标
	 	    x=screenWidth/2-frameWidth/2; y=screenHeight/2-frameHeight/2;
	 	4.我已经画好了一个窗体了,但是窗口无法关闭,我该怎么给这个窗体绑定事件呢?
	 	5.gameWindow.addWindowListener()给窗体添加一个监听者,需要一个WindowListener的参数
	 	   WindowListener是一个接口,它的有个叫WindowAdapter的子类
	 	   我们new一个WindowAdapter对象,addWindowListener是把WindowAdapter添加到监听的列表中,
	 	   当点击关闭的时候,就会去遍历这个列表,然后调用相应的方法.比如,关闭按钮就回去掉WindowAdapter的
	 	    windowClosing方法.-->这里涉及到一个适配器的设计模式
	 	 6.我想在屏幕中画一幅小人图片?怎么办呢?
	 	  gameWindow.paint(Graphics g) 需要传入一个Graphics类,
	 	  Graphics类可以提供画图形的方法.该类我们通常称之为画笔类,它的实例称之为画笔;
	 	  Graphics的哪个方法可以画图形呢?Graphics是一个抽象类,Graphics如何创建实例呢?
	 	  它的直接子类有Graphics2D.
	 	  其实画窗体的时候就有一个画笔,该画笔在Frame中可以获取,比如gameWindow.getGraphics()
	 	  但是画图要在paint方法内画.从而我们得创建一个类继承Frame类,然后重写paint方法才能把图画出来.
	 	  7.因为做不下去了,我只好创建一个GameFrame类然后继承Frame类.然后在GameStart来启动游戏.
	 	     
	 */
	Frame gameWindow=new Frame();
	//--------------------------设置窗口属性start-------------------------------------
	int frameWidth=800,frameHeight=500; //窗体的宽和高
	Toolkit kit = Toolkit.getDefaultToolkit(); //本机工具包,通过该实例可以获取系统的相关信息
	Dimension screenSize = kit.getScreenSize();//获取屏幕尺寸
	 int screenWidth = screenSize.width;                     
	 int screenHeight = screenSize.height; 
	 Point point=new Point(screenWidth/2-frameWidth/2,screenHeight/2-frameHeight/2);//窗体左上角的起点坐标
	 gameWindow.setBounds(point.x, point.y, frameWidth, frameHeight);
	 gameWindow.setBackground(Color.black);
	//--------------------------设置窗口属性end-------------------------------------
	//--------------------------给窗体的关闭按钮绑定事件start---------------------------
	 gameWindow.addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e) {
			System.exit(0); //退出程序,从而会关闭窗口
		}
	 });
	//--------------------------给窗体的关闭按钮绑定事件end---------------------------
	// Graphics g=new Graphics2D();
	 //gameWindow.paint(g)
	 gameWindow.show(); //显示窗体
	}
}
