package table.relation;

public class IsMemberOf {
    private int pid;
    private  int tid;

    public IsMemberOf(int pid, int tid) {
        this.pid = pid;
        this.tid = tid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }
}
