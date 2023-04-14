/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda1.Tienda1.service;

import Tienda1.Tienda1.entily.Pais;
import Tienda1.Tienda1.repository.PaisRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author aldav
 */
 @Service
public class PaisService implements IPaisService {

    @Autowired
    /**
     * hace la union de server y repository es oara unir objetos*
     */
    private PaisRepository paisRepository;

    @Override
    /*Aqui sobre escribimos los metodos*/
    public List<Pais> listCountry() {
        return (List<Pais>) paisRepository.findAll();

    }

}
