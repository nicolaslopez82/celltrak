package celltrak.challenge.test;

import celltrak.challenge.model.RepositorySearchParam;
import org.apache.log4j.Logger;
import com.jayway.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

/**
 * Created by nicolaslopez82.
 */

@Listeners(celltrak.challenge.listeners.TestListener.class)
public abstract class BaseTest {

	Logger logger = Logger.getLogger(BaseTest.class);

	@BeforeSuite(alwaysRun = true)
	public void init() {
		logger.info("Before suite method");
		RestAssured.baseURI = "https://api.github.com/search/repositories";
	}

	/**
	 * Setting the path to be logged in ExtentReport.
	 * @param repositorySearchParam
	 * @return
	 */
	protected StringBuilder buildPath(RepositorySearchParam repositorySearchParam){

		StringBuilder path = new StringBuilder();
		path.append(RestAssured.baseURI);
		path.append("?");
		path.append("q=");
		path.append(repositorySearchParam.getQ());
		path.append("&type=");
		path.append(repositorySearchParam.getType());
		path.append("&sort=");
		path.append(repositorySearchParam.getSort());
		path.append("&order=");
		path.append(repositorySearchParam.getOrder());
		path.append("&page=");
		path.append(repositorySearchParam.getPage());
		path.append( "&per_page=");
		path.append(repositorySearchParam.getPer_page());

		return path;
	}
}
