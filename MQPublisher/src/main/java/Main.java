import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Main {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        Producent producent = new Producent();
        producent.send();
    }
}
