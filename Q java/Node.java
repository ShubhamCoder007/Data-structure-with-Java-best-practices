public class Node
{
	private int data;
	private Node next;
	
	public Node(){
		super();
		this.next = null;
	}
	
	public Node(int data){
		this();
		this.data = data;
	}
	
	public void setItem(int data){
		this.data = data;
	}
	
	public int getItem(){
		return data;
	}
	
	public Node getNext(){
		return next;
	}
	
	public void setNext(Node next){
		this.next = next;
	}
}