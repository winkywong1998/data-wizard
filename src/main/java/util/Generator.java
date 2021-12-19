package util;

import java.sql.Timestamp;
import java.util.Random;

public class Generator {
    Random rand;

    public Generator(){
        rand = new Random();
    }

    public String genUid(){
        return Integer.toString(rand.nextInt(1000000000));
    }

    public String genPwd(){
        return Integer.toString(rand.nextInt(1000000000));
    }

    public Timestamp genTS(){
        long offset = Timestamp.valueOf("2021-01-01 00:00:00").getTime();
        long end = Timestamp.valueOf("2022-01-01 00:00:00").getTime();
        long diff = end - offset + 1;
        Timestamp ts = new Timestamp(offset + (long)(Math.random() * diff));
        return ts;
    }

    public String genLoc(){
        String[] loc= {"Ames Hall",
            "Barton Hall",
            "Bloomberg Center",
            "Clark Hall",
            "Croft Hall",
            "Hackerman Hall",
            "Krieger Hall",
            "Latrobe Hall"};
        return loc[rand.nextInt(loc.length)];
    }

}
