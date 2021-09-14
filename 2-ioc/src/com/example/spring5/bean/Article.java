package com.example.spring5.bean;

/**
 * @ProjectName: spring5-code
 * @Package: spring5.bean
 * @ClassName: Article
 * @Author: guoyy
 * @Description:
 * @Date: 2021/9/2 上午2:25
 * @UpdateDate: 2021/9/2 上午2:25
 * @Version: 1.0
 */
public class Article {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "content='" + content + '\'' +
                '}';
    }
}
