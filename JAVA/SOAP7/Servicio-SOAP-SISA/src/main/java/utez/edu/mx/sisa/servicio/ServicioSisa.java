package utez.edu.mx.sisa.servicio;

import utez.edu.mx.sisa.Usuario.controlador.UsuarioController;
import utez.edu.mx.sisa.Usuario.modelo.UsuarioBean;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import java.util.Date;


@WebService(name="ServicioSisa", targetNamespace = "utez")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class ServicioSisa {

    @WebMethod(operationName="consultarUsuario")

    public String consultarUsuario(@WebParam String matricula) {
        UsuarioController acciones = new UsuarioController();
        String bean = acciones.consultarUsuario(matricula);
        return bean;
    }

    @WebMethod(operationName="consultaGeneralUsuario")

        public String consultaGeneralUsuario() {
         String usuarios = "";
        UsuarioController acciones = new UsuarioController();
        usuarios = acciones.consultaGeneralUsuario();
        return usuarios;
    }

    @WebMethod(operationName="insertarUsuario")

    public boolean insertarUsuario(@WebParam(name ="matricula")String matricula, @WebParam(name ="nombre")String nombre,
                                   @WebParam(name ="apellidoP")String apellidoP, @WebParam(name ="apellidoM")String apellidoM,
                                   @WebParam(name ="fechaNac") Date fechaNac, @WebParam(name ="correo")String correo,
                                   @WebParam(name ="telefono")String telefono) {
        boolean bean = false;
        UsuarioController acciones = new UsuarioController();
        bean = acciones.registrarUsuario(matricula,nombre,apellidoP,apellidoM,new java.sql.Date(fechaNac.getTime()), correo,telefono );
        return bean;
    }

    @WebMethod(operationName="actualizarUsuario")

    public boolean actualizarUsuario( @WebParam(name ="nombre")String nombre, @WebParam(name ="apellidoP")String apellidoP,
                                      @WebParam(name ="apellidoM")String apellidoM, @WebParam(name ="fechaNac") Date fechaNac,
                                      @WebParam(name ="correo")String correo, @WebParam(name ="telefono")String telefono,
                                      @WebParam(name ="matricula")String matricula) {
        boolean bean = false;
        UsuarioController acciones = new UsuarioController();
        bean = acciones.actualizarUsuario(nombre,apellidoP,apellidoM,new java.sql.Date(fechaNac.getTime()),correo,telefono,matricula);
        return bean;
    }

    @WebMethod(operationName="eliminarUsuario")

    public boolean eliminarUsuario(@WebParam(name ="matricula")String martricula) {
        boolean bean = false;
        UsuarioController acciones = new UsuarioController();
        bean = acciones.eliminarUsuario(martricula);
        return bean;
    }


    public static void main(String[] args) {
        System.out.println("Iniciando servidor...");
        Endpoint.publish("http://localhost:7000/Servicio", new ServicioSisa());
        System.out.println("Esperando peticion...");

      /*  java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        System.out.println("Con UTIL: "+utilDate);
        System.out.println("Con SQL: "+sqlDate);*/
    }

}
