package table.relation;

public class IsVolunteer {
    private int pid;
    private  int vid;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public IsVolunteer(int pid, int vid) {
        this.pid = pid;
        this.vid = vid;
    }
}
