package 设计模式.行为型设计模式.模板方法模式;

public class Test {
	
	 public static void main(String[] args) {
        
		 //页面构造器
		 PageBuilder pageBuilder = new MyPageBuilder();
        
		 //调用统一的步骤方法
		 String html = pageBuilder.buildHtml();
        
		 System.out.println(html);
    }
	
}
