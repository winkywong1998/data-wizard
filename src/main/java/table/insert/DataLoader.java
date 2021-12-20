package table.insert;

import com.opencsv.CSVReader;
import org.apache.commons.lang3.StringUtils;
import util.Generator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DataLoader {

    public static void loadData(Connection connection, CSVReader reader) {
        Generator generator = new Generator();
        String line[];
        Iterator it = reader.iterator();
        it.next();
        while (it.hasNext()) {
            line = (String[]) it.next();
//            System.out.println(Arrays.toString(line));
            String [] elements  = StringUtils.strip(Arrays.toString(line),"[]").split(",");
            for(int i = 0; i < elements.length; i++){
               elements[i] = elements[i].trim();
            }
            PreparedStatement ps = null;
            String Uid = generator.genUid();
            try {
                List<String> sqlList = new ArrayList<>();
                sqlList.add(getUsersSQL(elements, generator, Uid));
                sqlList.add(getPaticipantSQL(elements));

                if(elements[10].equals("1")){
                    sqlList.add(getIsVolunteerSQL(elements,generator));
                    sqlList.add(getVolunteerSQL(elements,generator));
                }
                sqlList.add(getIsParticipantSQL(elements, Uid));
                sqlList.add(getVolunteerSQL(elements, generator));
                sqlList.add(getMemberOfSQL(elements));
                for(String sql : sqlList){
                    ps = connection.prepareStatement(sql);
                    ps.executeUpdate();
                }
                System.out.println("Inserted Successfully！");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            break;
        }
    }


    private static String getUsersSQL(String[] elem, Generator generator, String Uid){
        String Upwd = "'" + generator.genPwd() + "'";
        String LName = "'" + elem[2] + "'";
        String FName = "'" + elem[1] + "'";
        String phone = "'" + elem[4] + "'";
        String concat = "(" + Uid + "," + Upwd + "," + LName + "," + FName + "," + phone + ")";
        String sql = "INSERT INTO users(Uid,Upwd,LName,FName,Phone) VALUES" + concat;
        System.out.println(sql);
        return sql;
    }

    private static String getPaticipantSQL(String[] elem){
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

    private static String getIsVolunteerSQL(String[] elem, Generator generator){
        String ParticipantId = elem[0];
        String VolunteerId = generator.genUid();
        String concat = "(" + ParticipantId + "," + VolunteerId + ")";
        String sql = "INSERT INTO isVolunteer(ParticipantId,VolunteerId) VALUES" + concat;
        System.out.println(sql);
        return sql;
    }

    private static String getIsParticipantSQL(String[] elem, String Uid){
        String ParticipantId = elem[0];
        String concat = "(" + Uid + "," + ParticipantId + ")";
        String sql = "INSERT INTO isParticipant(Uid,ParticipantId) VALUES" + concat;
        System.out.println(sql);
        return sql;
    }

    private static String getVolunteerSQL(String[] elem, Generator generator){
        String VolunteerId = generator.genUid();
        String phone = "'" + elem[4] + "'";
        int HelpTime = generator.genInt(5);
        int CourseNum = generator.genInt(4);
        String concat = "(" + VolunteerId + "," + phone + ","  + HelpTime + "," + CourseNum + ")";
        String sql = "INSERT INTO volunteer(VolunteerId,phone,HelpTime,CourseNum) VALUES" + concat;
        System.out.println(sql);
        return sql;
    }

    private static String getMemberOfSQL(String[] elem){
        String ParticipantId = elem[0];
        String TeamId = elem[12];
        String concat = "(" + ParticipantId + "," + TeamId + ")";
        String sql = "INSERT INTO memberOf(ParticipantId,TeamId) VALUES" + concat;
        System.out.println(sql);
        return sql;
    }
}
