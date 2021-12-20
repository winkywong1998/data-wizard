package util;

import java.sql.Timestamp;
import java.util.Random;

public class Generator {
    static Random rand;

    public Generator(){
        rand = new Random();
    }

    public static String genUid(){
        return Integer.toString(rand.nextInt(1000000000));
    }

    public static String genPwd(){
        return Integer.toString(rand.nextInt(1000000000));
    }

    public static Timestamp genTS(){
        long offset = Timestamp.valueOf("2021-01-01 00:00:00").getTime();
        long end = Timestamp.valueOf("2022-01-01 00:00:00").getTime();
        long diff = end - offset + 1;
        Timestamp ts = new Timestamp(offset + (long)(Math.random() * diff));
        return ts;
    }

    public static String genLoc(){
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

    public static int genInt(int Range){
        return rand.nextInt(Range);
    }
}
