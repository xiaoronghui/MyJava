package Java基础.IO包深入解析.字节流;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectInputStream和ObjectOutStream的理解 {

	private static class Person implements Serializable{
		String userName;
		String hobby;
		public Person(String userName, String hobby) {
			super();
			this.userName = userName;
			this.hobby = hobby;
		}
	}
	
	/**
	 * 
	 *  ObjectInputStream和ObjectOutStream是专门对于对象读写的，要求类已经实现了Serializable接口.
	 * 
	 *  应用场景 :
	 *     
	 *         在远程调用接口中,可以通过这两个类来传输对象,非常有用
	 * 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Person person = new Person("张飞", "篮球");
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();	
		
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(bos));
		
		oos.writeObject(person);
		
		oos.close();
		
		byte[] objectBytes = bos.toByteArray();
		
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(objectBytes)));
		
		Person readPerson = (Person) ois.readObject();
		
		System.out.println(readPerson.userName);
		System.out.println(readPerson.hobby);
		
	}
	
	
	
}
