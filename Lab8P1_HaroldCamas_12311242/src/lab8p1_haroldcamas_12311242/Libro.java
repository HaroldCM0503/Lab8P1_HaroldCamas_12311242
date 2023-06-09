/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab8p1_haroldcamas_12311242;

public class Libro {
    String titulo;
    String autor;
    int año;
    
    Libro(){}
    
    Libro(String tituloN, String autorN, int añoN){
        this.titulo = tituloN;
        this.autor = autorN;
        this.año = añoN;
    }
    
    //Getters
    public String getTitulo(){
        return this.titulo;
    }
    public String getAutor(){
        return this.autor;
    }
    public int getAño(){
        return this.año;
    }
    
    //Setter
    public void setTitulo(String tituloN){
        this.titulo = tituloN;
    }
    
    public void setAutor(String autorN){
        this.autor = autorN;
    }
    
    public void setAño(int añoN){
        this.año = añoN;
    }
}
