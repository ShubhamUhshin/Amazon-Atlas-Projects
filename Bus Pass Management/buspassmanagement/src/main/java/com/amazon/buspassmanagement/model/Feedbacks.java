package com.amazon.buspassmanagement.model;

/*
create table Feedbacks(
	feedbackID INT IDENTITY(1,1),
	userID INT constraint feedbacks_id_fk references Users(id),
	raisedBy NVARCHAR(256),
	type INT,
	title NVARCHAR(256),
	description NVARCHAR(2048),
	createdOn DATETIME DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(feedbackID));
*/

public class Feedbacks {
		
		public int feedbackID;
		public int userID;	// user id for the user who raised the feedback
		public String raisedBy; // email
		public int type;
		public String title;
		public String description;
		public String createdOn;
		
		public Feedbacks() {
		}

		public Feedbacks(int feedbackID, int userID, String raisedBy, int type, String title, String description,
				String createdOn) {
			this.feedbackID = feedbackID;
			this.userID = userID;
			this.raisedBy = raisedBy;
			this.type = type;
			this.title = title;
			this.description = description;
			this.createdOn = createdOn;
		}
		
	public void prettyPrint() {
			System.out.println("~~~~~~~~~~~~~~~~~Feedback~~~~~~~~~~~~~~~~~~");
			System.out.println("FeedbackID:\t"+feedbackID);
			System.out.println("UserID:\t\t"+userID);
			System.out.println("Raised By:\t"+raisedBy);
			System.out.println("Type:\t\t"+type);
			System.out.println("Title:\t\t"+title);
			System.out.println("Description:\t"+description);
			System.out.println("Created On:\t"+createdOn);
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
		
		@Override
		public String toString() {
			return "Feedbacks [feedbackID=" + feedbackID + ", userID=" + userID + ", raisedBy=" + raisedBy + ", type=" + type
					+ ", title=" + title + ", description=" + description + ", createdOn=" + createdOn + "]";
	}
		
}

