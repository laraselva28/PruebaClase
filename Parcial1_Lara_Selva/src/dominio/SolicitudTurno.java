package dominio;

public class SolicitudTurno {

    private Paciente paciente;
    private String especialidad;


    public SolicitudTurno(Paciente paciente, String especialidad) {
        this.paciente = paciente;
        this.especialidad = especialidad;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
