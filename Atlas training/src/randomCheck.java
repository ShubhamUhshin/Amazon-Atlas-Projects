import java.util.Random;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public class randomCheck {
	public static void main(String[] args) {
    int min = -100;
    int max = 100;

    Random random = new Random();
    int randomNumber;
    for (int i = 0; i<10; i++) {
    	randomNumber = random.nextInt(max - min + 1) + min;

    	System.out.println(((max - min + 1)+min));
    	System.out.println("Random number between " + min + " and " + max + " is: " + randomNumber);
    }
  }
}
	
	
/*
    public static void main(String[] args) {
        // Create a ScheduledExecutorService with one thread
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        // Schedule the task to run every 5 seconds
        scheduler.scheduleAtFixedRate(new Runnable() {
            public void run() {
                // Call your function here
                myFunction();
            }
        }, 0, 5, TimeUnit.SECONDS);
    }

    public static void myFunction() {
        // Your function code goes here
        System.out.println("Function executed in a separate thread.");
    }
}
*/