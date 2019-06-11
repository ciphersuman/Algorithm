import java.util.Scanner;

public class CountOfUnion {
	
	public static void main(String args[])
	
	{
	Scanner sc = new Scanner(System.in);
		
		int noOfTestCase= sc.nextInt();
		
		sc.nextLine();
		
		String lengthCouple= sc.nextLine();
		
		String lengthCoupleArray[ ]= lengthCouple.split(" ");
		
		int m = Integer.parseInt(lengthCoupleArray[0]);
		
		int n = Integer.parseInt(lengthCoupleArray[1]);
		
		String firstArrString=  sc.nextLine();
		
		String secondArraString= sc.nextLine();
		
		String firstStringArray[]= firstArrString.split(" ");
		
		String secondStringARray[]= secondArraString.split(" ");
		
		
		int arr1[] = new int[m];
		
		
		int arr2[] = new int [n];
		
		for(int i=0;i<m;i++)
		{
			arr1[i]= Integer.parseInt(firstStringArray[i]);
			
			
		}
		
		for(int j=0;j<n;j++)
		{
			
			arr2[j]= Integer.parseInt(secondStringARray[j]);
		}
		
		
		
		
		
		
		
		int ucount= countUnion(arr1, arr2);
		
		System.out.println(ucount);
		
		
		}
		
		
		
		
		
		
	
	
	public static int countUnion(int arr1[],int arr2[])
	{
			int i=0;
			int j=0 ;
			
			
			int unioncounter=0;
			while(i<=arr1.length-1 && j<=arr2.length-1)
			{
				int temp1 = arr1[i];
				int temp2 = arr2[j];
				
				if(temp1==temp2)
				{
					unioncounter++;
					i++;
					j++;
				}
				else
				{
					if(temp1<temp2)
					{
						unioncounter++;
						i++;
					}
					else
					{
						unioncounter++;
						j++;
						
					}
				}
				
			}
			
			while(i<=arr1.length-1)
			{ 
				unioncounter++;
				i++;
			}
			while(j<=arr2.length-1)
			{
				unioncounter++;
				j++;
			}
			
			
			return  unioncounter;
	}

}
