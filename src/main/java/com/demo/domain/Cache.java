package com.demo.domain;

import java.io.Serializable;

public class Cache implements Serializable {
    private String UUID;
    private String value;

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Cache{" +
                "UUID='" + UUID + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
