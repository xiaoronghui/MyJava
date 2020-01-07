package Java基础.运算符;

public class 运算符 {
	public static void main(String[] args) {
		//取余运算符"%"
		int a=10%3;
		System.out.println(a);
		double a1=10.213%3; //小数也是可以取余的
		System.out.println(a1);
		
		//&&,||,!运算符,只能操作布尔值
		if((3>2)&&(2>1))System.out.println("&&运算符");
		if((1>2)||(2>1))System.out.println("||运算符");
		if(!(1>2))System.out.println("!运算符");
		
		//位运算符~,&,|,^,<<,>>,>>>
		int c=8;
		int d=6;
		System.out.println("8="+Integer.toBinaryString(8)+" 6="+Integer.toBinaryString(6));
		System.out.println("~8="+Integer.toBinaryString(~8)); //
		System.out.println("8&6="+(8&6)); //按位与
		System.out.println("8|6="+Integer.toBinaryString(8|6)); //按位或
		System.out.println("^8="+Integer.toBinaryString(~8)); //按位异或
		
		//左移就是把整个二进制码去除第一位,末尾加个0;比如n<<1 则相当于n*(2^1),n<<m 则相当于n*(2^m)
		System.out.println("<<8="+Integer.toBinaryString(8<<1)+"-->"+(8<<1)); //左移1位  
		System.out.println("<<6="+Integer.toBinaryString(6<<1)+"-->"+(6<<1)); //左移1位  
		System.out.println("<<8="+Integer.toBinaryString(8<<2)+"-->"+(8<<2)); //左移两位
		
		//右移就是把整个二进制码去除最后一位,头部加个0;比如n>>1 则相当于n*(2^-1),n<<m 则相当于n*(2^-m)
		System.out.println(">>8="+Integer.toBinaryString(8>>1)+"-->"+(8>>1)); //左移1位  
		System.out.println(">>6="+Integer.toBinaryString(6>>1)+"-->"+(6>>1)); //左移1位  
		System.out.println(">>8="+Integer.toBinaryString(8>>2)+"-->"+(8>>2)); //左移两位
		
		//>>> 也是右移,区别就在于该运算符与符号无关,也就是不管你原先是什么符号
		System.out.println("-8>>>1="+Integer.toBinaryString(-8>>>1)); //左移两位
		
		//扩展运算符  +=,-=,*=,/=,%=
		c+=2;  //相当于c=c+2; 其他的依此类推
		
		//三目运算符 用于代替if--else
		String  abc=(1>0)?"1>0":"1<0";
		System.out.println(abc);
		
		//运算符的优先级没必要理会,用括号隔开就行了
		
		/*
			-------运算符
		    --java支持的运算符
		     1) 算数运算符：+,-,*,/,%,++,--
		     2) 赋值运算符 : =
		     3) 关系运算符: >,<,>=,<=,==,!= instanceof
		     4) 逻辑运算符: &,|,^,~,>>,<<,>>>
		     5) 条件运算符: ? :
		     6) 扩展赋值运算符: +=,-=,*=,/=
		     
		    --二元运算符类型提升
		     两个不同类型的数进行运算,结果值的类型为表示范围更大的那个类型;
		     如 double * Long -->double
	
		    --一元运算符
		    int a=i++;  //i先赋值给a,然后做自加运算
		    int b=++i; //i先做自加运算,然后给a赋值
	    	int count = 0;
		    count ++ > 0  //先比较,然后再给count做自加运算

		    --位运算符
		     ~  二进制码取反
		     &  两个二进制码按位与运算
		     |    两个二进制码按或运算
		    ^   两个二进制码按异或运算
		    << 二进制码向左边移动n位 -->比如n<<1 则n的二进制码去除n位,末尾加个n个0;n<<1又则相当于n*(2^1),n<<m 则相当于n*(2^m)
		    >> 二进制码向右边移动n位-->右移就是把整个二进制码去除最后n位,头部加个n个0;比如n>>1 则相当于n*(2^-1),n<<m 则相当于n*(2^-m)
	
		    --扩展运算符
		      +=,-=,*=,/=,%=
		      a+=2 相当于 a=a+2;其他的依此类推
	
		    --三目运算符 用于代替if--else
		    String  abc=(1>0)?"1>0":"1<0";
	    */
		
	}
}
