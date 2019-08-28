package heap;

public class Heaps {

	int[] a;
	
	public Heaps() {
		this(5);
	}
	
	public Heaps(int n) {
		a = new int[n];
	}
	
	public Heaps(int[] n) {
		int c = 0;
		a = new int[n.length];
		for(int i : n)
			a[c++] = i;
	}
	
	public static int[] heapify(int[] a, int i) {
		//largest coordinate of the root
		int largest = i;
		int l = 2*i + 1;
		int r = 2*i + 2;
		
		if(l < a.length && a[largest] < a[l])
			largest = l;
		if(r < a.length && a[largest] < a[r])
			largest = r;
		
		//largest is not root then swap
		if(largest != i) {
			int temp = a[largest];
			a[largest] = a[i];
			a[i] = temp;
		
			//only when swapping is done heapifying is needed
			heapify(a, largest);
		}
		
		return a;
	}
	
	public static int[] deleteRoot(int[] a) {
		int num = a[0];
		
		a[0] = a[a.length - 1];
		
		a = updateArray(a, a.length - 1);
		
		return heapify(a, 0);
	}
	
	private static int[] updateArray(int[] a, int n) {
		// TODO Auto-generated method stub
		int[] temp = new int[n];
		for(int i = 0; i < n; i++)
			temp[i] = a[i];
		return temp;
	}

	public static int[] insert(int[] a, int data) {
		int c = 0;
		int[] temp = new int[a.length + 1];
		
		for(int i : a)
			temp[c++] = i;
		
		temp[a.length] = data;
		a = temp;
		
		return heapifyBu(a, temp.length - 1);
	}
	
	//bottom up heapify
	public static int[] heapifyBu(int[] a, int i) {
		int p = (i - 1)/2;
		
		if(p >= 0) {
			if(a[i] > a[p]) {
				int temp = a[i];
				a[i] = a[p];
				a[p] = temp;
				
				heapifyBu(a, p);
			}
		}
		
		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Array representation of Max-Heap
        //     10
        //    /  \
        //   5    3
        //  / \
        // 2   4
        int a[] = { 10, 5, 3, 2, 4 };

        printArray(a);
        a = deleteRoot(a);
        System.out.println("Deleted root: ");
        
        printArray(a);
        
        a = insert(a, 2);
        printArray(a);
        
        
	}

	public static void printArray(int[] a) {
		for(int i : a)
			System.out.print(i+" ");
		System.out.println();
	}

}
