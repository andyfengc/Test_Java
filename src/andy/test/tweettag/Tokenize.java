package andy.test.tweettag;

import java.util.List;

import cmu.arktweetnlp.POSTagger;
import cmu.arktweetnlp.Token;

public class Tokenize {

	public static void main(String[] args) {
//		String tweet = "Looking forward to having a chat with @example on my new radio show on Saturday";
		 String tweet = "Both Duffy's lawyer and lead Crown prosecutor Mark Holmes laid out their prospective cases. Bayne, who spoke in the afternoon, repeatedly referred to the prosecutor's opening statement, which contended that Duffy was an equal partner in the arrangement of the $90,000 payment, if not the instigator. Among the charges he faces, the 68-year-old Duffy, who represents P.E.I., is facing one count of bribery related to the $90,000 payment.";
		//pos tagger uses greedy decoder by default
		POSTagger postagger = new POSTagger();
		 
		List<Token> tokens =  postagger.runPOSTagger(tweet);
		for(Token token : tokens)
		{
		    System.out.println(token.getWord() + "\t"+ token.getPOS());
		}
	}

}
