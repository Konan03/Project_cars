package com.project.coches.domain.service;

import com.project.coches.domain.pojo.BrandCarPojo;
import com.project.coches.domain.repository.IBrandCarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * servicio de marcha coche
 */
@RequiredArgsConstructor
@Service
public class BrandCardService implements IBrandCarService{

    /**
     * repositorio de marca coche
     */
    private final IBrandCarRepository iBrandCarRepository;

    /**
     * devuelve una lista con todas las marcas de coches
     * @return la lista con marcas de coches
     */
    @Override
    public List<BrandCarPojo> getAll() {
        return iBrandCarRepository.getAll();
    }

    /**
     * devuelve una marca de coche dada su id
     * @param id Id de marca coche
     * @return Optional del marca coche encontrado
     */
    @Override
    public Optional<BrandCarPojo> getBrandCar(Integer id) {
        return iBrandCarRepository.getBrandCar(id);
    }

    /**
     * guarda una nueva marca coche
     * @param newBrandCar marca coche a guardar
     * @return marca coche guardada
     */
    @Override
    public BrandCarPojo save(BrandCarPojo newBrandCar) {
        return iBrandCarRepository.save(newBrandCar);
    }

    /**
     *
     * @param newBrandCar marca coche a actualizar
     * @return
     */
    @Override
    public BrandCarPojo update(BrandCarPojo newBrandCar) {

        if(iBrandCarRepository.getBrandCar(newBrandCar.getId()).isEmpty()){
            return null;
        }
        return iBrandCarRepository.save(newBrandCar);
    }

    /**
     * elimina una marca coche dada su id
     * @param idBrandCar Id del marca coche a eliminar
     * @return true si borro, false de lo contrario
     */
    @Override
    public boolean delete(Integer idBrandCar) {
        try {
            iBrandCarRepository.delete(idBrandCar);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
