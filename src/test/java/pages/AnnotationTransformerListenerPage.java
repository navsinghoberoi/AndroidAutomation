package pages;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/*
Using TestNG.xml file to implement retry for test methods mentioned in xml file.
This way is effective because here we dont need to add paramteres in every Test method to run retry method.
Ex of using retry without xml file -- @Test(retryAnalyzer = RetryFailedTestcasesPage.class) for each test method
*/

public class AnnotationTransformerListenerPage implements IAnnotationTransformer {

    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryFailedTestcasesPage.class);
    }
}