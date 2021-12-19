package util;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Anonymizer {
    String path;
    List<String> fNameList;
    List<String> lNameList;
    List<String> emailList;
    List<String> phoneList;
    Random rand;

    public Anonymizer(String csvName) throws IOException {
        rand= new Random();
        this.path = getCVSFilePath(csvName);
        this.fNameList = getColumnList("first_name");
        this.lNameList = getColumnList("last_name");
        this.emailList = getColumnList("email");
        this.phoneList = getColumnList("phone1");
    }

    public String getCVSFilePath(String csvName) {
        String filePath = Anonymizer.class.getClassLoader().getResource(csvName).getFile();
        return filePath;
    }


    private List<String> getColumnList(String columnName) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(path));
        List<String> list = new ArrayList();
        String [] nextLine;
        String [] entries = reader.readNext();
        int index = -1;
        for (int i = 0 ; i < entries.length; i++){
            if (entries[i].equals(columnName)){
                index = i;
            }
        }
        if(index != -1){
            while ((nextLine = reader.readNext()) != null) {
                list.add(nextLine[index]);
            }
        }else{
            return null;
        }
        return list;
    }

    public String getRandomFName() throws FileNotFoundException {
        String firstName = fNameList.get(rand.nextInt(fNameList.size()));
        return firstName;
    }

    public String getRandomLName() throws FileNotFoundException {
        String lastName = lNameList.get(rand.nextInt(lNameList.size()));
        return lastName;
    }

    public String getRandomEmail() throws FileNotFoundException {
        String email = emailList.get(rand.nextInt(emailList.size()));
        return email;
    }

    public String getRandomPhone() throws FileNotFoundException {
        String email = phoneList.get(rand.nextInt(phoneList.size()));
        return email;
    }
}
