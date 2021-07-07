package TCs;

import Libraries.BaseUtil;
import Libraries.Hook;
import Libraries.ReusableMethods;
import org.jsoup.Connection;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class scenarios {

    private BaseUtil base;
    
    Hook h=new Hook();


    public void login(){

        try{
            h.getdriver().findElement(By.xpath("//input[@id='username']")).sendKeys(base.username);
            h.getdriver().findElement(By.xpath("//input[@id='password']")).sendKeys(base.password);
            WebElement btnlogin=Hook.getdriver().findElement(By.xpath("//button[contains(text(),'Login')]"));

            Actions act=new Actions(h.getdriver());
            act.moveToElement(btnlogin).click()
                    .build().perform();
        }catch (Exception   e){

        }
    }

    public static boolean validatelogin(){
        try{
            if(Hook.getdriver().findElement(By.xpath("//*[contains(text(),'Thank You Successully Login!!']")).isDisplayed()){
                Assert.assertTrue(true);
                return true;
            }else{
                Assert.assertTrue(false);
                return false;
            }
        }catch (Exception   e){

        }

        return true;
    }

    public void scrolldown(){
        JavascriptExecutor js = (JavascriptExecutor) h.getdriver();
        js.executeScript("window.scrollBy(0,500)");
    }

    public void filltheform(){

        try{
            if(validatelogin()==true){
//                System.out.println("login successful");

                h.getdriver().findElement(By.xpath("//input[@id='developer-name']")).sendKeys(base.email);
                h.getdriver().findElement(By.xpath("//input[@id='populate']")).click();

                Thread.sleep(2000);
                h.getdriver().switchTo().alert().accept();

                Thread.sleep(2000);
                h.getdriver().switchTo().defaultContent();

                h.getdriver().findElement(By.xpath("//input[@id='3months']")).click();



                h.getdriver().findElement(By.xpath("//input[@id='discounts']")).click();

                h.getdriver().findElement(By.xpath("//input[@id='delivery-time']")).click();

                WebElement preferredtype=h.getdriver().findElement(By.xpath("//select[@id='preferred-payment']"));

                Select paymenttype=new Select(preferredtype);

                paymenttype.selectByIndex(1);

                if(h.getdriver().findElement(By.xpath("//select[@id='preferred-payment']")).isDisplayed()){
                    Assert.assertTrue(true);
//                    System.out.println("yes");
                }else {
                    Assert.assertTrue(false);
//                    System.out.println("No");
                }

                scrolldown();
                Thread.sleep(2000);
                Actions act=new Actions(h.getdriver());




                WebElement enabletoolbar=h.getdriver().findElement(By.xpath("//input[@id='tried-ecom']"));
//                act.moveToElement(enabletoolbar).sendKeys(Keys.ENTER).build().perform();
//                act.keyDown(Keys.TAB).build().perform();
                enabletoolbar.sendKeys(Keys.SPACE);
                enabletoolbar.sendKeys(Keys.TAB);
                Thread.sleep(2000);
//                act.sendKeys(Keys.ENTER);
                WebElement chk=h.getdriver().findElement(By.xpath("//div/parent::div/div/label/input"));
//////                WebElement chk1=h.getdriver().findElement(By.linkText("I have made an eCommerce purchase in the last 1 year"));
////
//////                chk.click();
//////                enabletoolbar.click();
//
//                act.moveToElement(enabletoolbar).click(enabletoolbar).build().perform();
//                enabletoolbar.click();
//                h.getdriver().findElement(By.xpath("//input[@id='tried-ecom']")).click();
                if(enabletoolbar.isSelected()){
                    WebElement dragger=h.getdriver().findElement(By.xpath("//body[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[4]/div[2]/div[1]/div[1]/div[1]/div[1]/div[12]"));

                    WebElement scale9=h.getdriver().findElement(By.xpath("//body/div[@id='__next']/div[1]/section[2]/div[1]/div[1]/div[4]/div[2]/div[1]/div[1]/div[1]/div[1]/div[10]"));

                    for(int i=0;i<4;i++){
                        dragger.sendKeys(Keys.ARROW_RIGHT);

                    }
//
//                    act.moveToElement(scale9).click().build().perform();
//                    act.clickAndHold(dragger)
//                            .moveToElement(scale9)
//                            .build().perform();

                    WebElement score9=h.getdriver().findElement(By.xpath("//div[@aria-valuenow='90']"));

                    if(score9.isDisplayed()){
                        Assert.assertTrue(true);
                    }else{
                        Assert.assertTrue(false);
                    }

                    WebElement feedback=h.getdriver().findElement(By.xpath("//textarea[@id='comments']"));
                    feedback.sendKeys("thank you");

                }else{
                    Assert.assertTrue(false);
                }

            }else{
                Assert.assertTrue(false);
            }

        }catch (Exception   e){

        }

    }


    public void opennewwindow(){

        try{
            ((JavascriptExecutor)h.getdriver()).executeScript("window.open('https://www.lambdatest.com/selenium-automation')");

            Thread.sleep(10000);

            String parent=h.getdriver().getWindowHandle();

            Set<String> tabs=h.getdriver().getWindowHandles();
            Iterator<String> I=tabs.iterator();
            while(I.hasNext()){
                String childwindow=I.next();

                if(!parent.equals(childwindow)){
                    h.getdriver().switchTo().window(childwindow);
                    Thread.sleep(2000);
//                   imagedownload();
                 Thread.sleep(2000);
                    h.getdriver().close();

                }
            }
            h.getdriver().switchTo().window(parent);

        }catch (Exception   e){

        }
    }


    public void imagedownload() throws IOException {
        WebElement jenkinselement=h.getdriver().findElement(By.xpath("//img[@title='Jenkins']"));
        String srcurl=jenkinselement.getAttribute("src");

        URL imageurl=new URL(srcurl);
        System.out.println(srcurl);
        BufferedImage saveImage= ImageIO.read(imageurl);
        ImageIO.write(saveImage,"svg",new File("/Users/venkatasuhku/Desktop/automationdemo/Jenkins.svg"));
    }


    public void imageupload() throws AWTException, InterruptedException {

        WebElement feedback=h.getdriver().findElement(By.xpath("//textarea[@id='comments']"));
        feedback.clear();
        feedback.sendKeys("thank you");
        Thread.sleep(2000);
        WebElement btnupload=h.getdriver().findElement(By.xpath("//form/input[@id='file']/following-sibling::label"));
        btnupload.click();
        File file = new File(System.getProperty("user.dir")+"/jenkins.svg");
        StringSelection stringSelection = new StringSelection(file.getAbsolutePath());

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
//        btnupload.sendKeys(Keys.SPACE);
//        Thread.sleep(2000);
//        btnupload.sendKeys(Keys.ESCAPE);


//        btnupload.sendKeys(file.getAbsolutePath());

//        h.getdriver().switchTo().alert().accept();

    }


    public void submit() throws InterruptedException, AWTException {
//        imageupload();
        WebElement ele=h.getdriver().findElement(By.xpath("//button[@id='submit-button']"));
        ele.sendKeys(Keys.SPACE);
        if(h.getdriver().findElement(By.xpath("//h1[contains(text(),'Thank you!')]")).isDisplayed()){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }

    }
}
