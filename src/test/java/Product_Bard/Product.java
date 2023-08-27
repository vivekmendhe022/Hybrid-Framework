package Product_Bard;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.generic.utilities.BaseClass2;
import com.object.repository.bard.product.BardHomePage;
import com.object.repository.bard.product.Bard_Product;

public class Product extends BaseClass2 {

	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		return eutil.readMultipleDataFromExcelSheet("ProductData");
	}

	@Test(dataProvider = "getData")
	public void createProduct(String PNAME, String PDESC, String PPRICE) {

		BardHomePage hp = new BardHomePage(d);

		Bard_Product bp = new Bard_Product(d);

//		bp.createProduct(PNAME, PDESC, PPRICE);

	}

	@Test(dataProvider = "getData")
	public void createProduct1(String cred[]) {

		Bard_Product bp = new Bard_Product(d);

		bp.createProduct(cred[0], cred[1], cred[2]);

	}
}
