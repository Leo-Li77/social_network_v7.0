package news;

import posts.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class NewsFeed {
    private ArrayList<Post> posts;
    private Scanner input = new Scanner(System.in);

    public NewsFeed() {
        this.posts = new ArrayList<>();
    }

    public boolean addPost() {
        System.out.println("Select post type: 1) Message 2) Photo 3) Event");
        int type = input.nextInt();
        input.nextLine();

        System.out.println("[Enter author]");
        String author = input.nextLine();

        switch (type) {
            case 1:
                System.out.println("[Enter message]");
                String msg = input.nextLine();
                posts.add(new MessagePost(author, msg));
                break;
            case 2:
                System.out.println("[Enter filename]");
                String fname = input.nextLine();
                System.out.println("[Enter caption]");
                String cap = input.nextLine();
                posts.add(new PhotoPost(author, fname, cap));
                break;
            case 3:
                System.out.println("[Enter event name]");
                String ename = input.nextLine();
                System.out.println("[Enter event cost]");
                double cost = input.nextDouble();
                input.nextLine();
                posts.add(new EventPost(author, ename, cost));
                break;
            default:
                System.out.println("<Invalid post type>");
                return false;
        }
        System.out.println("<Post added successfully>");
        return true;
    }

    public boolean updatePost() {
        listPosts();
        if (posts.isEmpty())
            return false;

        System.out.println("[Enter index to update]");
        int idx = input.nextInt();
        input.nextLine();

        if (!isValidIndex(idx)) {
            System.out.println("<Invalid index>");
            return false;
        }

        Post p = posts.get(idx);
        System.out.println("[Enter new author]");
        String author = input.nextLine();
        p.setAuthor(author);

        if (p instanceof MessagePost mp) {
            System.out.println("[Enter new message]");
            mp.setMessage(input.nextLine());
        } else if (p instanceof PhotoPost pp) {
            System.out.println("[Enter new caption]");
            pp.setCaption(input.nextLine());
        } else if (p instanceof EventPost ep) {
            System.out.println("[Enter new event name]");
            ep.setEventName(input.nextLine());
            System.out.print("[Enter new cost]");
            ep.setEventCost(input.nextDouble());
            input.nextLine();
        }
        System.out.println("<Post updated successfully>");
        return true;
    }

    public boolean deletePost() {
        listPosts();
        if (posts.isEmpty()) return false;

        System.out.println("[Enter index to delete]");
        int idx = input.nextInt();
        input.nextLine();

        if (!isValidIndex(idx)) {
            System.out.println("<Invalid index>");
            return false;
        }
        posts.remove(idx);
        System.out.println("<Post deleted successfully>");
        return true;
    }

    public void listPosts() {
        if (posts.isEmpty()) {
            System.out.println("<No posts available>");
            return;
        }
        for (int i = 0; i < posts.size(); i++) {
            System.out.println(i + ": " + posts.get(i));
        }
    }

    public void likeOrUnlikePost() {
        listPosts();
        if (posts.isEmpty()) return;

        System.out.println("[Enter post index]");
        int idx = input.nextInt();
        input.nextLine();

        if (!isValidIndex(idx)) {
            System.out.println("<Invalid index>");
            return;
        }

        Post p = posts.get(idx);
        if (!(p instanceof LikedPost)) {
            System.out.println("<This post cannot be liked>");
            return;
        }

        System.out.println("1) Like 2) Unlike");
        int choice = input.nextInt();
        input.nextLine();

        if (choice == 1) likeAPost(idx);
        else if (choice == 2) unLikeAPost(idx);
        else System.out.println("<Invalid choice>");
    }

    public void likeAPost(int index) {
        if (isValidIndex(index)) {
            Post post = posts.get(index);
            if (post instanceof LikedPost lp) {
                lp.likeAPost();
                System.out.println("<Post liked>");
            }
        }
    }

    public void unLikeAPost(int index) {
        if (isValidIndex(index)) {
            Post post = posts.get(index);
            if (post instanceof LikedPost lp) {
                lp.unlikeAPost();
                System.out.println("<Post unliked>");
            }
        }
    }

    public boolean isValidIndex(int index) {
        return index >= 0 && index < posts.size();
    }

    public void savePosts() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("posts.txt"))) {
            for (Post p : posts) {
                pw.println(p.toFileString());
            }
            System.out.println("<Posts saved successfully>");
        } catch (IOException e) {
            System.out.println("<Error saving posts>");
        }
    }

    public void loadPosts() {
        File file = new File("posts.txt");
        if (!file.exists()) {
            System.out.println("<No saved posts found>");
            return;
        }
        posts.clear();
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Post p = Post.fromFileString(line);
                if (p != null) posts.add(p);
            }
            System.out.println("<Posts loaded successfully>");
        } catch (IOException e) {
            System.out.println("<Error loading posts>");
        }
    }
}