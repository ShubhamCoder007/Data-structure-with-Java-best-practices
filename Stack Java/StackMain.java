class StackMain
{

	public static void main(String[] args)
	{
		
		Stack s = new Stack();
		for(int i = 1; i <= 10; i++)
			s.push(i);
		
		//System.out.println(s.peek());
		s.display();
		//while(!s.isEmpty())
			//System.out.println(s.pop());
		
		//s.pop();
		Stack copy = new Stack(s);
		System.out.println("Copy : ");
		copy.display();
		
		//reversing the stack  method 1
		System.out.println("Reversing from main:");
		Stack r = new Stack();
		while(!s.isEmpty())
			r.push(s.pop());
		r.display();
		
		//reversing method 2
		System.out.println("Reversing inbuilt function: ");
		r = copy.reverse();
		r.display();
		
		
		//get minimum section constant time O(1)
		System.out.println("\n\nMinimum stack");
		Stack min = new Stack();
		Stack support = new Stack();
		min.push(support, 4);
		min.push(support, 2);
		min.push(support, 7);
		min.push(support, 1);
		min.push(support, 8);
		min.display();
		System.out.println("Minimum : "+min.getMin(support));
		
		//displays the support stack entry
		support.display();
		
		//verifying after popping
		System.out.println("\n"+min.pop(support));
		System.out.println("Minimum : "+min.getMin(support));
		System.out.println("The stack");
		min.display();
		System.out.println("The support stack");
		support.display();
		
		System.out.println("\n"+min.pop(support));
		System.out.println("Minimum : "+min.getMin(support));
		System.out.println("The stack");
		min.display();
		System.out.println("The support stack");
		support.display();
		
		System.out.println("\n"+min.pop(support));
		System.out.println("Minimum : "+min.getMin(support));
		System.out.println("The stack");
		min.display();
		System.out.println("The support stack");
		support.display();
		
	}
}