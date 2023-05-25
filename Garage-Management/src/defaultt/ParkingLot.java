package defaultt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ParkingLot implements Subject{
	
	private static double TotalIncome=0;
	private HashMap<Integer,Time> VehicleMap=new HashMap<>();	/*The map has the key as vehicleID and a ticket object as value */
	private HashMap<Integer,Slot> slotMap=new HashMap<>();      /*The map has the key as vehicleID and a Slot object as value */
	private ArrayList<Observer> observerList = new ArrayList<Observer>();
	private HashMap<Integer,Observer> observerMap=new HashMap<>();      /*The map has the key as vehicleID and a Observer object as value */
	private static int AvailableSlots;
	private int GarageSize;
	private IslotSelection selectObj;
	private Ipayment payment;
	
	/**
	 * 
	 * @param rows  
	 * @param columns  initialize the size of the garage as rows and columns.
	 */
	ParkingLot(int GarageSize)
	{
    	this.GarageSize =GarageSize;
    	AvailableSlots = GarageSize;
	
	}
	
	public void setSelection(IslotSelection selectObj)
	{
		this.selectObj = selectObj;
	}
	
	public void setPayment(Ipayment payment)
	{
		this.payment = payment;
	}
	
			
	/**
	 * The parkIN function ties the vehicleID with a time object and sets the vehicle entry time to it.
	 * It also occupies a slot in the garage .
	 * @param IslotSelection object
	 * @param Vehicle object
	 * @param StartHours
	 * @param StartMinutes
	 */
	public void parkIN(Vehicle vObj,Garage garage,int StartHours,int StartMinutes, Observer notifyMethod)
	{	
		/**
		 * @Exception handles if the slot is occupied , returns an error message.
		 */
		int row=0, column = 0;		
		
		if (getAvailableSlots()!= 0 && isAvailableSlots(garage,vObj))
		{
			try{
				/* Get the spot in the garage from the select slot function.*/
				
				row = (int) selectObj.selectSlot( vObj.getLength(),vObj.getWidth(), garage.getGarageSlots()).get(1);   
				column = (int) selectObj.selectSlot( vObj.getLength(),vObj.getWidth(), garage.getGarageSlots()).get(2);
				
				garage.getSlot(row, column).occupySlot(vObj.getVehicleID());  // occupying the slot with the vehicle ID.
				
	   			register(vObj.getVehicleID(),notifyMethod); /*Registering*/

				/* Setting the entry time*/
				
				Time TimeObj = new Time();	
				TimeObj.setStartTime(StartHours, StartMinutes);	
				
				/* Tie the vehicle with the specific time and slot*/
				
				VehicleMap.put(vObj.getVehicleID(),TimeObj);                 
	    		slotMap.put(vObj.getVehicleID(),garage.getSlot(row, column));   		
	    		
	    		
	    		AvailableSlots--;

				}
			catch(Exceptions e){
					System.out.println(e.getMessage());
					vObj.decID();
				}
		}	
		
		else 
		{
			vObj.decID();       

		}
					
	}
	         
	/**
	 * The parkOut function sets the departure time to the vehicle.
	 * Then sets the occupied slot as empty.
	 * Then it calculates the fee of the vehicle.
	 * @param ID
	 * @param EndH   Departure time
	 * @param EndM
	 * @return The cost of the vehicle
	 * @throws Exceptions If the ID doesn't match a vehicle in the garage it throws an error message.
	 */
	public void parkOUT(Garage garage ,Vehicle vehicle, int EndH, int EndM) throws Exceptions
	{	
		
		Time Tobj = VehicleMap.get(vehicle.getVehicleID());
		double cost;
		if(Tobj==null)
		{
			throw new Exceptions("THIS ID DOESN'T EXIST");
		}
		
		else
		{
			if(Tobj.getStartHours()>EndH)     // Handles the time to calculate cost properly. 
		    	EndH +=24;
		    
			Tobj.setEndTime(EndH, EndM);
			
			/*Getting the cost by calling the calculate function from ticket*/

		    cost = payment.calculateCost(Tobj.getStartTime(),Tobj.getEndTime(),getSlotbyID(vehicle.getVehicleID()).getCost());  
		    
		    TotalIncome+=cost;
		    	    
		    System.out.println("The cost of this vehicle is: " + cost + " L.E. ");
		
			for(int i =0;i<garage.getGarageSlots().length;i++)  // Removing the vehicle from the slot.
	        {
	            for(int j =0;j<garage.getnumofRows(i);j++)
	            {
					
	                if (garage.getSlot(i, j).equals(slotMap.get(vehicle.getVehicleID())))  // if the slot matches the slot that the ID is assigned to remove the vehicle.
	                {
	                	garage.getSlot(i, j).removeSlot();
	                    slotMap.replace(vehicle.getVehicleID(), null);
	            		VehicleMap.replace(vehicle.getVehicleID(), null);
	            		notifyVehicle(vehicle,Tobj,cost);
	        			unregister(vehicle.getVehicleID(),observerMap.get(vehicle.getVehicleID()));
	                    AvailableSlots++;	
	                }

	            }
	        }
			
			
			
			
		}	    
	}
	
	/**
	 * 
	 * @param vehicleObj Checks if the vehicle has any fit slots.
	 * @return boolean.
	 */
	
    public boolean isAvailableSlots(Garage garage ,Vehicle vehicleObj) 
	    {    	
	    	boolean found = false;
	    	
	    	for(int i =0;i<garage.getGarageSlots().length;i++)
	        {
	            for(int j =0;j<garage.getnumofRows(i);j++)
	            {
					
	                if (vehicleObj.getLength()<= garage.getSlot(i, j).getLength() && vehicleObj.getWidth()<= garage.getSlot(i, j).getWidth() && garage.getSlot(i, j).isEmpty())
	                {
	                	found = true;
	                }

	            }
	    		System.out.println();

	        }
	    	
	    	return found;
	    }

		
	
	/*Getters*/
	public double getTotalIncome() {
		return TotalIncome;
	}

	public int GetNumOfVehicles()
	{
		return VehicleMap.size();
	}
	
    public void displaySlots(Garage garage)  // Prints all the slots.
    {
        garage.displaySlots();
    }
    
    public Slot getSlotbyID(int ID)  // Returns the slot that has the specific car ID.
    {
        return slotMap.get(ID);
    }
    
    public int getGarageSize()
    {
    	return GarageSize;
    }
    
    public int getAvailableSlots()
    {
    	return AvailableSlots;
    }
    
    
    public void displayAvailableSlots(Garage garage,Vehicle vehicleObj)
    
    {    	
    	boolean found = false;
    	
    	System.out.println("Slots Available for this Vehicle: ");
    	for(int i =0;i<garage.getGarageSlots().length;i++)
        {
            for(int j =0;j<garage.getnumofRows(i);j++)
            {
				
                if (vehicleObj.getLength()<= garage.getSlot(i, j).getLength() && vehicleObj.getWidth()<= garage.getSlot(i, j).getWidth() && garage.getSlot(i, j).isEmpty())
                {
                	System.out.print("< " + garage.getSlot(i, j).getOccupied() + " >" + "\t");			
                	found = true;
                }

            }
    		System.out.println();

        }
    	
    	if(found == false)
    	{
        	System.out.println("No slots Available for this vehicle ! ");			

    	}
    	
    }

	@Override
	public void register(int ID , Observer observer)
	{
		observerList.add(observer);
		observerMap.put(ID, observer);
	}

	@Override
	public void unregister(int ID , Observer observer) 
	{
		observerList.remove(observer);
		observerMap.remove(ID, observer);
	}

	@Override
	public void notifyVehicle(Vehicle vehicle,Time time ,double cost )
	{
		     
		for(int i = 0; i<observerList.size() ;i++)
		{	
			if(observerList.get(i).equals(observerMap.get(vehicle.getVehicleID())))
			{
				observerMap.get(vehicle.getVehicleID()).update(vehicle, time, cost);
			}
		}
        
		
	}


}