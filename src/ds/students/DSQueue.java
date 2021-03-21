package ds.students;

import ds.interfaces.Queue;

/**
 * @author simont
 * @author traqy014
 */

public class DSQueue extends Queue {
	
	public DSQueue(Queue s) {
		this.list = new DSList(s.list);
	
	}

	public DSQueue() {
		this.list = new DSList();
	}

	@Override
	public boolean offer(Token t) {
		if (t == null) {
			throw new NullPointerException();
		}
		/*
		if (this.list == null) {
			this.list = new DSList();
		}
		*/
		list.add(t);
		
		return true;
	}

	@Override
	public Token poll() {
		if (this.isEmpty() == true) {
			return null;
		}
		else {
		Node temp = this.list.head;
		list.remove(0);
		

		return temp.getToken() ;
		}
	}

	@Override
	public Token peek() {
		if (this.isEmpty() == true) {
			return null;
		}
		else {
		return this.list.head.getToken();
		}
	}

	@Override
	public String toString() {
		return this.list.toString();
	}

	@Override
	public int size() {
		
		return list.size() ;
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

}






