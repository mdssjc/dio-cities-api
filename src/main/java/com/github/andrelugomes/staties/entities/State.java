package com.github.andrelugomes.staties.entities;

import com.github.andrelugomes.countries.entities.Country;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;

/**
 * Representa a entidade de Estado no sistema.
 *
 * @author Marcelo dos Santos
 */
@Getter
@NoArgsConstructor
@Entity(name = "State")
@Table(name = "estado")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class State {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    private String uf;

    private Integer ibge;

    @ManyToOne
    @JoinColumn(name = "pais", referencedColumnName = "id")
    private Country country;

    @Type(type = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ddd", columnDefinition = "jsonb")
    private List<Integer> ddd;
}
