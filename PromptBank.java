import java.util.Random;

public class PromptBank {

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
