import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class MissedCalls {
    private final NavigableMap<LocalDateTime, String> missedCalls = new TreeMap<>();

    public void addMissCall(String phone) {
        missedCalls.put(LocalDateTime.now(), phone);
    }

    public String toString(PhoneBook phoneBook) {
        StringBuilder sb = new StringBuilder();
        System.out.println("Список пропущенных вызовов -> \n");
        for (Map.Entry<LocalDateTime, String> mc : missedCalls.entrySet()) {
            final Contact phoneContact = phoneBook.findPhoneContact(mc.getValue());
            sb
                    .append(mc.getKey().format(DateTimeFormatter.ofPattern("d:MMM:uuuu HH:mm:ss")))
                    .append("\t")
                    .append(phoneContact==null ? mc.getValue():phoneContact.getName())
                    .append("\n");
        }
        return sb.toString();
    }
}
