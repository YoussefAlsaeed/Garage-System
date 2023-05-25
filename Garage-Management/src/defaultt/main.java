package defaultt;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Youssef Alsaeed  ID: 20206093
 * @author Youssef Essmat   ID: 20206096
 * 
 * The purpose of this application is to act as a Parking Garage system that manages fees and vehicles and the slots.
 *
 **/

public class main {

	public static void main(String[] args) throws IOException 
	{						
				
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));   // Reader to read string array.
		
	    String[] inTime = new String[2];  /* The time of arriving*/
	    
	    int StartHours;
	    int StartMinutes;
	    
	    String[] outTime = new String[2]; /* The time of departure*/
	    
	    int EndHours;
	    int EndMinutes;
		
		int choice, selectChoice,notifyChoice;
		
		Scanner input = new Scanner(System.in);
		
		
		/**
		 * Reading the size of Garage Slots from the user and setting them.
		 * They are set using the constructor of the ParkingLot 
         */
		
		IGarageBuilder builtGarage = new randomizedGarage();

		
		System.out.print("Enter the number of rows: ") ;                                       	
		int garageRows = input.nextInt();
		builtGarage.setrowSize(garageRows);
		System.out.println();
		
		System.out.print("Enter the number of columns: ") ;
		int garageColumns = input.nextInt();
		builtGarage.setcolumnSize(garageColumns);
		System.out.println();

		
		System.out.print("Enter the Hourly Rate for this Garage: ") ;
		int HourlyRate = input.nextInt();
		builtGarage.sethourlyRate(HourlyRate);
		System.out.println();

		
		System.out.print("Enter the minimum slot size for this Garage: ") ;
		int min = input.nextInt();
		builtGarage.setminSlotSize(min);
		System.out.println();

		
		System.out.print("Enter the maximum slot size for this Garage: ") ;
		int max = input.nextInt();
		builtGarage.setmaxSlotSize(max);
		System.out.println();
		
		builtGarage.build();
		
		Garage garage = builtGarage.getResult();
		

		ParkingLot GarageCTR = new ParkingLot(garageRows*garageColumns);
		
		System.out.println();
		System.out.println("Garage Size is: " + garageRows*garageColumns) ;
		System.out.println();
		
		
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
				
		/* The do while loop views the menu for the user. */
		 

    do
    {
		System.out.println("1- Add a Vehicle: ") ;
		System.out.println("2- Remove a Vehicle and View fees: ");
		System.out.println("3- View total income: ");
		System.out.println("4- View total number of cars that have used the Parking lot: ");
		System.out.println("5- Display Available Slots: " );
		System.out.println("6- Exit" );
    	System.out.println();
    	System.out.println("`*`*`*`*`*`*`*`*`*`*`*`*`*`*`*`*`*`*`*`*`*`*`*");
    	System.out.println("Choice: ");
    	
        choice = input.nextInt();   /*Reading the user's choice*/
        System.out.println();
        
        
        switch (choice)
        {
            case 1:
            	/**
            	 * In Option 1 the user inputs the vehicle's name and model year,
            	 * then inputs The Entry time of the vehicle. 
            	 * 
            	 * The user then specifies the row and column to park the vehicle in.
            	 */
            	System.out.print("Enter your phone number: ");
            	String phoneNumber = input.next();
            	System.out.println();
            	
            	System.out.print("Enter your email: ");
            	String email = input.next();
            	System.out.println();
            	
            	System.out.print("Enter the Model Name: ");
            	String vehicleName = input.next();
            	System.out.println();
            	
            	System.out.print("Enter the Model Year: ");
            	int vehicleYear = input.nextInt();
            	System.out.println();
            	
            	System.out.print("Enter the Vehicle's length: ");
            	double vehicleLength = input.nextDouble();
            	System.out.println();
            	
            	System.out.print("Enter the Vehicle's width: ");
            	double vehicleWidth = input.nextDouble();
            	System.out.println();
            	
            	vehicleBuilder vehicleBuilder = new vehicleBuilder();

            	
            	vehicleBuilder.setmodelName(vehicleName);
            	vehicleBuilder.setmodelYear(vehicleYear);
            	vehicleBuilder.setLength(vehicleLength);
            	vehicleBuilder.setWidth(vehicleWidth);
            	vehicleBuilder.setphoneNumber(phoneNumber);
            	vehicleBuilder.setEmail(email);
            	          	
            	  	
            	Vehicle VehicleObj = vehicleBuilder.getResult();
            	vehicles.add(VehicleObj);

            	
            	System.out.print("Enter the entry time in 24 hour format (HH:MM) : ");
            	
            	inTime = in.readLine().split(":");       // Allows user to input time as HH:mm format.
            	StartHours = Integer.parseInt(inTime[0]);
            	StartMinutes = Integer.parseInt(inTime[1]);
            	

            	/**
            	 * The parkIN function in ParkingLot class is called.
            	 * It takes an object of Vehicle, Entry time, row and column as parameters.  
            	 */
            	
            	if (GarageCTR.isAvailableSlots(garage,VehicleObj)) // If the vehicle has any slots available for its dimensions.
            	{
                	GarageCTR.displayAvailableSlots(garage,VehicleObj);
                	System.out.print("Enter '1' for best fit / '2' for first fit: ");
                	selectChoice = input.nextInt();
                	System.out.println();
                	
                	System.out.print("Enter '1' for sms / '2' for Email : ");
                	notifyChoice = input.nextInt();
                	System.out.println();
                	
                	IslotSelection FirstFit = new FirstFitSelection(); // Coding to an interface.
                	IslotSelection BestFit = new BestFitSelection();
                	
                	
                	
                	if (selectChoice == 1)
                	{
                		GarageCTR.setSelection(BestFit);
                	}
                	else if (selectChoice == 2)
                	{
                		GarageCTR.setSelection(FirstFit);
                	}
                	
                	if (notifyChoice == 1)
                	{
                		SmsNotification notify = new SmsNotification();
                		GarageCTR.parkIN(VehicleObj,garage,StartHours,StartMinutes,notify);

                	}
                	else if(notifyChoice ==2)
                	{
                		EmailNotification notify = new EmailNotification();
                		GarageCTR.parkIN(VehicleObj,garage,StartHours,StartMinutes,notify);

                	}
                	
     	  	
                	System.out.println("The remaining slots are: " + GarageCTR.getAvailableSlots());  /*Displaying the number of the remaining slots */
                	System.out.println();

            	}	
            	else
            	{
            		System.out.println("No slots Available for this vehicle! ");
            		System.out.println();
            		System.out.println();
            		VehicleObj.decID();

            	}
            	
                break;
                
                
            case 2:
            	/**
            	 * In Option 2 the user inputs the unique ID of the car that will leave the garage.
            	 * 
            	 */
            	System.out.print("Enter the ID of the vehicle you will remove: ");
                int ID = input.nextInt();
            	System.out.println();
            	

				/**
				 * @Exception If the ID doesn't match a vehicle in the garage it catches an error message.
				 */
            	
            	try {
            	while (ID > vehicles.size())
            	{
            		throw new Exceptions("ID doesn't exist !");
                	
            	}
            	}catch(Exceptions e)
            	{
            		System.out.println();
            		System.out.println(e.getMessage());
            		System.out.println();
            		break;
            	}

            	System.out.print("Enter the departure time in 24 hour format (HH:MM) : ");
            	
            	outTime = in.readLine().split(":");          // Allows user to input time as HH:MM format.
            	EndHours = Integer.parseInt(outTime[0]);
            	EndMinutes = Integer.parseInt(outTime[1]);
            	
            	Ipayment payment= new calculatebyDimensions();         	
				
				/**
				 * @Exception If the ID doesn't match a vehicle in the garage it catches an error message.
				 */
            	
            	Vehicle vehicle = vehicles.get(ID -1);

            	
            	try{
            		GarageCTR.setPayment(payment);
					GarageCTR.parkOUT(garage, vehicle , EndHours, EndMinutes);  // Calculating the vehicle's cost

				}
				catch(Exceptions e){
					System.out.println(e.getMessage());
		

				}
            	System.out.println("The remaining slots are: " + GarageCTR.getAvailableSlots());  // Displaying Remaining Slots.
            	System.out.println();
            	
                break;

            case 3:
            	System.out.println("The total income is : " + GarageCTR.getTotalIncome() + " L.E."); // Displaying the garage's total income.
            	System.out.println();

                break;

            case 4:
            	System.out.println("Total number of cars: " + GarageCTR.GetNumOfVehicles()); // Displaying the total number of vehicles.
            	System.out.println();

                break;
                
            case 5:
            	GarageCTR.displaySlots(garage);  // Views the slots.
            	
                break;

        }
    } while (choice != 6);
		
	}
	
}
