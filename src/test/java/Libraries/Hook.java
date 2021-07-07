package Libraries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

public class Hook {

    private static ThreadLocal<WebDriver> driverThreadLocal=new ThreadLocal<>();

    public static WebDriver getdriver(){
        return driverThreadLocal.get();
    }

    public static void setdriver(WebDriver driver){
        driverThreadLocal.set(driver);
    }

//    private BaseUtil base;
//
//    TCs.scenarios sc=new TCs.scenarios();
//
//    private static ThreadLocal<WebDriver> driverThreadLocal=new ThreadLocal<>();
//
//    public static WebDriver getdriver(){
//        return driverThreadLocal.get();
//    }
//
//    public static void setdriver(WebDriver driver){
//        driverThreadLocal.set(driver);
//    }
//
//    @Parameters("browser")
//    @BeforeMethod
//    public void invokebrowser(String browsername){
//
//        try{
//            if(browsername.equalsIgnoreCase("chrome")){
//                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver");
//                base.driver=new ChromeDriver();
//                setdriver(base.driver);
//                getdriver().get(base.url);
//            }else if(browsername.equalsIgnoreCase("safari")){
//                base.driver=new SafariDriver();
//                setdriver(base.driver);
//                getdriver().get(base.url);
//            }else if(browsername.equalsIgnoreCase("firefox")){
//                System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir") + "/Drivers/geckodriver");
//                base.driver=new FirefoxDriver();
//                setdriver(base.driver);
//                getdriver().get(base.url);
//            }
//        }catch (Exception   e){
//
//        }
//
//    }
//
//    @Test
//    public void realscenario(){
////
//        sc.login();
//    }
//
//    @AfterMethod
//    public void cleanup(){
//        getdriver().close();
//        driverThreadLocal.set(null);
//    }
}
