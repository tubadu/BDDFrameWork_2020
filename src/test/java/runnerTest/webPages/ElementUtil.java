package runnerTest.webPages;

import Utils.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class ElementUtil {

    public static WebElement webAction(final By locator){
        Wait<WebDriver> wait=new FluentWait<WebDriver>(BasePage.get())
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class)
                .withMessage(
                        "Webdriver waited for 15 seconds not still could not find the element therefore TimeoutException"
                );
        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver){
                return  driver.findElement(locator);
            }
        });
    }
    public void clickOn(By locator){
        webAction(locator).click();
    }
    public void sendValue(By locator, String value){
        webAction(locator).sendKeys(value);

    }
    public String getTextFromElement(By locator){
        return webAction(locator).getText();
    }
    public void clear(By locator){

        webAction(locator).clear();
    }
    public boolean isElementDisplayed(By locator){

        return webAction(locator).isDisplayed();
    }
    public boolean isElementSelected(By locator){

        return  webAction(locator).isSelected();
    }
    public boolean isElementEnabled(By locator){

        return webAction(locator).isEnabled();
    }

    public List<WebElement> webElements(By locator){

        return BasePage.get().findElements(locator);
    }
    public void selectFromDropdownText(By locator, String dropDownText){
        WebElement text=webAction(locator);
        Select select=new Select(text);
        select.selectByVisibleText(dropDownText);
    }
    public void selectFromDropdownIndex(By locator, int  dropDownIndex){
        WebElement text=webAction(locator);
        Select select=new Select(text);
        select.selectByIndex(dropDownIndex);
    }
    public void scrollByElement(By locator){
        WebElement scrollElement= webAction(locator);
        JavascriptExecutor js=(JavascriptExecutor) BasePage.get() ;
    js.executeScript("argument[0].scrollIntoView;",scrollElement);
    }
    public void scrollByPixel(String xPixel,String yPixel){
        String str="window.scroll("+xPixel+","+yPixel+")";
        JavascriptExecutor js=(JavascriptExecutor)BasePage.get();
        js.executeScript(str);
    }
    public void movetoElement(By locator){
        Actions actions=new Actions(BasePage.get());
        actions.moveToElement(webAction(locator)).build().perform();
    }
    public String getScreenShot(String name){
        SimpleDateFormat df=new SimpleDateFormat("-yyyy-MM-dd-HH-mm");
        String date=df.format(new Date());
        TakesScreenshot ts=(TakesScreenshot)BasePage.get();
        File src=ts.getScreenshotAs((OutputType.FILE));
        String target=System.getProperty("user.dir")+"/test-output/Screenshots/"+name+date+
                ".png";
        File finalDestination=new File(target);
        try{
            FileUtils.copyFile(src,finalDestination);

        }catch (IOException e){
            e.printStackTrace();
        }return  target;
    }
}

