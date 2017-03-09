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
	
	/**
	 * Constructor.  instantiates printer object with provided parameters
	 * @param name
	 * 		the name of the printer
	 * @param minPages
	 * 		the mininum number of pages
	 * @param maxPages
	 * 		the maximum number of pages
	 */
	public  Printer(String name, int minPages, int maxPages){
		this.name = name;
		mininumPages = minPages;
		maximumPages = maxPages;
	}
	
	/**
	 * adds job to printer queue
	 * 
	 * @param pages 
	 * 			the number of pages of the job being added to the queue
	 */
	public void addJob(int pages){
		Job newJob = new Job(pages);
		jobQueue.add(newJob);
		System.out.println(name+":  added JOB "+newJob.pages+" pages at TIME: "+time);
	}
	
	/**
	 * returns whether or not the printer has more jobs in its queue
	 * 
	 * @return 
	 * 			true if printer has at least 1 more job in its queue, otherwise false
	 */
	public boolean hasNextJob(){
		return !jobQueue.isEmpty();
	}
	
	/**
	 * prints the next job in the queue
	 */
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
				printingJob.startTime = time;
				printingJob.completedTime = time+ ((printingJob.pages-1)/10)+1;
				isPrinting = true;
			}
		}
	}

	/**
	 * returns name of printer
	 * 
	 * @return  
	 * 			returns the name of the printer
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets name of printer
	 * 
	 * @param name
	 * 			name the printers name will be set to
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * returns minimum pages of printer
	 * 
	 * @return  
	 * 			returns the minimum pages of printer
	 */
	public int getMininumPages() {
		return mininumPages;
	}

	/**
	 * sets minimum pages of printer
	 * 
	 * @param minimumPages
	 * 			minimum pages the printers name will be set to
	 */
	public void setMininumPages(int mininumPages) {
		this.mininumPages = mininumPages;
	}

	/**
	 * returns maximum pages of printer
	 * 
	 * @return  
	 * 			returns the maximum pages of printer
	 */
	public int getMaximumPages() {
		return maximumPages;
	}

	/**
	 * sets maximum pages of printer
	 * 
	 * @param maximumPages
	 * 			maximum pages the printers name will be set to
	 */
	public void setMaximumPages(int maximumPages) {
		this.maximumPages = maximumPages;
	}

	/**
	 * returns static time variable
	 * 
	 * @return  
	 * 			returns the static time variable
	 */
	public static int getTime() {
		return time;
	}
	
	/**
	 * sets static time viriable
	 * 
	 * @param newTime
	 * 			time for static time variable to be set to
	 */
	public static void setTime(int newTime){
		time = newTime;
	}
	
	/**
	 * incriments static time variable
	 */
	public static void incrimentTime() {
		time++;
	}

	private static class Job{
		private int pages;
		private int submitTime;
		private int startTime;
		private int completedTime;
		
		/**
		 * Constructor.  instantiates Job object with provided parameters.  stat time and complete time set to 0
		 * @param pages
		 * 		number of pages of job
		 */
		public Job(int pages){
			this.pages = pages;
			submitTime = time;
			startTime = 0;
			completedTime = 0;
		}

		/**
		 * returns string representation of job
		 * @return	
		 * 		returns string representation of job
		 */
		public String toString(){
			return "Number of Pages: "+pages+"    Submit time: " +submitTime+"     Start Time: "+startTime+"     Completed Time: "+completedTime; 
		}
		
		
	}
}
