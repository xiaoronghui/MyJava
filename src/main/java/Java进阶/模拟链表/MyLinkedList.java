package Java进阶.模拟链表;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList implements List {
	private Node first;
	private Node last;
	private int size;
	
	public static void main(String[] args) {
		MyLinkedList list=new MyLinkedList();
		list.add("张飞");
		list.add("关羽");
		list.add(new Date());
		System.out.println(list+"-->长度为:"+list.size());
		Object[] arr=list.toArray();  							//测试toArray方法
		System.out.println(Arrays.toString(arr));
		System.out.println(list.get(0));
		list.remove(0);
		System.out.println(list);
		//list.remove(5); 
		list.add(0,"赵云");
		System.out.println(list);
		list.add(2,"曹操");
		System.out.println(list);
	}
	
	//添加一个元素
	public boolean add(Object obj){
		Node node=new Node();
		if(size==0){  									//若是第一个
			node.setPrevious(null);  			//第一个首尾为null
			node.setObj(obj);
			node.setNext(null); 					//第一个首尾为null
			first=node; 								//node现在在内存中,first指向了node,last也指向了node
			last=node;
		}else{ 									 	    //若不是第一个
			node.setPrevious(last);             //最后一个头部为上次那个last
			node.setObj(obj);
			node.setNext(null);                  //最后一个尾部为null
			last.setNext(node);                  //元内存中的那个node的下一个指向新的node
			last=node;                              //让最后一个指向新的node
		}
		size++;
		return true; 								 //既然接口都要返回boolean,那就返回一个
	}
	
	/**
	 * 获取指定索引位置上的元素
	 * @param index 容器中元素的索引位置
	 * @author ronghui.xiao
	 * @date 2015-2-4
	 * @return Object 返回一个对象
	 */
	public Object get(int index) {
		return node(index).getObj();
	}
	/**
	 * 检查索引是否越界
	 * @param index 容器中元素的索引位置
	 * @author ronghui.xiao
	 * @date 2015-2-4
	 * @return void 无返回值
	 */
	public boolean checkIndexOutOfBounds(int index){
		if(index<0||index>size-1){
			try {
				throw new Exception("索引'"+index+"'越界异常!");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		return true;
	}
	
	//重写toString方法
	public String toString(){
		if(size==0){
			return "[]";
		}else{
			StringBuilder sb=new StringBuilder();
			Node next=first;
			for(int i=0;i<size;i++){
				if(i==0){
					sb.append("[").append(first.getObj());  //stringBuilder添加的元素会自动转化为String
				}else{
					sb.append(",").append(next.getObj());
				}
				next=(Node) next.getNext();
			}
			return sb.append("]").toString();
		}
	}
	//长度
	public int size(){
		return size;
	}
	
	//转化为一个数组
	public Object[] toArray() {
		if(size==0){
			return null;
		}else{
			Object[] arr=new  Object[size];
			Node next=first;
			for(int i=0;i<size;i++){
				arr[i]=next.getObj();
				next=(Node) next.getNext();
			}
			return arr;
		}
	}
	//查看列表是否为空
	public boolean isEmpty() {
		return size==0?true:false;
	}

	/**
	 * 根据指定的元素索引删除容器中的元素
	 * @param index 容器中元素索引
	 * @author ronghui.xiao
	 * @date 2015-2-4
	 * @return Object 返回被删除的对象
	 */
	public Object remove(int index) {             //从这里看以看出,移除的效率比ArrayList高
		Node temp=node(index);
		Node prev=(Node) temp.getPrevious();  //该元素的上一个元素
		Node next=(Node) temp.getNext();       //该元素的下一个元素
		if(prev!=null){
			prev.setNext(next);			//设置上一个元素的下一个元素
		}else{
			first=next;
		}
		if(next!=null){
			next.setPrevious(prev);		//设置下一个元素的上一个元素
		}else{
			last=prev;
		}
		size--;
		return temp.getObj();
	}
	
	/**
	 * 根据指定索引获取元素对象
	 * @param index 容器中元素索引
	 * @author ronghui.xiao
	 * @date 2015-2-4
	 * @return Node 返回节点对象
	 */
	public Node node(int index){
		if(size==0){
			try {throw new Exception("容器内没有元素!");} catch (Exception e) {e.printStackTrace();}
			return null;
		}
		if(!checkIndexOutOfBounds(index))return null; // 越界则返回
		Node temp=null;    
		if(first!=null){
			//把索引和中点的索引进行比较,这样就不用全部遍历了.
			if(index<size>>2){ 				//右移一位除以2,也就是会所index小于终点位置的话.
				temp=first;
				for(int i=0;i<index;i++){     
					temp=(Node) temp.getNext();  
				}
			}else{
				temp=last;
				for(int i=size-1;i>index;i--){     
					temp=(Node) temp.getPrevious();
				}
			}
		}
		return (Node) temp;
	}
	
	/**
	 * 在指定索引下添加一个元素,该位置上原来的元素将会被覆盖
	 * @param index 容器中索引位置 element要添加的元素
	 * @author ronghui.xiao
	 * @date 2015-2-4
	 * @return void 无返回值
	 */
	public void add(int index, Object element) {
		Node temp=node(index);
		if(temp!=null){
			Node prev=(Node) temp.getPrevious();
			Node next=(Node) temp.getNext();
			Node node=new Node();
			node.setPrevious(prev);
			node.setNext(temp);
			node.setObj(element);
			if(prev!=null){
				prev.setNext(node);			//设置上一个元素的下一个元素
			}else{
				first=node;
			}
			if(next!=null){
				temp.setPrevious(node);		//设置下一个元素的上一个元素
			}else{
				last=node;
			}
			size++;
		}
	}
	
	//是否包含某个对象
	public boolean contains(Object o) {
		
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
}
