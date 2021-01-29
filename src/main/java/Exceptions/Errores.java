package Exceptions;

public class Errores extends Exception{
    ErrorCode et;
    public Errores(ErrorCode er){
        super();
        this.et = er;
    }

    @Override
    public String getMessage() {
        return et.toString();
    }
}
