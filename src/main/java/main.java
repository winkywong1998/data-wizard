import util.CSV;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        CSV CVSfile = new CSV("DataSource.csv");
//        CVSfile.printCVS();
        CVSfile.anonymize();
//        Randomizer randomizer = new Randomizer("us-500.csv");
//        System.out.println(randomizer.fNameList);
//        System.out.println(randomizer.getRandomFName());
//        System.out.println(randomizer.getRandomLName());
//        System.out.println(randomizer.getRandomEmail());
//        System.out.println(randomizer.getRandomPhone());
//        ConnectDB.getConnection();
    }
}
