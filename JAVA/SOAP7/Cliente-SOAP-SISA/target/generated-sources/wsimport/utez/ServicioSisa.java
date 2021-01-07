
package utez;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ServicioSisa", targetNamespace = "utez")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ServicioSisa {


    /**
     * 
     * @param fechaNac
     * @param apellidoP
     * @param correo
     * @param matricula
     * @param apellidoM
     * @param telefono
     * @param nombre
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "utez/ServicioSisa/insertarUsuarioRequest", output = "utez/ServicioSisa/insertarUsuarioResponse")
    public boolean insertarUsuario(
        @WebParam(name = "matricula", partName = "matricula")
        String matricula,
        @WebParam(name = "nombre", partName = "nombre")
        String nombre,
        @WebParam(name = "apellidoP", partName = "apellidoP")
        String apellidoP,
        @WebParam(name = "apellidoM", partName = "apellidoM")
        String apellidoM,
        @WebParam(name = "fechaNac", partName = "fechaNac")
        XMLGregorianCalendar fechaNac,
        @WebParam(name = "correo", partName = "correo")
        String correo,
        @WebParam(name = "telefono", partName = "telefono")
        String telefono);

    /**
     * 
     * @param matricula
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "utez/ServicioSisa/eliminarUsuarioRequest", output = "utez/ServicioSisa/eliminarUsuarioResponse")
    public boolean eliminarUsuario(
        @WebParam(name = "matricula", partName = "matricula")
        String matricula);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "utez/ServicioSisa/consultarUsuarioRequest", output = "utez/ServicioSisa/consultarUsuarioResponse")
    public String consultarUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "utez/ServicioSisa/consultaGeneralUsuarioRequest", output = "utez/ServicioSisa/consultaGeneralUsuarioResponse")
    public String consultaGeneralUsuario();

    /**
     * 
     * @param fechaNac
     * @param apellidoP
     * @param correo
     * @param matricula
     * @param apellidoM
     * @param telefono
     * @param nombre
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "utez/ServicioSisa/actualizarUsuarioRequest", output = "utez/ServicioSisa/actualizarUsuarioResponse")
    public boolean actualizarUsuario(
        @WebParam(name = "nombre", partName = "nombre")
        String nombre,
        @WebParam(name = "apellidoP", partName = "apellidoP")
        String apellidoP,
        @WebParam(name = "apellidoM", partName = "apellidoM")
        String apellidoM,
        @WebParam(name = "fechaNac", partName = "fechaNac")
        XMLGregorianCalendar fechaNac,
        @WebParam(name = "correo", partName = "correo")
        String correo,
        @WebParam(name = "telefono", partName = "telefono")
        String telefono,
        @WebParam(name = "matricula", partName = "matricula")
        String matricula);

}
