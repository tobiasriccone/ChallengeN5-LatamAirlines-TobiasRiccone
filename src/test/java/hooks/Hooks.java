package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static utils.WebDriverUtils.closeBrowser;
import static utils.WebDriverUtils.setUpBrowser;

public class Hooks {
    @Before
    public void setUp() { setUpBrowser(); }

    @After
    public void tearDown() { closeBrowser(); }
}