package com.amazon.buspassmanagement;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import com.amazon.buspassmanagementDebug.controller.AuthenticationService;
import com.amazon.buspassmanagementDebug.db.BusPassDAO;
import com.amazon.buspassmanagementDebug.db.FeedbackDAO;
import com.amazon.buspassmanagementDebug.db.StopDAO;
import com.amazon.buspassmanagementDebug.db.VehicleDAO;
import com.amazon.buspassmanagementDebug.model.BusPass;
import com.amazon.buspassmanagementDebug.model.Feedback;
import com.amazon.buspassmanagementDebug.model.Stop;
import com.amazon.buspassmanagementDebug.model.User;
import com.amazon.buspassmanagementDebug.model.Vehicle;

// Reference Link to Use JUnit as Testing Tool in your Project
// https://maven.apache.org/surefire/maven-surefire-plugin/examples/junit.html

public class AppTest {
    
	AuthenticationService authService = AuthenticationService.getInstance();
	VehicleDAO vehicleDAO = new VehicleDAO();
	BusPassDAO busPassDAO = new BusPassDAO();
	StopDAO stopDAO = new StopDAO();
	FeedbackDAO feedbackdao = new FeedbackDAO();
	
	// UNIT TESTS
	
	
	@Test
	public void testUserLogin() {
		
		User user = new User();
		user.email = "fionna@example.com";
		//user.password = "sia123";
		user.password = "fionna123";
		
		boolean result = authService.loginUser(user);
		
		// Assertion -> Either Test Cases Passes or It will Fail :)
		Assert.assertEquals(true, result);
		
	}
	
	@Test
	public void testAdminLogin() {
		
		User user = new User();
		user.email = "shubham@example.com";
		user.password = "admin123";
		
		boolean result = authService.loginUser(user);
		
		// Assertion -> Either Test Cases Passes or It will Fail :)
		Assert.assertEquals(true, result);
		Assert.assertEquals(1, user.type); // 1 should be equal to 1
		
	}
	
	@Test
	// Check pass validity
	public void  testPassValidity() {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date date1 = calendar.getTime();
	    String sql = "SELECT * from BusPass where validTill > '"+dateFormat.format(date1)+"' and id ="+7;
	    List<BusPass> busPass = busPassDAO.retrieve(sql);
	    boolean result = true;
		if (busPass.isEmpty())
			result = false;
		
		Assert.assertEquals(true,result);
	}
	
	@Test
	// Check vehicle on a particular route
	public void testCheckVehicle() {
		
		String sql = "SELECT * from Vehicle where routeId= "+3;
		List<Vehicle> vehicle = vehicleDAO.retrieve(sql);
		boolean result = true;
		if (vehicle.isEmpty())
			result = false;
		
		Assert.assertEquals(true,result);
			
		
	}
	@Test
	// Check Test Stop
	public void testStop() {
		
		String sql = "SELECT * from Stop where routeId= "+3;
		List<Stop> stop = stopDAO.retrieve(sql);
		boolean result = true;
		if (stop.isEmpty())
			result = false;
	
		Assert.assertEquals(true,result);
	}
	
	@Test
	// Check if a route has 2 stops 
	public void testNoOfStops() {
		
		String sql = "SELECT * from Stop where routeId= "+3;
		List<Stop> stop = stopDAO.retrieve(sql);
		boolean result = false;
		if (stop.size()>1)
			result = true;
	
		Assert.assertEquals(true,result);
	}
	
	@Test
	// Check if a user can raise a complaint
	public void raiseComplaint() {
		
		Feedback feedback = new Feedback();
		feedback.type = 2;
		feedback.description = "This is Feedback Testing";
		feedback.title = "Complaint";
		feedback.userId = 4;
		feedback.raisedBy = "fionna@example.com";
		int result = feedbackdao.insert(feedback);
		Assert.assertTrue(result>0);
	
	}
}
