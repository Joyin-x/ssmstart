package com.demo.domain.notice;

/**
 * @Author: 千城暮雪
 * @DATE： 2019/4/3 19:44
 * @Version 1.0.0
 */
public class Like {
    private int id;
    private int employeeId;
    private int articleId;
    private int like;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", articleId=" + articleId +
                ", like=" + like +
                '}';
    }
}
