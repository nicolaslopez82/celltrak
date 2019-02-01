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
import static org.testng.Assert.assertNull;
import static org.testng.AssertJUnit.assertNotNull;

/**
 * Created by nicolaslopez82.
 */

public class GitRepositoriesSearch_PositiveScenariosTests extends BaseTest {

    private GitRepositoriesSearch_PositiveScenariosTests() {
        super();
    }

    /**
     * @param repositorySearchParam
     */
    @Test(dataProvider="PositiveTestScenarios", dataProviderClass = AdminDataProviderGSON.class)
        public void TC1_RepoSearch_UserNetflixTypeRepoSortCreatedOrderDescPage1PerPage25_Expected200Code(RepositorySearchParam repositorySearchParam) {

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
                .statusCode(200)
                .and()
                .body("incomplete_results", equalTo(false))
            .extract();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Body", response.body().prettyPrint());
    }

    /**
     * @param repositorySearchParam
     */
    @Test(dataProvider="PositiveTestScenarios", dataProviderClass = AdminDataProviderGSON.class)
    public void TC2_RepoSearch_UserBaeldungTypeRepoSortUpdatedPage1_ExpectedTotalCountGreaterThanOrEqualTo10(RepositorySearchParam repositorySearchParam) {

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
                    .body("total_count", greaterThanOrEqualTo(10))
                .extract();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Body", response.body().prettyPrint());
    }


    /**
     * @param repositorySearchParam
     */
    @Test(dataProvider="PositiveTestScenarios", dataProviderClass = AdminDataProviderGSON.class)
    public void TC3_RepoSearch_UserGoogleTypeRepoSortCreatedOrderDescPage10PerPage50_ExpectedTotalIDsEqualTo100(RepositorySearchParam repositorySearchParam) {

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
                .extract();

        assertNotNull(response.getContentType());
        assertNotNull(response.getCookies());
        assertNull(response.getSessionId());
        assertNotNull(response.getBody());

        ExtentTestManager.getTest().log(LogStatus.INFO, "Body", response.body().prettyPrint());
    }
}
