package andy.test.date;

import java.io.File;
import java.io.FileReader;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  public static void main(String[] argv) throws Exception {
	  Date date = new Date();
	  DateFormat df = DateFormat.getDateInstance();
	  System.out.println(df.format(date));
	  
	  SimpleDateFormat sdf = new SimpleDateFormat("dd MMM");
	  System.out.println(sdf.format(date)); 
	  
	  Date anotherDate = sdf.parse("11 April");
	  System.out.println(anotherDate); 
  }
}