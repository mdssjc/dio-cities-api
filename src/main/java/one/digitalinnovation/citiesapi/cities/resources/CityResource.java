package one.digitalinnovation.citiesapi.cities.resources;

import one.digitalinnovation.citiesapi.cities.entities.City;
import one.digitalinnovation.citiesapi.cities.repositories.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Endpoints para o gerenciamento da entidade {@link City}.
 *
 * @author Marcelo dos Santos
 */
@RequiredArgsConstructor
@RequestMapping("/api/v1/cities")
@RestController
public class CityResource {

  private final CityRepository repository;

  @GetMapping
  public Page<City> cities(final Pageable page) {
    return repository.findAll(page);
  }
}
