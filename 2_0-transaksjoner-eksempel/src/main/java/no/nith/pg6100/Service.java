package no.nith.pg6100;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

public class Service {
    private final Random random = new Random();
    private final File file = new File("account.txt");

    public void addToAccount(int amount) throws IOException {
        System.out.println("Adding " + amount);
        int currentValue = readCurrentValue();
        currentValue += amount;

        executeLongRunningOperation();

        writeNewValue(currentValue);
    }

    public void subtractFromAccount(int amount) throws IOException {
        System.out.println("Subtracting " + amount);
        int currentValue = readCurrentValue();
        currentValue -= amount;

        executeLongRunningOperation();

        writeNewValue(currentValue);
    }

    private int readCurrentValue() throws IOException {
        List<String> lines = Files.readLines(file, Charset.defaultCharset());
        String content = lines.get(lines.size() - 1);
        return Integer.parseInt(content);
    }

    private void writeNewValue(int amount) throws IOException {
        Files.append(Integer.toString(amount) + "\n", file, Charset.defaultCharset());
    }

    private void executeLongRunningOperation() {
        int i = random.nextInt(10) + 1;
        if(i == 5) {
            throw new IllegalStateException("Something wrong happened");
        } else {
            try {
                Thread.sleep(i * 50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
