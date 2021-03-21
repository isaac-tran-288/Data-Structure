package ds.students;

import java.util.EmptyStackException;

import ds.interfaces.Stack;

/**
 * @author simont
 * @author traqy014
 */
public class DSStack extends Stack {
	
	@Override
	public int hashCode() {
		return 0;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DSStack other = (DSStack) obj;
		
		return this.list.equals(other.list);
	}
	


	public DSStack() {
		this.list = new DSList();
	}
	
	public DSStack(DSStack other) {
		this.list = new DSList(other.list);
	}
	
	public Token push(Token obj) {
		if (obj == null) {
			throw new NullPointerException();
		}
		this.list.add(0,obj);
		return obj;
	}

	public Token peek() {
		if (this.isEmpty() == true) {
			throw new EmptyStackException();
		}
		else {
			
			return this.list.head.getToken();
		}
		
	}

	public Token pop() {
		if (this.isEmpty() == true) {
			throw new EmptyStackException();
		}
		else {
			Node temp = this.list.head;
			
			this.list.remove(0);
			return temp.getToken();
		}
	}

	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	public int size() {
		return this.list.size();
	}
	
	@Override
	public String toString() {
		return this.list.toString();
	}
	


}
