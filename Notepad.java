import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Notepad {
    public static void main(String[] args) {
        Timer timer = new Timer();
        int numberOfRuns = 10;
        for (int i = 0; i < numberOfRuns; i++) {
            long delayInMillis = i * 1000;
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        ProcessBuilder pb = new ProcessBuilder("notepad.exe");
                        pb.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }, delayInMillis);
        }
    }
}