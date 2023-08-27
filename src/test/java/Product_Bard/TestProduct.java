package Product_Bard;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClass2;

public class TestProduct extends BaseClass2 {

	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		return eutil.readMultipleDataFromExcelSheet("ProductData");
	}

	@Test(dataProvider = "getData")
	public void createProduct(String PNAME, String PDESC, String PPRICE) {

		d.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
		d.findElement(By.id("productName")).sendKeys(PNAME);
		d.findElement(By.id("")).sendKeys(PDESC);
		d.findElement(By.id("productPrice")).sendKeys(PPRICE);
		d.findElement(By.xpath("//button[normalize-space()='Submit']")).click();

	}
}
