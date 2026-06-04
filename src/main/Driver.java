package main;

import news.NewsFeed;

import java.util.Scanner;

public class Driver {

    private final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=======================");
        System.out.println("| Social Network V7.0 |");
        System.out.println("=======================");

        Driver driver = new Driver();
        NewsFeed feed = new NewsFeed();
        driver.runMenu(feed);

    }


    private void showMenu() {
        System.out.println("-----------------------------");
        System.out.println("|         Main Menu         |");
        System.out.println("-----------------------------");
        System.out.println("| 1) Add a Post             |");
        System.out.println("| 2) Update a Post          |");
        System.out.println("| 3) Delete a Post          |");
        System.out.println("| 4) List Posts             |");
        System.out.println("| 5) Like / Unlike Post     |");
        System.out.println("-----------------------------");
        System.out.println("| 6) Save Posts             |");
        System.out.println("| 7) Load Posts             |");
        System.out.println("-----------------------------");
        System.out.println("| 0) Exit                   |");
        System.out.println("-----------------------------");
    }

    // getOption() - Version 2.0
    private int getOption() {
        int option = 0;
        try {
            option = input.nextInt();
            input.nextLine();
        } catch (Exception e) {
            input.nextLine(); // 清除无效输入
            return -1;
        }
        return option;
    }

    // runMenu() - Version 1.0
    private void runMenu(NewsFeed feed) {
        showMenu();
        System.out.println("[Enter your option]");
        int option = getOption();
        while (option != 0) {
            switch (option) {
                case 1 -> feed.addPost();
                case 2 -> feed.updatePost();
                case 3 -> feed.deletePost();
                case 4 -> feed.listPosts();
                case 5 -> feed.likeOrUnlikePost();
                case 6 -> feed.savePosts();
                case 7 -> feed.loadPosts();
                default -> System.out.println("<Invalid option>");
            }
            showMenu();
            System.out.println("[Enter your option]");
            option = getOption();
        }
        System.out.println("<Bye>");
    }
}
