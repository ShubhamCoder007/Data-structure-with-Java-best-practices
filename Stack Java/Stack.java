import java.util.EmptyStackException;
public class Stack
{
	private Node top = null;
	
	public Stack(){
	}
	
	public Stack(Node n){
		this.top = n;
	}
	
	public Stack(Stack s){
		Node r = null;
		for(Node temp = s.top; temp != null; temp = temp.getNext())
		{
			Node n = new Node(temp.getItem());
			n.setNext(r);
			r = n;
		}
		while(r != null){
			this.push(r.getItem());
			r = r.getNext();
		}
	}	
	
	public Stack reverse(){
		Node rev = null;
		for(Node temp = top; temp != null; temp = temp.getNext())
		{
			Node n = new Node(temp.getItem());
			n.setNext(rev);
			rev = n;
		}
		return new Stack(rev);
	}
	
	public void push(int data){
		Node n = new Node(data);
		n.setNext(top);
		top = n;
	}
	
	//overloaded for minimum stack
	public void push(Stack minstack, int data){
		minstack.minPush(data);
		Node n = new Node(data);
		n.setNext(top);
		top = n;
	}
	
	public int pop(){
		if(isEmpty())
			throw new EmptyStackException();
		int data = top.getItem();
		top = top.getNext();
		return data;
	}
	
	//overloaded pop so that we can use in normal stack pushing as well as minimum stack scenario
	//to preserve the normal legacy pushing code
	public int pop(Stack minstack){
		if(isEmpty())
			throw new EmptyStackException();
		int data = top.getItem();
		top = top.getNext();
		minstack.minPop(data);
		return data;
	}
	
	public int peek(){
		if(isEmpty())
			throw new EmptyStackException();
		return top.getItem();
	}
	
	//minstack is calling this function, so all the data members are of minstack
	//we want only the supporting minstack to call this function so it is private
	private void minPush(int data){		
		if(isEmpty() || peek() > data)
		{
			Node n = new Node(data);
			n.setNext(top);
			top = n;
		}
	}
	
	//minstack is referencing this function, so the functions are of minstack
	private void minPop(int data){
		if(peek() == data)
			pop();
	}
	
	public int getMin(Stack minstack){
		return minstack.peek();
	}
	
	public void display(){
		Node temp = top;
		for(; temp != null; temp = temp.getNext())
			System.out.print(temp.getItem()+" ");
		System.out.println();
	}
	
	public boolean isEmpty(){
		return top == null;
	}
}