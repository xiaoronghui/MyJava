package Java并发包.FutureData异步请求模式模拟;

public class Main {
	public static void main(String[] args) {
		
		FutureClient fc = new FutureClient();
		Data data = fc.request("请求参数");
		System.out.println("请求发送成功!");
		System.out.println("做其它事情...");
		
		String result = data.getRequest();
		System.out.println(result);
		
	}
}
