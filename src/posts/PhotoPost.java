package posts;

public class PhotoPost extends LikedPost {
    private String filename;
    private String caption;

    public PhotoPost(String author, String filename, String caption) {
        super(author);
        this.filename = filename;
        this.caption = caption;
    }

    public String getCaption() { return caption; }
    public void setCaption(String caption) { this.caption = caption; }

    @Override
    public String toString() {
        return "[Photo] " + getAuthor() + ": " + filename + " - " + caption + " (Likes: " + getLikes() + ")";
    }

    @Override
    public String toFileString() {
        return "PHO|" + getAuthor() + "|" + filename + "|" + caption + "|" + getLikes();
    }

    public static PhotoPost fromFileParts(String author, String[] parts) {
        if (parts.length < 5) return null;
        PhotoPost pp = new PhotoPost(author, parts[2], parts[3]);
        pp.setLikes(Integer.parseInt(parts[4]));
        return pp;
    }
}