import com.opencsv.CSVReader;
import table.ConnectDB;
import table.insert.DataLoader;
import util.CSV;

import java.io.IOException;
import java.sql.Connection;

public class main {
    public static void main(String[] args) throws IOException {
        Connection connection = ConnectDB.getConnection();
        CSV rawFile = new CSV("SignUpSheets.csv");
        rawFile.anonymize();
        CSVReader reader = CSV.getCVS(System.getProperty("user.dir") + "\\anonymizedDataSource.csv");
        DataLoader.loadData(connection, reader);


//        System.out.println(randomizer.fNameList);
//        System.out.println(randomizer.getRandomFName());
//        System.out.println(randomizer.getRandomLName());
//        System.out.println(randomizer.getRandomEmail());
//        System.out.println(randomizer.getRandomPhone());
//        ConnectDB.getConnection();
    }
}
