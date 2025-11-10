/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.Stack;
import Modelo.Postulante;
/**
 *
 * @author LENOVO
 */
public class Empresa {
    private Postulante estudiantesPre[];
    private String nombre;
    private String especBloq;

    public Empresa(String nombre, String especBloq ) {
        this.estudiantesPre = new Postulante [20]; 
        this.nombre = nombre;
        this.especBloq = especBloq;
    }

    public Postulante[] getEstudiantesPre() {
        return estudiantesPre;
    }

    public void setEstudiantesPre(Postulante[] estudiantesPre) {
        this.estudiantesPre = estudiantesPre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecBloq() {
        return especBloq;
    }

    public void setEspecBloq(String especBloq) {
        this.especBloq = especBloq;
    }

    
}
