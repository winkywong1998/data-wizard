package util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.apache.commons.lang3.StringUtils;

public class CSV {
    String path;
    CSVReader reader;

    public CSVReader getReader() {
        return reader;
    }

    public CSV (String csvName) throws FileNotFoundException {
        this.path = getCVSFilePath(csvName);
        this.reader = getCVS(this.path);
    }

    public String getCVSFilePath(String csvName) {
        String filePath = CSV.class.getClassLoader().getResource(csvName).getFile();
        return filePath;
    }

    public static CSVReader getCVS(String path) throws FileNotFoundException {
            CSVReader reader = new CSVReader(new FileReader(path));
            return reader;
    }

    public void printCVS(){
        String line[];
        Iterator it = this.reader.iterator();
        while (it.hasNext()) {
            line = (String[]) it.next();
            System.out.println(Arrays.toString(line));
            System.out.println("");
        }
    }

    public void anonymize() throws IOException {
            Anonymizer rand = new Anonymizer("us-500.csv");
            CSVWriter writer = new CSVWriter(new FileWriter("anonymizedDataSource.csv"));
            String[] entries = "number, first_name, last_name, email, phone, coding_before, yearOfCoding, num_of_exp, major, r_or_i, volunteer_or_not, degree, team"
                    .split(",");
            writer.writeNext(entries);

            String line[];
            Iterator it = this.reader.iterator();
            List<String> list;
            it.next();
            while (it.hasNext()) {
                    line = (String[]) it.next();
                    String [] elements = StringUtils.strip(Arrays.toString(line),"[]").split(",");
                    list = Arrays.asList(elements);
                    List<String> judgeList = new ArrayList<>(list);
                    judgeList.add(1, rand.getRandomFName());
                    judgeList.add(2, rand.getRandomLName());
                    judgeList.add(3, rand.getRandomEmail());
                    judgeList.add(4, rand.getRandomPhone());
                    writer.writeNext(judgeList.toArray(new String[list.size()]));
            }
        writer.close();
    }
}
