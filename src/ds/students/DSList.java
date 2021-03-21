package ds.students;

import ds.interfaces.List;

/**
 * @author simont
 * @author traqy014
 *
 */
public class DSList implements List {
	
	public Node head;
	private Node tail;

	public DSList() {
		
	}
	public DSList(Node head_) {
		head = tail = head_;
	}

	public DSList(DSList other) { // Copy constructor. 
		Node temp = other.head;
		while(temp != null) {
			this.add(temp.getToken());
			temp= temp.next;
		}
	}

	public Token remove(int index) {
		if (index <0 || index >= this.size()) {
			 throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		else if (index == 0) {
			Node temp = head;
			  if (head != null) {
			    head = head.next;
			    
			  }
			  if (temp != null) {
			    
			    return temp.getToken();
			  } 
			  else {
			    return null;
			  }
		}
		
		else if (index == this.size()-1) {
			Node temp = tail;
			if (tail != null) {
				tail= tail.prev;
				tail.next= null;
			}
            if (temp != null) {
			    
			    return temp.getToken();
			  } 
			else {
			    return null;
			}
		}
		
		else {
		Node ref = head;
		for(int i=0; i<index; i++) {
			ref = ref.next;
		}
		ref.next.prev = ref.prev;
		ref.prev.next = ref.next;
		return ref.getToken();
		}
	}
	
	public int indexOf(Token obj) {
		Node ref = head;
		
		for (int i = 0; i< this.size(); i++) {
			if(ref.getToken().equals( obj)) {
				return i;
			}
			ref = ref.next;
		}
		return -1;
	}

	public Node getNode(int index) {
		if (index <0 || index >= this.size()) {
			 return null;
		}
		else if (index == 0) {
			return head;
		}
		
		else {
		Node ref = head;
		for(int i=0; i<index; i++) {
			ref = ref.next;
		}
		
		return ref;
		}
	}

	public Token get(int index) {
		if (index <0 || index >= this.size()) {
			 return null;
		}
		else if (index == 0) {
			return head.getToken();
		}
		
		else {
		Node ref = head;
		for(int i=0; i<index; i++) {
			ref = ref.next;
		}
		
		return ref.getToken();
		}
	}

	public boolean isEmpty() {
		return this.size() ==0;
	}

	public int size() {
		int count  = 0;
		Node p = head;
		if (head == null) {
			return 0;
		}
		else
			while(p != null) {
				count++;
				
				p = p.next;
			}
		return count;
	}
	
	@Override
	public String toString() {
		String x ="";
		Node p = head;
		if (head == null) {
			return x;
		}
		else
			while(p != null) {
				x +=  p.getToken().toString();
				if (p.next != null) {
					x += " ";
				}
				p = p.next;
			}
		return x;
		
	}

	public boolean add(Token obj) {
		if(obj == null) {
			throw new NullPointerException();
		}
		Node x = new Node(null, null, obj);
		if (head == null) {
			head = tail =x;
		}
		else {
			tail.next = x ;
			x.prev = tail;
			tail = x;
		}
		return true;
	}

	public boolean add(int index, Token obj) {
		if (obj == null) {
			throw new NullPointerException();
		}
		Node newNode = new Node(null, null,obj);
		if (index <0 || index > this.size()) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		else if (index == 0) {			// insert before head
			newNode.next = head; 
		    newNode.prev = null; 
		  
		    /* change prev of head node to new node */
		    if (head != null) 
		        head.prev = newNode; 
		  
		    /* move the head to point to the new node */
		    head = newNode; 
		}
		else if (index == this.size()) { 	// insert after tail
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		}
		else {
			Node ref = head;
			for(int i=1; i<index; i++) {
				ref = ref.next;
			}
			newNode.next = ref.next;
			ref.next = newNode;
			newNode.prev = ref;
			newNode.next.prev = newNode;
		}
		return false;
	}
	
	public boolean contains(Token obj) {
        Node ref = head;
		boolean check = false;
		for (int i = 0; i< this.size(); i++) {
			if(ref.getToken().equals( obj)) {
				check = true;
				break;
			}
			ref = ref.next;
		}
		return check;
	}

	public boolean remove(Token obj) {
		if (obj == null) {
		    throw new NullPointerException();
		}
        Node ref = head;
        boolean check = false;
        
		for (int i = 0; i< this.size(); i++) {
			if(ref.getToken().equals( obj)) {
				check = true;
				this.remove(i);
				break;
			}
			ref = ref.next;
		}
		
		return check;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((head == null) ? 0 : head.hashCode());
		result = prime * result + ((tail == null) ? 0 : tail.hashCode());
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
		DSList other = (DSList) obj;
		if (this.size() != other.size()) {
			return false;
		}
		else {
			for (int i= 0; i< this.size(); i++) {
				if (this.get(i).equals(other.get(i)) == false) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	
}