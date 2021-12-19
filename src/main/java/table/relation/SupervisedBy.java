package table.relation;

public class SupervisedBy {
    private int vid;
    private int aid;

    public SupervisedBy(int vid, int aid) {
        this.vid = vid;
        this.aid = aid;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }
}
