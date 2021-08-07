package one.digitalinnovation.citiesapi.countries.repositories;

import one.digitalinnovation.citiesapi.countries.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório para a entidade {@link Country}.
 *
 * @author Marcelo dos Santos
 */
public interface CountryRepository extends JpaRepository<Country, Long> {

}
