package defaultt;

public class calculatebyDimensions implements Ipayment{

	@Override
	public double calculateCost(int startTime,int endTime,double hourlyRate)
	{	
	    
	    double duration = (endTime-startTime)/60.0;
	    
	    double cost = duration*hourlyRate;
	    		
	    return cost;
	}

}
