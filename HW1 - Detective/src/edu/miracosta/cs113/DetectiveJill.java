package edu.miracosta.cs113;
/**
 * DetectiveJill.java :Incrementing number for the Clue problem
 * 
 * @author Michael Jones (some material referenced from Nery Chapeton-Lamas)
 * @version 1.0
 *
 */
import java.util.Scanner;

public class DetectiveJill {
	/**
	 * Driver for increasing-number theory checker
	 * 
	 * @param args
	 *            command line arguments (unnused)
	 */
	public static void main(String[] args) {
		
		int answerSet;
		int weapon = 1;
		int solution;
		int murder = 1;
		int location = 1;
		boolean isGuessing = true;
		Scanner keyboard = new Scanner(System.in);
		AssistantJack jack;
		Theory answer;
		
		System.out.println("Which theory would you like to test? (1, 2, 3[random]): ");
		answerSet = keyboard.nextInt();
		keyboard.close();
		
		jack = new AssistantJack(answerSet);
		
		//increment each returned incorrect answer by 1 until answer is correct
		while(isGuessing){
			//check answer
			solution = jack.checkAnswer(weapon, location, murder);
			
			//Increment wrong answer identified by JackAssistant
			if(solution == 0){
				isGuessing= false;
			}else if(solution == 1){
				weapon++;
			}else if(solution == 2){
				location++;
			}else if(solution == 3){
				murder++;
			}
			
		}
		answer = new Theory(weapon, location, murder);
		
		//display results to user
		System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution = " + answer);

		if (jack.getTimesAsked() > 20) {
			System.out.println("FAILED!! You're a horrible Detective...");
		} else {
			System.out.println("WOW! You might as well be called Batman!");
		}
	}

}
