package com.demo.domain.attendance;

public class updateAttendance {
    private int id;
    private String afterWork;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAfterWork() {
        return afterWork;
    }

    public void setAfterWork(String afterWork) {
        this.afterWork = afterWork;
    }

    @Override
    public String toString() {
        return "updateAttendance{" +
                "id=" + id +
                ", afterWork='" + afterWork + '\'' +
                '}';
    }
}
