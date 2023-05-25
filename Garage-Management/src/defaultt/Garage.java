package defaultt;

public class Garage {
	
	private Slot[][] garageSlots;
	private int rows ;
	private int columns;
	
	public Garage()
	{
		
	}
	
	public Garage(int rows, int columns, Slot[][] garageSlots)
	{
		this.garageSlots = garageSlots;
		this.rows=rows;
		this.columns = columns;
	
	}
	
	public Slot[][] getGarageSlots ()
	{
		return garageSlots;
	}
	
	public void setGarageSlots(Slot[][] garageSlots)
	{
		this.garageSlots = garageSlots;
	}
	
	public Slot getSlot(int row , int column)
	{
		return garageSlots[row][column];
	}
	
	public int getnumofRows(int row)
	{
		return garageSlots[row].length;
	}
	
	public void displaySlots()  // Prints all the slots.
    {
    	for(int i =0;i<garageSlots.length;i++)
    	{
    		for(int j =0;j<garageSlots[i].length;j++) {
    			System.out.print("< " + garageSlots[i][j].getOccupied() + " >" + "\t");
    		}
    		System.out.println();
    		System.out.println();

    	}
    }
	
	
    
}
