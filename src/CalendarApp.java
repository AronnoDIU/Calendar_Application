import java.util.*;

public class CalendarApp {
    // Map to store events by date (key = date, value = list of events)
    private final Map<String, List<String>> events;

    public CalendarApp() {
        events = new HashMap<>(); // HashMap is used for O(1) access to events
    }

    // Add event to calendar on a specific date
    public void addEvent(String date, String event) {
        // If the date already exists in a map, add event to a list of events on that date (key)
        events.computeIfAbsent(date, k -> new ArrayList<>()).add(event);
        // Lambda expression above is equivalent to: events.putIfAbsent(date, new ArrayList<>());

        // Print success message
        System.out.println("Event added successfully.");
    }

    // View events on a specific date (key) in the calendar
    public void viewEvents(String date) {
        // Get a list of events on a specific date (key)
        List<String> eventsOnDate = events.get(date);

        // If the list is not empty, print all events on that date (key)
        if (eventsOnDate != null && !eventsOnDate.isEmpty()) {
            System.out.println("Events on " + date + ":");

            // Print all events on that date (key)
            for (String event : eventsOnDate) {
                System.out.println("- " + event);
            }
        } else { // Otherwise, print error message
            System.out.println("No events found on " + date + ".");
        }
    }

    // View all events in the calendar (key = date, value = list of events)
    public void viewAllEvents() {
        // If the map is empty, print error message
        if (events.isEmpty()) {
            System.out.println("No events found.");
        } else { // Otherwise, print all events in the calendar
            System.out.println("All Events:");

            // Print all events in the calendar (key = date, value = list of events)
            for (Map.Entry<String, List<String>> entry : events.entrySet()) {
                System.out.println("Date: " + entry.getKey());

                // Print all events on that date (key)
                for (String event : entry.getValue()) {
                    System.out.println("- " + event);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        CalendarApp calendarApp = new CalendarApp();
        String date; // date (key) in the calendar

        while (true) {
            System.out.println("\nCalendar Application Menu:");
            System.out.println("1. Add Event");
            System.out.println("2. View Events on a Date");
            System.out.println("3. View All Events");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = userInput.nextInt();
            userInput.nextLine(); // consume the newline character

            switch (choice) {
                case 1: // For Add event to calendar
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    date = userInput.nextLine();

                    System.out.print("Enter event description: ");
                    String event = userInput.nextLine();

                    // Add event to calendar
                    calendarApp.addEvent(date, event);
                    break;

                case 2: // For View events on a specific date (key) in the calendar
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    date = userInput.nextLine();

                    // View events on a specific date (key) in the calendar
                    calendarApp.viewEvents(date);
                    break;

                case 3: // For View all events in the calendar (key = date, value = list of events)
                    calendarApp.viewAllEvents();
                    break;

                case 4: // For Exit
                    System.out.println("Exiting Calendar Application. Goodbye!");
                    System.exit(0);

                default: // For Invalid choice
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}
