package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.TestBase;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preConditions(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
            app.getHelperUser().pause(50);
        }

    }

    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("a@gmail.com", "Mm2756808@");
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(50);
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");



    }

    @Test
    public void loginSuccessModel(){
        User user = new User().setEmail("a@gmail.com").setPassword("Mm2756808@");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitLogin();
        //Assert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        //app.getHelperUser().clickOKButton();


    }
    @Test public void loginWrongEmail(){
            app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("a@.com","Mm2756808@");
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(50);
        Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());



}
    @Test public void loginWrongPassword(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("a@2.com","Mm1@2756808@");
        app.getHelperUser().submitLogin();
        Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");
        app.getHelperUser().pause(50);


    }
    @Test public void loginUnregistredUser(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("a1212@gmail.com","Mm12@275680");
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(50);
        Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");


    }


    @AfterMethod
    public void postConditions(){
        app.getHelperUser().clickOKButton();
        app.getHelperUser().pause(50);

    }
}
