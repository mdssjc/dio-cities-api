package one.digitalinnovation.citiesapi;

import com.intuit.karate.junit5.Karate;

/**
 * Início dos testes de QA.
 *
 * @author Marcelo dos Santos
 */
public class QaTest {

  @Karate.Test
  Karate testAll() {
    return Karate.run().relativeTo(getClass());
  }
}
