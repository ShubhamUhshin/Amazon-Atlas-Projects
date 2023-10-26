public class LinearQueue 
{
	Node front;
	Node end;
	static int spot=0;
	Node Queue;
	
	public void addVehicle(String data)
	{
		spot++;
		
		Node node = new Node();
		node.Number = data;
		if (front == null)
		{
				front = node;
				end = node;
				System.out.println("Welcome");
				System.out.println("Vehicle Number "+node.Number+" entered the parking at spot "+spot);
		}
		
		else
		{
			Node temp = front;
			while (temp.nextNode != null)
			{
				temp = temp.nextNode;
			}
			temp.nextNode = node;
			end = node;
			
			System.out.println("Welcome");
			System.out.println("Vehicle Number "+node.Number+" entered the parking at spot "+spot);
		}
	}
	
	public void vehicleLeave()
	{
		
		if (front != null)
		{
			System.out.println("Rs 100 Parking Charge");
			System.out.println("----------------------");
			System.out.println("Recieved");
			System.out.println("Vehicle number: "+front.Number+" left");
			front = front.nextNode;
			System.out.println("---------------------------------------");
			spot--;
		}
		else
			System.out.println("No vehicles");
	}

	void display()
	{
		if (front != null)
		{
			Node temp = front;
			System.out.println("--------------------------------------------------");
			System.out.println("The list of vehicles in the parking currently are:");
			while (temp.nextNode!=null)
			{
				System.out.println(temp.Number);
				temp = temp.nextNode;
			}
			System.out.println(temp.Number);
			System.out.println("Then number of vehicles in the parking area currently are: "+spot);
			System.out.println("Thank you");
			System.out.println("------------------------------------------------------------------");
		}
		else
			System.out.println("Parking is empty");
	}
}