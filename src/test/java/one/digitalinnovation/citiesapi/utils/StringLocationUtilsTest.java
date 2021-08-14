package one.digitalinnovation.citiesapi.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Teste do utilitário {@link StringLocationUtils}.
 *
 * @author Marcelo dos Santos
 */
class StringLocationUtilsTest {

  @Test
  void shouldExtractGeoLocationsFormString() {
    String geoLocation = "(123, 321)";

    Double[] transform = StringLocationUtils.transform(geoLocation);

    Assertions.assertThat(transform[0]).isEqualTo(123.0);
    Assertions.assertThat(transform[1]).isEqualTo(321.0);
  }
}
