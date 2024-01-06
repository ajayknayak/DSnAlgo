package org.ajay.ds.algo.linkedlist;

import org.ajay.ds.algo.linkedlist.node.ListNode;

public class SingleLinkedList<T> {

	private ListNode<T> head;
	
	public SingleLinkedList(){
		this.head = null;
	}
	
	public ListNode<T> getHead() {
		return head;
	}

	/**
	 * Add element ti linked list
	 * @param data
	 */
	public void add(T data){
		if(null == head){
			head = new ListNode<T>(data);
			return;
		}
		ListNode<T> tmpHead = head;
		while(tmpHead.getNext() != null){
			tmpHead = tmpHead.getNext();
		}
		tmpHead.setNext(new ListNode<T>(data));
	}
	
	/**
	 * Add element to linked list at position
	 * @param data
	 * @param pos
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public void addAt(T data, int pos) throws ArrayIndexOutOfBoundsException{
		if(pos < 1 || pos > length()+1){
			throw new ArrayIndexOutOfBoundsException("Position out of bound");
		}
		ListNode<T> node = new ListNode<T>(data);
		if(pos == 1){
			node.setNext(head);
			head = node;
			return;
		}
		
		int count =1;
		ListNode<T> tmpHead = head;
		while(count < pos-1 ){
			tmpHead = tmpHead.getNext();
			count++;
		}
		node.setNext(tmpHead.getNext());
		tmpHead.setNext(node);
	}
	
	/**
	 * Delete an elements from the linked list
	 * @param data
	 * @throws Exception
	 */
	public void delete(T data)throws Exception{
		
		ListNode<T> tmpNode = head;
		if(tmpNode.getData() == data){
			head = tmpNode.getNext();
			return;
		}
		ListNode<T> prevnode = tmpNode;
		while(tmpNode!= null && tmpNode.getData() != data){
			prevnode = tmpNode;
			tmpNode = tmpNode.getNext();
		}
		if(tmpNode!=null && tmpNode.getData() == data){
			prevnode.setNext(tmpNode.getNext()); 
		} else {
			throw new Exception("Node Not Found");
		}
	}
	/**
	 * Delete by Index
	 * @param index
	 * @throws Exception
	 */
	public void deleteByIndex(int index)throws Exception{
		int length = length();
		if(index > length || index < 1){
			throw new Exception("Index out of bound");
		}
		if(index == 1){
			head = head.getNext();
			return;
		}
		
		ListNode<T> tmpNode = head;
		int count=1;
		while(count < index-1){
			tmpNode = tmpNode.getNext();
			count++;
		}
		if(tmpNode!=null){
			tmpNode.setNext(tmpNode.getNext().getNext()); 
		} else {
			throw new Exception("Node Not Found");
		}
	}
	
	/**
	 * Find the length
	 * @return
	 */
	public int length(){
		int lenght = 0;
		ListNode<T> tmpHead = head;
		while(tmpHead != null){
			lenght++;
			tmpHead = tmpHead.getNext();
		}
		return lenght;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		ListNode<T> tmpHead = head;
		while(null != tmpHead){
			sb.append(tmpHead.getData());
			if(tmpHead.getNext() != null){
				sb.append(",");
			}
			tmpHead = tmpHead.getNext();
		}
		sb.append("]");
		return sb.toString();
	}
	
	public String printList(ListNode<T> head) {
		StringBuilder sb = new StringBuilder("[");
		ListNode<T> tmpHead = head;
		while(null != tmpHead){
			sb.append(tmpHead.getData());
			if(tmpHead.getNext() != null){
				sb.append(",");
			}
			tmpHead = tmpHead.getNext();
		}
		sb.append("]");
		return sb.toString();
	}
	
	/**
	 * This is used to reverse the linked list.
	 * @param head
	 * @return
	 */
	public ListNode<T> reverseLinkedList(ListNode<T> head){
		
		ListNode<T> tmp = null;
		while(null != head){
			ListNode<T> nextNode = head.getNext();
			head.setNext(tmp);
			tmp = head;
			head = nextNode;
		}
		return tmp;
	}
	
}
