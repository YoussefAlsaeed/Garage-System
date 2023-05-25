package defaultt;

public class Time {
	
	private int StartHours;
	private int StartMinutes;
	private int StartTime;
	private int EndTime;
	private int EndHours;
	private int EndMinutes;
	
	Time ()
	{
		this.StartHours = 0;
		this.StartMinutes = 0;
		this.EndHours = 0;
		this.EndMinutes = 0;
	}
	
	/*Setters and getters*/
	                                                                             	                                                                                        		 
	public void setStartTime(int StartHours,int StartMinutes)                              
	{
		this.StartHours = StartHours;
		this.StartMinutes = StartMinutes;	
		this.StartTime = (StartHours * 60) +StartMinutes;  // Calculates the Start hours and minutes as minutes.
	}
	
	public int getStartTime()
	{
		return StartTime;
	}
	
	public void setEndTime(int EndHours,int EndMinutes)
	{
		this.EndHours = EndHours;
		this.EndMinutes = EndMinutes;
		this.EndTime = (EndHours*60) + EndMinutes;  // Calculates the Start hours and minutes as minutes.
	}	
	
	public int getEndTime()
	{
		return EndTime;
	}
	
	public int getStartHours() {
		return StartHours;
	}
	public void setStartHours(int startHours) {
		StartHours = startHours;
	}

	public int getEndHours() {
		return EndHours;
	}
	public void setEndHours(int EndHours) {
		this.EndHours = EndHours;
	}

	public int getStartMinutes() {
		return StartMinutes;
	}

	public void setStartMinutes(int startMinutes) {
		StartMinutes = startMinutes;
	}

	public int getEndMinutes() {
		return EndMinutes;
	}

	public void setEndMinutes(int endMinutes) {
		EndMinutes = endMinutes;
	}
	
	

}
