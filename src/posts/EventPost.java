package posts;

public class EventPost extends Post {
    private String eventName;
    private double eventCost;

    public EventPost(String author, String eventName, double eventCost) {
        super(author);
        this.eventName = eventName;
        this.eventCost = eventCost;
    }

    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }
    public double getEventCost() { return eventCost; }
    public void setEventCost(double eventCost) { this.eventCost = eventCost; }

    @Override
    public String toString() {
        return "[Event] " + getAuthor() + ": " + eventName + " ($" + eventCost + ")";
    }

    @Override
    public String toFileString() {
        return "EVT|" + getAuthor() + "|" + eventName + "|" + eventCost;
    }

    public static EventPost fromFileParts(String author, String[] parts) {
        if (parts.length < 4) return null;
        return new EventPost(author, parts[2], Double.parseDouble(parts[3]));
    }
}