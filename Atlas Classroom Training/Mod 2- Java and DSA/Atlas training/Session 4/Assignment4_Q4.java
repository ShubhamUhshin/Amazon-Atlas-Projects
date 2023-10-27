public class Assignment4_Q4 
{
	public static void main(String args[])
	{
		LinearQueue queue = new LinearQueue();
		
		queue.display();
		
		queue.addVehicle("JH05A8197");
		queue.addVehicle("WB02A1525");
		queue.addVehicle("OD09A6117");
		
		queue.display();
		
		queue.vehicleLeave();
		
		queue.display();
		
	}

}
