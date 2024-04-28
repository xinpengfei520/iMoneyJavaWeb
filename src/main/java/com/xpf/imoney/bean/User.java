package com.xpf.imoney.bean;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * Created by Vance on 2019/7/23 :)
 * Function:用户实体类
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    /**
     * Hibernate Validator 注解, User 对象的 name 属性必填
     */
    @NotEmpty
    private String name;
    private String password;
    private String gentle;
    private String email;
    private String city;

    public User() {
        super();
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGentle() {
        return gentle;
    }

    public void setGentle(String gentle) {
        this.gentle = gentle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", gentle='" + gentle + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
