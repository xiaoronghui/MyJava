package Java并发包.脏读;

public class DirtyRead {
	
	private String userName = "关羽";
	private String password = "papapa";
    
	public  synchronized void setValue(String userName,String password){
		this.userName = userName;
		try{
			Thread.sleep(2000);
		}catch (Exception e) {
			e.printStackTrace();
		}
		this.password = password;
		System.out.println("setValue最终结果,userName=" + userName + " password=" + password);
	}

	
	
	
	
	public void getValue(){
		System.out.println("getValue得到结果,userName=" + userName + " password=" + password);
	}
	
	/**
	 * 如果一个线程赋值的过程比较长,当设置到一半的时候,同时有另外一个线程来访问,
	 * 那么就导致只读到只设置了一半的那个数据,剩下的未赋值的则没有读取到.这样就造成了脏读.
	 * 所谓脏读就是说读取的整条数据不一致,一半新的一半老的,不伦不类的数据,这就叫脏读.
	 * 
	 * 解决方法 : 让getValue方法也加上synchronized;
	 */
	public static void main(String[] args) {
		final DirtyRead dirtyRead = new DirtyRead();
	
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				dirtyRead.setValue("张飞", "123");
			}
		},"t1");
		t1.start();
		
		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();	}
	
		dirtyRead.getValue();
	}
	
}
