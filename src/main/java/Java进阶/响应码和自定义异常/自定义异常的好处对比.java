package Java进阶.响应码和自定义异常;

/**
 *   自定义异常只有在检验数据的时候能看出具体的好处,
 *   而在同一个方法内看不出什么好处.或者说在同一个方法内没什么意义.
 */
public class 自定义异常的好处对比 {
	
	/*
	 * 缺点:
	 *     1) if判断过长,不美观,可读性差
	 *     2) 终究要返回值,只能通过判断是否有值来验证是否校验通过
	 * */
	public static String validate(int a , int b , int c){
		
		if(a == 1){
			return "a不能等于1";
		}else if(b == 2){
			return "b不能等于2";
		}else if(c == 3){
			return "c不能等于3";
		}
		
		return null;
	}
	
	//拆分了虽然好,但是要判断多次
	public static String validateA(int a){
		return a == 1 ? "a不能等于1" : null;
	}
	
	public static String validateB(int b){
		return b == 1 ?"b不能等于2" : null;
	}
	
	public static String validateC(int c){
		return c == 1 ?"c不能等于3" : null;
	}
	
	//抛异常的形式
	public static void validateAE(int a) throws BusinessException{
		if(a == 1) 
			throw new BusinessException(RiskControlResponseCode.CREATE_FAILE);
	}
	
	//抛异常的形式
	public static void validateBE(int b) throws BusinessException{
		 if(b == 2) 
				throw new BusinessException(RiskControlResponseCode.DELETE_FAILE);
	}
	
	//抛异常的形式
	public static void validateCE(int c) throws BusinessException{
		 if(c == 3) 
				throw new BusinessException(RiskControlResponseCode.CREATE_MAN_IS_BLANK);
	}
	
	public static void main(String[] args) {
		
		int a = 1 , b = 2 , c = 3; 
		
		if(validate(a, b, c) == null){
			System.out.println("验证通过1....");
		}
		/**
		 *  当判断出有错误的时候,为了及时中断校验,我们得一个一个判断,
		 *  下面的判断会越写越长,代码可读性和可维护性比较差
		 */
		String rst = null;
		if((rst = validateA(a) ) == null 
			&& (rst = validateB(b) ) == null
			&& (rst = validateC(c) ) == null ){
			System.out.println("验证通过2....");
		}
		
		/**
		 * 好处 : 
		 * 
		 *         1) 当发现有一个校验错误的时候,能及时中断校验,而不需要加判断,
		 *              可读性和可维护性比较好.
		 *              
		 *         2) 优于第一种方案,不需要有返回值 (主要优点就是终止校验这点很好)    
		 */
		try {
			
			validateAE(a);
			validateBE(b);
			validateCE(c);
			
			System.out.println("不需要任何判断....直接往下面写..");
			
		} catch (BusinessException e) {
			System.out.println("检验异常错误码 :" + e.getCode() + " 描述 : " + e.getMsg());
		}
		
	}
	
}
