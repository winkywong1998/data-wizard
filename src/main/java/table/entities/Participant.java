package table.entities;

public class Participant extends User {
    private int pid;
    private boolean RorI;
    private int numOfExp;
    private String major;
    private int yearOfCoding;
    private String Degree;

    public Participant(String uid, String upwd, String fName, String lName, String phone, int pid, boolean rorI, int numOfExp, String major, int yearOfCoding, String degree) {
        super(uid, upwd, fName, lName, phone);
        this.pid = pid;
        RorI = rorI;
        this.numOfExp = numOfExp;
        this.major = major;
        this.yearOfCoding = yearOfCoding;
        Degree = degree;
    }

    public Participant(int pid, boolean rorI, int numOfExp, String major, int yearOfCoding, String degree) {
        this.pid = pid;
        RorI = rorI;
        this.numOfExp = numOfExp;
        this.major = major;
        this.yearOfCoding = yearOfCoding;
        Degree = degree;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setRorI(boolean rorI) {
        RorI = rorI;
    }

    public void setNumOfExp(int numOfExp) {
        this.numOfExp = numOfExp;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setYearOfCoding(int yearOfCoding) {
        this.yearOfCoding = yearOfCoding;
    }

    public void setDegree(String degree) {
        Degree = degree;
    }

    public int getPid() {
        return pid;
    }

    public boolean isRorI() {
        return RorI;
    }

    public int getNumOfExp() {
        return numOfExp;
    }

    public String getMajor() {
        return major;
    }

    public int getYearOfCoding() {
        return yearOfCoding;
    }

    public String getDegree() {
        return Degree;
    }
}
