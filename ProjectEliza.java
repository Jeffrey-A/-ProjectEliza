import java.util.Scanner;

public class ProjectEliza {

	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		do {
			app(in);
		}while(continueProgram(in));
		System.out.println("Goodbye, until next time");
	}
	
	//brain of the program 
	public static void app(Scanner in) {
		
		String user;
		String temp="";
		String word1;
		String word2;
		
		PromptBank wordBank = new PromptBank(); 
		wordBank.setUp();//populating arrays
		
		welcome();
		wordBank.greet(); //greeting and prompting the user to enter name
		
		user = in.nextLine();
		user = getWord(user,'f');
		System.out.println("Hello "+ user+", Tell me what is on your mind today in 1 sentence.");
		
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
			
			//Getting first and last words 
			word1 = getWord(user,'f');
			word2 = getWord(user,'l');
			
			//Generating and printing the statement
			wordBank.generatePhrase(temp, word1, word2,dramatic); 
		}
	}
	
	public static void welcome() {
		System.out.println("");
		System.out.println("*****************************************************************************");
		System.out.println("                         Welcome to Eliza Therapy Center                     ");
		System.out.println("*****************************************************************************");
		System.out.println("");
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
