package Java进阶.循环和遍历;

public class 多层嵌套label标记 {
	public static void main(String[] args) {
		testWhileLabel();
	}
	
	//while循环标记测试
	private static void testWhileLabel() {
		int n = 0;
		   int m = 0;
		   C : while( n < 10){
			   System.out.println("我是n : " + n);
			   D: while(m  < 10){
				   System.out.println("我是m : " + m);
				   if(m == 5){
					   /*System.out.println("m已经5了,我要中断D");
					   break D;*/
					   System.out.println("m已经5了,我要中断C"); 
					   break C;
				   }
				   m ++;
			   }
			   n ++;
		   }
	}
	
	//for循环标记测试
	public static void testForLabel(){
		//A和B称之为label标记	 
	   A :	for(int i = 0 ; i < 10 ; i ++){
		   System.out.println("我是I : " + i);
		   B : for(int j = 0 ;  j < 10 ; j ++){
			   System.out.println("我是J : " + j);
			   if(j == 5){
				   System.out.println("J已经5了,我要中断B");
				   break B;
				   //System.out.println("J已经5了,我要中断A"); 
				   //break A;
			   }
		   }
	   }
		   
	}
}
