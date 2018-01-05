
public abstract class Plan {
	
	protected double rate ; 
	abstract void getRate();
	
	public void calculateBill(int unit )
	{
		System.out.println(unit*rate);
	}
	
	

}
