package celltrak.challenge.dataproviders;

import celltrak.challenge.model.RepositorySearchParam;
import celltrak.challenge.test.BaseTest;
import java.io.*;
import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;
import com.google.gson.Gson;

/**
 * Created by nicolaslopez82.
 */

public class AdminDataProviderGSON extends BaseTest{

    protected static String current_dir = System.getProperty("user.dir")+File.separator +
            "src" +
            File.separator +
            "test" +
            File.separator +
            "resources" +
            File.separator +
            "testdata";

    protected AdminDataProviderGSON() {}

    /**
     *
     * @param method
     * @return
     */
    @DataProvider(name="PositiveTestScenarios")
    public static Object[][] fetchPositiveTestData(Method method)
    {
        return new Object[][]{{GSONFromFileToRepositorySearchParam(method.getName())}};
    }

    /**
     * Read from a JSON file identifying the file through method Name.
     * @param methodName
     * @return
     */
    private static RepositorySearchParam GSONFromFileToRepositorySearchParam(String methodName){
        Gson gson = new Gson();
        RepositorySearchParam repositorySearchParam = new RepositorySearchParam();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(current_dir + File.separator  + methodName + ".json"));
            repositorySearchParam = gson.fromJson(bufferedReader, RepositorySearchParam.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return repositorySearchParam;
    }
}
