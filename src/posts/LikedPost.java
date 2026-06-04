package posts;

public abstract class LikedPost extends Post {

    private int likes;

    public LikedPost(String author) {
        super(author);
        this.likes = 0;
    }

    public void likeAPost() {
        likes++;
    }

    public void unlikeAPost() {
        if (likes > 0)
            likes--;
    }

    public int getLikes() {
        return likes;
    }

    protected void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public abstract String toFileString();
}