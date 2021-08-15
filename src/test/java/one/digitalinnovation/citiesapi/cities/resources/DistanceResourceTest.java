package one.digitalinnovation.citiesapi.cities.resources;

import one.digitalinnovation.citiesapi.cities.entities.City;
import one.digitalinnovation.citiesapi.cities.service.DistanceService;
import one.digitalinnovation.citiesapi.cities.service.EarthRadius;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Testes dos endpoints de {@link City}.
 *
 * @author Marcelo dos Santos
 */
@WebMvcTest(DistanceResource.class)
class DistanceResourceTest {

  @MockBean
  DistanceService service;

  @Autowired
  MockMvc mockMvc;

  long ibateId;
  long saoCarlosId;

  @BeforeEach
  void setUp() {
    ibateId = 4929L;
    saoCarlosId = 5254L;
  }

  @Test
  void shouldCalculateByPoints() throws Exception {
    given(service.distanceByPointsInMiles(ibateId, saoCarlosId)).willReturn(7.57102293200459);

    mockMvc.perform(get("/api/v1/distances/by-points")
                        .param("from", "4929")
                        .param("to", "5254"))
           .andExpect(status().isOk())
           .andExpect(content().string("7.57102293200459"));

    then(service).should().distanceByPointsInMiles(ibateId, saoCarlosId);
  }

  @Test
  void shouldCalculateByCube() throws Exception {
    given(service.distanceByCubeInMeters(ibateId, saoCarlosId)).willReturn(12426.810463475855);

    mockMvc.perform(get("/api/v1/distances/by-cube")
                        .param("from", "4929")
                        .param("to", "5254"))
           .andExpect(status().isOk())
           .andExpect(content().string("12426.810463475855"));

    then(service).should().distanceByCubeInMeters(ibateId, saoCarlosId);
  }

  @Test
  void shouldCalculateByMath() throws Exception {
    given(service.distanceUsingMath(ibateId, saoCarlosId, EarthRadius.METERS)).willReturn(12426.810463475855);

    mockMvc.perform(get("/api/v1/distances/by-math")
                        .param("from", "4929")
                        .param("to", "5254")
                        .param("unit", "METERS"))
           .andExpect(status().isOk())
           .andExpect(content().string("12426.810463475855"));

    then(service).should().distanceUsingMath(ibateId, saoCarlosId, EarthRadius.METERS);
  }
}
