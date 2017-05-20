package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.relevantcodes.extentreports.LogStatus;

import abstractClasses.BasePageObject;

public class CheckoutPage extends BasePageObject {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	 @FindBy(how = How.CSS, using = "#shipping_method_0_flat_rate9[name='shipping_method[0]']")
	 private WebElement FlatRate;
	 
	 @FindAll(@FindBy(how = How.CSS, using = "ul.wc_payment_methods li"))
	 private List<WebElement> PaymentMethods;	
	 
	 @FindBy(how = How.CSS, using = "#ship-to-different-address-checkbox")
	 private WebElement ShipToDifferetAddress;
	 
	 @FindBy(how = How.CSS, using = "#terms.input-checkbox")
	 private WebElement TermsAndCondition;
	 
	 @FindBy(how = How.CSS, using = "#place_order")
	 private WebElement PlaceOrder;
	 
	 public void Select_FlatRate(){
		 FlatRate.click();
		 report.log(LogStatus.INFO, "Selected FlatRate Delivery on Checkout Page");
	 }
	 
	 public void Check_ShipToDifferentAddress(){
		 if(!ShipToDifferetAddress.isSelected()) ShipToDifferetAddress.click();
		 report.log(LogStatus.INFO, "Checkbox Checked for Ship To Differet Address on Checkout Page");
	 }
	 
	 public void UnCheck_ShipToDifferentAddress(){
		 if(ShipToDifferetAddress.isSelected()) ShipToDifferetAddress.click();
		 report.log(LogStatus.INFO, "Checkbox UnChecked for Ship To Differet Address on Checkout Page");
	 }
	 
	 public void Select_Payment(int paymentMethod){
		 switch (paymentMethod){
		 case 0: PaymentMethods.get(paymentMethod).click();
		 report.log(LogStatus.INFO, "Check Payment method is Selected on Checkout Page");
		 break;
		 case 1: PaymentMethods.get(paymentMethod).click();
		 report.log(LogStatus.INFO, "Cash Payment method is Selected on Checkout Page");
		 break;
		 }
	 }
	 
	 public void Check_TermsAndCondition(){
		 TermsAndCondition.click();
		 report.log(LogStatus.INFO, "Checked Terms And Condition on Checkout Page");
	 }
	 
	 public void ClickOn_PlaceOrder(){
		 PlaceOrder.click();
		 report.log(LogStatus.INFO, "Clicked on Place Order on Checkout Page");
	 }

}
