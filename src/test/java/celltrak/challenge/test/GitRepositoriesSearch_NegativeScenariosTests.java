package celltrak.challenge.test;

import celltrak.challenge.dataproviders.AdminDataProviderGSON;
import celltrak.challenge.extentreport.ExtentTestManager;
import celltrak.challenge.model.RepositorySearchParam;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/**
 * Created by nicolaslopez82.
 */

public class GitRepositoriesSearch_NegativeScenariosTests extends BaseTest{

    private GitRepositoriesSearch_NegativeScenariosTests() {
        super();
    }

    /**
     * @param repositorySearchParam
     */
    @Test(dataProvider="PositiveTestScenarios", dataProviderClass = AdminDataProviderGSON.class)
    public void TC4_RepoSearch_UserGoogleTypeRepoSortCreatedOrderDescPage1000PerPage50_ExpectedMessageError(RepositorySearchParam repositorySearchParam){

        ExtentTestManager.getTest().log(LogStatus.INFO, "Base URI", RestAssured.baseURI);
        ExtentTestManager.getTest().log(LogStatus.INFO, "Path", super.buildPath(repositorySearchParam).toString());

        Response response = (Response) given()
                .contentType(ContentType.JSON)
                    .queryParam("q", repositorySearchParam.getQ())
                    .queryParam("type", repositorySearchParam.getType())
                    .queryParam("sort", repositorySearchParam.getSort())
                    .queryParam("order", repositorySearchParam.getOrder())
                    .queryParam("page", repositorySearchParam.getPage())
                    .queryParam("per_page", repositorySearchParam.getPer_page())
                .when()
                    .get(RestAssured.baseURI)
                .then()
                    .assertThat()
                    .statusCode(422)
                    .and()
                    .body("message", equalTo("Only the first 1000 search results are available"))
                .extract();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Body", response.body().prettyPrint());
    }

    /**
     * @param repositorySearchParam
     */
    @Test(dataProvider="PositiveTestScenarios", dataProviderClass = AdminDataProviderGSON.class)
    public void TC5_RepoSearch_UserLanguageSortStarsOrderDescPage1PerPage5_Expected422Code(RepositorySearchParam repositorySearchParam) {

        ExtentTestManager.getTest().log(LogStatus.INFO, "Base URI", RestAssured.baseURI);
        ExtentTestManager.getTest().log(LogStatus.INFO, "Path", super.buildPath(repositorySearchParam).toString());

        Response response = (Response) given()
                .contentType(ContentType.JSON)
                    .queryParam("q", repositorySearchParam.getQ())
                    .queryParam("type", repositorySearchParam.getType())
                    .queryParam("sort", repositorySearchParam.getSort())
                    .queryParam("order", repositorySearchParam.getOrder())
                    .queryParam("page", repositorySearchParam.getPage())
                    .queryParam("per_page", repositorySearchParam.getPer_page())
                .when()
                    .get(RestAssured.baseURI)
                .then()
                    .assertThat()
                    .statusCode(422)
                    .and()
                    .body("message", equalTo("Validation Failed"))
                .extract();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Body", response.body().prettyPrint());
    }
}
