package checker;

public interface ICanCheckRule<TEntity> {
	
	public CheckResult checkRule(TEntity entity);
}
