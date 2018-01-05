import java.lang.ref.SoftReference;




public class Softreference<T> {
	
	
	public static void main(String args[])
	{
	
	A a =new A();
	
	SoftReference<A> soft = new SoftReference<A>( a);
	
	System.out.println("1 a --  "+a);
	System.out.println("2 soft --- "+soft);
	
	a= null;/*
	
	
	though we make a refrence to null
	*/
	
	System.out.println("3 a ---- "+ a);
	
	a=soft.get();
	
	System.out.println("4 a --- "+a);
	
	}
 
	

}


class A 
{
	
}
