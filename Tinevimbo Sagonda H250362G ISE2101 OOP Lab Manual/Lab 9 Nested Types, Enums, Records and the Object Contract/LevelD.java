enum Level {
    LOW, MEDIUM, HIGH
}
public class LevelD {
    public static void main(String[] args) {
        Level level = Level.MEDIUM;

        switch (level) {
            case LOW:
                System.out.println("Advice: Take your time.");
                break;

            case MEDIUM:
                System.out.println("Advice: Stay focused.");
                break;

            case HIGH:
                System.out.println("Advice: Act immediately!");
                break;
        }
    }
}