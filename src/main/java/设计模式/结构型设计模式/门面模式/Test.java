package 设计模式.结构型设计模式.门面模式;

public class Test {
	
	public static void main(String[] args) {
		
		//统一访问的门面模式
		Computer computer = new Computer();
		computer.start();
		computer.shutdown();
		
		//不想暴露的内部接口的门面模式
		HttpServletRqust httpRequest = new Requst();
		
		//如果直接使用Requst,则可以强转回来
		Requst requst = (Requst) httpRequest;
		requst.addCookie("userName", "张飞");
		
		HttpServletRqust httpRequest2 = new RequestFace();
		
		System.out.println(httpRequest2.getParameter("a"));
		
	}

}
