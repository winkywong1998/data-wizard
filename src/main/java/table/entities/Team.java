package table.entities;

public class Team {
    private int tid;
    private String TeamName;
    private int meetingTime;

    public Team(int tid, String teamName, int meetingTime) {
        this.tid = tid;
        TeamName = teamName;
        this.meetingTime = meetingTime;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    public int getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(int meetingTime) {
        this.meetingTime = meetingTime;
    }
}
