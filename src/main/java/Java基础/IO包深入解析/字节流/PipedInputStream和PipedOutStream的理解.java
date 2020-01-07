package Java基础.IO包深入解析.字节流;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedInputStream和PipedOutStream的理解 {
	
	
	/**
	 * 
	 *  PipedOutputStream和PipedInputStream是管道输出流和管道输入流，配合使用可以实现线程间通信.

  		注 : 单词piped就是管道的意思 
	 * 
	 *  两个流通过方法connect对接起来,例如 : 	pos.connect(pis);
	 * 
	 */
	public static void main(String[] args) throws IOException {
		
		PipedInputStream pis = new PipedInputStream();
		PipedOutputStream pos = new PipedOutputStream();
		
		PipedInputThread pit = new PipedInputThread(pis);
		PipedOutThread pot = new PipedOutThread(pos);
		
		//两个管道对接起来
		pos.connect(pis);
		
		pot.start();
		
		pit.start();
		
	}
	
	
	static class  PipedInputThread extends Thread{
		
		private PipedInputStream pis;
		
		public PipedInputThread(PipedInputStream pis) {
			super();
			this.pis = pis;
		}

		public void run() {
				try {
					readMsg();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		public void readMsg() throws IOException{
			
			BufferedReader br = new BufferedReader(new InputStreamReader(pis));
			
			System.out.println("接收到的消息 : " + br.readLine());
			
			br.close();
		}
		
	}
	
	static class PipedOutThread extends Thread{
		
		private PipedOutputStream pos;
		
		public PipedOutThread(PipedOutputStream pos) {
			this.pos = pos;
		}

		public void run() {
			try {
				writeMsg();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void writeMsg() throws IOException{
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(pos));
			
			bw.write("你好呀");
			
			bw.close();
			
		}
		
	}
	
	
	
	
}
