package excepciones;

public class PacienteYaExiste extends RuntimeException {
    public PacienteYaExiste(String message) {
        super(message);
    }
    public PacienteYaExiste() {
        super();
    }
}


