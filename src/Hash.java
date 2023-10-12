import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.bouncycastle.util.encoders.Base64;


public class Hash {
    // Method that calculates the hash of a particular file by providing it filepath
    public String calculateHash(String dirname) throws NoSuchAlgorithmException, IOException {
        // defined a byte array to read the large data in small chunks
        byte[] chunkSize = new byte[10000];
        int count;

        // created digest object and used the algorithm to perform operation
        MessageDigest digest = MessageDigest.getInstance("SHA3-256");

        // created buffer object to read the small chunks
        BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(dirname));

        // reading all chunks until we don't have any data left in file and closing the buffer
        while ((count = buffer.read(chunkSize)) > 0) {
            digest.update(chunkSize, 0, count);
        }
        buffer.close();

        // created hash array to store the hashed value
        byte[] hash = digest.digest();

        // converted hash array to string
        String hashedString = Base64.toBase64String(hash);

        //printing and returning the result
        System.out.println(dirname.concat("\t\t->\t\t").concat(hashedString));
        return hashedString;
    }
}
