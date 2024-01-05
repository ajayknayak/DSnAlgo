package org.ajay.ds.algo.linkedlist.node;

public class DListNode<T> {
	
	private T data;
	private DListNode<T> next;
	private DListNode<T> prev;
	
	public DListNode(){}
	public DListNode(T data){
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public DListNode<T> getNext() {
		return next;
	}
	public void setNext(DListNode<T> next) {
		this.next = next;
	}
	public DListNode<T> getPrev() {
		return prev;
	}
	public void setPrev(DListNode<T> prev) {
		this.prev = prev;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.data);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		result = prime * result + ((prev == null) ? 0 : prev.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DListNode<?> other = (DListNode<?>) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		if (prev == null) {
			if (other.prev != null)
				return false;
		} else if (!prev.equals(other.prev))
			return false;
		return true;
	}

}
