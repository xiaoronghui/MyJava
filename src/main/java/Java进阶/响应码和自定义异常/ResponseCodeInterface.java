package Java进阶.响应码和自定义异常;

/**
 * @function 响应码规范接口
 * @author ronghui.xiao
 * @date 2017年1月23日
 */
public interface ResponseCodeInterface {
	
	 /*响应吗*/
	 String getCode();
	 
	 /*响应消息*/
	 String getMsg();
	 
}
