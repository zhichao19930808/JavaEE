package library;

/**
 * Created by Administrator on 2017/6/29.
 */
public class Books {
    private Integer id;
    private String title;
    private String author;
    private String pub;
    private String time;
    private double price;
    private int amount;

    public Books(Integer id, String title, String author, String pub, String time, double price, int amount) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pub = pub;
        this.time = time;
        this.price = price;
        this.amount = amount;
    }

    public Books() {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPub(String pub) {
        this.pub = pub;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Integer getId() {

        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPub() {
        return pub;
    }

    public String getTime() {
        return time;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
}
