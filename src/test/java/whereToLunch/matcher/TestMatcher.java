package whereToLunch.matcher;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import whereToLunch.web.json.JsonUtil;

/**
 * Created by Eugene on 17.03.2017.
 */
abstract public class TestMatcher<T> extends BaseMatcher<String> {
    protected T expected;

    public TestMatcher(T expected) {
        this.expected = expected;
    }

    @Override
    public boolean matches(Object actual) {
        return compare(expected, (String) actual);
    }

    abstract protected boolean compare(T expected, String actual);

    @Override
    public void describeTo(Description description) {
        description.appendText(JsonUtil.writeValue(expected));
    }
}
