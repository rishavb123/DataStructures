public class Util {

    public static String removeTrailingSpaces(String s) {
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) != ' ') return s.substring(0, i + 1);            
        }
        return "";
    }

    public static String removeLeadingSpace(String s) {
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' ') return s.substring(i);            
        }
        return "";
    }

    public static String removeLeadingAndTrailingSpaces(String s) {
        return removeTrailingSpaces(removeLeadingSpace(s));
    }

    public static double toDouble(String s) {
        s = s.replaceAll(" ", "").replaceAll("\\$", "").replaceAll("\\*", "").replaceFirst(",", "");
        if(s.length() == 0) return -1;
        return Double.parseDouble(s);
    }

    public static int toInt(String s) {
        s = s.replaceAll(" ", "").replaceAll("\\$", "").replaceAll("\\*", "").replaceFirst(",", "");
        if(s.length() == 0) return -1;
        return Integer.parseInt(s);
    }

    public static double convertFrac(int whole, String frac) {
        if (frac == null || frac.equals(""))
            return whole;
        String[] parts = frac.split("/");
        return whole + (double)Integer.parseInt(parts[0]) / (double)Integer.parseInt(parts[1]);
    }

    public static double fromMixedNumber(String s) {
        s = s.replaceAll(" ", "").replaceAll("\\$", "").replaceAll("\\*", "").replaceFirst(",", "");
        if(s.split(" ").length > 1)
            return convertFrac(Integer.parseInt(s.split(" ")[0]), s.split(" ")[1].replaceAll("\\*", "0"));
        else
            return s.contains("/")? convertFrac(0, s) : Double.parseDouble(s);
    }

}