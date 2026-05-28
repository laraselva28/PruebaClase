package excepciones;

public class NoHayTurnosPendientes extends RuntimeException {
    public NoHayTurnosPendientes(String message) {
        super(message);
    }
    public NoHayTurnosPendientes() {
        super();
    }
}
