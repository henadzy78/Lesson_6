import org.testng.annotations.*;


//@Listeners( Listener.class)

public class BaseTest {

    //Before Annotations
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod");
    }

    //After Annotations
    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod");
    }
}
