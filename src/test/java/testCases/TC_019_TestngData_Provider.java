package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_019_TestngData_Provider {
	@Test(dataProvider = "dataSet")
	public void test(String username, String password) {
		System.out.println(username + " ====" + password);
	}

	@DataProvider
	public Object[][] dataSet() {
		return new Object[][] { { "username", "password" }, { "username1", "password1" }, { "username2", "password2" },
				{ "username3", "password3" } };

	}
}
