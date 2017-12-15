import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class BananaSong {
    public static void main(String[] args) {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
        driver.findElement(By.id("gs_htif0"));
        Actions make  = new Actions(driver);
        Action kbEvents = make.sendKeys("Banana song").build();
        kbEvents.perform();
        driver.findElement(By.xpath(".//*[@name='btnK']")).click();
        driver.findElement(By.xpath(".//*[@href='https://www.youtube.com/watch?v=wCkerYMffMo']")).click();
        if (driver.findElement(By.xpath("//*[@id='logo-icon-container']")).isDisplayed()!=true){
            throw new RuntimeException("Мы не на Ютубе");
        }
        int times=Integer.parseInt(driver.findElement(By.xpath("//*[@id='count']/yt-view-count-renderer/span[1]")).getText());
        if (times<50000000){
            throw new RuntimeException("Мы не то видео смотрим");
        }
    }
}
