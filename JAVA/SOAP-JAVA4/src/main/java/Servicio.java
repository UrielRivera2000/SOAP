import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

@WebService(name="Servicio", targetNamespace = "utez")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class Servicio {
    int valorEntero = (int)Math.floor(Math.random() * (10 - 1 + 1) + 1);
   @WebMethod(operationName="devolverMensaje")

    public String devolerMensaje(@WebParam(name ="mensaje")int numero){


        System.out.println("Numero: "+valorEntero);
        if(numero == valorEntero){
            return "Correcto "+numero;
        }else{
            return "Error, el numero es: "+valorEntero;
        }


   }

    public static void main(String[] args) {
        System.out.println("Iniciando servidor...");
        Endpoint.publish("http://localhost:8000/Servicio", new Servicio());
        System.out.println("Esperando petición...");
    }
}
