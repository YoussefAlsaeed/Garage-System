package defaultt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class BestFitSelection  implements IslotSelection
{

	@Override
	/**
	 *this function return list of objects, it takes length and width of a vehicle and a 2d array of class slots 
	 *
	 */
	public List<Object> selectSlot(double length,double width,Slot[][] slotList)
	{		
		boolean selected = false;
		int row=0,column=0;
		double Size = 0 ;
		List<List> numbers = new ArrayList<>();  //a list of list that stores the index of the candidates slots and their size.
		for(int i =0;i<slotList.length;i++)
    	{
    		for(int j =0;j<slotList[i].length;j++) {		
    			if (length <=slotList[i][j].getLength() && width<=slotList[i][j].getWidth()&& slotList[i][j].isEmpty())
    			{
    				selected = true;
    				row = i;
    				column = j;
    				Size =slotList[i][j].getLength()*slotList[i][j].getWidth();
    	    		numbers.add(Arrays.asList(row,column,Size)); // adding the index and the size of candidate slots to the list of list.
    			}
    		}
    	}		
		double bestFitSize = (double) numbers.get(0).get(2); // storing the size of the first list as a best fit size.
		row = (int) numbers.get(0).get(0);
		column = (int) numbers.get(0).get(1);
		
		for(int j = 1; j<numbers.size(); j++) //loops on the list 
		{
			if(j < numbers.size() && bestFitSize > (double) numbers.get(j).get(2) )// check for the smallest size in the list.
			{
				bestFitSize = (double) numbers.get(j).get(2);
				row = (int) numbers.get(j).get(0);
				column = (int) numbers.get(j).get(1);
			}
		}
		return Arrays.asList(selected,row,column);
	}
}