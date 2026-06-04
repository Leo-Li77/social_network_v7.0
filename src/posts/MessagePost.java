package posts;

public class MessagePost extends LikedPost {
    private String message;

    public MessagePost(String author, String message) {
        super(author);
        this.message = message;
    }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    @Override
    public String toString() {
        return "[Message] " + getAuthor() + ": " + message + " (Likes: " + getLikes() + ")";
    }

    @Override
    public String toFileString() {
        return "MSG|" + getAuthor() + "|" + message + "|" + getLikes();
    }

    public static MessagePost fromFileParts(String author, String[] parts) {
        if (parts.length < 4) return null;
        MessagePost mp = new MessagePost(author, parts[2]);
        mp.setLikes(Integer.parseInt(parts[3]));
        return mp;
    }
}