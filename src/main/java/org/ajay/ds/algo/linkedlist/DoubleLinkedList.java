package org.ajay.ds.algo.linkedlist;

public class DoubleLinkedList<T> {
	
	private DListNode<T> head;
	private DListNode<T> tail;
	
	public DoubleLinkedList(){
		this.head = null;
		this.tail = null;
	}
	
	public void add(T data){
		
		if(this.head == null){
			this.head = new DListNode<T>(data);
			this.tail = head;
			return;
		}
		DListNode<T> tmpNode = head;
		while(tmpNode.getNext() != null){
			tmpNode = tmpNode.getNext();
		}
		DListNode<T> node = new DListNode<T>(data);
		node.setPrev(tmpNode);
		tmpNode.setNext(node);
		this.tail = node;
	}
	
	public void addAt(T data, int index) throws Exception{
		int length = length();
		if(index < 1 || index > length+1){
			throw new IndexOutOfBoundsException("Index out of bound");
		}
		DListNode<T> node = new DListNode<T>(data);
		if(index == 1){
			node.setNext(head);
			if(null != head){
				head.setPrev(node);
			}
			head = node;
			if(this.tail == null){
				this.tail = this.head;
			}
		}
		
		int count = 1;
		DListNode<T> tmpNode = this.head;
		while(count < index -1){
			count++;
			tmpNode = tmpNode.getNext();
		}
		DListNode<T> currentNode = tmpNode.getNext();
		tmpNode.setNext(node);
		node.setPrev(tmpNode);
		node.setNext(currentNode);
		if(index == length+1){
			this.tail = node;
		} else {
			currentNode.setPrev(node);
		}
	}
	
	public void delete(T data) throws Exception{
		
		if(null == head){
			throw new Exception("Empty Double Linked List");
		}
		DListNode<T> tmpNode = this.head;
		if(tmpNode.getData() == data){
			this.head = tmpNode.getNext();
			this.head.setPrev(null);
			if(tmpNode.getData() == tail.getData()){
				tail = head;
			}
			return;
		}
		
		while(tmpNode.getData() != data){
			tmpNode = tmpNode.getNext();
		}
		
		tmpNode.getPrev().setNext(tmpNode.getNext());
		if(tmpNode.getNext() != null){
			tmpNode.getNext().setPrev(tmpNode.getPrev());
		} else {
			this.tail = tmpNode.getPrev();
		}
	}
	
	public void deleteByIndex(int index) throws Exception{
		int length = length();
		if(index < 1 || index > length+1 ){
			throw new IndexOutOfBoundsException("Index bound of exception");
		}
		if(1 == index){
			this.head = this.head.getNext();
			this.head.setPrev(null);
			if(1==length){
				tail = head;
			}
			return;
		}
		int count = 1;
		DListNode<T> tmpNode = this.head;
		while(count < index){
			count++;
			tmpNode = tmpNode.getNext();
		}
		tmpNode.getPrev().setNext(tmpNode.getNext());
		if(tmpNode.getNext() != null){
			tmpNode.getNext().setPrev(tmpNode.getPrev());
		} else {
			this.tail = tmpNode.getPrev();
		}
	}
	
	public int length(){
		int length = 0;
		DListNode<T> tmpNode = head;
		while(tmpNode != null){
			length++;
			tmpNode = tmpNode.getNext();
		}
		return length;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		DListNode<T> tmpNode = head;
		while(tmpNode != null){
			sb.append(tmpNode.getData());
			if(tmpNode.getNext() != null){
				sb.append(",");
			}
			tmpNode = tmpNode.getNext();
		}
		sb.append("]");
		return sb.toString();
		
	}
	
	public String toReverse(){
		StringBuilder sb = new StringBuilder("[");
		DListNode<T> tmpNode = tail;
		while(tmpNode != null){
			sb.append(tmpNode.getData());
			if(tmpNode.getPrev() != null){
				sb.append(",");
			}
			tmpNode = tmpNode.getPrev();
		}
		sb.append("]");
		return sb.toString();
	}

}
