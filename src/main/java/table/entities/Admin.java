package table.entities;

public class Admin extends User {
    private boolean isLeader;
    private int aid;

    public Admin(String uid, String upwd, String fName, String lName, String phone, boolean isLeader, int aid) {
        super(uid, upwd, fName, lName, phone);
        this.isLeader = isLeader;
        this.aid = aid;
    }

    public Admin(boolean isLeader, int aid) {
        this.isLeader = isLeader;
        this.aid = aid;
    }
}
