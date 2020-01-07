package Java进阶.响应码和自定义异常;

/**
 * @function 自定义异常
 * @author ronghui.xiao
 * @date 2017年1月23日
 */
public class BusinessException extends Exception{

	private static final long serialVersionUID = -4414168477990262510L;
	
	private ResponseCodeInterface responseCodeInterface;
	
	private String code;
	
	private String msg;
	
	public BusinessException(ResponseCodeInterface responseCodeInterface){
		this.responseCodeInterface = responseCodeInterface;
		this.code = responseCodeInterface.getCode();
		this.msg = responseCodeInterface.getMsg();
	}
	
	public BusinessException(String code , String msg){
		this.code = responseCodeInterface.getCode();
		this.msg = responseCodeInterface.getMsg();
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public ResponseCodeInterface getResponseCodeInterface() {
		return responseCodeInterface;
	}
	
}
