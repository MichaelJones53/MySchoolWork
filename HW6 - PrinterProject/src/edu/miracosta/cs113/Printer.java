package edu.miracosta.cs113;

import java.util.LinkedList;
import java.util.Queue;

public class Printer {
	private static int time = 0;
	private String name;
	private int mininumPages;
	private int maximumPages;
	private boolean isPrinting = false;
	private Queue<Job> jobQueue = new LinkedList<Job>();
	
	public  Printer(String name, int minPages, int maxPages){
		this.name = name;
		mininumPages = minPages;
		maximumPages = maxPages;
	}
	
	
	public void addJob(int pages){
		Job newJob = new Job(pages);
		jobQueue.add(newJob);
		System.out.println(name+":  added JOB "+newJob.pages+" pages at TIME: "+time);
	}
	
	public boolean hasNextJob(){
		return !jobQueue.isEmpty();
	}
	
	public void printNextJob(){
	
		if(isPrinting){
			if(jobQueue.peek().completedTime == time){
				Job finishedJob = jobQueue.poll();
				System.out.println(name+" \t\tcompleted "+finishedJob.toString());
				isPrinting = false;
				printNextJob();
			}
			
		}else{
			Job printingJob = jobQueue.peek();
			if(printingJob != null){
				printingJob.setStartTime(time);
				printingJob.setCompletedTime(time+ ((printingJob.pages-1)/10)+1);
				isPrinting = true;
			}
		}
	}



	
	





	public String getName() {
		return name;
	}






	public void setName(String name) {
		this.name = name;
	}






	public int getMininumPages() {
		return mininumPages;
	}






	public void setMininumPages(int mininumPages) {
		this.mininumPages = mininumPages;
	}






	public int getMaximumPages() {
		return maximumPages;
	}






	public void setMaximumPages(int maximumPages) {
		this.maximumPages = maximumPages;
	}


	public static int getTime() {
		return time;
	}
	
	public static void setTime(int newTime){
		time = newTime;
	}


	public static void incrimentTime() {
		time++;
	}





	private static class Job{
		private int pages;
		private int submitTime;
		private int startTime;
		private int completedTime;
		
		public Job(int pages){
			this.pages = pages;
			submitTime = time;
			startTime = 0;
			completedTime = 0;
		}

		public int getPages() {
			return pages;
		}

		public void setPages(int pages) {
			this.pages = pages;
		}

		public int getSubmitTime() {
			return submitTime;
		}

		public void setSubmitTime(int submitTime) {
			this.submitTime = submitTime;
		}

		public int getStartTime() {
			return startTime;
		}

		public void setStartTime(int startTime) {
			this.startTime = startTime;
		}

		public int getCompletedTime() {
			return completedTime;
		}

		public void setCompletedTime(int completedTime) {
			this.completedTime = completedTime;
		}
		
		public String toString(){
			return "Number of Pages: "+pages+"    Submit time: " +submitTime+"     Start Time: "+startTime+"     Completed Time: "+completedTime; 
		}
		
		
	}
}
