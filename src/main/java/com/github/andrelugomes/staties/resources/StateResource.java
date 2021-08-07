package com.github.andrelugomes.staties.resources;

import com.github.andrelugomes.staties.entities.State;
import com.github.andrelugomes.staties.repositories.StateRepository;
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
@RequestMapping("/states")
public class StateResource {

    private final StateRepository repository;

    @GetMapping
    public List<State> states() {
        return repository.findAll();
    }
}
