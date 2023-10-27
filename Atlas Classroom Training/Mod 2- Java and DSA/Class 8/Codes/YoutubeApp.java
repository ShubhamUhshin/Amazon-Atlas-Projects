package com.amazon.atlas.casestudy;

interface Notification{
	
}

// Reference Variable of Notification can refer to the Object of User :)
class User implements Notification{
	
}

class YoutubeChannel{
	
	
	void subscribe(Notification notification) { 
		
	}
	
	void uploadVideo(String videoName) {
		
	}
	
}

public class YoutubeApp {

	public static void main(String[] args) {
		

		YoutubeChannel channel = new YoutubeChannel();
		User user = new User();
		
		channel.subscribe(user);
		
	}

}
