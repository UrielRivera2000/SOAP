import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

@WebService(name="Servicio", targetNamespace = "utez")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class Servicio {

    @WebMethod(operationName="rfc")

    public String rfc(@WebParam(name ="mensaje")String nombre, String apellidoP, String apellidoM, String fecha){

        String rfc = apellidoP.substring(0,1).toUpperCase();
        apellidoP=apellidoP.toUpperCase();
        if (apellidoP.charAt(1)!='A'&& apellidoP.charAt(1)!='E'&& apellidoP.charAt(1)!='I'&& apellidoP.charAt(1)!='O'&& apellidoP.charAt(1)!='U' ){
            for(int x = 2; x<apellidoP.length(); x++){
                if(apellidoP.charAt(x) == 'A' ||apellidoP.charAt(x) == 'E'||apellidoP.charAt(x) == 'I'||apellidoP.charAt(x) == 'O'||apellidoP.charAt(x) == 'U' ){
                    rfc=rfc+apellidoP.charAt(x);
                    break;
                }
            }
        }else{
            rfc = rfc +apellidoP.charAt(1);
        }


        rfc=rfc+apellidoM.substring(0,1).toUpperCase()+nombre.substring(0,1).toUpperCase()+fecha.substring(2,4)+
                fecha.substring(5,7)+fecha.substring(8,10);

        for (int j = 0; j < 2; j++) {
            int codigoAscii = (int) Math.floor(Math.random() * (65 - 90) + 90);
            rfc = rfc+(char)codigoAscii;
        }
        int codigoAscii = (int) Math.floor(Math.random() * (0 - 10) + 10);
        rfc = rfc+codigoAscii;


        return "RFC: "+rfc;
    }

    public static void main(String[] args) {
        System.out.println("Iniciando servidor...");
        Endpoint.publish("http://localhost:9000/Servicio", new Servicio());
        System.out.println("Esperando petición...");
    }
}