package defaultt;

public class Vehicle {
	private String modelName;
	private int modelYear;
	private static int incrementVehicleID =0 ;  /*Static integer to auto increment the ID and make it unique*/
	private int VehicleID;                      /*Stores the Unique ID of each vehicle */
	private double length;
	private double width;
	private String phoneNumber;
	private String email;

    
	public Vehicle() {
		this.modelName = "";
		this.modelYear = 0;
		VehicleID = 0;
		this.phoneNumber ="";
		this.email ="";


	}

	/*Constructor sets Vehicle name and model year and unique ID*/
	Vehicle(String modelName ,int modelYear,double length,double width,String phoneNumber, String email)
    {
    	this.modelName = modelName;
    	this.modelYear = modelYear;
    	this.length = length;
    	this.width = width;
    	this.incrementVehicleID++;
    	this.VehicleID = incrementVehicleID;
		this.phoneNumber =phoneNumber;
		this.email =email;
    	
    }
	
	/**
	 * Setters and getters.
	 */
	
	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getModelYear() {
		return modelYear;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}

    public int getVehicleID () {
    	return VehicleID;
    }
	public void decID(){
		this.incrementVehicleID--;
		this.VehicleID--;
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
	
	public void getDimensions()
	{
		System.out.println(length +" x "+ width);
	}
	
	

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Vehicle [modelName=" + modelName + ", modelYear=" + modelYear + ", VehicleID=" + VehicleID + ", length="
				+ length + ", width=" + width + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}
	
	
   
}
