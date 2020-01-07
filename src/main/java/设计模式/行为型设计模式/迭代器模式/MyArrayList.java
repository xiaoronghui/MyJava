package 设计模式.行为型设计模式.迭代器模式;

import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {
	
	private Object[] array = new Object[100];
	
	private int size = 0;
	
	public MyArrayList() {
		
	}
	
	public void add(T t){
		array[size ++] = t;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new MyIterator<T>();
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder("[");
		
		for(int i = 0 ; i < size; i ++){
			Object item = array[i];
			sb.append(item == null ? "null" : item.toString()).append(",");
		}
		
		sb = sb.length() > 1 ? sb.deleteCharAt(sb.length() - 1) : sb;
		
		sb.append("]");
		
		return sb.toString();
	}

	private class MyIterator<E> implements Iterator<E>{
		
		int index = 0;
		
		@Override
		public boolean hasNext() {
			return index < size;
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			return (E) array[index ++];
		}
		
	}

}
