package Java进阶.响应码和自定义异常;

/**
 * @function 风险控制系统响应码枚举
 * @author ronghui.xiao
 * @date 2017年1月23日
 */
public enum RiskControlResponseCode implements ResponseCodeInterface{
	
	/*成功的code从20001开始*/
	CREATE_SUCCESS("20001","创建成功!"),
	DELETE_SUCCESS("20002","删除成功!"),
	UPDATE_SUCCESS("20003","更新成功!"),
	SEARCH_SUCCESS("20004","查询成功!"),
	
	/*失败的code从40001开始*/
	CREATE_FAILE("40001","创建失败!"),
	DELETE_FAILE("40002","删除失败!"),
	UPDATE_FAILE("40003","更新失败!"),
	SEARCH_NOT_FOUND("40004","查询未找到!"),
	RECORD_ALREADY_EXISTS("40005","记录已存在!"),
    CREATE_MAN_IS_BLANK("40006","创建人为空!"),
    UPDATE_MAN_IS_BLANK("40007","更新人为空!"),
    INVALID_ID("40008","ID不合法!"),
    NULL_PARAMETER("40009","参数为null!");
	
	private String code;
    private String msg;
    
    private RiskControlResponseCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
    
}
