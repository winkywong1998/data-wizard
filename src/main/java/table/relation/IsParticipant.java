package table.relation;

public class IsParticipant {
    private String uid;
    private int pid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public IsParticipant(String uid, int pid) {
        this.uid = uid;
        this.pid = pid;
    }
}
