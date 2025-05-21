import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LoginRecord {
    String id;
    int terminal;
    LocalTime login;
    LocalTime logoff;

    public LoginRecord(String id, int terminal, String login, String logoff) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.id = id;
        this.terminal = terminal;
        this.login = LocalTime.parse(login, fmt);
        this.logoff = LocalTime.parse(logoff, fmt);
    }

    public long sessionDurationSeconds() {
        return java.time.Duration.between(login, logoff).getSeconds();
    }
}
