package defaultt;

import java.util.ArrayList;

public interface Subject {
	
	public void register(int ID,Observer observer);
	public void unregister(int ID,Observer observer);
	public void notifyVehicle(Vehicle vehicle , Time time,double cost);

}
