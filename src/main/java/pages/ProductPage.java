package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.Set;

public class ProductPage extends BasePage {

    public static String searchName = "";


    @FindBy(xpath = "//h1") //"//div[contains(@class, 'headline__header-title')]//*[contains(text(),'Телевизоры')]")
    public WebElement titlePage;

    @FindBy(id = "glpricefrom")
    public WebElement priceFrom;

    @FindBy(id = "glpriceto")
    public WebElement priceTo;

    @FindBy(xpath = "//*[text()='Производитель']")
    public WebElement tvProducer;

    @FindBy(xpath = "//button[@role='listbox']")
    public WebElement countElementOnPage;

    @FindBy(xpath = "//button[@role='listbox']") //"//div[@class='select__item select__item_selected_yes']//span") //
    public WebElement selectedCount;

    @FindBy(id = "header-search")
    public WebElement searchLine;

    @FindBy(xpath = "//div[@class='n-snippet-list n-snippet-list_type_vertical metrika b-zone b-spy-init b-spy-events i-bem metrika_js_inited snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']")
    public WebElement searchList;


    public ProductPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectTVProducer(String checkBoxName){

        if ( !tvProducer.findElement(By.xpath("//input[@name='"+checkBoxName+"']")).isSelected() )
        {
         tvProducer.findElement(By.xpath("//input[@name='"+checkBoxName+"']")).sendKeys(Keys.SPACE);
        }
    }

    public void fillField (String fieldName, String value){
        FieldNames arg;
        arg = FieldNames.valueOf(fieldName);
        switch (arg) {
            case glpricefrom:
                fillField(priceFrom, value);
                break;
            case glpriceto:
                fillField(priceTo, value);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице.");
        }
    }

    public void selectElementCount(String value){

        countElementOnPage.click();
        countElementOnPage.findElement(By.xpath("//span[(@class='select__text')][text()='"+value+"']//parent::div")).click();
    }

    public void getSearchElement(){
        //Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 10, 1000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='n-filter-applied-results metrika b-zone i-bem n-filter-applied-results_js_inited b-zone_js_inited']")));

        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='n-filter-applied-results metrika b-zone i-bem n-filter-applied-results_js_inited b-zone_js_inited']")));
        //wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//div[@class='n-filter-applied-results metrika b-zone i-bem n-filter-applied-results_js_inited b-zone_js_inited']")));

        //wait.until(ExpectedConditions.visibilityOf(searchList.findElement(By.xpath("//*[@class='n-snippet-list n-snippet-list_type_vertical metrika b-zone b-spy-init b-spy-events i-bem metrika_js_inited snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']/descendant::a[2]/img"))));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='n-snippet-list n-snippet-list_type_vertical metrika b-zone b-spy-init b-spy-events i-bem metrika_js_inited snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']/descendant::a[2]/img")));



        fillField(searchLine, titlePage.findElement(By.xpath("//*[@class='n-snippet-list n-snippet-list_type_vertical metrika b-zone b-spy-init b-spy-events i-bem metrika_js_inited snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']/descendant::h3[1]/a")).getText());
        fillField(searchLine, titlePage.findElement(By.xpath("//*[@class='n-snippet-list n-snippet-list_type_vertical metrika b-zone b-spy-init b-spy-events i-bem metrika_js_inited snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']/descendant::h3[1]/a")).getText());

        ProductPage.searchName = searchLine.getText();
    }

    public void searchElementClick(){
        Set<String> oldWindowsSet = BaseSteps.getDriver().getWindowHandles();
        titlePage.findElement(By.xpath("//*[@class='n-snippet-list n-snippet-list_type_vertical metrika b-zone b-spy-init b-spy-events i-bem metrika_js_inited snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']/descendant::h3[1]/a")).click();
        Set<String> newWindowsSet = BaseSteps.getDriver().getWindowHandles();
        newWindowsSet.removeAll(oldWindowsSet);
        String newWindowHandle = newWindowsSet.iterator().next();
        BaseSteps.getDriver().switchTo().window(newWindowHandle);
    }

    public enum FieldNames {
        glpricefrom,
        glpriceto;
    }






}
