
public class GetPlanFactory {
	
	


public Plan getPlan(String plantype)
{
	if(plantype==null)
	{
		return null;
		
	}
	
	if(plantype.equalsIgnoreCase("DOMESTICTYPE"))
	{
		return new DomesticPlan();
	}
	else
	{
		if(plantype.equalsIgnoreCase("COMMERCIALTYPE"))
		{
			return new CommercialPlan();
		}
		else
		{
			if(plantype.equalsIgnoreCase("INSTITUTIONALPLAN"))
			{
				return new InstitutionPlan();
			}
		}
	}
	return null;
}


}