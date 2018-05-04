package tests.iOS;

import commons.iOS.Commons;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import commons.iOS.SetUp;

public class SignUpTest extends SetUp {


    
    Commons common ;

    @BeforeClass
    public void setUp() throws Exception {
        createIosSession();
    }

    @Test
    public void firstTest() {

        // Write Code to Test SignUp
    }
}


