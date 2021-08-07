package one.digitalinnovation.citiesapi.countries.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Representa a entidade de País no sistema.
 *
 * @author Marcelo dos Santos
 */
@Getter
@NoArgsConstructor
@Entity(name = "Country")
@Table(name = "pais")
public class Country {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "nome_pt")
    private String portugueseName;

    @Column(name = "sigla")
    private String code;

    private Integer bacen;
}
