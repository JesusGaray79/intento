
package modelo;

public class mascota {
    private String nombre;
    private String tipo;
    private int edad;
    
    //constructor 
    public mascota () {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int calEdadHumana(){ 
    int edHuma;
    edHuma = edad * 7;
    return edHuma;
    }
    
    // metodod para enivar los datos a la jTable
    
    public Object[] RegistrarDato(){
    Object[] fila = {nombre,tipo,edad, calEdadHumana()};
    
    return fila;
}
    
}
