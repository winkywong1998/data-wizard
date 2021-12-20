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

    public static Timestamp genDate(){
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

    public static String genRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
