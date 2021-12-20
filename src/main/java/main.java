import com.opencsv.CSVReader;
import db.ConnectDB;
import db.DataLoader;
import util.CSV;

import java.io.IOException;
import java.sql.Connection;

public class main {
    public static void main(String[] args) throws IOException {
        Connection connection = ConnectDB.getConnection();
        CSV rawFile = new CSV("SignUpSheets.csv");
        rawFile.anonymize();
        CSVReader signUp = CSV.getCVS(System.getProperty("user.dir") + "\\anonymizedDataSource.csv");
        CSVReader meeting = new CSV("Meeting.csv").getReader();
        DataLoader dl = new DataLoader();
        dl.loadData(connection, signUp, meeting);
    }
}
