package 设计模式.结构型设计模式.门面模式;

//门面
public class Computer {
	
	private Cpu cpu = new Cpu();
	private Disk disk = new Disk();
	private Memory memory = new Memory();
	
	public void start(){
		cpu.start();
		disk.start();
		memory.start();
	}
	
	public void shutdown(){
		cpu.shutdown();
		disk.shutdown();
		memory.shutdown();
	}
	
}
