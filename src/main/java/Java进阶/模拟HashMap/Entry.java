package Java进阶.模拟HashMap;
/**
 * Entry:记录,登记的意思,可以形象的表示HashMap中每一个键值对
 * @author ronghui.xiao
 * @date 2015-2-21
 */
class Entry{   
	Object key;
	Object value;
	public Entry() {
		super();
	}
	public Entry(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	/**
	 * 重写toString方法
	 * @author ronghui.xiao
	 * @date 2015-2-20
	 * @return String 供打印的字符串
	 */
	public String toString(){
		return this.key+"="+this.value;
	}
}