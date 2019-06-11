import java.util.Scanner;

public class MissingNumberInArray {
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int noftestcase=sc.nextInt();
		
		for(int  i=0;i<noftestcase;i++)
		{
			int len= sc.nextInt();
			sc.nextLine();
			
			String arrss= sc.nextLine();
			
			String ar[]=arrss.split(" ");
			int arr[]= new int[len-1];
			
			for(int y=0;y<len-1;y++)
			{
				arr[y]= Integer.parseInt(ar[y]);
				
			}
			int number = findMissingNumber(arr,len);
			
			
			System.out.println("");
			System.out.print(number);
			
			
			
		}
		
	}
	
	
	
	public static  int findMissingNumber(int arr[],int len)
	{
	   int expected = ( len*(len+1))/2;
	   int sum =0 ;
	   for(int i=0;i<arr.length;i++)
	   {
		   sum=sum+arr[i];
		   
	   }
	   
	   return expected- sum;
		
	}

}
