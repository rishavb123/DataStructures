import java.util.*;
import java.text.SimpleDateFormat;

public class Passenger implements Comparable<Passenger> {

    private String firstName;
    private String lastName;
    private String time;
    private String city;

    public Passenger(String name, String time, String city) {
        this.firstName = name.split(" ")[0];
        this.lastName = name.split(" ")[1];
        this.time = time;
        this.city = city;
    }

    public int compareTo(Passenger guy) {
        int a = etdCalc();
        int b = guy.etdCalc();
        if((a > 60 && b > 60) || a == b)
            return 0;
        return (a - b) / Math.abs(a-b);
    }

    public int etdCalc() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        String t = time.split(":")[0].length() > 1? time : "0" + time;
        if(t.substring(6).equals("AM"))
            t = t.substring(0, 6);
        else
            t = (Integer.parseInt(time.split(":")[0]) + 12) + ":" + time.split(":")[1].substring(0, 2);
        try {
            Date date = sdf.parse(t);
            Date cur = sdf.parse("09:03");
            long diff = date.getTime() - cur.getTime();
            return (int) (diff / 60000L);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String flightTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String flightCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String toString() {
        int minutes = etdCalc();
        return lastName + ", " + firstName + " - " + city + " - " + time + " - " + (minutes > 60? (minutes/60) + " hour" + (minutes > 120? "s":"") + " and ":"") + (minutes%60) + " minutes from now";
    }

}