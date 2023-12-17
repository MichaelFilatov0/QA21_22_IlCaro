package tests;

import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @Test
    public void test(){
    app.getHelperUser().openLogRegForm();
    app.getHelperUser().typeLogPass("a@gmail.com","Mm2756808@");

    }
}
