package flowers.exceptions;

public class FlowerNotFoundException extends ArrayStoreException {

    public FlowerNotFoundException(){
        super("Needed flower not found");
    }

}
