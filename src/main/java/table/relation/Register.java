package table.relation;

public class Register {
    private  int tid;
    private  int mid;

    public Register(int tid, int mid) {
        this.tid = tid;
        this.mid = mid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }
}
