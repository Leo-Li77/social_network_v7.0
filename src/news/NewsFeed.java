package news;

import posts.*;
import java.util.ArrayList;

public class NewsFeed {

    private ArrayList<Post> posts;

    public boolean addPost() {
        return false;
    }

    public boolean updatePost() {
        return false;
    }

    public boolean deletePost() {
        return false;
    }

    public void listPosts() {

    }

    public void likeOrUnlikePost() {

    }

    public void likeAPost(int index) {
        Post post = null;
        if (isValidIndex(index)) {
            post = posts.get(index);
            if ((post instanceof LikedPost)){
                ((LikedPost) post).likeAPost();
            }
        }
    }

    public void unLikeAPost(int index) {
        Post post = null;
        if (isValidIndex(index)) {
            post = posts.get(index);
            if ((post instanceof LikedPost)){
                ((LikedPost) post).unlikeAPost();
            }
        }
    }

    public boolean isValidIndex(int index) {
        return false;
    }

    public void savePosts() {

    }

    public void loadPosts() {

    }
}
