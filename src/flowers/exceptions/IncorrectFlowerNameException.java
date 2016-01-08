package flowers.exceptions;

public class IncorrectFlowerNameException extends IllegalArgumentException {

    public IncorrectFlowerNameException(){
        super("Desired flower does not exist");
    }

}
