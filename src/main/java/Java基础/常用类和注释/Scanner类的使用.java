package Java基础.常用类和注释;

import java.util.Scanner;

public class Scanner类的使用 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in); //传入一个输入流
		System.out.print("a=");
		int a=scanner.nextInt(); //返回我们键入的数
		System.out.print(" b=");
		int b=scanner.nextInt(); 
		System.out.print(a+b);
	}
}
