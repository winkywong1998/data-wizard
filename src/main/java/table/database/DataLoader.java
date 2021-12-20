package table.database;

import com.opencsv.CSVReader;
import org.apache.commons.lang3.StringUtils;

import util.Generator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class DataLoader {
    List<String> vIdList;
    Generator generator;

    public DataLoader(){
        vIdList = new ArrayList<>();
        generator = new Generator();
    }
    public void loadData(Connection connection, CSVReader signUp, CSVReader meeting) {
        List<String> sqlList = new ArrayList<>();
        String[] admin1 = {"Che", "Mingxuan", "123-456-7890", "Y", "1"};
        String[] admin2 = {"Wang", "Xuanwei", "456-789-0123", "N", "2"};
        String adminUId1 = this.generator.genUid();
        String adminUId2 = this.generator.genUid();
        sqlList.add(getUserAsAdminSQL(admin1,adminUId1));
        sqlList.add(getUserAsAdminSQL(admin2,adminUId2));
        sqlList.add(getAdminSQL(admin1));
        sqlList.add(getAdminSQL(admin2));
        sqlList.add(getIsAdminSQL(admin1,adminUId1));
        sqlList.add(getIsAdminSQL(admin2,adminUId2));

        String line[];
        PreparedStatement ps = null;
        Iterator it1 = signUp.iterator();
        it1.next();

        while (it1.hasNext()) {
            String Uid = generator.genUid();
            line = (String[]) it1.next();
//            System.out.println(Arrays.toString(line));
            String [] elements  = StringUtils.strip(Arrays.toString(line),"[]").split(",");
            for(int i = 0; i < elements.length; i++){
               elements[i] = elements[i].trim();
            }
            sqlList.add(getUsersSQL(elements, Uid));
            sqlList.add(getPaticipantSQL(elements));

            if(elements[10].equals("1")){
                sqlList.add(getIsVolunteerSQL(elements));
                sqlList.add(getVolunteerSQL(elements));
            }
            sqlList.add(getIsParticipantSQL(elements, Uid));
            sqlList.add(getVolunteerSQL(elements));
            sqlList.add(getMemberOfSQL(elements));
        }

        for(int i = 1; i < 6; i++){
            sqlList.add(getTeamSQL(generator, i));
        }
        //Loading Meeting.csv
        Iterator it2 = meeting.iterator();
        it2.next();
        while (it2.hasNext()) {
            line = (String[]) it2.next();
//            System.out.println(Arrays.toString(line));
            String [] elements  = StringUtils.strip(Arrays.toString(line),"[]").split(",");
            for(int i = 0; i < elements.length; i++){
                elements[i] = elements[i].trim();
            }
            String[] attendList = elements[2].split("/");
            String[] registerList = elements[3].split("/");
            sqlList.add(getHoldSQL(elements));
            sqlList.add(getMeetingSQL(elements));
            for(int i = 0 ; i < generator.genInt(2) + 1; i++){
                sqlList.add(getHelpsSQL(elements));
            }
            for (String volunteer : this.vIdList){
                sqlList.add(getSupervisedBySQL(volunteer));
            }
            for(String team : attendList){
                sqlList.add(getAttendSQL(elements, team));
            }
            for(String team : registerList){
                sqlList.add(getRegisterSQL(elements, team));
            }
            break;
        }
        for(String sql : sqlList){
            try {
                ps = connection.prepareStatement(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Inserted Successfully！");
    }


    private String getUserAsAdminSQL(String[] elem, String Uid){
        String Upwd = "'" + this.generator.genPwd() + "'";
        String LName = "'" + elem[1] + "'";
        String FName = "'" + elem[0] + "'";
        String phone = "'" + elem[2] + "'";
        String concat = "(" + Uid + "," + Upwd + "," + LName + "," + FName + "," + phone + ")";
        String sql = "INSERT INTO user(Uid,Upwd,LName,FName,Phone) VALUES" + concat;
        System.out.println(sql);
        return sql;
    }

    private String getAdminSQL(String[] elem){
        String AdminId = elem[4];
        String IsLeader = "'" + elem[3] + "'";
        String concat = "(" + AdminId + "," + IsLeader + ")";
        String sql = "INSERT INTO admin(AdminId,IsLeader) VALUES" + concat;
        System.out.println(sql);
        return sql;
    }

    private String getIsAdminSQL(String[] elem, String Uid){
        String AdminId = elem[4];
        String concat = "(" + Uid + "," +  AdminId + ")";
        String sql = "INSERT INTO isadmin(Uid,AdminId) VALUES" + concat;
        System.out.println(sql);
        return sql;
    }

    private String getUsersSQL(String[] elem, String Uid){
        String Upwd = "'" + this.generator.genPwd() + "'";
        String LName = "'" + elem[2] + "'";
        String FName = "'" + elem[1] + "'";
        String phone = "'" + elem[4] + "'";
        String concat = "(" + Uid + "," + Upwd + "," + LName + "," + FName + "," + phone + ")";
        String sql = "INSERT INTO user(Uid,Upwd,LName,FName,Phone) VALUES" + concat;
        System.out.println(sql);
        return sql;
    }

    private String getPaticipantSQL(String[] elem){
        String ParticipantId = elem[0];
        String Degree = "'" + elem[11] + "'";
        String Major = "'" + elem[8] + "'";
        String YearOfCoding = elem[6];
        String NumOfExp = elem[7];
        String RorI = "'" + elem[9] + "'";
        String concat = "(" +
                ParticipantId + "," +
                Degree + "," +
                Major + "," +
                YearOfCoding + "," +
                NumOfExp +  "," +
                RorI + ")";
        String sql = "INSERT INTO participant(ParticipantId,Degree,Major,YearOfCoding,NumOfExp, RorI) VALUES" + concat;
        System.out.println(sql);
        return sql;
    }

    private String getIsVolunteerSQL(String[] elem){
        String ParticipantId = elem[0];
        String VolunteerId = this.generator.genUid();
        this.vIdList.add(VolunteerId);
        String concat = "(" + ParticipantId + "," + VolunteerId + ")";
        String sql = "INSERT INTO isVolunteer(ParticipantId,VolunteerId) VALUES" + concat;
        System.out.println(sql);
        return sql;
    }

    private String getIsParticipantSQL(String[] elem, String Uid){
        String ParticipantId = elem[0];
        String concat = "(" + Uid + "," + ParticipantId + ")";
        String sql = "INSERT INTO isParticipant(Uid,ParticipantId) VALUES" + concat;
        System.out.println(sql);
        return sql;
    }

    private String getVolunteerSQL(String[] elem){
        String VolunteerId = this.generator.genUid();
        String phone = "'" + elem[4] + "'";
        int HelpTime = this.generator.genInt(5);
        int CourseNum = this.generator.genInt(4) + 1;
        String concat = "(" + VolunteerId + "," + phone + ","  + HelpTime + "," + CourseNum + ")";
        String sql = "INSERT INTO volunteer(VolunteerId,phone,HelpTime,CourseNum) VALUES" + concat;
        System.out.println(sql);
        return sql;
    }

    private String getMemberOfSQL(String[] elem){
        String ParticipantId = elem[0];
        String TeamId = elem[12];
        String concat = "(" + ParticipantId + "," + TeamId + ")";
        String sql = "INSERT INTO memberOf(ParticipantId,TeamId) VALUES" + concat;
        System.out.println(sql);
        return sql;
    }

    private static String getTeamSQL(Generator generator, int TeamId){
        String MeetingTimes = generator.genInt(4) + "";
        String TeamName = "'" + generator.genRandomString(5) + "'";
        String concat = "(" + TeamId + "," + MeetingTimes + "," + TeamName + ")";
        String sql = "INSERT INTO team(TeamId, MeetingTimes,TeamName) VALUES" + concat;
        System.out.println(sql);
        return sql;
    }

    private String getMeetingSQL(String[] elem){
        String MeetingId = elem[0];
        String Time = "'" + this.generator.genDate() + "'";
        String Location = "'" + this.generator.genLoc() + "'";
        String TeamCapacity = String.valueOf(5);
        String concat = "(" + MeetingId + "," + Time + "," + Location + "," + TeamCapacity +")";
        String sql = "INSERT INTO meeting(MeetingId, Time, Location, TeamCapacity) VALUES" + concat;
        System.out.println(sql);
        return sql;
    }

    private String getHoldSQL(String[] elem){
        String AdminId = elem[1];
        String MeetingId = elem[0];
        String concat = "(" + AdminId + "," +  MeetingId + ")";
        String sql = "INSERT INTO hold(AdminId,MeetingId) VALUES" + concat;
        System.out.println(sql);
        return sql;
    }

    private String getHelpsSQL(String[] elem){
//        System.out.println(this.vIdList.size());
        String VolunteerId = this.vIdList.get(this.generator.genInt(this.vIdList.size()));
        String MeetingId = elem[0];
        String concat = "(" + VolunteerId + "," +  MeetingId + ")";
        String sql = "INSERT INTO helps(VolunteerId,MeetingId) VALUES" + concat;
        System.out.println(sql);
        return sql;
    }

    private String getSupervisedBySQL(String vId){
        String AdminId = this.generator.genInt(1) + 1 + "";
        String VolunteerId = vId;
        String concat = "(" + AdminId + "," +  VolunteerId + ")";
        String sql = "INSERT INTO supervisedby(AdminId,VolunteerId) VALUES" + concat;
        System.out.println(sql);
        return sql;
    }

    private String getRegisterSQL(String[] elem, String TeamId){
        String MeetingId = elem[0];
        String concat = "(" + TeamId + "," +  MeetingId + ")";
        String sql = "INSERT INTO register(TeamId,MeetingId) VALUES" + concat;
        System.out.println(sql);
        return sql;
    }

    private String getAttendSQL(String[] elem, String TeamId){
        String MeetingId = elem[0];
        String concat = "(" + TeamId + "," +  MeetingId + ")";
        String sql = "INSERT INTO attend(TeamId,MeetingId) VALUES" + concat;
        System.out.println(sql);
        return sql;
    }
}
