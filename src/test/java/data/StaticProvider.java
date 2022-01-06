package data;

import org.testng.annotations.DataProvider;

public class StaticProvider {

    @DataProvider (name = "dataForDiff")
    public static Object[][] dateForDiffFunction(){
        return new Object[][]{
                {12, -34, 46},
                {6, 9, -3},
                {21, 3, 18},
                {2, -3, 5}
        };
    }
}
