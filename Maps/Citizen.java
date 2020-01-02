/*
Write a Citizen class with instance variables of first name, last name, street, street number,
relation, rent or own, value of property (or rent amount), gender, age, marital status (single,
married, widowed, divorced), age at first marriage, attend school, can read, birthplace,
father’s birthplace, mother’s birthplace, mother tongue, year immigrated, occupation,
industry, and transcriber remarks. (Citizen must be sortable by priority based on the order
shown above.)
*/

public class Citizen {

    private String firstName;
    private String lastName;
    private String street;
    private String streetNumber;
    private String relation;
    private boolean renting;
    private double propertyValue;
    private String gender;
    private double age;
    private String maritalStatus;
    private int ageAtFirstMarriage;
    private boolean attendSchool;
    private boolean canRead;
    private String birthplace;
    private String fathersBirthplace;
    private String mothersBirthplace;
    private String mothersTongue;
    private int yearImmigrated;
    private String occupation;
    private String industry;
    private String remarks;

    public Citizen(String firstName, String lastName, String street, String streetNumber, String relation, boolean renting, double propertyValue, String gender, double age, String maritalStatus, int ageAtFirstMarriage, boolean attendSchool, boolean canRead, String birthplace, String fathersBirthplace, String mothersBirthplace, String mothersTongue, int yearImmigrated, String occupation, String industry, String remarks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.streetNumber = streetNumber;
        this.relation = relation;
        this.renting = renting;
        this.propertyValue = propertyValue;
        this.gender = gender;
        this.age = age;
        this.maritalStatus = maritalStatus;
        this.ageAtFirstMarriage = ageAtFirstMarriage;
        this.attendSchool = attendSchool;
        this.canRead = canRead;
        this.birthplace = birthplace;
        this.fathersBirthplace = fathersBirthplace;
        this.mothersBirthplace = mothersBirthplace;
        this.mothersTongue = mothersTongue;
        this.yearImmigrated = yearImmigrated;
        this.occupation = occupation;
        this.industry = industry;
        this.remarks = remarks;
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
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getStreetNumber() {
        return streetNumber;
    }
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
    public String getRelation() {
        return relation;
    }
    public void setRelation(String relation) {
        this.relation = relation;
    }
    public boolean isRenting() {
        return renting;
    }
    public void setRenting(boolean renting) {
        this.renting = renting;
    }
    public double getPropertyValue() {
        return propertyValue;
    }
    public void setPropertyValue(double propertyValue) {
        this.propertyValue = propertyValue;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public double getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getMaritalStatus() {
        return maritalStatus;
    }
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
    public int getAgeAtFirstMarriage() {
        return ageAtFirstMarriage;
    }
    public void setAgeAtFirstMarriage(int ageAtFirstMarriage) {
        this.ageAtFirstMarriage = ageAtFirstMarriage;
    }
    public boolean isAttendSchool() {
        return attendSchool;
    }
    public void setAttendSchool(boolean attendSchool) {
        this.attendSchool = attendSchool;
    }
    public boolean isCanRead() {
        return canRead;
    }
    public void setCanRead(boolean canRead) {
        this.canRead = canRead;
    }
    public String getBirthplace() {
        return birthplace;
    }
    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }
    public String getFathersBirthplace() {
        return fathersBirthplace;
    }
    public void setFathersBirthplace(String fathersBirthplace) {
        this.fathersBirthplace = fathersBirthplace;
    }
    public String getMothersBirthplace() {
        return mothersBirthplace;
    }
    public void setMothersBirthplace(String mothersBirthplace) {
        this.mothersBirthplace = mothersBirthplace;
    }
    public String getMothersTongue() {
        return mothersTongue;
    }
    public void setMothersTongue(String mothersTongue) {
        this.mothersTongue = mothersTongue;
    }
    public int getYearImmigrated() {
        return yearImmigrated;
    }
    public void setYearImmigrated(int yearImmigrated) {
        this.yearImmigrated = yearImmigrated;
    }
    public String getOccupation() {
        return occupation;
    }
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    public String getIndustry() {
        return industry;
    }
    public void setIndustry(String industry) {
        this.industry = industry;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}