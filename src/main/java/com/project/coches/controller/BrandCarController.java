package com.project.coches.controller;

import com.project.coches.domain.pojo.BrandCarPojo;
import com.project.coches.domain.service.IBrandCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * controlador rest de marca coche
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/marcas-coches")
public class BrandCarController {

    /**
     * servicio de marca coche
     */
    private final IBrandCarService iBrandCarService;

    /**
     * devuelve lista de marcas coche
     * @return hhtcode OK con lista de marcas coche
     */
    @GetMapping()
    public ResponseEntity<List<BrandCarPojo>> gettAll(){
        //return new ResponseEntity.ok(iBrandCarService.getAll()); otra alternativa
        return ResponseEntity.status(HttpStatus.OK).body(iBrandCarService.getAll());
        //return new ResponseEntity<>(iBrandCarService.getAll(), HttpStatus.OK); segunda opcion para crear in response entity
    }

    /**
     *devuelve una marca coche dada su id
     * @param id Ide de la marca coche a buscar
     * @return httpcode OK si la encuentr, httpcode nor found de lo contrario
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<BrandCarPojo> getBrandCar(@PathVariable Integer id){
        return ResponseEntity.of(iBrandCarService.getBrandCar(id));
    }

    /**
     *crea una nueva marca coche
     * @param brandCarPojoNew marca coche a crear
     * @return httpcode Create si la guarda correctamente, httpcode BadRequest de lo contrario
     */
    @PostMapping
    public ResponseEntity<BrandCarPojo> save(@RequestBody BrandCarPojo brandCarPojoNew){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iBrandCarService.save(brandCarPojoNew));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     *  actualiza una marca coche
     * @param brandCarPojoUpdate marca coche actualizada
     * @return httpcode OK si la actualiza correctamente
     */
    @PatchMapping
    public ResponseEntity<BrandCarPojo> update(@RequestBody BrandCarPojo brandCarPojoUpdate){
        return ResponseEntity.of(iBrandCarService.update(brandCarPojoUpdate));
    }

    /**
     * elimina una marca coche dada su id
     * @param id Id de la marca coche a eliminar
     * @return httpcode OK si la elimina, httpcode httpcode sino existe
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        return new ResponseEntity<>(this.iBrandCarService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND );
    }
}
