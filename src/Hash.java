import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.bouncycastle.util.encoders.Base64;


public class Hash {
    public String calculateHash(String dirname) throws NoSuchAlgorithmException, IOException {
        byte[] chunkSize = new byte[10000];
        int count;
        MessageDigest digest = MessageDigest.getInstance("SHA3-256");
        BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(dirname));
        while ((count = buffer.read(chunkSize)) > 0) {
            digest.update(chunkSize, 0, count);
        }
        byte[] hash = digest.digest();
        String hashedString = Base64.toBase64String(hash);
        System.out.println(dirname.concat("\t->\t").concat(hashedString));
        return hashedString;
    }
}
