package org.ajay.ds.algo.linkedlist;

import org.ajay.ds.algo.linkedlist.node.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class SingleLinkedListTest {
	
	SingleLinkedList<Integer> integerList = new SingleLinkedList<Integer>();
	SingleLinkedList<String> stringList = new SingleLinkedList<String>();
	
	@Test
	public void testAdd(){
		integerList.add(1);
		integerList.add(2);
		integerList.add(3);
		integerList.add(4);
		Assert.assertEquals("[1,2,3,4]",integerList.toString());
	}
	
	@Test
	public void testAddString(){
		stringList.add("Ajay");
		stringList.add("Nandini");
		stringList.add("Additri");
		stringList.add("Adishree");
		Assert.assertEquals("[Ajay,Nandini,Additri,Adishree]",stringList.toString());
	}
	@Test
	public void addAt_Integer() throws Exception{
		integerList.add(1);
		integerList.add(2);
		integerList.add(3);
		integerList.add(4);
		integerList.add(5);
		integerList.add(6);
		integerList.add(7);
		integerList.addAt(0, 1);
		Assert.assertEquals("[0,1,2,3,4,5,6,7]",integerList.toString());
		integerList.addAt(33, 4);
		Assert.assertEquals("[0,1,2,33,3,4,5,6,7]",integerList.toString());
		
	}
	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void addAt_Integer_Exp() throws Exception{
		integerList.add(1);
		integerList.add(2);
		integerList.add(3);
		integerList.add(4);
		integerList.addAt(5, 5);
		Assert.assertEquals("[1,2,3,4,5]",integerList.toString());
		integerList.addAt(6, 7);
	}
	
	@Test (expected=Exception.class)
	public void delete() throws Exception{
		integerList.add(1);
		integerList.add(2);
		integerList.add(3);
		integerList.add(4);
		integerList.add(5);
		integerList.add(6);
		integerList.add(7);
		Assert.assertEquals("[1,2,3,4,5,6,7]",integerList.toString());
		integerList.delete(1);
		Assert.assertEquals("[2,3,4,5,6,7]",integerList.toString());
		integerList.deleteByIndex(4);
		Assert.assertEquals("[2,3,4,6,7]",integerList.toString());
		integerList.deleteByIndex(7);
		Assert.assertEquals("[2,3,4,6,7]",integerList.toString());
		
		
	}
	
	@Test
	public void reverseLinkedList(){
		integerList.add(1);
		integerList.add(2);
		integerList.add(3);
		integerList.add(4);
		integerList.add(5);
		integerList.add(6);
		integerList.add(7);
		Assert.assertEquals("[1,2,3,4,5,6,7]",integerList.toString());
		ListNode<Integer> reverseList = integerList.reverseLinkedList(integerList.getHead());
		Assert.assertEquals("[7,6,5,4,3,2,1]",integerList.printList(reverseList));
	}

}
