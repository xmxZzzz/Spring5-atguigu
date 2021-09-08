package spring5.bean;

/**
 * @ProjectName: spring5-code
 * @Package: spring5.test
 * @ClassName: Book
 * @Author: guoyy
 * @Description:
 * @Date: 2021/8/30 上午12:42
 * @UpdateDate: 2021/8/30 上午12:42
 * @Version: 1.0
 */
public class Book {
    private String name;
    private String author;
    private String version;
    private String createTime;
    private String address;
    private Article article;
    private Book1 book1;

    public void setBook1(Book1 book1) {
        this.book1 = book1;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Article getArticle() {
        return article;
    }

    public Book1 getBook1() {
        return book1;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Book(String version){
        this.version = version;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAuthor(String author){
        this.author= author;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getVersion() {
        return version;
    }
}
