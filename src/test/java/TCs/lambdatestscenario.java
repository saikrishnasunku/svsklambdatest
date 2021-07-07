package TCs;

import Libraries.BaseUtil;
import Libraries.Hook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;

public class lambdatestscenario {
    private BaseUtil base;

    TCs.scenarios sc=new TCs.scenarios();

//    private static ThreadLocal<WebDriver> driverThreadLocal=new ThreadLocal<>();
//
//    public static WebDriver getdriver(){
//        return driverThreadLocal.get();
//    }
//
//    public static void setdriver(WebDriver driver){
//        driverThreadLocal.set(driver);
//    }

    Hook h=new Hook();


    @Parameters("browser")
    @BeforeMethod
    public void invokebrowser(String browsername){

        try{
            if(browsername.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver");
                base.driver=new ChromeDriver();
                h.setdriver(base.driver);
                h.getdriver().get(base.url);
                h.getdriver().manage().window().maximize();
            }else if(browsername.equalsIgnoreCase("safari")){
                base.driver=new SafariDriver();
                h.setdriver(base.driver);
                h.getdriver().get(base.url);
                h.getdriver().manage().window().maximize();
            }else if(browsername.equalsIgnoreCase("firefox")){
                System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir") + "/Drivers/geckodriver");
//                webdriver.firefox.marionette
                base.driver=new FirefoxDriver();
                h.setdriver(base.driver);
                h.getdriver().get(base.url);
//                h.getdriver().manage().window().maximize();
            }
        }catch (Exception   e){

        }

    }

    @Test
    public void realscenario() throws InterruptedException, AWTException {
//
        sc.login();
        sc.filltheform();
        sc.opennewwindow();
        Thread.sleep(2000);
        sc.scrolldown();
        sc.submit();

    }

    @AfterMethod
    public void cleanup() throws InterruptedException {
        try{
            Thread.sleep(3000);
            h.getdriver().close();
        }catch (Exception   e){

        }

//        h.getdriver().quit();
//        driverThreadLocal.set(null);
    }
}
