package andy.test.regex;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransformDates {

	/**
	 * Transforms dates in a file from one format to another.
	 * 
	 * For example, "On 9/6/78, a really cool thing happened." and a destination
	 * format of "EEEE, MMMM dd, yyyy". The expected output would be "On
	 * Wednesday, September 06, 1978, a really cool thing happened.
	 *
	 * "
	 *
	 * @param file
	 *            The file whose dates will be transformed.
	 * @param sourcePattern
	 *            A {@link SimpleDateFormat}-compatible date format that
	 *            identifies the format of dates within the file to transform.
	 * @param destinationPattern
	 *            A {@link SimpleDateFormat}-compatible date format that
	 *            identifies the destination format of transformed dates.
	 */
	public static void transformDates(final File file, String sourcePattern, String destinationPattern) {
		Scanner scanner = null;
		// create regex pattern
		String datePatternStr = "(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/((19|20)\\d\\d|\\d\\d)";
		Pattern pattern = Pattern.compile(datePatternStr);
		// create source date format parser
		SimpleDateFormat sourceDateParser = new SimpleDateFormat(sourcePattern);
		// create target date format parser
		SimpleDateFormat targetDateParser = new SimpleDateFormat(destinationPattern);
		
		try {
			scanner = new Scanner(file);
			// loop source line by line
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				// match date
				Matcher matcher = pattern.matcher(line);
				while (matcher.find()){
					// find the matched date
					String matchStr = matcher.group();
					// format date
					Date date = sourceDateParser.parse(matchStr);
					String targetStr = targetDateParser.format(date);
					// replace date string
					line = line.replace(matchStr, targetStr);
					// re-match remaining string
					matcher = pattern.matcher(line);
				}
				// display formatted result
				System.out.println(line);
				
//				String target = "";
//				Matcher matcher = pattern.matcher(line);
//				while (matcher.find()) {
//					// find the matched string
//					String matchStr = matcher.group();
//					// System.out.println(matchStr);
//					// try to parse date
//					// if (sourceDateParser.parse(matchStr) != null) {
//					// find the valid date
//					// System.out.println("Find the source date: " +
//					// sourceDateParser.parse(matchStr));
//					Date date = sourceDateParser.parse(matchStr);
//					// format the date
//					String targetStr = targetDateParser.format(date);
//					// System.out.println("Target date format: " +
//					// targetDateParser.format(date));
//					String result = line.replace(matchStr, targetStr);
//					System.out.println(result);
//					// }
//				}

			}

		} catch (ParseException pe) {
			System.out.println("Parse date failed");
			pe.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find the file");
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}

	public static void main(String[] args) {
		// get file
		File file = new File(TransformDates.class.getResource("/andy/test/resources/input.txt").getPath());
		// transform text
		transformDates(file, "MM/dd/yy", "EEEE, MMMM dd yyyy");
	}
}
