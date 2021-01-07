package utez.edu.mx.sisa.Usuario.modelo;

import utez.edu.mx.sisa.conexion.ConexionMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private final String SQL_CONSULTAR_USUARIO = "Select * FROM usuario WHERE matricula = ? ;";
    private final String SQL_INSERTAR_USUARIO = "insert into usuario (matricula, nombre, apellidoP, apellidoM, fechaNac, correo, telefono) value (?, ?, ?, ?, ?, ?, ?); ";
    private final String SQL_ELIMINAR_USUARIO = "delete from usuario WHERE matricula =?;";
    private final String SQL_ACTUALIZAR_USUARIO = "update usuario set nombre=?, apellidoP=?, apellidoM=?, fechaNac=?, correo=?, telefono=? WHERE matricula=?;";
    private final String SQL_CONSULTA_GENERAL_USUARIO = "Select * FROM usuario;";

    public UsuarioBean consulatarUsuario(UsuarioBean bean){
        UsuarioBean usuario = null;
        try{
            con= ConexionMySQL.getConnection();
            pstm = con.prepareStatement(SQL_CONSULTAR_USUARIO);
            pstm.setString(1,bean.getMatricula());
            rs = pstm.executeQuery();
            if(rs.next()){
                usuario = new UsuarioBean();
                usuario.setMatricula(rs.getString("matricula"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidoP(rs.getString("apellidoP"));
                usuario.setApellidoM(rs.getString("apellidoM"));
                usuario.setFechaNac(rs.getDate("fechaNac"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setTelefono(rs.getString("telefono"));
            }

        }catch(SQLException e){
            System.out.println("Error en el metodo de consultar el Usuario->"+e);
        }finally{
            try{
                rs.close();
                pstm.close();
                con.close();
            }catch (SQLException e){
                System.out.println("Error al cerrar las conexiones");
            }

        }
        return usuario;
    }

    public List<UsuarioBean> consultaGeneralUsuario(){
        List<UsuarioBean> usuarios =  new ArrayList();
        try{
            con= ConexionMySQL.getConnection();
            pstm = con.prepareStatement(SQL_CONSULTA_GENERAL_USUARIO);
            rs = pstm.executeQuery();
            while(rs.next()){
                UsuarioBean usuario =new UsuarioBean();
                usuario.setMatricula(rs.getString("matricula"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidoP(rs.getString("apellidoP"));
                usuario.setApellidoM(rs.getString("apellidoM"));
                usuario.setFechaNac(rs.getDate("fechaNac"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setTelefono(rs.getString("telefono"));
                usuarios.add(usuario);
            }

        }catch(SQLException e){
            System.out.println("Error en el metodo de consulta general de Usuario->"+e);
        }finally{
            try{
                rs.close();
                pstm.close();
                con.close();
            }catch (SQLException e){
                System.out.println("Error al cerrar las conexiones");
            }

        }
        return usuarios;
    }

    public boolean insertarUsuario(UsuarioBean bean){
        boolean resultado = false;
        try{
            con= ConexionMySQL.getConnection();
            pstm = con.prepareStatement(SQL_INSERTAR_USUARIO);
            pstm.setString(1,bean.getMatricula());
            pstm.setString(2,bean.getNombre());
            pstm.setString(3,bean.getApellidoP());
            pstm.setString(4,bean.getApellidoM());
            pstm.setDate(5,bean.getFechaNac());
            pstm.setString(6,bean.getCorreo());
            pstm.setString(7,bean.getTelefono());
            resultado = pstm.executeUpdate() == 1;
        }catch(SQLException e){
            System.out.println("Error en el metodo de insertar Usuario->"+e);
        }finally{
            try{
                pstm.close();
                con.close();
            }catch (SQLException e){
                System.out.println("Error al cerrar las conexiones");
            }

        }
        return resultado;
    }

    public boolean actualizarUsuario(UsuarioBean bean){
        boolean resultado = false;
        try{
            con= ConexionMySQL.getConnection();
            pstm = con.prepareStatement(SQL_ACTUALIZAR_USUARIO);
            pstm.setString(1,bean.getNombre());
            pstm.setString(2,bean.getApellidoP());
            pstm.setString(3,bean.getApellidoM());
            pstm.setDate(4,bean.getFechaNac());
            pstm.setString(5,bean.getCorreo());
            pstm.setString(6,bean.getTelefono());
            pstm.setString(7,bean.getMatricula());
            resultado = pstm.executeUpdate() == 1;
        }catch(SQLException e){
            System.out.println("Error en el metodo de actualizar Usuario->"+e);
        }finally{
            try{
                pstm.close();
                con.close();
            }catch (SQLException e){
                System.out.println("Error al cerrar las conexiones");
            }

        }
        return resultado;
    }

    public boolean eliminarUsuario(UsuarioBean bean){
        boolean resultado = false;
        try{
            con= ConexionMySQL.getConnection();
            pstm = con.prepareStatement(SQL_ELIMINAR_USUARIO);
            pstm.setString(1,bean.getMatricula());
            resultado = pstm.executeUpdate() == 1;
        }catch(SQLException e){
            System.out.println("Error en el metodo de eliminar Usuario->"+e);
        }finally{
            try{
                pstm.close();
                con.close();
            }catch (SQLException e){
                System.out.println("Error al cerrar las conexiones");
            }

        }
        return resultado;
    }
}

