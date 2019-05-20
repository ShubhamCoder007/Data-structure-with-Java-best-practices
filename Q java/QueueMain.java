class QueueMain
{
	public static void main(String[] args)throws EmptyQueueException
	{
		Queue q = new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		System.out.println("total: "+q.total());
		q.display();
		
		System.out.println("Reversing");
		q.reverse(q.getFront());
		
		q.display();
		
		System.out.println("Reversing using stack");
		q.reverse();
		q.display();
		
		System.out.println("Reversing first 2 elements");
		q.reverseFirstK(2);
		q.display();
		
		q.enqueue(6);
		q.display();
		
		System.out.println("\nTotal Elements: "+q.total());
		
		//cloning
		Queue q1 = new Queue(q);
		q1.dequeue();
		q1.display();
		q.display();
		
		Queue q2 = new Queue(8,7,6,5,4,3,2,1);
		
		q2.remove(2);
		q2.display();
		
		q2 = q2.sort();
		q2.display();
		
	}
}
		