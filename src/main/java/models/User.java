package models;

import java.util.*;

public class User {
    private Integer id;
    private String firstName;
    private String surName;
    private String mail;
    private String phone;
    private String password;
    private Boolean isPremium;
    public String login;
    private String birthday;
    private List<Dictionary> dictionaryList;
    private String role;


    public User() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getPremium() {
        return isPremium;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPremium(Boolean premium) {
        isPremium = premium;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public User(String firstName, String surName, String birthday, String mail, String phone, String password, String login) {
        this.firstName = firstName;
        this.surName = surName;
        this.mail = mail;
        this.phone = phone;
        this.password = password;
        this.isPremium = false;
        this.login = login;
        this.birthday = birthday;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Dictionary> getDictionaryList() {
        return dictionaryList;
    }

    public void setDictionaryList(List<Dictionary> dictionaryList) {
        this.dictionaryList = dictionaryList;
    }

    public List<String> getDictionaryNameAsList() {
        List<String> dictionaryNameList= new LinkedList<>();
        for (Dictionary dictionary: dictionaryList
             ) {
            dictionaryNameList.add(dictionary.getName());
        }
        return dictionaryNameList;
    }

    public Map<String, String> getDictionaryIdAndNameAsMap() {
        Map<String, String> map = new HashMap<>();
        for (Dictionary dictionary: dictionaryList
        ) {
            map.put(String.valueOf(dictionary.getId()), dictionary.getName());
        }
        return map;
    }

    public Dictionary getDictionatyById(Integer id) {
        Dictionary temp = null;
        for (Dictionary dictionary:this.dictionaryList
             ) {
            if(dictionary.getId() == id ) {
                temp = dictionary;
                break;
            }
        }
        return temp;
    }

}
