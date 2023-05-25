package defaultt;


public class randomizedGarage implements IGarageBuilder
{	
	Slot[][] garageSlots;
	private int rows;
	private int columns;
	private double length;
	private double width;
	private double hourlyRate;
	private double maxSlotSize;
	private double minSlotSize;	
	
	@Override
	public void reset() 
	{
		
		for(int i =0;i<rows;i++)
    	{
    		for(int j =0;j<columns;j++)
    		{
    			garageSlots[i][j] = new Slot();
    		}
    	}   
    			
	}

	@Override
	public void setrowSize(int rows) {
		this.rows = rows;
		
	}

	@Override
	public void setcolumnSize(int columns) {
		this.columns = columns;
		
	}

	@Override
	public void sethourlyRate(double hourlyRate) {
		this.hourlyRate=hourlyRate;
		
	}

	@Override
	public void setLength(double length) {
		this.length = length;
		
	}

	@Override
	public void setWidth(double width) {
		this.width = width;	
	}

	@Override
	public void setminSlotSize(double minSlotSize) {
        this.minSlotSize=minSlotSize;		
	}

	@Override
	public void setmaxSlotSize(double maxSlotSize) {
		this.maxSlotSize=maxSlotSize;
		
	}
	
	public void build()
	{	
    	garageSlots= new Slot[rows][columns];
		
    	for(int i =0;i<rows;i++)
    	{
    		for(int j =0;j<columns;j++)
    		{
    			double length= Math.floor(Math.random()*(maxSlotSize-minSlotSize+1)+minSlotSize);  
    			double width = Math.floor(Math.random()*(maxSlotSize-minSlotSize+1)+minSlotSize);
    	    	Slot slot = new Slot();
    	    	slot.setLength(length);
    	    	slot.setWidth(width);
    	    	slot.setCost(hourlyRate);
    	    	slot.setOccupied(Double.toString(length)+" x "+Double.toString(width)+ " | Cost: " + Double.toString(slot.getCost()));
    	    	
    			garageSlots[i][j] = slot;
    		}
    	}   	
	}
		
	@Override
	public Garage getResult()
	{	
    	return new Garage ( rows , columns , garageSlots );
	}
	
	


}
