package checker;

import java.util.ArrayList;
import java.util.List;

public class RuleChecker<TEntity> {

	private List<ICanCheckRule<TEntity>> rules;

	public List<ICanCheckRule<TEntity>> getRules() {
		return rules;
	}

	public void setRules(List<ICanCheckRule<TEntity>> rules) {
		this.rules = rules;
	}
	
	public List<CheckResult> check(TEntity entity){
		List<CheckResult> result  = new ArrayList<CheckResult>();
		
		for(ICanCheckRule<TEntity> rule: rules){
			result.add(rule.checkRule(entity));
		}
		return result;
	}
}
