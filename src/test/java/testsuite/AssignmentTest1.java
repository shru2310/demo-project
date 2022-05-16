package testsuite;

import org.testng.annotations.Test;

import facebook.login.FBLoginAndPost;
import utility.BaseClass;

public class AssignmentTest1 extends BaseClass {

	public AssignmentTest1() throws Throwable {
		super();
	}

	FBLoginAndPost fBLoginAndPost = new FBLoginAndPost();

	@Test
	public void testFacebookPost() throws Throwable {
		fBLoginAndPost.navigate(driver);
		fBLoginAndPost.post(driver);
	}

}
