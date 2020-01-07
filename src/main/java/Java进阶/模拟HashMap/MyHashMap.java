package Java进阶.模拟HashMap;
/**
 * 缺点:
 *   这个版本的模拟每次获取元素的时候都要遍历,很是麻烦.
 *   也就说查询某个一个元素效率低下.
 *   MyHashMap02版本会解决这个问题
 */
public class MyHashMap {
	Entry[] arr=new Entry[990];
	int size;
	/**
	 * 加入一条键值对
	 * @param key 键对象 value 值对象
	 * @author ronghui.xiao
	 * @date 2015-2-20
	 * @return 无返回值
	 */
	public void put(Object key,Object value){
		if(containsKey(key)){  //若键对象已经存在则覆盖
			for (int i = 0; i < size; i++) {
				if(arr[i].key.equals(key)){  //Object的equals即比较值有比较地址,这岂不会有错?
					arr[i].value=value;
					break;
				}
			}
		}else{
			Entry entry=new Entry(key,value);  
			arr[size++]=entry;
		}
	}
	/**
	 * 根据键对象获取值对象
	 * @param key 键对象
	 * @author ronghui.xiao
	 * @date 2015-2-20
	 * @return void 无返回值
	 */
	public Object get(Object key){
		for (int i = 0; i < size; i++) {
			if(arr[i].key.equals(key)){  //Object的equals即比较值有比较地址,这岂不会有错?
				return arr[i].value;
			}
		}
		return null;
	}
	/**
	 * 移除指定的键值对
	 * @param key 键对象
	 * @author ronghui.xiao
	 * @date 2015-2-20
	 * @return Object 被移除的对象
	 */
	public Object remove(Object key){
		Object oldObj=null;
		for (int i = 0; i < size; i++) {
			if(arr[i].key.equals(key)){  										//Object的equals即比较值有比较地址,这岂不会有错?
				oldObj=arr[i];
				int flag=size-i-1; 												//如果是最后一个,则值为0;只有一个的时候也是最后一个,从而也为0.也就是剩下的个数
				if(flag>0){ 														//若不是最后一个,后面的元素往前移动一格
					System.arraycopy(arr, i+1, arr, i, flag); 			//中间的移除了,往前移
				}
				arr[--size]=null;													//最后那个位置赋值为null
				break;
			}
		}
		return oldObj;
	}
	/**
	 * 是否包含指定的key对象
	 * @param key 键对象
	 * @author ronghui.xiao
	 * @date 2015-2-20
	 * @return boolean 布尔值
	 */
	public boolean containsKey(Object key){
		for (int i = 0; i < size; i++) {
			if(arr[i].key.equals(key)){  //Object的equals即比较值有比较地址,这岂不会有错?
				return true;
			}
		}
		return false;
	}
	/**
	 * 是否包含某个值对象
	 * @param value 值对象
	 * @author ronghui.xiao
	 * @date 2015-2-20
	 * @return boolean 布尔值
	 */
	public boolean containsValue(Object value){
		for (int i = 0; i < size; i++) {
			if(arr[i].value.equals(value)){  
				return true;
			}
		}
		return false;
	}
	/**
	 * 获取容器内键值对的个数
	 * @author ronghui.xiao
	 * @date 2015-2-20
	 * @return int 容器内键值对个数
	 */
	public int size(){
		return size;
	}
	/**
	 * 检测容器是否为空
	 * @author ronghui.xiao
	 * @date 2015-2-20
	 * @return  boolean 布尔型
	 */
	public boolean isEmpty(){
		return size>0?false:true;
	}
	/**
	 * 把指定容器里的键值对合并到当前容器中(注意键值对的唯一性)
	 * @param MyHashMap map容器对象
	 * @author ronghui.xiao
	 * @date 2015-2-20
	 * @return boolean 布尔型
	 */
	public boolean putAll(MyHashMap map){
		Entry[] temp=map.arr;
		for (int i = 0; i < map.size(); i++) {
			this.put(temp[i].key, temp[i].value);
		}
		return true;
	}
	/**
	 * 重写toString方法
	 * @author ronghui.xiao
	 * @date 2015-2-20
	 * @return String 用于打印的字符串,如:{sex=男, name=张飞}
	 */
	public String toString(){
		StringBuilder sb=new StringBuilder("{");
		for (int i = 0; i < size; i++) {
			if(i==0){
				sb.append(arr[i].toString());
			}else{
				sb.append(",").append(arr[i].toString());
			}
		}
		return sb.append("}").toString();
	}
}
