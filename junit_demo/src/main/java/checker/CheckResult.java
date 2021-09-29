package checker;

public class CheckResult {

	
	
	private String message;
	private RuleResult result;
	
	public CheckResult(String message, RuleResult result) {
		this.message = message;
		this.result = result;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public RuleResult getResult() {
		return result;
	}
	public void setResult(RuleResult result) {
		this.result = result;
	}
	
	
}
