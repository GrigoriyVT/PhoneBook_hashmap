import java.util.*;

public class PhoneBook {
    private final Map<String, List<Contact>> phone_book = new HashMap<>();

    public boolean addGroup(String group) {
        if (!phone_book.containsKey(group)) {
            phone_book.put(group, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean addContact(String group, Contact contact) {
        if (phone_book.containsKey(group)) {
            List<Contact> contact_list = phone_book.get(group);
            contact_list.add(contact);
            phone_book.put(group, contact_list);
            return true;
        } else return false;
    }

    public List<Contact> findGroupContact(String group) {
        return new ArrayList<>(phone_book.get(group));
    }

    public Contact findPhoneContact(String phone) {
        for (List<Contact> contact_list : phone_book.values()) {
            for (Contact contact : contact_list) {
                if (contact.getPhone().equals(phone))
                    return contact;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<Contact>> group : phone_book.entrySet()) {
            sb
                    .append(group.getKey())
                    .append("\n");
            for (Contact contact : group.getValue()) {
                sb
                        .append("\t")
                        .append(contact)
                        .append("\n");
            }
        }
        return sb.toString();
    }
}
