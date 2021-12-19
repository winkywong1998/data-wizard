package table.entities;

public class Volunteer extends Participant{
    private int vid;
    private String phone;
    private int helpTime;
    private int courseNum;

    public Volunteer(String uid, String upwd, String fName, String lName, String phone, int pid, boolean rorI, int numOfExp, String major, int yearOfCoding, String degree, int vid, String phone1, int helpTime, int courseNum) {
        super(uid, upwd, fName, lName, phone, pid, rorI, numOfExp, major, yearOfCoding, degree);
        this.vid = vid;
        this.phone = phone1;
        this.helpTime = helpTime;
        this.courseNum = courseNum;
    }

    public Volunteer(int pid, boolean rorI, int numOfExp, String major, int yearOfCoding, String degree, int vid, String phone, int helpTime, int courseNum) {
        super(pid, rorI, numOfExp, major, yearOfCoding, degree);
        this.vid = vid;
        this.phone = phone;
        this.helpTime = helpTime;
        this.courseNum = courseNum;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getHelpTime() {
        return helpTime;
    }

    public void setHelpTime(int helpTime) {
        this.helpTime = helpTime;
    }

    public int getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(int courseNum) {
        this.courseNum = courseNum;
    }
}
