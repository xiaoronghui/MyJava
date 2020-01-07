package Java基础.IO包深入解析.字符流;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class PipedReader和PipedWriter的理解 {

	/**
	 * 
	 *  PipedReaderThread和PipedWriter是管道字符输出流和管道字符输入流，配合使用可以实现线程间通信.
	 *  原理和字节的管道流一样,只不过在操作字符上面更为方便

  		注 : 单词piped就是管道的意思 
	 * 
	 *  两个流通过方法connect对接起来,例如 : 	pos.connect(pis);
	 * 
	 */
	public static void main(String[] args) throws IOException {
		
		PipedReader pis = new PipedReader();
		PipedWriter pos = new PipedWriter();
		
		PipedReaderThread pit = new PipedReaderThread(pis);
		PipedWriterThread pot = new PipedWriterThread(pos);
		
		//两个管道对接起来
		pos.connect(pis);
		
		pot.start();
		
		pit.start();
		
	}
	
	
	static class  PipedReaderThread extends Thread{
		
		private PipedReader pr;
		
		public PipedReaderThread(PipedReader pr) {
			super();
			this.pr = pr;
		}

		public void run() {
				try {
					readMsg();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		public void readMsg() throws IOException{
			
			BufferedReader br = new BufferedReader(pr);
			
			System.out.println("接收到的消息 : " + br.readLine());
			
			br.close();
		}
		
	}
	
	static class PipedWriterThread extends Thread{
		
		private PipedWriter pw;
		
		public PipedWriterThread(PipedWriter pw) {
			this.pw = pw;
		}

		public void run() {
			try {
				writeMsg();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void writeMsg() throws IOException{
			
			BufferedWriter bw = new BufferedWriter(pw);
			
			bw.write("你好呀");
			
			bw.close();
			
		}
		
	}
	
	
	
}
