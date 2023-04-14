/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda1.Tienda1.entily;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author aldav
 */
@Entity
@Table(name = "paises")
public class Pais implements Serializable {

    @Id  /*Aqui se indica que va hacer el Id , primate key*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)  /*Lo que hace esta linea es para indicarle que es auto incremento ID*/
    private long id;
    private String pais;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

}
