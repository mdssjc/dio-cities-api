package com.github.andrelugomes.staties.repositories;

import com.github.andrelugomes.staties.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório para a entidade {@link State}.
 *
 * @author Marcelo dos Santos
 */
public interface StateRepository extends JpaRepository<State, Long> {

}
