package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.AlterarDadosCadastraisTest;
import tests.LoginTest;
import tests.LogoutTest;

@RunWith(Suite.class)
@SuiteClasses({
	
	LoginTest.class,
	LogoutTest.class,
	AlterarDadosCadastraisTest.class
	
})

public class SuiteTests {

	
	
}
