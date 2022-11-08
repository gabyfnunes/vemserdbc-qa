package IteraAula1.step;

import IteraAula1.util.Browser;
import org.junit.After;
import org.junit.Before;


public class BaseTeste extends Browser {

    @Before
    public void abrirNavegador() {
        browserUp("https://itera-qa.azurewebsites.net/home");
    }

    @After
    public void fecharNavegador() {
        browserDown();
    }
}
