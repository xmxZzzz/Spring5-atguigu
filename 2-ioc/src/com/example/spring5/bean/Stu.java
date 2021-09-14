package com.example.spring5.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ProjectName: spring5-code
 * @Package: spring5.bean
 * @ClassName: Stu
 * @Author: guoyy
 * @Description:
 * @Date: 2021/9/2 上午2:36
 * @UpdateDate: 2021/9/2 上午2:36
 * @Version: 1.0
 */
public class Stu {
    private String[] strs;
    private List<String> list;
    private Map<String,String> map;
    private Set<String> set;
    private List<Article> articleList;
    private Map<String,Article> articleMap;
    private Set<Article> articleSet;

    public void setArticleSet(Set<Article> articleSet) {
        this.articleSet = articleSet;
    }

    public void setArticleMap(Map<String, Article> articleMap) {
        this.articleMap = articleMap;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "strs=" + Arrays.toString(strs) +
                ", list=" + list +
                ", map=" + map +
                ", set=" + set +
                ", articleList=" + articleList +
                ", articleMap=" + articleMap +
                ", articleSet=" + articleSet +
                '}';
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public void setStrs(String[] strs) {
        this.strs = strs;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public String[] getStrs() {
        return strs;
    }

    public List<String> getList() {
        return list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public Set<String> getSet() {
        return set;
    }

    public List<Article> getArticleList() {
        return articleList;
    }
}
