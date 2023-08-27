package organization;

import org.testng.annotations.Test;

import com.generic.utilities.BaseClass;

public class CreateNewOrganizationTest extends BaseClass{

	@Test(invocationCount = 3)
	public void createNewOrgTest() {
		System.out.println("Done");
	}
}
