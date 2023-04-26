/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2;

/**
 *
 * @author grupo 8
 */
public class Pronostico {
   //atributos
   private int idPronostico;
   private Equipo equipo;
   private Partido partido;
   private char resultado;

   public Pronostico(int idPronostico, Equipo equipo, Partido partido, char resultado) {
      this.idPronostico = idPronostico;
      this.equipo = equipo;
      this.partido = partido;
      this.resultado = resultado;
   }
public Pronostico() {      
   }

  

   public Equipo getEquipo() {
      return equipo;
   }

   public void setEquipo(Equipo equipo) {
      this.equipo = equipo;
   }

   public Partido getPartido() {
      return partido;
   }

   public void setPartido(Partido partido) {
      this.partido = partido;
   }

   public char getResultado() {
      return resultado;
   }

   public void setResultado(char resultado) {
      this.resultado = resultado;
   }

   public void setIdPronostico(int idPronostico) {
      this.idPronostico = idPronostico;
   }

   public int getIdPronostico() {
      return idPronostico;
   }

  
 
   @Override
   public String toString() {
      return "Pronostico{" + "idPronostico=" + idPronostico + ", equipo=" + equipo + ", partido=" + partido + ", resultado=" + resultado + '}';
   }
   
}
