import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.System.currentTimeMillis;

/**
 * create by fungus on 2018/7/30
 **/

public class Main {
    //one day
    private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;

    public static void main(String[] args) throws ParseException {
        //创建定时器
        Timer timer = new Timer();
        SimpleDateFormat dataFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = dataFormat1.parse("2018-07-30 17:50:20");
        System.out.println("程序开始 现在是：" + new Date().toString());
        timer.schedule(new MyTask(), d);
    }
}

class MyTask extends TimerTask {
    @Override
    public void run() {
        new Thread(() -> {
            long l1 = currentTimeMillis();
            System.out.println("Hello!! 线程1开始时间：" + new Date().toString());
            String myUrl = "http://m.5read.com/914?backurl=http%3A%2F%2Fmc.m.5read" +
                    ".com%2Fweixin%2FuserBind1_viewForwordCookie.jspx%3Freal" +
                    "Url%3Dhttp%253A%252F%252Fmc.m.5read.com%252Fweixin%252F" +
                    "userBind1_viewProxySn.jspx%253FwxProductId%253D26%2526ba" +
                    "ckUrl%253Dhttp%25253a%25252f%25252fseat.lib.xauat.edu.cn%2" +
                    "5252fssLogin%2526openid%253DoOVSot4wkoI_-syS0j6QNxcwhz7" +
                    "k%26ubId%3D4915854";
            WebDriver driver = new ChromeDriver();
            driver.manage().window().setPosition(new Point(0,0));
            driver.manage().window().setSize(new Dimension(150,600));
            String xpath1 = "//*[@id=\"app\"]/div/div[2]/div[1]/div[2]" +
                    "/div/div[1]/div[2]/select";
            String xpath2 = "//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/" +
                    "div/div[3]/div[2]/select";
            String xpath3 = "//*[@id=\"app\"]/div/div[2]/div[1]/div[4]/button";
            driver.get(myUrl);

            //下面两行智能等待网络时间
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
            System.out.println("Hello!! 线程1网络加载时间：" + (System.currentTimeMillis() - l1) + "毫秒");
            System.out.println("Hello!! 线程链接到URl：" + new Date().toString());
            //选择自习区域
            WebElement e1 = driver.findElement(
                    By.xpath(xpath1));
            Select select1 = new Select(e1);
            select1.selectByValue("9");
            //选择自习上午还是下午
            WebElement e2 = driver.findElement(
                    By.xpath(xpath2));
            Select select2 = new Select(e2);
            select2.selectByValue("0");
            //预约操作
            WebElement e3 = driver.findElement(
                    By.xpath(xpath3));
            JavascriptExecutor jsEx = (JavascriptExecutor) driver;
            jsEx.executeScript("arguments[0].click();", e3);
            System.out.println("Hello!! 线程1结束时间：" + new Date().toString());
        }).start();
        new Thread(() -> {
            long l1 = System.currentTimeMillis();
            System.out.println("Hello!! 线程2开启时间：" + new Date().toString());
            String myUrl = "http://m.5read.com/914?backurl=http%3A%2F%2Fmc.m.5read" +
                    ".com%2Fweixin%2FuserBind1_viewForwordCookie.jspx%3Freal" +
                    "Url%3Dhttp%253A%252F%252Fmc.m.5read.com%252Fweixin%252F" +
                    "userBind1_viewProxySn.jspx%253FwxProductId%253D26%2526ba" +
                    "ckUrl%253Dhttp%25253a%25252f%25252fseat.lib.xauat.edu.cn%2" +
                    "5252fssLogin%2526openid%253DoOVSot4wkoI_-syS0j6QNxcwhz7" +
                    "k%26ubId%3D4915854";
            WebDriver driver = new ChromeDriver();
            driver.manage().window().setPosition(new Point(500,0));
            driver.manage().window().setSize(new Dimension(150,600));
            String xpath1 = "//*[@id=\"app\"]/div/div[2]/div[1]/div[2]" +
                    "/div/div[1]/div[2]/select";
            String xpath2 = "//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/" +
                    "div/div[3]/div[2]/select";
            String xpath3 = "//*[@id=\"app\"]/div/div[2]/div[1]/div[4]/button";
            driver.get(myUrl);

            //下面两行智能等待网络时间
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
            System.out.println("Hello!! 线程2网络加载时间：" + (System.currentTimeMillis() - l1) + "毫秒");
            System.out.println("Hello!! 线程链接到URl：" + new Date().toString());
            //选择自习区域
            WebElement e1 = driver.findElement(
                    By.xpath(xpath1));
            Select select1 = new Select(e1);
            select1.selectByValue("9");
            //选择自习上午还是下午
            WebElement e2 = driver.findElement(
                    By.xpath(xpath2));
            Select select2 = new Select(e2);
            select2.selectByValue("1");
            //预约操作
            WebElement e3 = driver.findElement(
                    By.xpath(xpath3));
            JavascriptExecutor jsEx = (JavascriptExecutor) driver;
            jsEx.executeScript("arguments[0].click();", e3);
            System.out.println("Hello!! 线程2结束时间：" + new Date().toString());
        }).start();
    }
}
