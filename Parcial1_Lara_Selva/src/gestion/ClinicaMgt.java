package gestion;

import dominio.Turno;
import excepciones.NoHayPacientesEsperando;
import excepciones.NoHayTurnosPendientes;
import excepciones.PacienteNoExiste;
import excepciones.PacienteYaExiste;

public interface ClinicaMgt {

    void registrarPaciente(String cedula, String nombre, String telefono)
            throws PacienteYaExiste;

    void solicitarTurno(String cedula, String especialidad)
            throws PacienteNoExiste;

    Turno llamarProximoPaciente()
            throws NoHayPacientesEsperando;

    Turno atenderProximoTurno()
            throws NoHayTurnosPendientes;

    void cerrarTurno(Turno turno, String resolucion);

    Turno consultarTurnoAtendido(String idTurno);

    Turno buscarTurnoPendiente(String idTurno) ;

    void mostrarHistorial();
}
