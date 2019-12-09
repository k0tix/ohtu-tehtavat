package statistics.matcher;

public class QueryBuilder {
    private Matcher matcher;

    public QueryBuilder() {
        this.matcher = new All();
    }

    public Matcher build() {
        Matcher result = this.matcher;
        this.matcher = new All();
        return result;
    }

    public QueryBuilder playsIn(String team) {
        return this.newRule(new PlaysIn(team));
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        return this.newRule(new HasAtLeast(value, category));
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        return this.newRule(new HasFewerThan(value, category));
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        this.matcher = new Or(matchers);
        return this;
    }

    private QueryBuilder newRule(Matcher rule) {
        this.matcher = new And(this.matcher, rule);
        return this;
    }
}