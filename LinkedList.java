class LinkedList
{
	static node head = null;
	
	public static class node
	{
		int data;
		node next;
		
		node(int data)
		{
			this.data = data;
			next = null;
			
			if(head == null)
				head = this;
		}
		
		//returns the total number of nodes
		public int getTotalNodes()
		{
			int i = 0;
			for(node temp = this; temp != null; temp = temp.next, i++);
			return i;
		}
		
		//length recurssion implementation
		public int lengthLL()
		{
			if(this.next != null)
				return 1 + this.next.lengthLL();
			return 1;
		}
		
		public node insert(int data)
		{
			node n = new node(data);
			node temp = this;
			for(; temp.next != null; temp = temp.next);
			temp.next = n;
			return n;
		}
		
		public node updateHead(int data)
		{
			node n = new node(0);
			n.next = this;
			head = n;
			return n;
		}
		
		public node insertIndex(int index, int data)
		{
			node n = new node(data);
			node temp = this;
			int i = 1;
			for(; temp.next != null && i != index - 1 ; i++, temp = temp.next);
			
			//to handle excess index error
			if(temp == null || temp.next == null && index > i)
				return insert(data);
			
			node temp1 = temp.next;
			temp.next = n;
			n.next = temp1;
			return this;
		}
		
		public node deleteIndex(int index)
		{
			if(index > getTotalNodes())
			{
				System.out.println("Exceeds the total number of nodes!");
				return this;
			}
			if(index <= 1)
			{
				head = head.next;
				return head;
			}
			
			node temp = this;
			for(int i = 1 ; temp.next != null && i != index - 1 ; i++, temp = temp.next);
			temp.next = temp.next.next;
			return this;
		}
		
		//search for an item
		public boolean search(int item)
		{
			node temp = this;
			while(temp != null)
			{
				if(temp.data == item)
					return true;
				temp = temp.next;
			}
			return false;
		}
		
		public boolean detectLoop()
		{
			node temp = this;
			for(; temp.next != null; temp = temp.next)
			{
				node t = temp.next;
				while(t.next != temp && t.next != null)
					t = t.next;
				
				if(t == temp)
					return true;
			}
			return false;
		}
		
		public node sortList()
		{
			node temp = this;
			for(;temp.next != null; temp = temp.next)
			{
				for(node temp1 = this; temp1.next.next != null; temp1 = temp1.next)
				{
					if(temp1.data > temp1.next.data)
					{
						node x = temp1.next;
						node y = temp1.next.next;
						
						node t = temp1;
						temp1 = temp1.next;
						//temp1.next = temp1.next.next;
						temp1.next = t;
						temp1.next.next = x;
						temp1.next = y;
					}
				}
			}
			return this;
		}
		
	}
	
	
	
	public static void display(node head)
	{
		System.out.println("The datas are :\n");
		for(node n = head; n != null; n = n.next)
			System.out.println(n.data);
	}
	
	public static void main(String[] args)
	{
		head = new node(1);
		head.insert(3).insert(2).insert(5).insert(4);
		
		//head.sortList();
		
		/*  node loop 
		node n = head.insertIndex(2,10);
		node temp = head.next.next.next;
		head.next.next.next = n;
		n.next = temp;
		*/
		
		head.updateHead(0);
		
		head.deleteIndex(1);
		
		head.insertIndex(6,6);
	
		
		//handling the excess index
		head.insertIndex(8,7);
		
		display(head);
		
		System.out.println("Nodes : "+head.getTotalNodes());
		System.out.println("Node : "+head.lengthLL());
		
		//handling the delete null error
		head.deleteIndex(100);
		
		System.out.println(head.search(5));
		
		System.out.println(head.detectLoop());
	}
}

		
		
		
		