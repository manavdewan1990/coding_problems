package com.company.data_structure;



public class LinkedList<T> implements List<T> {

	private Node<T> head;
	
	static class Node <T>{
		private Node<T> next;

		 private T data;

		public Node(T data2) {
			this.data=data2;
		}

		
		public Node() {
			// TODO Auto-generated constructor stub
		}


		public Node<T> getNext() {
			return next;
		}


		public void setNext(Node<T> next) {
			this.next = next;
		}


		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

	}

	
	
	@Override
	public boolean add(T data) {
		
		if (this.head==null)
		{
			this.head=new Node<T>(data);
		}
		else
		{
			Node<T> temp= this.head;
			this.head=new Node<T>(data);
			this.head.next=temp;
		}
		return false;

	}



	public Node<T> getHead() {
		return head;
	}



	public void setHead(Node<T> head) {
		this.head = head;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		Node<T> start= this.head;
		do
		{
			builder.append(start.getData() + "->");
			start=start.next;
		}while (start.getNext()!=null);
		
	
		return builder.toString();
	}



	
	
}
