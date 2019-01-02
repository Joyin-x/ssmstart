package com.demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author wwx
 * @date 2018/12/28 10:58
 **/

@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class Department {

    private int id;
    private String name;
    private String principal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }
}
