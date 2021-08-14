package one.digitalinnovation.citiesapi.cities.resources;

import one.digitalinnovation.citiesapi.cities.entities.City;
import one.digitalinnovation.citiesapi.cities.repositories.CityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.geo.Point;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Testes dos endpoints de {@link City}.
 *
 * @author Marcelo dos Santos
 */
@WebMvcTest(CityResource.class)
class CityResourceTest {

    @MockBean
    CityRepository repository;

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldReturnCitiesPageable() throws Exception {
        City ibate = new City(4929L, "Ibaté", 26, 3519303, "(-21.95840072631836,-47.98820114135742)",
                              new Point(-21.95840072631836, -47.98820114135742));
        City saoCarlos = new City(5254L, "São Carlos", 26, 3548906, "(-22.01740074157715,-47.88600158691406)",
                                  new Point(-22.01740074157715, -47.88600158691406));
        List<City> cities = Arrays.asList(ibate, saoCarlos);
        PageRequest pageable = PageRequest.of(0, 10);
        Page<City> page = new PageImpl<>(cities, pageable, cities.size());
        given(repository.findAll(pageable)).willReturn(page);

        mockMvc.perform(get("/api/v1/cities")
                                .param("page", "0")
                                .param("size", "10"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.content[0].id", is(4929)))
               .andExpect(jsonPath("$.content[1].id", is(5254)))
               .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        then(repository).should().findAll(pageable);
    }
}
