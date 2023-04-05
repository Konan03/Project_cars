package com.project.coches.domain.service;

import com.project.coches.domain.pojo.BrandCarPojo;

import java.util.List;
import java.util.Optional;

public interface IBrandCarService {

    /**
     * devuelve una lista con todas las marcas de coches
     * @return la lista con marcas de coches
     */
    List<BrandCarPojo> getAll();

    /**
     * devuelve una marca de coche dada su id
     * @param id Id de marca coche
     * @return Optional del marca coche encontrado
     */
    Optional<BrandCarPojo> getBrandCar(Integer id);

    /**
     * guarda una nueva marca coche
     * @param newBrandCar marca coche a guardar
     * @return marca coche guardada
     */
    BrandCarPojo save (BrandCarPojo newBrandCar);

    /**
     * elimina una marca coche dada su id
     * @param idBrandCar Id del marca coche a eliminar
     */
    boolean delete (Integer idBrandCar);
}
