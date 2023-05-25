package defaultt;

public interface IGarageBuilder {
	
	public void reset();
		
	public void setLength(double length);
	
	public void setWidth(double width);
	
	public void setminSlotSize(double minSlotSize);
	
	public void setmaxSlotSize(double maxSlotSize);
	
	public void setrowSize(int rows);
	
	public void setcolumnSize(int columns);
	
	public void build();
	
	public Garage getResult();
	
	public void sethourlyRate(double hourlyRate);
	
	}


