package Java进阶.List接口和模拟ArrayList;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList {
	private Object[] value; 		//用于存放元素,使用private修饰我们的属性,若是value都能随便赋值的话,那下面的判断就没意义了..
	 //数组中元素的个数,使用private修饰我们的属性,如果可以随便改的话,下面使用了size判断就没意义了,这也就是使用private的原因
	private int size;			  
	/*
	 	modCount:表示结构上被修改的次数.
	 	如果这个数组大家一起再使用,在多线程并发的时候可能会有别的人在新增或者删除数组中的某个元素,而你刚好在迭代查看这个数组,
	 	然而这个数组数组中某个位置上的元素不是原来的那个,或者根本就不存在的,从而我们得报异常.
	 	暂时不考虑这个.
	 */
	int modCount;  //
	 
	public MyArrayList(){
		value=new Object[16]; //默认16个
	}
	public MyArrayList(int size){
		value=new Object[size]; //默认16个
	}
	//添加元素
	public void  add(Object object){
		//若超过边界,我把容量扩大两倍,把老数组的值赋值给新数组
		if(size>=value.length){
			int newLength=value.length*2;
			Object[] newArr=new Object[newLength];
			for (int i = 0; i < value.length; i++) {
				newArr[i]=value[i];
			}
			value=newArr; //新数组的地址赋个value属性
		}
		value[size]=object;
		size++;
	}
	//获取元素
	public Object get(int index){
		if(index<0||index>(size-1)){
			try {throw new Exception();} catch (Exception e) {e.printStackTrace();}
		}
		return value[index];
	}
	//获取数组长度
	public int size(){
		return size;
	}
	//重写toString方法,用于打印
	public String toString(){
		StringBuilder sb=new StringBuilder("[");
		for (int i = 0; i < size; i++) {
			if(i==0){
				sb.append(value[i]);
			}else{
				sb.append(",").append(value[i]);
			}
		}
		return sb.append("]").toString();
	}
	//indexOf方法
	public int indexOf(Object object){
		if(object==null)return -1;
		for (int i = 0; i < size; i++) {
			if(value[i]==object){ //这里是既判断地址,又判断值,如何只判断值呢?
				return i;
			}
		}
		return -1;
	}
	//lastIndexOf方法
	public int lastIndexOf(Object object){
		if(object==null)return -1;
		for (int i = size-1; i >=0; i--) {
			if(value[i]==object){ //这里是既判断地址,又判断值,如何只判断值呢?
				return i;
			}
		}
		return -1;
	}
	//remove方法
	public Object remove(int index){
		checkIndex(index);
		Object oldObj=value[index];
		//只要在中间删除一个,那么后面的元素就要往前移动一格.若只有一个的话或是最后一个元素的话,只要把该位置赋值为null就行了
		int flag=size-index-1; //如果是最后一个,则值为0;只有一个的时候也是最后一个,从而也为0.也就是剩下的个数
		if(flag>0){ //若不是最后一个,后面的元素往前移动一格
			System.arraycopy(value, index+1, value, index,flag);
		}
		value[--size]=null;//最后那个位置赋值为null
		return oldObj;
	}
	//检验是否越界
	public void checkIndex(int index){
		if(size==0&&index>=size){
			try {
				throw new  Exception("越界异常!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	//返回一个可以遍历数组的迭代器
    public Iterator iterator() {
        return new Itr();
    }
    //迭代器类(ArrayList的内部类)
    private class Itr implements Iterator {
        int cursor;           // index of next element to return 下一个元素的索引,默认为0
        int lastRet = -1;  // index of last element returned; -1 if no such 上一个元素的索引,默认为-1
        int expectedModCount = modCount;  //modCount:表示结构上被修改的次数

        public boolean hasNext() {
            return cursor != size;   //是否有下一个元素
        }

        public Object next() {
            checkForComodification();   //检查是否有人改动了列表
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();  //若超过边界,则报异常
            Object[] elementData = MyArrayList.this.value;  //拿到存放数据的那个数组
            if (i >= elementData.length)   //若索引大于数组的长度,说明在数组中删除了一个元素,从而抛出一个异常
                throw new ConcurrentModificationException();
            cursor = i + 1;  //让游标指向下一个元素
            return  elementData[lastRet = i]; //返回当前指向的元素
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();  //若上一个元素不存在则报错
            checkForComodification(); 				 //检查数组是否有改动

            try {
                MyArrayList.this.remove(lastRet);   //上面各种检验之后还用一个try catch进行捕获 ,当前元素
                cursor = lastRet;                            //删除完上一个之后,游标也向上移动一格
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException(); //若还是报错,证明有人在此时此刻改动了数组
            }
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)  //只要是被人改动过,那就报异常
                throw new ConcurrentModificationException();
        }
    }
    
	public static void main(String[] args) {
		MyArrayList list=new MyArrayList();
		list.add("张飞");
		list.add("关羽");
		System.out.println(list);
		//如果超过容量,会怎么样呢?报ArrayIndexOutOfBoundsException异常,从而我们要修改add方法
		//经过修改add方法,可以容纳更多的元素了
		for (int i = 0; i < 20; i++) {
			list.add(i);
		}
		System.out.println(list);
		list.remove(1); //把关羽移除
		System.out.println(list);
		System.out.println("--------------------使用Iterator来遍历数组--------------------");
		Iterator iterator=list.iterator();
		while(iterator.hasNext()){
			Object temp=iterator.next();
			System.out.println(temp);
		}
	}
	
}
