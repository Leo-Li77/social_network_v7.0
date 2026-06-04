package posts;

public class EventPost extends Post {

    private String eventName;
    private double eventCost;

    public EventPost(String author, String eventName, double eventCost) {
        super(author);
        this.eventName = eventName;
        this.eventCost = eventCost;
    }
}
