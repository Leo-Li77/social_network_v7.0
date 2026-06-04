package posts;

public class MessagePost extends LikedPost {

    private String message;

    public MessagePost(String author, String message) {
        super(author);
        this.message = message;
    }



}
