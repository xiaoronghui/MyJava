package 设计模式.创建型设计模式.原型模式;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 原型模式
 * @author Administrator
 */
public class Prototype implements Cloneable{
	
	private Object config;
	
	private int count = 10000;
	
	private String name;
	
	public Prototype(){
		
		/*初始化config,这是一个非常漫长的过程,但是每个实例都是一样的*/
		 try {
			long time = 2000;
			Thread.sleep(time);
			this.config = new Object();
			System.out.println("属性config初始化完毕,耗时 : "+time+"ms");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的。
	public Prototype clone() throws CloneNotSupportedException{
		return (Prototype) super.clone();
	}
	
	//深复制：将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。简单来说，就是深复制进行了完全彻底的复制，而浅复制不彻底。
	public Prototype deepClone() throws IOException, ClassNotFoundException {
		
		/* 写入当前对象的二进制流 */
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        /* 读出二进制流产生的新对象 */
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        
        return (Prototype) ois.readObject();
	}
	
	public Object getConfig() {
		return config;
	}

	public void setConfig(Object config) {
		this.config = config;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		Prototype prototype1 = new Prototype();
		prototype1.setName("原型1");
		
		System.out.println(prototype1.getName());
		
		
		Prototype prototype2 = prototype1.clone();
		System.out.println("克隆对象的count : " + prototype2.getCount());
		
		
	}
}
