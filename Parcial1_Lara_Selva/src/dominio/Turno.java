package dominio;

public class Turno {

    private String idTurno;
    private Paciente paciente;
    private String especialidad;
    private String estado;
    private String resolucion;

    public Turno(String idTurno, Paciente paciente, String especialidad) {
        this.idTurno =idTurno;
        this.paciente = paciente;
        this.especialidad = especialidad;
        this.estado = "PENDIENTE";
        this.resolucion = "";
    }

    public String getIdTurno() {
        return idTurno;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getEstado() {
        return estado;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setIdTurno(String idTurno) {
        this.idTurno = idTurno;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    @Override
    public String toString() {
        return idTurno + " - " + paciente.getNombre() + " - "
                + especialidad + " - " + estado + " - " + resolucion;
    }
    public void cambiarestado(Turno turno){
        turno.estado="atendido";
    }
    public void hacerresolucion(String resolucion){
        this.resolucion=resolucion;
    }
}