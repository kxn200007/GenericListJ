

public class BinaryFormatException extends Exception {

    public BinaryFormatException() {
        super("Empty String\n");
    }

    public BinaryFormatException(char invalid) {
        super("'" + invalid + "' is not a valid Binary character\n");
    }
}
