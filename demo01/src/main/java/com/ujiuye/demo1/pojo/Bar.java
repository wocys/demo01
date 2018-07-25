package com.ujiuye.demo1.pojo;

public class Bar {
    private Integer bar_id;

    private String name;

    private Integer value;

    private Integer index;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getBar_id() {
        return bar_id;
    }

    public void setBar_id(Integer bar_id) {
        this.bar_id = bar_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}