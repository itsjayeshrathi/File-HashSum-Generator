import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.util.encoders.Base64;

public class Runner implements Runnable {
    public String dirname;
    public int index;
    public String hash;

    public Runner(String dirname, int index) {
        this.dirname = dirname;
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }

    @Override
    public void run() {
        File files = new File(this.dirname);
        File[] listOfFiles = files.listFiles();
        assert listOfFiles != null;
        int len = listOfFiles.length;
        List<Runner> runnersList = new ArrayList<>();
        List<Thread> threadsList = new ArrayList<>();
        String[] hashes = new String[len];
        String combined = "";
        for (int i = 0; i < len; i++) {
            File file = listOfFiles[i];
            if (file.isFile()) {
                try {
                    hashes[i] = Hash.calculateHash(file.getPath());
                } catch (NoSuchAlgorithmException | IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (file.isDirectory()) {
                Runner runner = new Runner(file.getPath(), i);
                runnersList.add(runner);
                Thread thread = new Thread(runner);
                threadsList.add(thread);
                thread.start();
            }
        }
        for (Thread t : threadsList) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for (Runner r : runnersList) {
            int i = r.getIndex();
            hashes[i] = r.getHash();
        }
        for (String h : hashes) {
            combined = combined.concat(h);
        }
        byte[] bytes = combined.getBytes(StandardCharsets.UTF_8);
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA3-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        digest.update(bytes);
        this.hash = Base64.toBase64String(digest.digest());
    }

    public String getHash() {
        return this.hash;
    }
}
