package one.digitalinnovation.citiesapi.countries.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import one.digitalinnovation.citiesapi.countries.entities.Country;
import one.digitalinnovation.citiesapi.countries.repositories.CountryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Teste do endpoint de {@link Country}.
 *
 * @author Marcelo dos Santos
 */
@WebMvcTest(CountryResource.class)
class CountryResourceTest {

    @MockBean
    CountryRepository repository;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    void shouldReturnCountries() throws Exception {
        List<Country> countries = Arrays.asList(
                new Country(1L, "Brazil", "Brasil", "BR", 1058),
                new Country(225L, "United States", "Estados Unidos", "US", 2496));
        given(repository.findAll()).willReturn(countries);

        mockMvc.perform(get("/api/v1/countries"))
               .andExpect(status().isOk())
               .andExpect(content().json(mapper.writeValueAsString(countries)))
               .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        then(repository).should().findAll();
    }
}
