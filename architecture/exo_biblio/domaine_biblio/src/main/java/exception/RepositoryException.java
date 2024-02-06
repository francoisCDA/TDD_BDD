package exception;

public class RepositoryException extends Exception {
    public RepositoryException(String methodeName){
        super("repository excpetion : " + methodeName);
    }
}
