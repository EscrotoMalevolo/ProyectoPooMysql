package controller.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import controller.Usuario;

public class ServicesUsuario {
    private final String tabla_Usuarios = "uwu";
    
    public void guardar_usuario(Connection conexion, Usuario usuario){
        try{
            PreparedStatement consulta;
            
            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla_Usuarios + "(usuario, contraseña, correo, nombre) VALUES(?, ?, ?, ?)");
            consulta.setString(1, usuario.getUsername());
            consulta.setString(2, usuario.getPassword());
            consulta.setString(3, usuario.getEmail());
            consulta.setString(4, usuario.getName());
            
            consulta.executeUpdate();
            
            System.out.println("Se guardaron los datos correctamente. ");
        } 
        catch (SQLException ex){
            System.out.println("Hubo un error al momento de guardar los datos. ");
        }
    }
    
    public boolean Info_UsuarioLogin(Connection conexion, String Usuario, String Contraseña) {
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT contraseña FROM " + this.tabla_Usuarios + " WHERE usuario = ?");
            consulta.setString(1, Usuario);
            ResultSet resultado = consulta.executeQuery();
            if (resultado.next()) {
                String contraseñaObtenida = resultado.getString("contraseña");
                return Contraseña.equals(contraseñaObtenida);
            }
        } catch (SQLException ex) {
            // Manejo de excepciones opcionalmente
            System.out.println("Error en la verificación del login: " + ex.getMessage());
        }
        return false;
    }
    public void actualizar_usuario(Connection conexion, String newusuario, String usuario){
        try{
            PreparedStatement consulta;
            
            consulta = conexion.prepareStatement("UPDATE " + this.tabla_Usuarios + " SET usuario = ? WHERE usuario = ?");
            consulta.setString(1, newusuario);
            consulta.setString(2, usuario);
            consulta.executeUpdate();
            
            System.out.println("Se guardaron los datos correctamente. ");
        } 
        catch (SQLException ex){
            System.out.println("Hubo un error al momento de guardar los datos. "+ ex.getMessage());
        }
    }
    
    public void actualizar_email(Connection conexion, String newemail, String email){
        try{
            PreparedStatement consulta;
            
            consulta = conexion.prepareStatement("UPDATE " + this.tabla_Usuarios + " SET correo = ? WHERE correo = ?");
            consulta.setString(1, newemail);
            consulta.setString(2, email);
            consulta.executeUpdate();
            
            System.out.println("Se guardaron los datos correctamente. ");
        } 
        catch (SQLException ex){
            System.out.println("Hubo un error al momento de guardar los datos. "+ ex.getMessage());
        }
    }
    
    public void actualizar_password(Connection conexion, String newpassword, String password){
        try{
            PreparedStatement consulta;
            
            consulta = conexion.prepareStatement("UPDATE " + this.tabla_Usuarios + " SET contraseña = ? WHERE contraseña = ?");
            consulta.setString(1, newpassword);
            consulta.setString(2, password);
            consulta.executeUpdate();
            
            System.out.println("Se guardaron los datos correctamente. ");
        } 
        catch (SQLException ex){
            System.out.println("Hubo un error al momento de guardar los datos. "+ ex.getMessage());
        }
    }
    
    public void actualizar_nombres(Connection conexion, String newnames, String names){
        try{
            PreparedStatement consulta;
            
            consulta = conexion.prepareStatement("UPDATE " + this.tabla_Usuarios + " SET nombre = ? WHERE nombre = ?");
            consulta.setString(1, newnames);
            consulta.setString(2, names);
            consulta.executeUpdate();
            
            System.out.println("Se guardaron los datos correctamente. ");
        } 
        catch (SQLException ex){
            System.out.println("Hubo un error al momento de guardar los datos. "+ ex.getMessage());
        }
    }
    
    public String getEmail(Connection conexion, String Usuario) {
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT correo FROM " + this.tabla_Usuarios + " WHERE usuario = ?");
            consulta.setString(1, Usuario);
            ResultSet resultado = consulta.executeQuery();
            if (resultado.next()) {
                String emailObtenido = resultado.getString("correo");
                return emailObtenido;
            }
        } catch (SQLException ex) {
            // Manejo de excepciones opcionalmente
            System.out.println("Error en la verificación del email: " + ex.getMessage());
        }
        return null;
    }
    
    public String getNombres(Connection conexion, String Usuario) {
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT nombre FROM " + this.tabla_Usuarios + " WHERE usuario = ?");
            consulta.setString(1, Usuario);
            ResultSet resultado = consulta.executeQuery();
            if (resultado.next()) {
                String nombresObtenido = resultado.getString("nombre");
                return nombresObtenido;
            }
        } catch (SQLException ex) {
            // Manejo de excepciones opcionalmente
            System.out.println("Error en la verificación del nombre: " + ex.getMessage());
        }
        return null;
    }
}