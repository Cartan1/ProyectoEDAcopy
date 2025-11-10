/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author LENOVO
 */
public class Postulante {
    private String nombre;
    private float promedioAcademico;
    private float habilidadTecnica;
    private float habilidadBlanda;
    private Postulante compañero;
    private String especialidad;
    private int[] ranking;
    private int postID;
    private boolean acto;
    
    
    public Postulante(String nombre, float promedioAcademico ,Postulante compañero, String especialidad, int[] ranking){
        this.nombre = nombre;
        this.promedioAcademico = promedioAcademico;
        this.habilidadTecnica = 0;
        this.habilidadBlanda = 0;
        this.compañero = compañero;
        this.especialidad = especialidad;
        this.ranking = ranking;
        this.acto = false;
    }
    
    public boolean getActo() {
        return acto;
    }

    public void setActo(boolean acto) {
        this.acto = acto;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPromedioAcademico() {
        return promedioAcademico;
    }

    public void setPromedioAcademico(float promedioAcademico) {
        this.promedioAcademico = promedioAcademico;
    }

    public float getHabilidadTecnica() {
        return habilidadTecnica;
    }

    public void setHabilidadTecnica(float entrevista) {
        this.habilidadTecnica = entrevista;
    }

    public float getHabilidadBlanda() {
        return habilidadBlanda;
    }

    public void setHabilidadBlanda(float habilidadBlanda) {
        this.habilidadBlanda = habilidadBlanda;
    }

    public Postulante getCompañero() {
        return compañero;
    }

    public void setCompañero(Postulante compañero) {
        this.compañero = compañero;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int[] getRanking() {
        return ranking;
    }

    public void setRanking(int[] ranking) {
        this.ranking = ranking;
    }
    
    
    
}
