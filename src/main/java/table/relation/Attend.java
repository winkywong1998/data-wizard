package table.relation;

public class Attend {
    private int tid;
    private int mid;

    public Attend(int tid, int mid) {
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
