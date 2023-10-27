package com.amazon.atlas22.behavioral;

import java.util.Scanner;

class Candidate{
	
	String name;
	int experience;
	String competencies;

	public Candidate(String name, int experience, String competencies) {
		this.name = name;
		this.experience = experience;
		this.competencies = competencies;
	}

	@Override
	public String toString() {
		return "Candidate [name=" + name + ", experience=" + experience + ", competencies=" + competencies + "]";
	}
	
}

// Base Interface
interface JobInterviewChain{
	// Who is going to process the request in the next step
	void setNextChain(JobInterviewChain nextChain);
	// Processing the Request
	void interview(Candidate candidate);
}


class ShortlistCandidate implements JobInterviewChain{
	
	JobInterviewChain nextChain;
	
	public void setNextChain(JobInterviewChain nextChain) {
		this.nextChain = nextChain;
	}
	
	public void interview(Candidate candidate) {
		System.out.println("[ShortlistCandidate] Started");
		if(candidate.experience >=3) {
			if(candidate.competencies.contains("Java") && candidate.competencies.contains("MySQL")) {
				// Here Candidate is ShortListed
				System.out.println("Dear "+candidate.name+" You are Shortlisted for Next Round");
				nextChain.interview(candidate);
			}else {
				System.out.println("Sorry !! You are Not Shortlisted as your competencies do not match");
			}
		}else {
			System.out.println("Sorry !! You are less experienced for the Job");
		}
	}
}

class WrittenTest implements JobInterviewChain{
	
	JobInterviewChain nextChain;
	
	public void setNextChain(JobInterviewChain nextChain) {
		this.nextChain = nextChain;
	}
	
	public void interview(Candidate candidate) {
		System.out.println("[WrittenTest] Started");

		String[] competencies = candidate.competencies.split(",");
		int score = competencies.length;
		if(score >=5 ) {
			nextChain.interview(candidate);
		}else {
			System.out.println("Sorry !! Your Written Test is not clear. Good Luck.");
		}
	}
}

class TechnicalInterview implements JobInterviewChain{
	
	JobInterviewChain nextChain;
	
	public void setNextChain(JobInterviewChain nextChain) {
		this.nextChain = nextChain;
	}
	
	public void interview(Candidate candidate) {
		System.out.println("[TechnicalInterview] Started");
		System.out.println("Welcome to Technical Interview "+candidate.name);
		Scanner scanner = new Scanner(System.in);
		System.out.println("What is transient keyword in Java ?");
		String answer = scanner.nextLine().toLowerCase();
		scanner.close();
		
		String[] keywords = {"not","saved","serialized"};
		
		boolean result = answer.contains(keywords[0]) && answer.contains(keywords[1]) && answer.contains(keywords[2]);
		
		if(result) {
			System.out.println("Dear "+candidate.name+" you are Hired. Welcome to James Tech...");
		}else {
			System.out.println("Sorry !! Your Technical Interview is not clear. Good Luck.");
		}
	}
}

public class ChainOfResponsibility {

	public static void main(String[] args) {
		
		JobInterviewChain round1 = new ShortlistCandidate();
		JobInterviewChain round2 = new WrittenTest();
		JobInterviewChain round3 = new TechnicalInterview();
		
		round1.setNextChain(round2);
		round2.setNextChain(round3);
		
		
		Candidate candidate = new Candidate("John Watson", 5, "Java, DSA, MySQL, MongoDB, AWS");
		round1.interview(candidate);

	}

}
