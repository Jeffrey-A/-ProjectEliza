import java.util.Random;
import java.util.Scanner;

class PromptBank {

	String [] questions;
	String [] statements;
	
	public PromptBank(){
		questions = new String[3]; //initialize your array to the correct length to match your number of questions you populate it with
		statements =new String[3]; //initialize your array to the correct length to match your number of questions you populate it with
		
	}
	
	//populate the container arrays in wordBak
	public void setUp() {
		this.populateStatementsArray();
		this.populateQuestionsArray();
	}
	public void print(String s) {
		System.out.println(s);
	}
	
	public void greet() {
		this.print("Hello, my name is Eliza. What is your name?");
	}
	
	public void populateStatementsArray(){
		statements[0] = "Tell me more about BLANK1 and BLANK2";
		statements[1] = "BLANK1 seems important to you, so does BLANK2. Please tell me more.";
		statements[2] = "BLANK1 and BLANK2 seem to be on your mind. Let's talk about it.";
		/*complete this method with your other statements using BLANK1 for word1
		 * and BLANK2 for word2 place holder 
		 */
	}
	public void populateQuestionsArray(){
		questions[0] = "Is there anything else about BLANK1 and BLANK2?";
		questions[1] = "Does BLANK1 bother you? How about BLANK2?";
		questions[2] = "Are BLANK1 and BLANK2 things you think about often?";
		
		/*complete this method with your other questions using BLANK1 for word1
		 * and BLANK2 for word2 place holder 
		 */
		
	}
	
	public int getRandomIndex() {
		Random number = new Random();
		return number.nextInt(3);
	}
	  
	public String getRandomStatementTrunk(){
		//fill in the method so it randomly selects the statement template
		int index = this.getRandomIndex();
		return this.statements[index];
	}
	
	public String getRandomQuestionTrunk(){
		//fill in the method so it randomly selects the question template
		//from the questions array ... hint use Math.random() to get the random index
		//so you can replace BLANK1 and BLANK2 with the appropriate words

		int index = this.getRandomIndex();
		return this.questions[index];
	}
	
	//it replaces the temporary words BLANK1 AND BLANK2 and print the new sentence
	public void generatePhrase(String sentence, String word1, String word2, boolean dramatic) {
		String temp = sentence.replace("BLANK1", word1);
		String finalSentence = temp.replace("BLANK2", word2);
		if(dramatic) {
			print("WOW! Dramatic! "+ finalSentence);
		}else {
			print(finalSentence);
		}
		
	}
	
	
	
}

public class ProjectEliza {

	static PromptBank wordBank = new PromptBank(); 
	
	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		do {
			app(in);
		}while(continueProgram(in));
		System.out.println("Goodbye, until next time");
	}
	
	//brain of the program uppper level method
	public static void app(Scanner in) {
		
		String user;
		String temp="";
		String word1;
		String word2;
		
		wordBank.setUp();//populating arrays
		wordBank.greet();
		user = in.nextLine();
		user = getWord(user,'f');
		System.out.println("Hello, "+ user+" Tell me what is on your mind today in 1 sentence.");
		
		while(true) {
			
			boolean dramatic =false;
			user = in.nextLine();
			if(user.equals("EXIT")) {
				break;
			}
			
			if(user.charAt(user.length()-1)=='?') {
				temp = wordBank.getRandomQuestionTrunk();//get a random question from the words bank
			}else if(user.charAt(user.length()-1)=='!') {
				//WOW! Dramatic! 
				dramatic = true;
				temp = wordBank.getRandomStatementTrunk();
			}else {
				temp = wordBank.getRandomStatementTrunk();//get a random statement from the words bank
			}
			
			
			word1 = getWord(user,'f');
			word2 = getWord(user,'l');
			
			wordBank.generatePhrase(temp, word1, word2,dramatic);
		}
	}
	
	//returns the first or last word without punctuation 
	public static String getWord(String sentence, char word) {
		String[] words;
		words = sentence.split(" ");
		String cleanedWord="";
		
		if(word=='f') {//return the first word
			String temp = words[0];
			
			for(int i=0; i < temp.length(); i++) {
				if(Character.isLetter(temp.charAt(i))) {
					cleanedWord+= Character.toString(temp.charAt(i));
				}
			}
			
		}else {//return the last word
			String temp = words[words.length -1];
			
			for(int i=0; i < temp.length(); i++) {
				if(Character.isLetter(temp.charAt(i))) {
					cleanedWord+= Character.toString(temp.charAt(i));
				}
			}
			
		}
		
		return cleanedWord;
	}
	
	public static boolean continueProgram(Scanner in) {
		String response="";
		System.out.println("Do you want to run the session again?");
		response = in.nextLine();
		
		if(response.equalsIgnoreCase("yes")) {
			return true;
		}
		return false;
	}
	
	
	
	

}

