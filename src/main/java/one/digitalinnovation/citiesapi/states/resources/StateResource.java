package one.digitalinnovation.citiesapi.states.resources;

import one.digitalinnovation.citiesapi.states.entities.State;
import one.digitalinnovation.citiesapi.states.repositories.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Endpoints para o gerenciamento da entidade {@link State}.
 *
 * @author Marcelo dos Santos
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/states")
public class StateResource {

    private final StateRepository repository;

    @GetMapping
    public List<State> states() {
        return repository.findAll();
    }
}
