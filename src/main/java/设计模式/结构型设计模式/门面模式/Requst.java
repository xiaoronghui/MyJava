package 设计模式.结构型设计模式.门面模式;

public class Requst implements HttpServletRqust{
	
	//该方法不想暴露出去
	public void addCookie(String key ,String value){
		System.out.println("addCookie不允许客户端使用");
		System.out.println("添加cookie : {"+key+" : "+value+"}");
	}

	@Override
	public String getParameter(String key) {
		return "abc";
	}
	
	
}
