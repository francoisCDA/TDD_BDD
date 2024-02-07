package exception;

public class ImpossibleReservationException extends Exception{

    public ImpossibleReservationException(String problem) {
        super("Invalid argument : " + problem);
    }

}
