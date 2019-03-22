package com.demo.domain.notice;

public class Discuss {
    private int id;
    private int employeeID;
    private String content;
    private String discussTime;
    private String employeeName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDiscussTime() {
        return discussTime;
    }

    public void setDiscussTime(String discussTime) {
        this.discussTime = discussTime;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return "Discuss{" +
                "id=" + id +
                ", employeeID=" + employeeID +
                ", content='" + content + '\'' +
                ", discussTime='" + discussTime + '\'' +
                ", employeeName='" + employeeName + '\'' +
                '}';
    }
}
