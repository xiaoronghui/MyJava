package 设计模式.结构型设计模式.门面模式;

//门面
public class RequestFace implements HttpServletRqust{
	
	private Requst requst = new Requst(); 

	@Override
	public String getParameter(String key) {
		return requst.getParameter(key);
	}

}
