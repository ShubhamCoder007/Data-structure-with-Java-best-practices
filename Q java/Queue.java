public class Queue 
{
	private Node front = null;
	private Node rear = null;
	private int total;
	
	public Queue(){
	}
	
	public Queue(int...a){
		for(int i:a)
			enqueue(i);
		System.out.println("\nQueue created");
		display();
	}
	
	//cloning a queue
	public Queue(Queue q){
		Node t = q.getFront();
		while(t != null){
			enqueue(t.getItem());
			t = t.getNext();
		}
		System.out.println("\nCloned successfully");
		display();
	}
	
	public Node getFront(){
		return front;
	}
	
	public boolean isEmpty(){
		return front == null;
	}
	
	public int total(){
		return total;
	}
	
	public void enqueue(int data)
	{
		Node n = new Node(data);
		if(front == null){
			front = rear = n;
			total++;
			return;
		}
		rear.setNext(n);
		rear = n;
		total++;
	}
	
	public int dequeue()throws EmptyQueueException{
		int data;
		if(front == null)
			throw new EmptyQueueException();
		if(front == rear){
			data = front.getItem();
			front = rear = null;
			total--;
			return data;
		}
		data = front.getItem();
		front = front.getNext();
		total--;
		return data;
	}
	
	public void reverse(Node n){
		if(n.getNext() == null){
			front = n;
			return;
		}
		reverse(n.getNext());
		rear.setNext(n);
		rear = n;
		rear.setNext(null);
	}
	
	//reversing using stack
	public void reverse()throws EmptyQueueException{
		Stack s = new Stack();
		while(!isEmpty())
			s.push(dequeue());
		while(!s.isEmpty())
			enqueue(s.pop());
	}
	
	public void reverseFirstK(int k){
		if(k <= 0)
			return;
		
		//if entire q is reversed then flag denotes it, so that rear could be updated
		boolean flag = false;
		if(k > total){
			k = total;
			flag = true;
		}
		
		Stack s = new Stack();
		Node start = null;
		Node t = null;
		
		while(k > 0){
			try{
			s.push(dequeue());
			}catch(EmptyQueueException e){
				return;
			}
			k--;
		}
		
		while(!s.isEmpty()){
			Node n = new Node(s.pop());
			if(t == null){
				start = t = n;
				continue;
			}
			t.setNext(n);
			t = n;
		}
		t.setNext(front);
		front = start;
		
		//if entire queue is reversed then rear has to be updated
		if(flag)
			rear = t;
	}
	
	public void remove(int data){
		Node t = front;
		if(front == null)
			return;
		if(front.getItem() == data){
			front = front.getNext();
			return;
		}
		for(; t.getNext().getItem() != data && t.getNext() != null ; t = t.getNext());
		if(t.getNext().getNext() == null){
			t.setNext(null);
			return;
		}
		t.setNext(t.getNext().getNext());
		System.gc();
	}
	
	public Queue sort(){
		Stack s = new Stack();
		Queue q1 = new Queue(this);
		Queue q = new Queue();
		while(!q1.isEmpty()){
			Node t = q1.getFront();
			int startlen = s.total();
			int endlen = 0;
			while(t != null){
				if(s.isEmpty() || s.peek() > t.getItem())
					s.push(t.getItem());
				t = t.getNext();
				endlen = s.total();
			}
			if(startlen == endlen){
				while(!s.isEmpty()){
					int d = s.peek();
					q1.remove(d);
					q.enqueue(s.pop());
				}
				continue;
			}
			int d = s.peek();
			q.enqueue(s.pop());
			q1.remove(d);
			q.display();
		}
		return q;
	}
			
	
	public void display(){
		Node temp = front;
		System.out.println("Displaying Queue:\n----------------------------------------------------------");
		for(; temp != null; temp = temp.getNext())
			System.out.print("| "+temp.getItem()+" |");
		System.out.println("\n----------------------------------------------------------\n");
	}
}