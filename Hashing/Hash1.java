/*hashing concept: Given  an unorder array and a number x, find if a pair exists which adds up to x*/
// O(n)

import java.io.*;
class Hash1
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the size of the array: ");
		int n = Integer.parseInt(br.readLine());
		System.out.println("Enter the number to find as a pair of array elements: ");
		int x = Integer.parseInt(br.readLine());
		
		boolean[] hash = new boolean[x];
		for(int i = 0; i < x; i++)
			hash[i] = false;
		
		for(int i = 0; i < n; i++){
			System.out.println("Enter the element of the array: ");
			int a = Integer.parseInt(br.readLine());
			if(hash[a]){
				System.out.println("Exists! you entered "+a+", and "+(x-a)+" is already present");
				break;
			}
			else
				System.out.println("Can't form such pair till now, Doesn't Exists!");
			
			hash[x - a] = true;
		}
		
	}
}
				
			