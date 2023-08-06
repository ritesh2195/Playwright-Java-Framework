package Utilities;

import com.microsoft.playwright.*;

import java.nio.file.Paths;
import java.util.Base64;
import java.util.Properties;

public class BrowserFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
    private static ThreadLocal<Page> tlPage = new ThreadLocal<>();
    private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();

    public static Playwright getPlaywright() {
        return tlPlaywright.get();
    }

    public static Browser getBrowser() {
        return tlBrowser.get();
    }

    public static BrowserContext getBrowserContext() {
        return tlBrowserContext.get();
    }

    public static Page getPage() {
        return tlPage.get();
    }

    public Page initBrowser() {

        String browserName = ConfigReader.getInstance().getBrowser();

        tlPlaywright.set(Playwright.create());

        switch (browserName.toLowerCase()) {

            case "chromium":
                tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "firefox":
                tlBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "safari":
                tlBrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "chrome":
                tlBrowser.set(
                        getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)));
                break;
            case "edge":
                tlBrowser.set(
                        getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false)));
                break;

            default:
                System.out.println("please pass the right browser name......");
                break;
        }

        tlBrowserContext.set(getBrowser().newContext());

        tlPage.set(getBrowserContext().newPage());

        getPage().navigate(ConfigReader.getInstance().getURL());

        return getPage();
    }

    public static String takeScreenshot() {
        String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";

        byte[] buffer = getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));

        String base64Path = Base64.getEncoder().encodeToString(buffer);

        return base64Path;
    }
}
