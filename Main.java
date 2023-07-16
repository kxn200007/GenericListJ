

public class Main {

    public static int bin2Dec(String binary) throws BinaryFormatException {
        int decimalValue = 0;


        // Initializing base value to 2^0 = 1,
        int base = 1;

        //Check for Empty String
        if (binary.length() == 0) {
            throw new BinaryFormatException();
        }
        //Calculate Decimal Value in Loop reading from right to left.
        for (int i = binary.length() - 1; i >= 0; i--) {

            //Add base to decimal value if 1
            if (binary.charAt(i) == '1') {
                decimalValue += base;
            }
            //add nothing if 0
            else if (binary.charAt(i) == '0') {
                decimalValue += 0;
            }
            //throw exception
            else {
                throw new BinaryFormatException(binary.charAt(i));
            }

            base = base * 2;
        }
        
        return decimalValue;
    }

    public static void main(String[] args) throws BinaryFormatException {
        String bin = "a1";
        System.out.println(bin2Dec(bin));
    }
}
