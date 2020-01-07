package Java并发包.FutureData异步请求模式模拟;

public class FutureClient {
	
	public Data request(final String queryStr){
		
		final FutureData futureData = new FutureData();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				RealData realData = new RealData(queryStr);
				futureData.setRealData(realData);
			}
		}).start();
		
		
		return futureData;
		
	}
}
