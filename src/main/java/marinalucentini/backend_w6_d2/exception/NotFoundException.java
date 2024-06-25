package marinalucentini.backend_w6_d2.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException (int id){
        super("L'elemento con id: " + id + "non è stato trovato");
    }
}
