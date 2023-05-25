package defaultt;

public class vehicleBuilder implements IvehicleBuilder {
	
	private String modelName;
	private int modelYear;
	private double length;
	private double width;
	private String phoneNumber;
	private String email;

	@Override
	public void setmodelName(String modelName)
	{
		this.modelName = modelName;		
	}

	@Override
	public void setmodelYear(int modelYear)
	{
		this.modelYear = modelYear;		
	}

	@Override
	public void setphoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;		
	}

	@Override
	public void setEmail(String email)
	{
		this.email = email;		
	}

	@Override
	public void setLength(double length)
	{
		this.length = length;		
	}

	@Override
	public void setWidth(double width)
	{
		this.width = width;
	}
	
	public Vehicle getResult()
	{
		return new Vehicle(modelName , modelYear, length, width, phoneNumber,  email);
	}
	


}
