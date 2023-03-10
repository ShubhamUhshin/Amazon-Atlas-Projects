package com.amazon.buspassmanagement;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.amazon.buspassmanagement.controller.AuthenticationService;
import com.amazon.buspassmanagement.controller.BusPassManagement;
import com.amazon.buspassmanagement.controller.FeedbacksManagement;
import com.amazon.buspassmanagement.controller.RoutesManagement;
import com.amazon.buspassmanagement.controller.StopsManagement;
import com.amazon.buspassmanagement.controller.VehicleManagement;
import com.amazon.buspassmanagement.db.BusPassDAO;
import com.amazon.buspassmanagement.db.FeedbacksDAO;
import com.amazon.buspassmanagement.db.RoutesDAO;
import com.amazon.buspassmanagement.db.StopsDAO;
import com.amazon.buspassmanagement.db.UserDAO;
import com.amazon.buspassmanagement.db.VehiclesDAO;
import com.amazon.buspassmanagement.model.User;
import com.amazon.buspassmanagement.model.Vehicles;
import com.amazon.buspassmanagement.model.BusPass;
import com.amazon.buspassmanagement.model.Feedbacks;
import com.amazon.buspassmanagement.model.Routes;
import com.amazon.buspassmanagement.model.Stops;

// Reference Link to Use JUnit as Testing Tool in your Project
// https://maven.apache.org/surefire/maven-surefire-plugin/examples/junit.html

public class AppTest {
    
	AuthenticationService authTest = AuthenticationService.getInstance(); 
	RoutesManagement routesTest = RoutesManagement.getInstance();
	StopsManagement stopsTest = StopsManagement.getInstance();
	VehicleManagement vehiclesTest = VehicleManagement.getInstance();
	BusPassManagement busPassTest = BusPassManagement.getInstance();
	FeedbacksManagement feedbacksTest = FeedbacksManagement.getInstance();
	Routes routeTest = new Routes();
	StopsDAO stopdaoTest = new StopsDAO();
	RoutesDAO routedaoTest = new RoutesDAO();
	BusPassDAO buspassdaoTest = new BusPassDAO();
	VehiclesDAO vehicledaoTest = new VehiclesDAO();
	FeedbacksDAO feedbackdaoTest = new FeedbacksDAO();
	// UNIT TESTS

	@Test
	public void testAdminLogin() {
		
		User user = new User();
		user.email = "srvshu@amazon.com";
		user.password = "srvshu123";
		
		boolean result = authTest.loginUser(user);
		
		// Assertion -> Either Test Cases Passes or It will Fail :)
		Assert.assertEquals(true, result);
		Assert.assertEquals(1, user.type); // 1 should be equal to 1
		
	}
	
	@Test
	public void testUserLogin() {
		
		User user = new User();
		user.email = "john@example.com";
		user.password = "john123";
		
		boolean result = authTest.loginUser(user);
		
		// Assertion -> Either Test Cases Passes or It will Fail :)
		Assert.assertEquals(true, result);
		Assert.assertEquals(2, user.type);
		
	}
	@Test
	public void testUserRegister() {
		
	User user = new User();
	// Hardcoding User details to test register function
	user.name = "TestUser1";
	user.type = 2;
	user.phone = "11111 11111";
	user.address = "test Address";
	user.email = "testUser1@example.com";
	user.password = "testUser1123";
	user.department = "Test";
	UserDAO userdao = new UserDAO();
	int result = userdao.insert(user);
	
	// Assertion -> Either Test Cases Passes or It will Fail :)
	Assert.assertTrue(result>0);

	}
	@Test
    public void testAddRoute() {

        User user = new User();

        user.email = "srvshu@amazon.com";
        user.password = "srvshu123";

        authTest.loginUser(user);

        BusPassSession.user = user;
        
        routeTest.title = "Test Route";
        routeTest.description = "Route for Testing";
        routeTest.adminID = BusPassSession.user.id;

        int result = routedaoTest.insert(routeTest);

        Assert.assertTrue(result>0);
    }
	
	@Test
    public void testAddStop() {

        int result=0;
        int sequenceOrder=0;
        int idx =0;

        User user = new User();
        Stops stop = new Stops();

        user.email = "srvshu@amazon.com";
        user.password = "srvshu123";

        authTest.loginUser(user);

        BusPassSession.user = user;

        String[] stops = {"Rameswaram","Manamadurai Jn"};

        stop.adminID=BusPassSession.user.id;
        stop.routeID = 1; //Manually giving routeID

        while(idx<stops.length) {
            stop.address = stops[idx];
            idx++;
            stop.sequenceOrder=++sequenceOrder;
            result = stopdaoTest.insert(stop);
            if(result==0)
                break;
        }

        Assert.assertTrue(result>0);
    }
	
