package iloveyouboss;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.closeTo;

public class ProfileTest {
	@Test
	public void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
		Profile profile = new Profile("Bull Hockey, Inc.");
		Question question = new BooleanQuestion(1, "Got bonuses?");
		Answer profileAnswer = new Answer(question, Bool.FALSE);
		profile.add(profileAnswer);
		Criteria criteria = new Criteria();
		Answer criteriaAnswer = new Answer(question, Bool.TRUE);
		Criterion criterion = new Criterion(criteriaAnswer, Weight.MustMatch);
		criteria.add(criterion);

		boolean matches = profile.matches(criteria);

		assertFalse(matches);
	}

	@Test
	public void matchAnswersTrueForAnyDontCareCriteria() {
		Profile profile = new Profile("Bull Hockey, Inc.");
		Question question = new BooleanQuestion(1, "Got milk?");
		Answer profileAnswer = new Answer(question, Bool.FALSE);
		profile.add(profileAnswer);
		Criteria criteria = new Criteria();
		Answer criteriaAnswer = new Answer(question, Bool.TRUE);
		Criterion criterion = new Criterion(criteriaAnswer, Weight.DontCare);
		criteria.add(criterion);

		boolean matches = profile.matches(criteria);
		assertTrue(matches);
	}

	@Test
	public void compareArray() {
		assertThat(new String[] { "a", "b", "c" }, equalTo(new String[] { "a", "b", "c" }));
	}

	@Test
	public void compareFloatNumber() {
		assertThat(2.32 * 3, equalTo(6.96));
	}

	@Test
	public void compareFloatNumber2() {
		assertTrue(Math.abs((2.32 * 3) - 6.96) < 0.0005);
	}

	@Test
	public void compareFloatNumber3() {
		assertThat(2.32 * 3, closeTo(6.96, 0.005));
	}
}
