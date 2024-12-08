package ScenarioDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:Features", // Chemin vers vos fichiers .feature
        glue = "ScenarioDefinitions", // Package contenant les définitions des étapes
        strict = true
)
public class Test_Runner {
}
