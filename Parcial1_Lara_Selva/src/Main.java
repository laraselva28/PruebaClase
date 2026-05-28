import dominio.Turno;
import gestion.ClinicaMgr;
import gestion.ClinicaMgt;

public class Main {

    public static void main(String[] args) {

        try {
            ClinicaMgt clinica = new ClinicaMgr();

            clinica.registrarPaciente("11111111", "Ana Pérez", "099111111");
            clinica.registrarPaciente("22222222", "Luis Gómez", "099222222");
            clinica.registrarPaciente("33333333", "María Silva", "099333333");

            clinica.solicitarTurno("11111111", "Cardiología");
            clinica.solicitarTurno("22222222", "Dermatología");
            clinica.solicitarTurno("33333333", "Pediatría");

            Turno turno1 = clinica.llamarProximoPaciente();
            Turno turno2 = clinica.llamarProximoPaciente();
            Turno turno3 = clinica.llamarProximoPaciente();

            System.out.println("Turnos generados:");
            System.out.println(turno1);
            System.out.println(turno2);
            System.out.println(turno3);

            Turno atendido = clinica.atenderProximoTurno();

            System.out.println("Turno atendido:");
            System.out.println(atendido);

            clinica.cerrarTurno(atendido, "Paciente atendido correctamente.");

            System.out.println("Consulta de turno atendido:");
            Turno consultado = clinica.consultarTurnoAtendido(atendido.getIdTurno());
            System.out.println(consultado);

            System.out.println("Historial:");
            clinica.mostrarHistorial();

        } catch (Exception e) {
            System.out.println("Error: " + e.getClass().getSimpleName());
        }
    }
}