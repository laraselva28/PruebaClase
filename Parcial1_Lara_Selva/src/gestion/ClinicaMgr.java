package gestion;

import dominio.*;
import excepciones.*;
import uy.edu.um.tad.list.MyLinkedListImpl;
import uy.edu.um.tad.list.MyList;
import uy.edu.um.tad.queue.EmptyQueueException;
import uy.edu.um.tad.queue.MyQueue;
import uy.edu.um.tad.queue.MyQueueImpl;
import uy.edu.um.tad.stack.EmptyStackException;
import uy.edu.um.tad.stack.MyStack;
import uy.edu.um.tad.stack.MyStackImpl;


public class ClinicaMgr implements ClinicaMgt {
    private  MyQueue<Paciente> pacientes;
    //turnos pendientes  es el stack turnos
    private  MyStack<Turno>  turnos ;
    private  MyList<Turno> historial;
    private  MyQueue<SolicitudTurno> espera;


    public ClinicaMgr() {
        this.pacientes= new MyQueueImpl<>();
        this.turnos= new MyStackImpl<>();
        this.historial=new MyLinkedListImpl<>();
        this.espera= new MyQueueImpl<>();
    }

    @Override
    public void registrarPaciente(String cedula, String nombre, String telefono)
            throws PacienteYaExiste {
        Paciente nuevopaciente= new Paciente(cedula,nombre,telefono);
        if(pacientes.contains(nuevopaciente)){
            throw new PacienteYaExiste("el paciente ya existe");
        }
        pacientes.enqueue(nuevopaciente);
    }

    @Override
    public void solicitarTurno(String cedula, String especialidad)
            throws PacienteNoExiste {
        Paciente pacientesol= buscarPaciente(cedula);
        if(pacientesol==null){
            throw new PacienteNoExiste("el paciente no existe");
        }
        SolicitudTurno nuevasolicitud= new SolicitudTurno(pacientesol,especialidad);
        espera.enqueue(nuevasolicitud);
    }

    @Override
    public Turno llamarProximoPaciente()
            throws NoHayPacientesEsperando {
        if(espera.isEmpty()){

            throw new NoHayPacientesEsperando("no hay pacientes esperando");
        }

        while(!espera.isEmpty()){
            try {
                SolicitudTurno solicitudactual= espera.dequeue();
                String id= solicitudactual.getPaciente().getCedula();
                Turno nuevoturno= new Turno(id,solicitudactual.getPaciente(),solicitudactual.getEspecialidad());
                turnos.push(nuevoturno);
                return nuevoturno;

            } catch (EmptyQueueException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @Override
    public Turno atenderProximoTurno()
            throws NoHayTurnosPendientes {
        if(turnos.isEmpty()){
            throw new NoHayTurnosPendientes("no hay turnos pendientes");
        }
        while(!turnos.isEmpty()){
            try {
                Turno turnoactual=turnos.pop();
                turnoactual.cambiarestado(turnoactual);
                return turnoactual;

            } catch (EmptyStackException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @Override
    public void cerrarTurno(Turno turno, String resolucion) {
        turno.hacerresolucion(resolucion);
        historial.add(turno);
    }

    @Override
    public Turno consultarTurnoAtendido(String idTurno) {
        for(int i=0;i<historial.size();i++){
            Turno turnoactual=historial.get(i);
            if(turnoactual.getIdTurno().equals(idTurno)){
                return turnoactual;
            }
        }
        return null;
    }

    @Override
    public Turno buscarTurnoPendiente(String idTurno) {
        Turno encontrado = null;
        MyStack<Turno> auxiliar= new MyStackImpl<>();
        while(!turnos.isEmpty()){
            try {
                Turno turnoactual=turnos.pop();
                if(turnoactual.equals(idTurno)){
                    encontrado=turnoactual;
                    return encontrado;
                }else{
                    auxiliar.push(turnoactual);
                }
            } catch (EmptyStackException e) {
                throw new RuntimeException(e);
            }
        }
        turnos=auxiliar;
        return null;
    }

    @Override
    public void mostrarHistorial() {
        for(int i=0;i<historial.size();i++){
            Turno turnoactual=historial.get(i);
            System.out.println("el id es "+turnoactual.getIdTurno());
            System.out.println("la cedula es"+ turnoactual.getPaciente().getCedula());
            System.out.println("el nombre es"+ turnoactual.getPaciente().getNombre());
            System.out.println("especialidad"+turnoactual.getEspecialidad());
            System.out.println("estado"+turnoactual.getEstado());
            System.out.println("resolucion"+turnoactual.getResolucion());
        }
    }
    public  Paciente buscarPaciente(String cedula){
        for(int i=0;i<pacientes.size();i++){
            Paciente pacienteactual=pacientes.get(i);
            if(pacienteactual.getCedula().equals(cedula)){
                return pacienteactual;
            }
        }
        return null;
    }

}
