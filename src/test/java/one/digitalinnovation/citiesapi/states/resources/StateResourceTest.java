package one.digitalinnovation.citiesapi.states.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import one.digitalinnovation.citiesapi.countries.entities.Country;
import one.digitalinnovation.citiesapi.states.entities.State;
import one.digitalinnovation.citiesapi.states.repositories.StateRepository;
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
 * Teste do endpoint de {@link State}.
 *
 * @author Marcelo dos Santos
 */
@WebMvcTest(StateResource.class)
class StateResourceTest {

  @MockBean
  StateRepository repository;

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper mapper;

  @Test
  void shouldReturnCountries() throws Exception {
    Country brazil = new Country(1L, "Brazil", "Brasil", "BR", 1058);
    List<State> states = Arrays.asList(
        new State(26L, "São Paulo", "SP", 35, brazil, Arrays.asList(11, 12, 13, 14, 15, 16, 17, 18, 19)),
        new State(11L, "Minas Gerais", "MG", 31, brazil, Arrays.asList(34, 37, 31, 33, 35, 38, 32)));
    given(repository.findAll()).willReturn(states);

    mockMvc.perform(get("/api/v1/states"))
           .andExpect(status().isOk())
           .andExpect(content().json(mapper.writeValueAsString(states)))
           .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    then(repository).should().findAll();
  }
}
