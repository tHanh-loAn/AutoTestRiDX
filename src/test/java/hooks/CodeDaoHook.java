package hooks;


import base.WebApp;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CodeDaoHook {
    @Before
    public void init(){
        System.out.println("Before");
        WebApp app = new WebApp();
        WebApp.setWebApp(app);
    }

    @After
    public void teardown(){
        System.out.println("After");
        WebApp.getWebApp().quit();
        WebApp.setWebApp(null);
    }
}
