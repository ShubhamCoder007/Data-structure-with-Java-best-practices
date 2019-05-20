public class EmptyQueueException extends Exception
{
	private String msg;
	
	public EmptyQueueException(){
		this("Empty Queue!");
	}
	
	public EmptyQueueException(String msg){
		super(msg);
		this.msg = msg;
	}
	
	public String getMsg(){
		return msg;
	}
}
	