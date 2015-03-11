package com.fedomn.todomvc.Model;

import java.util.Date;

public class Goddess {

    private Integer id;
    private String user_name;
    private Integer sex;
    private Integer age;
    private Date birthday;
    private String email;
    private String mobile;
    private Date create_date;
    private Date update_date;

    public Goddess(Integer id, String user_name, Integer sex, Integer age, Date birthday, String email, String mobile) {
        this.id = id;
        this.user_name = user_name;
        this.sex = sex;
        this.age = age;
        this.birthday = birthday;
        this.email = email;
        this.mobile = mobile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Goddess)) return false;

        Goddess goddess = (Goddess) o;
        return goddess.id.equals(id) &&
                goddess.age.equals(age) &&
                goddess.birthday.equals(birthday) &&
                goddess.email.equals(email) &&
                goddess.mobile.equals(mobile) &&
                goddess.sex.equals(sex) &&
                goddess.user_name.equals(user_name);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (user_name != null ? user_name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Goddess{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", create_date=" + create_date +
                ", update_date=" + update_date +
                '}';
    }
}
