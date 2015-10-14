package andy.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
public static void main(String[] args) {
//	testBasicMatch();
//	
//	testGreedyMatch();
	
	testSplit();
	
	String str;
}

private static void testSplit() {
	String str = "one two,alpha9 12!done.";
	Pattern pattern = Pattern.compile("[ ,.!]");
	String[] result = pattern.split(str);
	for (String s : result){
		System.out.println(s);
	}
	
}

private static void testBasicMatch() {
	  Pattern pattern = Pattern.compile("An.*");
	  Matcher matcher = pattern.matcher("My name is Andy");
	  if (matcher.matches()){
		  System.out.println("find");
	  }
	  else{
		  System.out.println("not find");
	  }

}

private static void testGreedyMatch() {
	String str = "Jon Jonathan Frank Ken Todd";
//	Pattern pattern = Pattern.compile("Jon.*");// greedy match
	Pattern pattern = Pattern.compile("Jon.*?");//relunctant match
	Matcher matcher = pattern.matcher(str);
	String result = matcher.replaceAll("Tony");
	System.out.println(result);
}
}
