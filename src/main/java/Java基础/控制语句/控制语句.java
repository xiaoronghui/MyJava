package Java基础.控制语句;

public class 控制语句 {
	public static void main(String[] args) {
	   //if,if--else,if--else if--else 等语句
	  if(2>1)System.out.println("2>1");
	  
	  //switch语句 
	  int day=(int) (Math.random()*4+1); 
	 //参数需要int,或者可以转为int的类型(byte,char,short)或枚举;注:JDK7中还可以放字符串;
	  switch(day){ 
	  	case 1:
	  		System.out.println("星期"+day);
	  		break; //-->break用于退出switch语句,若没有break,则继续往下执行,这个叫"case穿透"
	  	case 2:
	  		System.out.println("星期"+day);
	  		break;
	  	case 3:
	  		System.out.println("星期"+day);
	  		break;
	  	default:
	  		 System.out.println("不知道今天星期几..");
	  }
	  
	  //利用case穿透判断c2是元音还是辅音
	  char c='a';
	  int ran=(int) (Math.random()*26);
	  char c2=(char)(c+ran);
	  switch(c2){  //switch语句参数可以是字符,因为字符可以自动转化为整型
	  	case 'a':
	  	case 'e':
	  	case 'i' :
	  	case 'o':
	  	case 'u':
	  		System.out.println("元音");
	  		break;
	  	case 'y' :
	  	case 'w' :
	  		System.out.println("半元音");
	  		break;
	  	default:
	  		System.out.println("辅音");
	  }
	  
		//while循环
		int k=1;
		while(k<=5){
			System.out.println(k);
			k++;
		}
		
		//do..while循环
		int m=0;
		do{
			System.out.println(m);
			m++;
		}while(m<=5);
		
		//for循环计算100以内奇数的和
		int jSum=0,oSum=0;
		for(int i=0;i<100;i++){
			if(i%2==0){
				oSum+=i;
			}else{
				jSum+=i;
			}
		}
		System.out.println("100以为奇数的和:"+jSum+"偶数和:"+oSum);
		
		//输出1-1000能被5整除的数,每行输出3个
		for(int i=1;i<1000;i++){
			if(i%5==0)System.out.print(i+"\t");
			if(i%15==0)System.out.println();
		}
		System.out.println();
		//打印九九乘法表
		for(int i=1;i<=9;i++){
			for(int j=1;j<=i;j++){
				System.out.print(j+"x"+i+"="+j*i+"\t");
			}
			System.out.println();
		}
		
		//break: 终止循环  continue终止当次循环进入下个循环
	    for(int i=1;i<100;i++){ //打印1-100不被3整除的数
	    	if(i%3==0)continue;
	    	System.out.print(i+"\t");
	    }
	    
	    //outer的用法,带标签的循环
	    outer:for(int i=101;i<=150;i++){ //打印101-150之间的质数
			    	for(int j=2;j<101;j++){
			    		if(i%j==0)continue outer; //当发现不是质数则跳到外层循环continue而不是内层continue
			    	}
	    		}
	    
	    //
	    
	}
}
