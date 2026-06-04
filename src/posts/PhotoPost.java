package posts;

public class PhotoPost extends LikedPost {

    private String filename;
    private String caption;

    public PhotoPost(String author, String filename, String caption) {
        super(author);
        this.filename = filename;
        this.caption = caption;
    }
}
