package ScoreCollection;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class ScoreCollectionTest {

	@Test
	public void test() {
	}
	
	@Test
	public void answersArithmeticMeanOfTwoNumbers(){
		ScoreCollection sc = new ScoreCollection();
		sc.add(() -> 5);
		sc.add(() -> 7);
		int result = sc.arithmeticMean();
		assertThat(result, equalTo(6));
	}

}
