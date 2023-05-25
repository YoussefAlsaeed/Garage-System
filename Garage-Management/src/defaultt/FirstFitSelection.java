package defaultt;

import java.util.Arrays;
import java.util.List;

public class FirstFitSelection implements IslotSelection {
	
	/**
	 *this function return list of objects, it takes length and width of a vehicle and a 2d array of class slots 
	 *
	 */
	@Override
	public List<Object> selectSlot(double length,double width,Slot[][] slotList) 
	{
		boolean selected = false;
		int row=0,column=0;
	
		for(int i =0;i<slotList.length;i++)  // looping on the 2D array.
    	{
    		for(int j =0;j<slotList[i].length;j++) {
    			
    			if (length<= slotList[i][j].getLength() && width<= slotList[i][j].getWidth() && slotList[i][j].isEmpty())
    			{
    				selected = true;
    				row = i;
    				column = j;
    				return Arrays.asList(selected,row,column); // Returns the first spot that matches the vehicle dimensions.
    			}
    			
    		}

    	}
		return Arrays.asList(selected);

	
	}
	
	
}
