/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author yuuze
 */
public class JankenIf {
	public static void main(String[] args) {
 
		// Input user's hand by using keybord
		int user = getUser();
 
		// Produre the computer's hand by using random number
		int pc = getPc();
 
		// Judge the result
		String result = judgeJanken(user,pc);
 
		// Present the result
		showResult(user,pc,result);
	}
 
	public static int getUser() {
		// Preperation of Input of keybord
		Scanner stdin = new Scanner(System.in);
 
		// Infinite roop
		while(true) {
			// Show the message
			System.out.println("Please input your hand");
			System.out.print("(Rock:0，Scissor:1、Paper:2)　--> ");
 
			// Check whether the input is integer or not
			if(stdin.hasNextInt()) {
				// Read the data input as a integer
				int number = stdin.nextInt();
				// 「0，1，2」are only valid in the inerger
				if(number<=-1 || number >=3) {
					// Out of range is n
					System.out.println("[error]Only「0～2」can be inputted");
					continue;
				}else {
					// In case of 0,1,2、return as a result of method
					return number;
				}
			}else {
				// In case of non-integer、Redo because of invalid data
				System.out.println("[error]Only integer can be inputted");
				// Remove the unnecessary token from the buffer
				stdin.next();
			}
		}
	}
 
	public static int getPc() {
		// Preperation of random number
		Random rand = new Random();
		// Ask for one of 0,1,2, and return as the result of method
		return rand.nextInt(3);
	}
 
	public static String judgeJanken(int user,int pc) {
		String result=""; // Store the judged result
 
		if((user==0 && pc==1) || (user==1 && pc==2) || (user==2 && pc==0)) {
			result="win";
		}else if( (user==0 && pc==2) || (user==1 && pc==0) || (user==2 && pc==1)) {
			result="lose";
		}else {
			result="draw";
		}
 
		// return the result
		return result;
	}
 
	public static void showResult(int user,int pc,String result) {
		// Define the Rock-paper-scissors hand in arrangement

		String[] janken= {"Rock","Scissors","Paper"};
		// Shwot the result
		System.out.println("your hand:"+janken[user]+",Computer's hand:"+janken[pc]);
		System.out.println("Result："+result);
 
	}

}
