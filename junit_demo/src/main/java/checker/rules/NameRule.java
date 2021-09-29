package checker.rules;

import checker.CheckResult;
import checker.ICanCheckRule;
import checker.RuleResult;
import domain.Person;

public class NameRule implements ICanCheckRule<Person>{

	public CheckResult checkRule(Person entity) {

		if(entity.getFirstName()==null)
			return new CheckResult("", RuleResult.Error);
		if(entity.getFirstName().equals(""))
			return new CheckResult("", RuleResult.Error);
		return new CheckResult("", RuleResult.Ok);
	}

}
