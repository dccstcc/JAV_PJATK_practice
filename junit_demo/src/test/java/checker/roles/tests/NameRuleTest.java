package checker.roles.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import checker.CheckResult;
import checker.RuleResult;
import checker.rules.NameRule;
import domain.Person;

public class NameRuleTest {

	NameRule rule = new NameRule();
	
	@Test
	public void checker_should_check_if_the_person_name_is_not_null(){
		Person p = new Person();
		CheckResult result =rule.checkRule(p);
		assertTrue(result.getResult().equals(RuleResult.Error));
		
	}
	
	@Test
	public void checker_should_check_if_the_person_name_is_not_empty(){
		Person p = new Person();
		p.setFirstName("");
		CheckResult result =rule.checkRule(p);
		assertTrue(result.getResult().equals(RuleResult.Error));
		
	}
	
	@Test
	public void checker_should_return_OK_if_the_name_is_not_null(){
		Person p = new Person();
		p.setFirstName("Jan");
		CheckResult result =rule.checkRule(p);
		assertTrue(result.getResult().equals(RuleResult.Ok));
		
	}
	
	//...reszta testów

}
