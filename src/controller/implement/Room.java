package controller.implement;

/**
 *
 * @author juan_
 */
public class Room extends Molde{
    //private String diseñoId;}
    private String nombre;

    public Room(double base, double altura, double profundidad, String nombre) {
        super(base, altura, profundidad);
        this.nombre= nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void getArea(double base, double altura) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String toString() {
        return "Ambiente{" + super.toString() + "nombre=" + nombre + '}';
    }
    
    
}
