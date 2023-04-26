/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2;

/**
 *
 * @author grupo 8
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaPartidos {

   //atributos
   private List<Partido> partidos;
   private String partidosCSV;

   //metodos
   public ListaPartidos(List<Partido> partidos, String partidosCSV) {
      this.partidos = partidos;
      this.partidosCSV = partidosCSV;
   }

   public ListaPartidos() {
      this.partidos = new ArrayList<Partido>();
      this.partidosCSV = "D:\\A_CURSO_BIG-DATA\\A-UTN-JAVA\\NetBeansProjects\\TP\\src\\tp2\\partidos.csv";
   }

   public List<Partido> getPartidos() {
      return partidos;
   }

   public void setPartidos(List<Partido> partidos) {
      this.partidos = partidos;
   }

   public String getPartidosCSV() {
      return partidosCSV;
   }

   public void setPartidosCSV(String partidosCSV) {
      this.partidosCSV = partidosCSV;
   }

   @Override
   public String toString() {
      return "ListaPartidos{" + "partidos= " + partidos +"/n"+ ", partidosCSV= " + partidosCSV + '}'+"/n";
   }

   //*****
   // add y remove elementos
   public void addPartido(Partido p) {
      this.partidos.add(p);
   }

   public void removePartido(Partido p) {
      this.partidos.remove(p);
   }

   public Partido getPartido(int idPartido) {

      Partido encontrado = null;

      for (Partido pa : this.getPartidos()) {

         if (pa.getIdPartido() == idPartido) {
            encontrado = pa;
            break;
         }
      }
      return encontrado;
   }

   public String listar() {
      String lista = "";
      for (Partido partido : partidos) {
         lista += "\n" + partido;
      }
      return lista;
   }

   public void cargarDeArchivo(ListaEquipos equipos) {

      String datosPartido;

      String vectorPartido[];

      Partido partido;
      int fila = 0;

      try {
         Scanner sc = new Scanner(new File(this.getPartidosCSV()));
         //this.getPartidosCSV()));
         sc.useDelimiter("\n");

         while (sc.hasNext()) {

            datosPartido = sc.next();

            fila++;

            if (fila == 1) {
               continue;
            }

            vectorPartido = datosPartido.split(",");

            // graba el equipo en memoria
            //convertir un string a un entero;
            int idPartido = Integer.parseInt(vectorPartido[0]);
            int idEquipo1 = Integer.parseInt(vectorPartido[1]);
            int idEquipo2 = Integer.parseInt(vectorPartido[2]);
            int golesEquipo1 = Integer.parseInt(vectorPartido[3]);
            int golesEquipo2 = Integer.parseInt(vectorPartido[4]);
            Equipo equipo1 = equipos.getEquipo(idEquipo1);
            Equipo equipo2 = equipos.getEquipo(idEquipo2);
            // crea el objeto en memoria
            partido = new Partido(idPartido, equipo1, equipo2, golesEquipo1, golesEquipo2);
            // equipo1, equipo2, golesEquipo1, golesEquipo2)
            //idEquipo1 , idEquipo2, golesEquipo1, golesEquipo2);

            // llama al metodo add para grabar el equipo en la lista en memoria
            this.addPartido(partido);
         }
         //closes the scanner
      } catch (IOException ex) {
         System.out.println("Mensaje: " + ex.getMessage());
      }

   }

}