	@Test
	public void testUpdateVehicle() {
		
		Vehicles testVehicles = new Vehicles();
		
		User user = new User();
		user.email = "srvshu@amazon.com";
		user.password = "srvshu123";
		
		authTest.loginUser(user);
		BusPassSession.user = user;
		testVehicles.vehicleID = 1;
		testVehicles.adminID = BusPassSession.user.id;
		testVehicles.regNo = "Test007";
		testVehicles.type = 1;
		testVehicles.filledSeats = 10;
		testVehicles.totalSeats = 40;
		testVehicles.startPickUpTime = "8:00AM";
		testVehicles.startDropOffTime = "6:00PM";
		testVehicles.vehicleAvailability = 1;
		testVehicles.driverID = 2;
		testVehicles.routeID = 1;
		
		int result = vehicledaoTest.update(testVehicles);
		//Assert.assertEquals(true,result);
		Assert.assertTrue(result>0);
		
	}
	
	@Test
	public void testApproveRejectPass() {
		
		User user = new User();
		user.email = "srvshu@amazon.com";
		user.password = "srvshu123";
		
		BusPassSession.user = user;
		
		BusPass testBusPass = new BusPass();
		testBusPass.buspassID = 1;
		
		testBusPass.status = 2;
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Calendar calendar = Calendar.getInstance();
        Date date1 = calendar.getTime();
        testBusPass.approvedRejectedOn = dateFormat.format(date1);
        calendar.add(Calendar.YEAR, 1);
        Date date2 = calendar.getTime();
        testBusPass.validTill = dateFormat.format(date2);
        
        int result = buspassdaoTest.update(testBusPass);
		//Assert.assertEquals(true,result);
		Assert.assertTrue(result>0);
        
	}

	@Test
	public void testAddFeedback() {
		User user = new User();
		user.email = "john@example.com";
		user.password = "john123";
		authTest.loginUser(user);
		BusPassSession.user = user;
		
		Feedbacks testFeedback = new Feedbacks();
		
		testFeedback.type = 1;
		testFeedback.title = "Test Suggestion";
		testFeedback.description = "This is to check if feedback is working properly";
		testFeedback.raisedBy = BusPassSession.user.email;
		testFeedback.userID = BusPassSession.user.id;
		boolean result = (feedbackdaoTest.insert(testFeedback)>0);
		Assert.assertEquals(true,result);
	}
	@Test
	// Check pass validity
	public void  testPassValidity() {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date date1 = calendar.getTime();
	    String sql = "SELECT * from BusPass where validTill > '"+dateFormat.format(date1)+"' and buspassID ="+1;
	    List<BusPass> busPass = buspassdaoTest.retrieve(sql);
	    boolean result = true;
		if (busPass.isEmpty())
			result = false;
		
		Assert.assertEquals(true,result);
	}
	
	@Test
	// Check vehicle on a particular route
	public void testCheckVehicle() {
		
		String sql = "SELECT * from Vehicles where routeId= "+1;
		List<Vehicles> vehicle = vehicledaoTest.retrieve(sql);
		boolean result = true;
		if (vehicle.isEmpty())
			result = false;
		
		Assert.assertEquals(true,result);
			
		
	}
	@Test
	// Check Test Stop
	public void testStop() {
		
		String sql = "SELECT * from Stops where routeID = "+1;
		List<Stops> stop = stopdaoTest.retrieve(sql);
		boolean result = true;
		if (stop.isEmpty())
			result = false;
	
		Assert.assertEquals(true,result);
	}
	
	@Test
	// Check if a route has 2 stops 
	public void testNoOfStops() {
		
		String sql = "SELECT * from Stops where routeID = "+1;
		List<Stops> stop = stopdaoTest.retrieve(sql);
		boolean result = false;
		if (stop.size()>1)
			result = true;
	
		Assert.assertEquals(true,result);
	}
	
	@Test
	// Check if a user can raise a complaint
	public void raiseComplaint() {
		
		Feedbacks feedback = new Feedbacks();
		feedback.type = 2;
		feedback.description = "This is Feedbacks Testing";
		feedback.title = "Complaint";
		feedback.userID = 2;
		feedback.raisedBy = "fionna@example.com";
		int result = feedbackdaoTest.insert(feedback);
		Assert.assertTrue(result>0);
	
	}
}
