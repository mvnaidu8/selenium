package in.mvnaidu.java.maven.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.BeforeTest;

public class ExtentReportsTest {
	ExtentReports extent;
	@BeforeTest
	public void config() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Extent Reports Test");
		reporter.config().setDocumentTitle("Doc Title");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA Engineer", "Venkat");
	}

	@Test
	public void TestMeth1() {
		/*
		 * ExtentTest test = extent.createTest("TestMeth1"); test.fail("Fail");
		 */
		System.out.println("Hello from TestMeth1");
		extent.flush();
		
	}
	@Test
	public void TestMeth2() {
		SoftAssert softAssert = new SoftAssert();
		extent.createTest("TestMeth2");
		softAssert.assertTrue(false);
		System.out.println("TestMeth2 Sysout");
		extent.flush();
	}

}
