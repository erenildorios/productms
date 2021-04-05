package br.com.compasso.productms.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;


@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
public class Produto {

    @EqualsAndHashCode.Include
    @Id
    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    @NotNull
    private String name;

    @Column(nullable = false)
    @NotNull
    private String description;

    @Column(nullable = false)
    @NotNull
    @Positive
    private BigDecimal price;
}
