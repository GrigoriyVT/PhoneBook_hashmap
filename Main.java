import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        MissedCalls missedCalls = new MissedCalls();

        phoneBook.addGroup("Семья");
        phoneBook.addGroup("Работа");
        phoneBook.addGroup("Друзья");

        phoneBook.addContact("Семья", new Contact("Мама", "+79997896543"));
        phoneBook.addContact("Семья", new Contact("Папа", "+79857896543"));
        phoneBook.addContact("Семья", new Contact("Сестра", "+79807896543"));
        phoneBook.addContact("Работа", new Contact("Василий", "+79218975632"));
        phoneBook.addContact("Работа", new Contact("Артем", "+79256775632"));
        phoneBook.addContact("Работа", new Contact("Василий", "+79279875632"));
        phoneBook.addContact("Друзья", new Contact("Даня", "+79819817271"));
        phoneBook.addContact("Друзья", new Contact("Настя", "+79819357271"));
        phoneBook.addContact("Друзья", new Contact("Инна", "+79813917271"));

        try (Scanner scanner = new Scanner(System.in)) {
            String input;
            while (true) {
                System.out.println("Введите пропущенный номер или \"end\" для выхода ->");
                input = scanner.nextLine();
                if ("end".equals(input)) {
                    System.out.println("Выход из программы...");
                    break;
                }
                missedCalls.addMissCall(input);
            }
        }
        System.out.println(missedCalls.toString(phoneBook));
    }
}
