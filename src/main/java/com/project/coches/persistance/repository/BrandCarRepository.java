package com.project.coches.persistance.repository;

import com.project.coches.domain.pojo.BrandCarPojo;
import com.project.coches.domain.repository.IBrandCarRepository;
import com.project.coches.persistance.entity.BrandCarEntity;
import com.project.coches.persistance.mapper.IBrandCarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * repositorio de marca coche
 */
@RequiredArgsConstructor // crea constructor con los atributos final
@Repository
public class BrandCarRepository implements IBrandCarRepository {

    /**
     * crud de marca coche
     */
    private final IBrandCarCrudRepository iBrandCarCrudRepository;

    /**
     * mapper de marca coche
     */
    private final IBrandCarMapper iBrandCarMapper;


    /**
     * devuelve una lista con todas las marcas de coches
     * @return la lista con marcas de coches
     */
    @Override
    public List<BrandCarPojo> getAll() {
        return iBrandCarMapper.toMarcasCochePojo(iBrandCarCrudRepository.findAll());
    }

    /**
     * devuelve una marca de coche dada su id
     * @param id Id de marca coche
     * @return Optional del marca coche encontrado
     */
    @Override
    public Optional<BrandCarPojo> getBrandCar(Integer id) {
        return iBrandCarCrudRepository.findById(id)
                .map(iBrandCarMapper::toMarcaCochePojo);
        //brandCarEntity -> iBrandCarMapper.toMarcaCochePojo(brandCarEntity) - lambda
        //iBrandCarMapper::toMarcaCochePojo - por referencia
    }

    /**
     * guarda una nueva marca coche
     * @param newBrandCar marca coche a guardar
     * @return marca coche guardada
     */
    @Override
    public BrandCarPojo save(BrandCarPojo newBrandCar) {
        BrandCarEntity brandCarEntity = iBrandCarMapper.toMarcaCocheEntity(newBrandCar);
        return iBrandCarMapper.toMarcaCochePojo(iBrandCarCrudRepository.save(brandCarEntity));
    }

    /**
     * elimina una marca coche dada su id
     * @param idBrandCar Id del marca coche a eliminar
     */
    @Override
    public void delete(Integer idBrandCar) {
        iBrandCarCrudRepository.deleteById(idBrandCar);
    }
}
