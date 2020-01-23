public class Citizen implements Comparable<Citizen> {

    private String firstName;
    private String lastName;
    private String street;
    private String streetNumber;
    private String relation;
    private String renting;
    private Double propertyValue;
    private String gender;
    private Double age;
    private String maritalStatus;
    private Integer ageAtFirstMarriage;
    private String attendSchool;
    private String canRead;
    private String birthplace;
    private String fathersBirthplace;
    private String mothersBirthplace;
    private String motherTongue;
    private Integer yearImmigrated;
    private String occupation;
    private String industry;
    private String remarks;

    public Citizen(String firstName, String lastName, String street, String streetNumber, String relation, String renting, String propertyValue, String gender, String age, String maritalStatus, String ageAtFirstMarriage, String attendSchool, String canRead, String birthplace, String fathersBirthplace, String mothersBirthplace, String mothersTongue, String yearImmigrated, String occupation, String industry, String remarks) {
        this(
            firstName, 
            lastName, 
            street, 
            streetNumber, 
            relation, 
            (renting.equals(".") || renting.equals("un") || renting.equals(""))? null: renting, 
            (propertyValue.equals(".") || propertyValue.equals("un") || propertyValue.equals(""))? -1: (propertyValue.contains(" ")? Util.fromMixedNumber(propertyValue): Util.toDouble(propertyValue)), 
            gender, 
            (age.equals(".") || age.equals("un") || age.equals(""))? -1 : Util.fromMixedNumber(age), 
            maritalStatus, 
            (ageAtFirstMarriage.equals(".") || ageAtFirstMarriage.equals("un") || ageAtFirstMarriage.equals(""))? -1: (ageAtFirstMarriage.equals(".")? -1 : Util.toInt(ageAtFirstMarriage)), 
            attendSchool, 
            canRead, 
            birthplace, 
            fathersBirthplace, 
            mothersBirthplace, 
            mothersTongue, 
            (yearImmigrated.equals(".") || yearImmigrated.equals("un") || yearImmigrated.equals(""))? -1 : Util.toInt(yearImmigrated), 
            occupation, 
            industry, 
            remarks
        );
    }

    public Citizen(String firstName, String lastName, String street, String streetNumber, String relation, String renting, double propertyValue, String gender, double age, String maritalStatus, int ageAtFirstMarriage, String attendSchool, String canRead, String birthplace, String fathersBirthplace, String mothersBirthplace, String motherTongue, int yearImmigrated, String occupation, String industry, String remarks) {
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
        this.motherTongue = motherTongue;
        this.yearImmigrated = yearImmigrated;
        this.occupation = occupation;
        this.industry = industry;
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " from " + getStreet();
    }

    /*
        Generated with JavaScript:
        const capitalize = (s) => {
            if (typeof s !== 'string') return ''
            return s.charAt(0).toUpperCase() + s.slice(1)
        }
        let arr = "firstName lastName street streetNumber relation renting propertyValue gender age maritalStatus ageAtFirstMarriage attendSchool canRead birthplace fathersBirthplace mothersBirthplace motherTongue yearImmigrated occupation industry remarks".split(" ");
        let result = "";
        for(let i = 0; i < arr.length; i++) {
            result += `if(${arr[i]}.compareTo(o.get${capitalize(arr[i])}()) != 0)\n\treturn ${arr[i]}.compareTo(o.get${capitalize(arr[i])}());\nelse `;
        }
        result+="\n\treturn 0;";
        console.log(result);
    */
    @Override
    public int compareTo(Citizen o) {
        if(firstName.compareTo(o.getFirstName()) != 0)
            return firstName.compareTo(o.getFirstName());
        else if(lastName.compareTo(o.getLastName()) != 0)
            return lastName.compareTo(o.getLastName());
        else if(street.compareTo(o.getStreet()) != 0)
            return street.compareTo(o.getStreet());
        else if(streetNumber.compareTo(o.getStreetNumber()) != 0)
            return streetNumber.compareTo(o.getStreetNumber());
        else if(relation.compareTo(o.getRelation()) != 0)
            return relation.compareTo(o.getRelation());
        else if(renting.compareTo(o.getRenting()) != 0)
            return renting.compareTo(o.getRenting());
        else if(propertyValue.compareTo(o.getPropertyValue()) != 0)
            return propertyValue.compareTo(o.getPropertyValue());
        else if(gender.compareTo(o.getGender()) != 0)
            return gender.compareTo(o.getGender());
        else if(age.compareTo(o.getAge()) != 0)
            return age.compareTo(o.getAge());
        else if(maritalStatus.compareTo(o.getMaritalStatus()) != 0)
            return maritalStatus.compareTo(o.getMaritalStatus());
        else if(ageAtFirstMarriage.compareTo(o.getAgeAtFirstMarriage()) != 0)
            return ageAtFirstMarriage.compareTo(o.getAgeAtFirstMarriage());
        else if(attendSchool.compareTo(o.getAttendSchool()) != 0)
            return attendSchool.compareTo(o.getAttendSchool());
        else if(canRead.compareTo(o.getCanRead()) != 0)
            return canRead.compareTo(o.getCanRead());
        else if(birthplace.compareTo(o.getBirthplace()) != 0)
            return birthplace.compareTo(o.getBirthplace());
        else if(fathersBirthplace.compareTo(o.getFathersBirthplace()) != 0)
            return fathersBirthplace.compareTo(o.getFathersBirthplace());
        else if(mothersBirthplace.compareTo(o.getMothersBirthplace()) != 0)
            return mothersBirthplace.compareTo(o.getMothersBirthplace());
        else if(motherTongue.compareTo(o.getMotherTongue()) != 0)
            return motherTongue.compareTo(o.getMotherTongue());
        else if(yearImmigrated.compareTo(o.getYearImmigrated()) != 0)
            return yearImmigrated.compareTo(o.getYearImmigrated());
        else if(occupation.compareTo(o.getOccupation()) != 0)
            return occupation.compareTo(o.getOccupation());
        else if(industry.compareTo(o.getIndustry()) != 0)
            return industry.compareTo(o.getIndustry());
        else if(remarks.compareTo(o.getRemarks()) != 0)
            return remarks.compareTo(o.getRemarks());
        else 
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
    public String getRenting() {
        return renting;
    }
    public void setRenting(String renting) {
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
    public void setAge(double age) {
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
    public String getAttendSchool() {
        return attendSchool;
    }
    public void setAttendSchool(String attendSchool) {
        this.attendSchool = attendSchool;
    }
    public String getCanRead() {
        return canRead;
    }
    public void setCanRead(String canRead) {
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
    public String getMotherTongue() {
        return motherTongue;
    }
    public void setMotherTongue(String motherTongue) {
        this.motherTongue = motherTongue;
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