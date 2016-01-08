package flowers.exceptions;

public class IllegalFlowersCountException extends IllegalArgumentException {

    public IllegalFlowersCountException(){
        super("Flower's count must be great than 0");
    }

}
