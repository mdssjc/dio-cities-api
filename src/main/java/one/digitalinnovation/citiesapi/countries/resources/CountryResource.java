package one.digitalinnovation.citiesapi.countries.resources;

import one.digitalinnovation.citiesapi.countries.entities.Country;
import one.digitalinnovation.citiesapi.countries.repositories.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Endpoints para o gerenciamento da entidade {@link Country}.
 *
 * @author Marcelo dos Santos
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/countries")
public class CountryResource {

    private final CountryRepository repository;

    @GetMapping
    public List<Country> countries() {
        return repository.findAll();
    }
}
