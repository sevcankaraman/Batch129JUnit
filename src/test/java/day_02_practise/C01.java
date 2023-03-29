package day_02_practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C01 {
    public static void main(String[] args) {
        // https://www.amazon.com/ adresine gidin
        // arama kutusunun, tagName'inin 'input' oldugunu test ediniz
        // arama kutusunun, name attribute'nun degerinin 'field-keywords' oldugunu test edin
        // sayfayi kapatiniz
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.amazon.com/ adresine gidin
        driver.get("https://amazon.com/");

        // arama kutusunun, tagName'inin 'input' oldugunu test ediniz
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        String actuelTagname=aramaKutusu.getTagName();//gercek tagname
        String expectedTagname="input";// beklenen tagname

        if (expectedTagname.equals(actuelTagname)){
            System.out.println("tagname input");
        }else {
            System.out.println("tagname input değil");
        }

        // arama kutusunun, name attribute'nun degerinin 'field-keywords' oldugunu test edin

        String actuelNameDegeri=aramaKutusu.getAttribute("name");
        String exceptedNameDegeri="field-keywords";

        if (exceptedNameDegeri.equals(actuelNameDegeri)){
            System.out.println("name degeri field-keywords");
        }else{
            System.out.println("name değeri field-keywords değil");
        }

        driver.close();




    }
}
