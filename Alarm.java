import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AlarmClock {

    public static void main(String[] args) {
        // Set your alarm time here (HH:mm:ss format)
        String alarmTime = "07:30:00";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.println("Alarm set for " + alarmTime);

        while (true) {
            LocalTime now = LocalTime.now();
            String currentTime = now.format(formatter);

            System.out.println("Current time: " + currentTime);

            if (currentTime.equals(alarmTime)) {
                System.out.println("⏰ Alarm ringing! Wake up!");

                // Optional: beep sound
                java.awt.Toolkit.getDefaultToolkit().beep();

                break; // stop after alarm
            }

            try {
                Thread.sleep(1000); // check every second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
