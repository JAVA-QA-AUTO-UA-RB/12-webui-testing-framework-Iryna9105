import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

// This test class inherits BasicSetupTest class, where the browser is initialized
// browser variable is available here as it's inherited, so you'll have it available at any place
public class SeleniumTestngTest extends BasicSetupTest {

    private final String URL = "https://the-internet.herokuapp.com/";


    @Test
    public void abTestingPageHasSpecificTextTest() {
        browser.get(URL);
        browser.findElement(By.linkText("A/B Testing"))
                .click();
        WebElement header = browser.findElement(By.cssSelector("div.example h3"));
        String text = header.getText();
        Assert.assertTrue(text.equals("A/B Test Control") || text.equals("A/B Test Variation"), "The text not found");

    }

    @Test
    public void addRemoveElementsTest() {
        browser.get(URL);
        browser.findElement(By.linkText("Add/Remove Elements"))
                .click();
        WebElement addElement = browser.findElement(By.cssSelector("button[onclick='addElement()']"));
        for (int i = 0; i < 3; i++) {
            addElement.click();
        }
        List<WebElement> deleteElements = browser.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        Assert.assertEquals(deleteElements.size(), 3, "There should be 3 buttons.");

        for (WebElement deleteElement : deleteElements) {
            deleteElement.click();
        }

        deleteElements = browser.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        Assert.assertEquals(deleteElements.size(), 0, "The buttons Delete should be removed.");

    }

    @Test
    public void checkboxesTest() {
        browser.get(URL);
        browser.findElement(By.linkText("Checkboxes"))
                .click();
        List<WebElement> checkboxes = browser.findElements(By.cssSelector("input[type='checkbox']"));

        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
        for (WebElement checkbox : checkboxes) {
            Assert.assertTrue(checkbox.isSelected(), "The checkbox must be selected.");
        }

    }

    @Test
    public void dropdownTest() {
        browser.get(URL);
        browser.findElement(By.linkText("Dropdown"))
                .click();
        WebElement dropdown = browser.findElement(By.id("dropdown"));
        dropdown.findElement(By.cssSelector("option[value='2']"))
                .click();
        WebElement selected = browser.findElement(By.cssSelector("option[value='2']:checked"));
        Assert.assertNotNull(selected, "The Option 2 should be selected.");
    }

    @Test
    public void formAuthenticationTest() {
        browser.get(URL);
        browser.findElement(By.linkText("Form Authentication"))
                .click();
        browser.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
        browser.findElement(By.cssSelector("#password")).sendKeys("SuperSecretPassword!");
        browser.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement actualMessage = browser.findElement(By.id("flash"));
        Assert.assertTrue(actualMessage.getText().contains("You logged into a secure area!"), "Login not confirmed.");

        WebElement logout = browser.findElement(By.cssSelector("a[href='/logout']"));
        logout.click();

        String successMessage = browser.findElement(By.cssSelector("#flash")).getText();
        Assert.assertTrue(successMessage.contains("You logged out of the secure area!"));


    }
    @Test
    public void dragAndDropTest() {
        browser.get(URL);
        browser.findElement(By.linkText("Drag and Drop"))
                .click();
        WebElement columnA = browser.findElement(By.cssSelector("#column-a"));
        WebElement columnB = browser.findElement(By.cssSelector("#column-b"));

        Actions actions = new Actions(browser);
        actions.dragAndDrop(columnA, columnB).perform();
        String columnAText = columnA.findElement(By.tagName("header")).getText();
        Assert.assertTrue(columnAText.equals("B"));
    }

    @Test public void horizontalSliderTest() {
        browser.get(URL);
        browser.findElement(By.linkText("Horizontal Slider")).click();

        WebElement slider = browser.findElement(By.cssSelector("input[type='range']"));
        WebElement value = browser.findElement(By.id("range"));

        String initialValue = value.getText();
        Actions actions = new Actions(browser);
        actions.clickAndHold(slider).moveByOffset(30, 0).release().perform();
        String newValue = value.getText();
        Assert.assertNotEquals(initialValue, newValue, "The slider value has not changed.");

    }

}
