package com.project.coches.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * entidad de marca coche
 */
@Getter
@Setter
@Entity
@Table(name="marca_choche")
public class BrandCarEntity {


    /**
     * id de la marca
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    /**
     * descripcion de la marca
     */
    @Column(name="description")
    private String description;
}
