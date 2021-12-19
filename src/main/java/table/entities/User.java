package table.entities;

public class User {
    private String uid;
    private String upwd;
    private String fName;
    private String lName;
    private String Phone;

    public User(String uid, String upwd, String fName, String lName, String phone) {
        this.uid = uid;
        this.upwd = upwd;
        this.fName = fName;
        this.lName = lName;
        Phone = phone;
    }

    public User() {
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getUid() {
        return uid;
    }

    public String getUpwd() {
        return upwd;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getPhone() {
        return Phone;
    }
}
