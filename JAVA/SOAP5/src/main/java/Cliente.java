import localhost.soap.miservicio.Miservicio;
import localhost.soap.miservicio.MiservicioPortType;

import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        Miservicio serv = new Miservicio();
        MiservicioPortType puerto = serv.getMiservicioPort();

        Scanner leer = new Scanner (System.in);

        System.out.println("Ingresa la primera palabra");
        String pal1 = leer.next();
        System.out.println("Ingresa la segunda palabra");
        String pal2 = leer.next();
        System.out.println("Ingresa la Tecera palabra");
        String pal3 = leer.next();
        System.out.println("Ingresa la cuarta palabra");
        String pal4 = leer.next();
        System.out.println("Ingresa la quinta palabra");
        String pal5 = leer.next();


        String respuesta  = puerto.devolverMensaje(pal1,pal2,pal3,pal4,pal5);
        System.out.println(respuesta);

    }
}
