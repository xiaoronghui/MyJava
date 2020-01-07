package Java进阶.内省的简单应用;

import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;

import Java进阶.反射.MyPoint;

public class BeanUtil工具包操作JavaBean {
	public static void main(String[] args) throws Exception{
		//这里通过反射从配置文件得到一个实例(这里简单的处理下,直接new个实例好了)
	   Object point=new MyPoint(3, 4);
	   test1(point);
	   OrderGoods goods=new OrderGoods();
	   goods.setOrderGoodsId(1);
	   goods.setGoodsName("香蕉");
	   goods.setGoodsMemo("很好吃的香蕉");
	   goods.setInputDate(new Date());
	   //Bean转map很简单
	   System.out.println(BeanUtils.describe(goods));
	   OrderGoodsDTO orderGoodsDTO=new OrderGoodsDTO();
	   //拷贝属性,完美的解决了dto和实体对象的问题
	   BeanUtils.copyProperties(orderGoodsDTO, goods);
	   System.out.println(orderGoodsDTO.getGoodsName());
	   System.out.println(orderGoodsDTO.getInputDate());
	}
	
	//使用BeanUtils获取属性值
	public  static void test1(Object obj){
		  //使用BeanUtil获取属性值
		   try {
			   System.out.println(BeanUtils.getProperty(obj, "x"));
			} catch (Exception e) {
				e.printStackTrace();
			} 
	}
}
