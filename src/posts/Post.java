package posts;

public abstract class Post {
    private String author;

    public Post(String author) {
        this.author = author;
    }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    // 用于保存到文件的格式化字符串
    public abstract String toFileString();

    // 静态工厂方法：从文件行还原对象
    public static Post fromFileString(String line) {
        String[] parts = line.split("\\|", -1);
        if (parts.length < 2) return null;

        String type = parts[0];
        String author = parts[1];

        return switch (type) {
            case "MSG" -> MessagePost.fromFileParts(author, parts);
            case "PHO" -> PhotoPost.fromFileParts(author, parts);
            case "EVT" -> EventPost.fromFileParts(author, parts);
            default -> null;
        };
    }
}