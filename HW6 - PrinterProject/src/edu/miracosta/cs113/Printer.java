package edu.miracosta.cs113;

import java.util.LinkedList;
import java.util.Queue;

public class Printer {
	private static int time = 0;
	private int mininumPages;
	private int maxinumPages;
	private Queue<Job> jobQueue = new LinkedList<Job>();
	
	
	
	
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
