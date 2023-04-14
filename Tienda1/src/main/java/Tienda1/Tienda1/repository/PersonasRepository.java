/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda1.Tienda1.repository;

import Tienda1.Tienda1.entily.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aldav
 */
@Repository
/* Definimos que tipo de clase o como se va a conportar*/
public interface PersonasRepository extends CrudRepository<Persona, Long> {/*Se encarga de ir hacer la consulta a la base de datos*/
 /* elimina */
}
