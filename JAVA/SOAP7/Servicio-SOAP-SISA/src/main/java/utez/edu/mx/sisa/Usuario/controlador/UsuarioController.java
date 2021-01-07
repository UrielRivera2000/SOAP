package utez.edu.mx.sisa.Usuario.controlador;

import utez.edu.mx.sisa.Usuario.modelo.UsuarioBean;
import utez.edu.mx.sisa.Usuario.modelo.UsuarioDao;

import java.sql.Date;
import java.util.List;

public class UsuarioController {
    public String consultarUsuario(String matricula){
        UsuarioBean bean3 = new UsuarioBean();
        UsuarioBean bean = new UsuarioBean();
        UsuarioDao dao = new UsuarioDao();
        bean.setMatricula(matricula);
        bean3= dao.consulatarUsuario(bean);

        if(bean3 ==  null){
            return "No existe ese registro";
        }else{
            return "\n"+bean3.getMatricula()+"\n"+bean3.getNombre()+"\n"+ bean3.getApellidoP()+"\n"
                    + bean3.getApellidoM()+"\n"+ bean3.getFechaNac()+"\n"+ bean3.getCorreo()+"\n" +bean3.getTelefono();
        }

    }

    public String consultaGeneralUsuario(){
        List<UsuarioBean> bean3 = null;
        UsuarioDao dao = new UsuarioDao();

        bean3= dao.consultaGeneralUsuario();
        String resultado = "";
        for (UsuarioBean usuario  : bean3 ) {
            resultado = resultado+ "\n"+usuario.getMatricula()+"\n"+usuario.getNombre()+"\n"+ usuario.getApellidoP()+"\n"
                    + usuario.getApellidoM()+"\n"+ usuario.getFechaNac()+"\n"+ usuario.getCorreo()+"\n" +usuario.getTelefono()+"\n";
        }
        if(resultado ==  ""){
            return "No hay registros";
        }else{
            return "El resultado es: "+ resultado;
        }

    }

    public boolean registrarUsuario(String matricula, String nombre, String apellidoP, String apellidoM,
                                    Date fechaNac, String correo, String telefono){

        UsuarioBean bean = new UsuarioBean();
        UsuarioDao dao = new UsuarioDao();

        bean.setMatricula(matricula);
        bean.setNombre(nombre);
        bean.setApellidoP(apellidoP);
        bean.setApellidoM(apellidoM);
        bean.setFechaNac(fechaNac);
        bean.setCorreo(correo);
        bean.setTelefono(telefono);

        boolean resultado = dao.insertarUsuario(bean);
        return resultado;
    }

    public boolean actualizarUsuario( String nombre, String apellidoP, String apellidoM,
                                     Date fechaNac, String correo, String telefono,String matricula){

        UsuarioBean bean = new UsuarioBean();
        UsuarioDao dao = new UsuarioDao();

        bean.setNombre(nombre);
        bean.setApellidoP(apellidoP);
        bean.setApellidoM(apellidoM);
        bean.setFechaNac(fechaNac);
        bean.setCorreo(correo);
        bean.setTelefono(telefono);
        bean.setMatricula(matricula);

        boolean resultado = dao.actualizarUsuario(bean);
        return resultado;
    }

    public boolean eliminarUsuario(String matricula){

        UsuarioBean bean = new UsuarioBean();
        UsuarioDao dao = new UsuarioDao();

        bean.setMatricula(matricula);

        boolean resultado = dao.eliminarUsuario(bean);
        return resultado;
    }
}
