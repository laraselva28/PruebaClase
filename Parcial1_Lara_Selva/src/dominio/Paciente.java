package dominio;

public class Paciente {

    private String cedula;
    private String nombre;
    private String telefono;

    public Paciente(String cedula, String nombre, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Paciente)) {
            return false;
        }

        Paciente otro = (Paciente) obj;
        return this.cedula.equals(otro.cedula);
    }

    @Override
    public String toString() {
        return cedula + " - " + nombre + " - " + telefono;
    }
}