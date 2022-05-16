package testsuite;

import org.testng.annotations.Test;

import utility.BaseClass;
import walletHub.WHubReview;

public class AssignmentTest2 extends BaseClass {

	WHubReview wHubReview = new WHubReview();

	public AssignmentTest2() throws Throwable {
		super();
	}

	@Test
	public void testWalletHubReview() throws Throwable {
		wHubReview.walletHubReview(driver);
	}
}
