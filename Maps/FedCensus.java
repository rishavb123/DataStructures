import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FedCensus {

    public static void main(String[] args) {
        ArrayList<Citizen> list = readFile();
        FedCensus obj = new FedCensus();
        if(args.length > 0) {
            Method method;
            for (String arg : args)
                try {
                    printLine();
                    printTitle(arg);
                    method = obj.getClass().getMethod(arg + "Stuff", ArrayList.class);
                    method.invoke(obj, list);
                    printLine();
                } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                        | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        else
            for(Method method: obj.getClass().getMethods())
                try {
                    if(method.getName().length() > 5 && method.getName().substring(method.getName().length() - 5).equals("Stuff")) {
                        printLine();
                        printTitle(method.getName().substring(0, method.getName().length() - 5));
                        method.invoke(obj, list);
                        printLine();
                    }
                } catch (SecurityException | IllegalAccessException | IllegalArgumentException
                        | InvocationTargetException e) {
                    e.printStackTrace();
                }
    }

    public static void printLine() {
        System.out.println("\n--------------------------------------------------------\n");
    }    

    public static void printTitle(String title) {
        System.out.println("\n----------------------\n");
        System.out.println(title);
        System.out.println("\n----------------------\n");
    }

    public void maritalStatusStuff(ArrayList<Citizen> citizens) {
        TreeMap<String, HashMap<String, HashSet<Double>>> map = new TreeMap<>();
        for(Citizen citizen: citizens) {
            if(citizen.getRenting() == null || citizen.getRenting().equals(".") || citizen.getMaritalStatus() == null || citizen.getMaritalStatus().equals(".") || citizen.getPropertyValue() == -1) continue;
            map.putIfAbsent(citizen.getMaritalStatus(), new HashMap<>());
            map.get(citizen.getMaritalStatus()).putIfAbsent(citizen.getRenting(), new HashSet<>());
            map.get(citizen.getMaritalStatus()).get(citizen.getRenting()).add(citizen.getPropertyValue());
        }
        System.out.println("Values:");
        for(String renting: map.keySet()) {
            System.out.println(renting + ": " + map.get(renting));
        }
        TreeMap<String, HashMap<String, Double>> averages = new TreeMap<>();
        for(String maritalStatus: map.keySet()) {
            averages.put(maritalStatus, new HashMap<>());
            for(String renting: map.get(maritalStatus).keySet()) {
                double sum = 0;
                for(Double a: map.get(maritalStatus).get(renting))
                    sum += a;
                averages.get(maritalStatus).put(renting, sum / map.get(maritalStatus).get(renting).size());
            }
        }
        System.out.println("\nAverages:");
        for(String renting: averages.keySet()) {
            System.out.println(renting + ": " + averages.get(renting));
        }
    }

    public void birthplaceStuff(ArrayList<Citizen> citizens) {
        TreeMap<String, PriorityQueue<Double>> map = new TreeMap<>();
        for(Citizen citizen: citizens) {
            if(citizen.getBirthplace() == null || citizen.getBirthplace().equals(".")) continue;
            map.putIfAbsent(citizen.getBirthplace(), new PriorityQueue<>());
            map.get(citizen.getBirthplace()).add(citizen.getAge());
        }

        for(String birthplace: map.keySet()) {
            System.out.println("Birthplace: " + birthplace);
            if(birthplace.equals("Pennsylvania")) 
                System.out.println("\tThere were " + map.get(birthplace).size() + " people from " + birthplace);
            else
                for(Double age: map.get(birthplace))
                    System.out.println("\tAge: " + age);
        }
    }

    public void languageStuff(ArrayList<Citizen> citizens) {
        TreeMap<String, ArrayList<String>> map = new TreeMap<>();
        for(Citizen citizen: citizens) {
            if(citizen.getMotherTongue() == null || citizen.getMotherTongue().equals(".")) continue;
            map.putIfAbsent(citizen.getMotherTongue(), new ArrayList<>());
            map.get(citizen.getMotherTongue()).add(citizen.getLastName() + ", " + citizen.getFirstName());
        }

        for(String motherTongue: map.keySet())
            System.out.println("There are " + map.get(motherTongue).size() + " " + ((map.get(motherTongue).size() == 1)? "person" : "people") + " who speak " + motherTongue);

    }

    public void occupationStuff(ArrayList<Citizen> citizens) {
        TreeMap<String, HashSet<String>> map = new TreeMap<>();
        for(Citizen citizen: citizens) {
            if(citizen.getOccupation() ==  null || citizen.getOccupation().equals(".")) continue;
            map.putIfAbsent(citizen.getOccupation().replaceAll("\t", ""), new HashSet<>());
            map.get(citizen.getOccupation().replaceAll("\t", "")).add(citizen.getFathersBirthplace());
        }
        for(String occupation: map.keySet()) {
            System.out.println(occupation + ": " + map.get(occupation) + " " + occupation.length());
        }
    }

    public void genderStuff(ArrayList<Citizen> citizens) {
        TreeMap<String, HashSet<String>> map = new TreeMap<>();
        for(Citizen citizen: citizens) {
            if(citizen.getGender() == null || citizen.getGender().equals(".")) continue;
            map.putIfAbsent(citizen.getGender(), new HashSet<>());
            map.get(citizen.getGender()).add(citizen.getRemarks());
        }
        for(String gender: map.keySet()) {
            System.out.println("\n\n" + gender + ": " + map.get(gender));
        }
    }    

    public void rentStuff(ArrayList<Citizen> citizens) {
        TreeMap<String, HashSet<Double>> map = new TreeMap<>();
        for(Citizen citizen: citizens) {
            if(citizen.getRenting() == null || citizen.getRenting().equals(".") || citizen.getPropertyValue() == -1) continue;
            map.putIfAbsent(citizen.getRenting(), new HashSet<>());
            map.get(citizen.getRenting()).add(citizen.getPropertyValue());
        }
        for(String renting: map.keySet()) {
            System.out.println(renting + ": " + map.get(renting));
        }
    }

    public void streetStuff(ArrayList<Citizen> citizens) {
        TreeMap<String, TreeSet<Citizen>> map = new TreeMap<>();

        for(Citizen citizen: citizens) {
            if(citizen.getStreet() == null || citizen.getStreet().equals(".")) continue;
            map.putIfAbsent(citizen.getStreet(), new TreeSet<>());
            map.get(citizen.getStreet()).add(citizen);
        }

        for(String street: map.keySet()) {
            System.out.println("Street: " + street);
            for(Citizen citizen: map.get(street))
                System.out.println("\t" + citizen);
        }
    }

    public static ArrayList<Citizen> readFile() {
        try {
            List<String> lines = Files.readAllLines(new File("./FedCensus1930_CambriaCountyPA.txt").toPath());
            
            ArrayList<Citizen> list = new ArrayList<>();
            for(String line: lines) {
                line = line.replaceAll("\\*", " ");
                if(line.length() > 3 && line.substring(0, 3).matches("-?\\d+")) {
                    //                            first name                                        last name                                         street                                            streetNumber                                      relation                                           renting                                             propertyValue                                       gender                                              age                                                 maritalStatus                                       ageAtFirstMarriage                                  attendSchool                                        canRead                                             birthplace                                          fathersBirthplace                                   mothersBirthplace                                   mothersTongue                                       yearImmigrated                                      occupation                                          industry                                            remarks                 
                    Citizen citizen = new Citizen(Util.removeLeadingAndTrailingSpaces(line.substring(71,88)), Util.removeLeadingAndTrailingSpaces(line.substring(55,71)), Util.removeLeadingAndTrailingSpaces(line.substring(20,36)), Util.removeLeadingAndTrailingSpaces(line.substring(36,45)), Util.removeLeadingAndTrailingSpaces(line.substring(88,108)), Util.removeLeadingAndTrailingSpaces(line.substring(108,113)), Util.removeLeadingAndTrailingSpaces(line.substring(113,121)), Util.removeLeadingAndTrailingSpaces(line.substring(133,138)), Util.removeLeadingAndTrailingSpaces(line.substring(143,151)), Util.removeLeadingAndTrailingSpaces(line.substring(151,156)), Util.removeLeadingAndTrailingSpaces(line.substring(156,162)), Util.removeLeadingAndTrailingSpaces(line.substring(162,167)), Util.removeLeadingAndTrailingSpaces(line.substring(167,173)), Util.removeLeadingAndTrailingSpaces(line.substring(173,190)), Util.removeLeadingAndTrailingSpaces(line.substring(190,207)), Util.removeLeadingAndTrailingSpaces(line.substring(207,224)), Util.removeLeadingAndTrailingSpaces(line.substring(224,235)), Util.removeLeadingAndTrailingSpaces(line.substring(235,241)), Util.removeLeadingAndTrailingSpaces(line.substring(252,274)), Util.removeLeadingAndTrailingSpaces(line.substring(274,303)), Util.removeLeadingAndTrailingSpaces(line.substring(342)));
                    list.add(citizen);
                }
            }

            return list;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}