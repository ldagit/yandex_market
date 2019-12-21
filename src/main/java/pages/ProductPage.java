package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.Set;

public class ProductPage extends BasePage {

    public static String searchName = "";
    public static String elementCount="";


    @FindBy(xpath = "//h1")
    public WebElement titlePage;

    //@FindBy(id = "glpricefrom")
    @FindBy(name = "Цена от")
    public WebElement priceFrom;

    //@FindBy(id = "glpriceto")
    @FindBy(name = "Цена до")
    public WebElement priceTo;

    @FindBy(xpath = "//*[text()='Производитель']")
    public WebElement tvProducer;

    @FindBy(xpath = "//button[@role='listbox']")
    public WebElement countElementOnPage;

    @FindBy(xpath = "//button[@role='listbox']")
    public WebElement selectedCount;

    @FindBy(id = "header-search")
    public WebElement searchLine;


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
        /*FieldNames arg;
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
        }*/
        switch (fieldName) {
            case "Цена от":
                fillField(priceFrom, value);
                break;
            case "Цена до":
                fillField(priceTo, value);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице.");
        }
    }

    public void selectElementCount(String value){

        countElementOnPage.click();
        BaseSteps.getDriver().findElement(By.xpath("//span[(@class='select__text')][text()='"+value+"']//parent::div")).click();
        elementCount = value;

    }

    public void getSearchElement(){
        fillField(searchLine, BaseSteps.getDriver().findElement(By.xpath("//*[contains(@class, 'n-snippet-list')]/descendant::h3[1]/a")).getText());
        searchName = BaseSteps.getDriver().findElement(By.xpath("//*[contains(@class, 'n-snippet-list')]/descendant::h3[1]/a")).getText();
        /*fillField(searchLine, BaseSteps.getDriver().findElement(By.xpath("//*[@class='n-snippet-list n-snippet-list_type_vertical metrika b-zone b-spy-init b-spy-events i-bem metrika_js_inited snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']/descendant::h3[1]/a")).getText());
        searchName = BaseSteps.getDriver().findElement(By.xpath("//*[@class='n-snippet-list n-snippet-list_type_vertical metrika b-zone b-spy-init b-spy-events i-bem metrika_js_inited snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']/descendant::h3[1]/a")).getText();//searchLine.getText();*/
    }

    public void searchElementClick(){
        Set<String> oldWindowsSet = BaseSteps.getDriver().getWindowHandles();
        BaseSteps.getDriver().findElement(By.xpath("//*[contains(@class, 'n-snippet-list')]/descendant::h3[1]/a")).click();
        Set<String> newWindowsSet = BaseSteps.getDriver().getWindowHandles();
        newWindowsSet.removeAll(oldWindowsSet);
        String newWindowHandle = newWindowsSet.iterator().next();
        BaseSteps.getDriver().switchTo().window(newWindowHandle);
    }

    public int checkElementCount(){
        int i = 0;
        String str;
        do{
            i++;
            str = Integer.toString(i);
        }
        while (isSearchListElementPresent(str));
        i--;
        return i;
    }

    public boolean isSearchListElementPresent(String num) {
        try {
            BaseSteps.getDriver().findElement(By.xpath("//*[contains(@class, 'n-snippet-list')]/descendant::h3[" + num + "]/a"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public enum FieldNames {
        glpricefrom,
        glpriceto;
    }






}
