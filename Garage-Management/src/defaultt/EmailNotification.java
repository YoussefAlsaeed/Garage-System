package defaultt;

public class EmailNotification implements Observer{

	@Override
	public void update(Vehicle vehicle, Time time, double cost)
	{
		System.out.println("******************************"); 
		System.out.println("|    Sent through email....  |");
		System.out.println("******************************") ;
		System.out.println("Hello " + vehicle.getEmail() + ", " +"The cost of your stay is: " +cost + " L.E. ");
		System.out.println("Entry time : " + time.getStartHours() +":" +time.getStartMinutes());
		System.out.println("Departure time : " + time.getEndHours() +":" +time.getEndMinutes());

	}

}
