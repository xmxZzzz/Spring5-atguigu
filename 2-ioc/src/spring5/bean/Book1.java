package spring5.bean;

/**
 * @ProjectName: spring5-code
 * @Package: spring5.bean
 * @ClassName: Book1
 * @Author: guoyy
 * @Description:
 * @Date: 2021/9/2 上午2:15
 * @UpdateDate: 2021/9/2 上午2:15
 * @Version: 1.0
 */
public class Book1 {
    private String bname;
    public Book1(String bname){
        this.bname = bname;
    }

    public String getBname() {
        return bname;
    }

    @Override
    public String toString() {
        return "Book1{" +
                "bname='" + bname + '\'' +
                '}';
    }
}
