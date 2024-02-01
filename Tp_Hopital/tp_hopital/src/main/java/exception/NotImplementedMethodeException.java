package exception;

public class NotImplementedMethodeException extends RuntimeException {
    public NotImplementedMethodeException() {
        super("méthode non implémentée");
    }
}
