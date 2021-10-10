package com.example.ichat.Models;

public class Users {

    String profilepic , useraName , mail , password , userId , lastMessage;

    public Users(String profilepic, String useraName, String mail, String password, String userId, String lastMessage) {
        this.profilepic = profilepic;
        this.useraName = useraName;
        this.mail = mail;
        this.password = password;
        this.userId = userId;
        this.lastMessage = lastMessage;
    }


    public Users(){}

    //Signup Constructors

    public Users(String useraName, String mail, String password) {

        this.useraName = useraName;
        this.mail = mail;
        this.password = password;
    }


    public String getProfilepic() {
        return profilepic;
    }



    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public String getUseraName() {
        return useraName;
    }

    public void setUseraName(String useraName) {
        this.useraName = useraName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }
}
