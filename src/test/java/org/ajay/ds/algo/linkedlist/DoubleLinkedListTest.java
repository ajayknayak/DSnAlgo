package org.ajay.ds.algo.linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class DoubleLinkedListTest {
	
	DoubleLinkedList<Integer> intDList = new DoubleLinkedList<Integer>();
	DoubleLinkedList<String> strDList = new DoubleLinkedList<String>();
	
	@Test
	public void add(){
		intDList.add(1);
		intDList.add(2);
		intDList.add(3);
		intDList.add(4);
		intDList.add(5);
		intDList.add(6);
		Assert.assertEquals("[1,2,3,4,5,6]", intDList.toString());
		Assert.assertEquals("[6,5,4,3,2,1]", intDList.toReverse());
	}

}
