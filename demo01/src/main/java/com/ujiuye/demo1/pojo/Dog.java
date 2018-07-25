package com.ujiuye.demo1.pojo;

public class Dog {
    private Integer dog_id;

    private String name;

    private Integer person_fk;

    public Integer getDog_id() {
        return dog_id;
    }

    public void setDog_id(Integer dog_id) {
        this.dog_id = dog_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getPerson_fk() {
        return person_fk;
    }

    public void setPerson_fk(Integer person_fk) {
        this.person_fk = person_fk;
    }
}