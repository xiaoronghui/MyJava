package Java基础.剑侠跑路游戏;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;


/**
 *剑侠类 
 * @param
 * @author ronghui.xiao
 * @date 2015-1-29
 * @return
 */
public class SwordMan implements GameElements{
	int x,y,w,h; 				//坐标和宽高
	GameFrame gameFrame;
	int speed=30;
	Dir oldDir=Dir.STOP;
	Dir dir=Dir.STOP;		//默认右边
	
	ImageIcon[] runImgs_U={
			new ImageIcon(getClass().getResource("imgs/swordman/u1.png")),
			new ImageIcon(getClass().getResource("imgs/swordman/u2.png")),
			new ImageIcon(getClass().getResource("imgs/swordman/u3.png")),
			new ImageIcon(getClass().getResource("imgs/swordman/u4.png")),
			new ImageIcon(getClass().getResource("imgs/swordman/u5.png")),
	};
	ImageIcon[] runImgs_D={
			new ImageIcon(getClass().getResource("imgs/swordman/d1.png")),
			new ImageIcon(getClass().getResource("imgs/swordman/d2.png")),
			new ImageIcon(getClass().getResource("imgs/swordman/d3.png")),
			new ImageIcon(getClass().getResource("imgs/swordman/d4.png")),
			new ImageIcon(getClass().getResource("imgs/swordman/d5.png")),
	};
	ImageIcon[] runImgs_L={
			new ImageIcon(getClass().getResource("imgs/swordman/L1.png")),
			new ImageIcon(getClass().getResource("imgs/swordman/L2.png")),
			new ImageIcon(getClass().getResource("imgs/swordman/L3.png")),
			new ImageIcon(getClass().getResource("imgs/swordman/L4.png")),
			new ImageIcon(getClass().getResource("imgs/swordman/L5.png")),
	};
	ImageIcon[] runImgs_R={
			new ImageIcon(getClass().getResource("imgs/swordman/r1.png")),
			new ImageIcon(getClass().getResource("imgs/swordman/r2.png")),
			new ImageIcon(getClass().getResource("imgs/swordman/r3.png")),
			new ImageIcon(getClass().getResource("imgs/swordman/r4.png")),
			new ImageIcon(getClass().getResource("imgs/swordman/r5.png")),
	};
	int step=0;
	
	public SwordMan(int x, int y,GameFrame gameFrame) {
		this.x = x;
		this.y = y;
		this.gameFrame=gameFrame;
	}
	
	//画出自己
	public void draw(Graphics g){
		Color c=g.getColor();
		if(dir==Dir.U){
			if(y<=0)y=gameFrame.getFrameHeight();
			if(step<runImgs_U.length){
				g.drawImage(runImgs_U[step].getImage(),x,y,null); //画下一个动作
				move(); //先移动,然后画
				step++;
			}else{
				g.drawImage(runImgs_U[0].getImage(),x,y,null); //停下来的时候就是第一张图片
			}
		}else if(dir==Dir.D){
			if(y>=gameFrame.getFrameHeight())y=0;
			if(step<runImgs_D.length){
				g.drawImage(runImgs_D[step].getImage(),x,y,null); //画下一个动作
				move(); //先移动,然后画
				step++;
			}else{
				g.drawImage(runImgs_D[0].getImage(),x,y,null); //停下来的时候就是第一张图片
			}
		}else if(dir==Dir.L){
			if(x<=0)x=gameFrame.getFrameWidth();
			if(step<runImgs_L.length){
				g.drawImage(runImgs_L[step].getImage(),x,y,null); //画下一个动作
				move(); //先移动,然后画
				step++;
			}else{
				g.drawImage(runImgs_L[0].getImage(),x,y,null); //停下来的时候就是第一张图片
			}
		}else if(dir==Dir.R){
			if(x>=gameFrame.getFrameWidth())x=0;
			if(step<runImgs_R.length){
				g.drawImage(runImgs_R[step].getImage(),x,y,null); //画下一个动作
				move(); //先移动,然后画
				step++;
			}else{
				g.drawImage(runImgs_R[0].getImage(),x,y,null); //停下来的时候就是第一张图片
			}
		}else{
			g.drawImage(runImgs_R[0].getImage(),x,y,null); //停下来的时候就是第一张图片
		}
		g.setColor(c);
	}
	
/*	//返回老鼠图片的矩形
	public Rectangle getRect(){
		return new Rectangle(x, y, rat.getIconWidth(),rat.getIconHeight());
	}*/
	
	/*
		我想在按住上下左右键的时候改变老鼠的坐标.
		老鼠坐标是改变了.从而我得有一个线程不断的重画我们老鼠.这样看起来才是移动的.
	*/
	public void keyPressed(KeyEvent e){
		int key=e.getKeyCode();					//拿到所按下键的Ascii码值
		switch(key){										//判断所按下的键是否是上下左右
			case KeyEvent.VK_UP:
				dir=Dir.U;
				if(oldDir==dir){
					if(step>=runImgs_U.length){
						step=0;
					}
				}else{
					step=0;
				}
				break;
			case KeyEvent.VK_DOWN:
				dir=Dir.D;
				if(oldDir==dir){
					if(step>=runImgs_D.length){
						step=0;
					}
				}else{
					step=0;
				}
				break;
			case KeyEvent.VK_LEFT:
				dir=Dir.L;
				if(oldDir==dir){
					if(step>=runImgs_L.length){
						step=0;
					}
				}else{
					step=0;
				}
				break;
			case KeyEvent.VK_RIGHT:
				dir=Dir.R;
				if(oldDir==dir){
					if(step>=runImgs_R.length){
						step=0;
					}
				}else{
					step=0;
				}
				break;
		}
		oldDir=dir;
	}
	//移动的方法
	public void move(){
		switch (dir) {
			case U:
				y-=speed;
				break;
			case D:
				y+=speed;
				break;
			case L:
				x-=speed;
				break;
			case R:
				x+=speed;
				break;
		}
	}
}
