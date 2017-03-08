package edu.miracosta.cs113;

import java.util.LinkedList;
import java.util.Queue;

public class Printer {
	private static int time = 0;
	private String name;
	private int mininumPages;
	private int maxinumPages;
	private boolean isPrinting = false;
	private Queue<Job> jobQueue = new LinkedList<Job>();
	
	public  Printer(String name, int minPages, int maxPages){
		this.name = name;
		mininumPages = minPages;
		maxinumPages = maxPages;
	}
	
	
	public void addJob(int pages){
		jobQueue.add(new Job(pages));
		System.out.println(name+": added job of "+pages+" at time "+time);
	
	}
	
	
	
	public void printNextJob(){
		isPrinting = true;
		Job printingJob = jobQueue.peek();
		printingJob.setStartTime(time);
		printingJob.setCompletedTime(time+ ((printingJob.pages-1)/10)+1);
		
	}

	public void tick(){
		//check if printing
		if(isPrinting){
			if(jobQueue.peek().completedTime == time){
				jobQueue.poll();
				if(!jobQueue.isEmpty()){
					this.printNextJob();
				}else{
					isPrinting = false;
				}
			}
		}else{
			if(!jobQueue.isEmpty()){
				this.printNextJob();
			}
		}
		
		
			//if so, check if job done yet
				//if not, continue printing
				//if so, pop off job from queue and start next one
			//if not printing, check if job in queue and start printing if so
		
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






	public int getMaxinumPages() {
		return maxinumPages;
	}






	public void setMaxinumPages(int maxinumPages) {
		this.maxinumPages = maxinumPages;
	}


	public static int getTime() {
		return time;
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
			return "Number of Pages: "+pages+"\tSubmit time: " +submitTime+"\tCompleted Time: "+completedTime; 
		}
		
		
	}
}
