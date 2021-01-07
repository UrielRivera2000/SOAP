import utez.ServicioSisa;
import utez.ServicioSisaService;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws DatatypeConfigurationException, ParseException {
        ServicioSisaService serv = new ServicioSisaService();
        ServicioSisa puerto = serv.getServicioSisaPort();

        Scanner leer = new Scanner (System.in);
        int opc = 0;

        String matricula = "", nombre="",apellidoP="", apellidoM="",fechaNac="", correo="", telefono="";
        do{
            System.out.println("Tenemos las siguietes opcionees");
            System.out.println("1) Consultar todos los usuarios");
            System.out.println("2) Consultar un usuario en especifico");
            System.out.println("3) Registrar un usuario");
            System.out.println("4) Actualizar un usuario");
            System.out.println("5) Eliminar un usuario");
            System.out.println("0) Salir");
            opc = leer.nextInt();
            switch(opc){
                case 1:
                    System.out.println("----------CONSULTA GENERAL-------");
                    System.out.println("Los usuarios son los siguientes: ");
                    if(puerto.consultaGeneralUsuario() ==  null){
                        System.out.println("No hay registros");
                    }else{
                        System.out.println(puerto.consultaGeneralUsuario());
                    }

                    break;
                case 2:
                    System.out.println("----------CONSULTA ESPECIFICA-------");
                    System.out.println("Ingresa la matricula del usuario a buscar");
                    leer.skip("\n");
                    matricula = leer.nextLine();
                    if(puerto.consultarUsuario(matricula) ==  null){
                        System.out.println("No hay registros con esa matricula");
                    }else{
                        System.out.println(puerto.consultarUsuario(matricula));
                    }

                    break;
                case 3:
                    System.out.println("----------REGISTRAR USUARIO-------");
                    leer.skip("\n");
                    System.out.println("Ingresa la matricula");
                    matricula=leer.nextLine();
                    System.out.println("Ingresa el nombre");
                    nombre= leer.nextLine();
                    System.out.println("Ingresa el apellido paterno");
                    apellidoP = leer.nextLine();
                    System.out.println("Ingresa el apellido materno");
                    apellidoM = leer.nextLine();
                    System.out.println("Ingresa la fecha de nacimiento");
                    fechaNac = leer.nextLine();
                    System.out.println("Ingresa el correo electronico personal");
                    correo = leer.nextLine();
                    System.out.println("Ingresa el telefono");
                    telefono = leer.nextLine();

                    XMLGregorianCalendar fecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(fechaNac);
                    System.out.println(puerto.insertarUsuario(matricula, nombre, apellidoP, apellidoM, fecha.normalize(), correo, telefono));


                    break;
                case 4:
                    System.out.println("----------ACTUALIZAR USUARIO-------");
                    leer.skip("\n");
                    System.out.println("Ingresa la matricula del usuario a modificar");
                    matricula=leer.nextLine();

                    System.out.println("Ingresa el nombre");
                    nombre= leer.nextLine();
                    System.out.println("Ingresa el apellido paterno");
                    apellidoP = leer.nextLine();
                    System.out.println("Ingresa el apellido materno");
                    apellidoM = leer.nextLine();
                    System.out.println("Ingresa la fecha de nacimiento");
                    fechaNac = leer.nextLine();
                    System.out.println("Ingresa el correo electronico personal");
                    correo = leer.nextLine();
                    System.out.println("Ingresa el telefono");
                    telefono = leer.nextLine();
                    XMLGregorianCalendar fechaa = DatatypeFactory.newInstance().newXMLGregorianCalendar(fechaNac);
                    System.out.println(puerto.actualizarUsuario( nombre, apellidoP, apellidoM, fechaa.normalize(), correo, telefono,matricula));


                    break;
                case 5:
                    System.out.println("----------ELIMINAR USUARIO-------");
                    leer.skip("\n");
                    System.out.println("Ingresa la matricula del usuario a eliminar");
                    matricula = leer.nextLine();
                    System.out.println(puerto.eliminarUsuario(matricula));

                    break;
                case 0:

                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Error de opcion");

            }

        }while(opc !=0);













      /*  System.out.println("Ingresa tu nombre");
        String nombre = leer.next();
        System.out.println("Ingresa tu apellido paterno");
        String apellidoP = leer.next();
        System.out.println("Ingresa tu apellido materno");
        String apellidoM = leer.next();
        System.out.println("Ingresa tu fecha de nacimiento");
        String fecha_nac = leer.next();
        System.out.println("Ingresa tu sexo");
        String sexo = leer.next();
        System.out.println("Ingresa tu estado");
        String estado = leer.next();*/

/*SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
Date fechaj = sdf.parse(fecha_nac);

java.util.Date sqlDate = new java.util.Date(fechaj.getTime());*/

      //  XMLGregorianCalendar fecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(fecha_nac);
        // System.out.println(fecha.toString());


      /*  String respuesta  = puerto.consultarCurp(nombre,apellidoP,apellidoM,fecha.normalize(),sexo,estado);
        System.out.println(respuesta); */

    }
}
