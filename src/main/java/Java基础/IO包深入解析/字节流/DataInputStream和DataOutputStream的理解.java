package Java基础.IO包深入解析.字节流;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 *  当我们要把一串有类型的基本数据发送到的时候,读取的时候希望按照原来的类型读取出来.
 *  蛋疼的是 : 按什么顺序写入的,就得按什么顺去读取.
 *  
 *  其实完全可以发送一段json过去,自己去解析.没必要那么麻烦.
 *
 *  它和普通的流的区别就在于可以发送任意基本类型的数据,对面接收的时候也可以直接转化过来.相对于
 *  字符流只能发送字符,字节流只能发送字节来说,还有扩展了一点功能. 
 *  唯一恶心的就是要按顺序读取.
 *  
 *  (很多时候我们并不想传一个一个的数据,而是想传一整个对象,这个时候就要去ObjectInputStream找答案了)
 */
public class DataInputStream和DataOutputStream的理解 {
	
	public static void main(String[] args) throws IOException {
		
		String serverIp = "127.0.0.1";
		int serverPort = 6666;
		
		//创建一个监听指定端口的服务器
		ServerClient serverClient = new ServerClient(serverPort);
		
		serverClient.start();
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		
		DataOutputStream dos = new DataOutputStream(byteArrayOutputStream);
		
		dos.writeUTF("张飞"); //姓名
		dos.writeInt(30);  //年龄
		dos.writeBoolean(true); //婚否
		
		byte[] buff = byteArrayOutputStream.toByteArray();
		
		//把数据打包,需要数据,服务器IP地址和服务器端口
		DatagramPacket datagramPacket = new DatagramPacket(buff, buff.length, new InetSocketAddress(serverIp,serverPort));
		
		DatagramSocket datagramSocket = new DatagramSocket();
		
		datagramSocket.send(datagramPacket);//数据包套接字把数据包给发送出去
		
		datagramSocket.close();
		
	}

	//服务器
	public static  class ServerClient{
		
		DatagramSocket serverSocket = null;
		
		public ServerClient(int port){
			try {
				this.serverSocket = new DatagramSocket(port);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void start(){
			
			new Thread(new Runnable() {
				
				public void run() {
					
					while(true){
						
						try {
							
							byte[] buff = new byte[1024];
							
							DatagramPacket datagramPacket=new DatagramPacket(buff, buff.length);
							
							serverSocket.receive(datagramPacket);
							
							ByteArrayInputStream bis = new ByteArrayInputStream(datagramPacket.getData());
							
							DataInputStream dis= new DataInputStream(bis);
							
						    String name = dis.readUTF();
							int age = dis.readInt();
							boolean isMarray = dis.readBoolean();
							
							System.out.println("服务器接收到的数据 : name : " + name + " age : " + age + " isMarray : " + isMarray);
							
							
						} catch (IOException e) {
							e.printStackTrace();
						}
						
					}
				}
			}).start();
			
		}
		
		
	}
	
}
