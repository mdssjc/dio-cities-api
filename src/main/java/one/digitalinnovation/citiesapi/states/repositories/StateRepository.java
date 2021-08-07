package one.digitalinnovation.citiesapi.states.repositories;

import one.digitalinnovation.citiesapi.states.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório para a entidade {@link State}.
 *
 * @author Marcelo dos Santos
 */
public interface StateRepository extends JpaRepository<State, Long> {

}
