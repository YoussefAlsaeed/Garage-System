package defaultt;

public class Slot {
	
	private double length;
	private double width;
	private double minSlotSize;
	private double maxSlotSize;
	private String occupied;
	private boolean isEmpty;
	private double cost;
	
	Slot()
	{
		this.length= 0;
		this.width = 0;
		this.isEmpty=true;
		this.cost=0; // Setting the cost of the slot.	
		this.occupied = Double.toString(length)+" x "+Double.toString(width)+ " | Cost: " + Double.toString(cost); 
	}
	
		
	public String getOccupied() {
		return occupied;
	}

	public void setOccupied(String occupied) {
		this.occupied = occupied;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public double getMinSlotSize() {
		return minSlotSize;
	}

	public void setMinSlotSize(double minSlotSize) {
		this.minSlotSize = minSlotSize;
	}

	public double getMaxSlotSize() {
		return maxSlotSize;
	}

	public void setMaxSlotSize(double maxSlotSize) {
		this.maxSlotSize = maxSlotSize;
	}

    public void setCost(double hourlyCost)
    {
		this.cost=((length*width)/2) + hourlyCost; // Setting the cost of the slot.	

    }
	
	public double getCost() {
		return cost;
	}	
	/**
	 * 
	 * @param ID The ID of the car that we want to remove
	 * @throws Exceptions  if the slot is already occupied throw an error message.
	 */
	public void occupySlot(int ID) throws Exceptions
    {		  	
    	if (isEmpty()==false)
    	{
			throw new Exceptions ("The slot is Occupied\n");
    	} 
		else
		{
    		setOccupied("          " + Integer.toString(ID) + "           ");
    		setEmpty(false);  // assigning the slot as not empty.
    		
    	}		
    } 
	
	public void removeSlot()
	{
		setOccupied(Double.toString(length)+" x "+Double.toString(width) +" | Cost: " + Double.toString(cost));  // Setting the occupied as Empty.
		setEmpty(true);
	}	
		
}
