package com.amazon.buspassmanagement;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
		//user.password = "sia123";
		user.password = "john123";
		
		boolean result = authTest.loginUser(user);
		
		// Assertion -> Either Test Cases Passes or It will Fail :)
		Assert.assertEquals(true, result);
		Assert.assertEquals(2, user.type);
		
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

        String[] stops = {"Rameswaram","Manamadurai Jn","Vijayawada Jn","Balharshah",
                "Rani Kamalapati Habibganj","V Lakshmibai Jhansi Jhs","Delhi Safdarjng"};

        stop.adminID=BusPassSession.user.id;
        stop.routeID=13; //Manually giving routeID

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
		testVehicles.vehicleID = 3;
		testVehicles.adminID = BusPassSession.user.id;
		testVehicles.regNo = "Test007";
		testVehicles.type = 1;
		testVehicles.filledSeats = 10;
		testVehicles.totalSeats = 40;
		testVehicles.startPickUpTime = "8:00AM";
		testVehicles.startDropOffTime = "6:00PM";
		testVehicles.vehicleAvailability = 1;
		testVehicles.driverID = 13;
		testVehicles.routeID = 13;
		
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
		testBusPass.buspassID = 6;
		
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
}
