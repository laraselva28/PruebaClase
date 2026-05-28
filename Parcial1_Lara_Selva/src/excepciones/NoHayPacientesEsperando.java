package excepciones;

public class NoHayPacientesEsperando extends RuntimeException {
    public NoHayPacientesEsperando(String message) {
        super(message);
    }
    public NoHayPacientesEsperando() {
        super();
    }
}
