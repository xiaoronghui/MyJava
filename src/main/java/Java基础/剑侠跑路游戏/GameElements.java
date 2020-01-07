package Java基础.剑侠跑路游戏;

import java.awt.Graphics;
/**
 * 只要是游戏元素,都要给我实现这个接口,方便我调用
 * @param
 * @author ronghui.xiao
 * @date 2015-1-29
 * @return
 */
public interface GameElements {
	public void draw(Graphics g);
}
