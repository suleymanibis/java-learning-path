import java.util.Scanner;

public class TimeConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Toplam saniyeyi girin: ");
        int totalSeconds = input.nextInt();

        System.out.print("Format türü girin (long/short): ");
        String formatType = input.next();
        formatType = formatType.toLowerCase();

        switch (formatType) {
            case "short" -> System.out.println(formatTime(totalSeconds, "short"));
            case "long" -> System.out.println(formatTime(totalSeconds));
            default -> System.out.println("Böyle bir format tipi bulunamadı!");
        }
    }

    public static String formatTime(int totalSeconds, String format) {
        int hours = totalSeconds / 3600;
        int remainingSeconds = (totalSeconds % 3600);
        int minutes = remainingSeconds / 60;
        int seconds = remainingSeconds % 60;

        format = format.toLowerCase();

        String formattedTime = "";

        if (format.equals("long"))
            formattedTime = String.format("%d Saat %d Dakika %d Saniye", hours, minutes, seconds);
        else if (format.equals("short"))
            formattedTime = String.format("%02d:%02d:%02d", hours, minutes, seconds);

        return formattedTime;
    }

    public static String formatTime(int totalSeconds) {
        return formatTime(totalSeconds, "long");
    }
}
