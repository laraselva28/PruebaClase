package excepciones;

public class PacienteNoExiste extends RuntimeException {
    public PacienteNoExiste(String message) {
        super(message);
    }
    public PacienteNoExiste() {
        super();
    }
}
