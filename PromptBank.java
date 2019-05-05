import java.util.Random;

public class PromptBank {

	String [] questions;
	String [] statements;
	
	public PromptBank(){
		//initializes my variables
		questions = new String[5]; 
		statements =new String[5]; 
		
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
		statements[0] = "Tell me more about BLANK1 and BLANK2.";
		statements[1] = "BLANK1 seems important to you, so does BLANK2. Please tell me more.";
		statements[2] = "BLANK1 and BLANK2 seem to be on your mind. Let's talk about it.";
		statements[3] = "Please, give me more details about BLANK1 and BLANK2.";
		statements[4] = "I'm curious about BLANK1 and BLANK2. Tell me your thoughts about them.";
		
		
	}
	public void populateQuestionsArray(){
		questions[0] = "Is there anything else about BLANK1 and BLANK2?";
		questions[1] = "Does BLANK1 bother you? How about BLANK2?";
		questions[2] = "Are BLANK1 and BLANK2 things you think about often?";
		questions[3] = "How often do you think about BLANK1 and BLANK2?";
		questions[4] = "Is BLANK1 important to you? What about BLANK2?";	
	}
	
	//produces a random number
	public int getRandomIndex() {
		Random number = new Random();
		return number.nextInt(questions.length);
	}
	  
	//gets a random statement
	public String getRandomStatementTrunk(){
		int index = this.getRandomIndex();
		return this.statements[index];
	}
	
	public String getRandomQuestionTrunk(){
		//gets a random question
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
