package AutomationTestHomework.step;

import AutomationTestHomework.util.Browser;
import org.junit.After;
import org.junit.Before;


public class BaseTeste extends Browser {

    @Before
    public void abrirNavegador() {
        browserUp("https://practice.automationtesting.in/");
    }

    @After
    public void fecharNavegador() {
        browserDown();
    }
}
