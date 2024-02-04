import java.util.Arrays;

public class Person {
    private String firstName;
    private String middleName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this(firstName, null, lastName);
    }

    public Person() {
        
    }

    public Person(String firstName, String middleName, String lastName) {
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
    }

    public Person(String fullName) {
        setFullName(fullName);
    }

    public Person(Person other) {
        this.firstName = other.firstName;
        this.lastName = other.lastName;
        this.middleName = other.middleName;
    }

    // getters og setters før atributter

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void  setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        if (hasMiddleName()) {
        return firstName + " " + middleName + " " + lastName;
        } else {
        return firstName + " " + lastName;
        }
    }

    public void setFullName(String fullName) {
        int firstSpaceIndex = fullName.indexOf(" ");
        int lastSpaceIndex = fullName.lastIndexOf(" ");

        if (firstSpaceIndex != -1) {
            firstName = fullName.substring(0, firstSpaceIndex);

            if (lastSpaceIndex > firstSpaceIndex) {
                middleName = fullName.substring(firstSpaceIndex + 1, lastSpaceIndex);
                lastName = fullName.substring(lastSpaceIndex + 1);
            } else {
                lastName = fullName.substring(firstSpaceIndex + 1);
            }
        } else {
            firstName = fullName;
            middleName = null;
            lastName = null;
        }
    }

    public String getFullName() {
        if (hasMiddleName() && getMiddleName() != null) {
            return firstName + " " + middleName + " " + lastName;
        } else {
            return firstName + " " + lastName;
        }
    }

    public boolean hasMiddleName() {
        return middleName != null;
    }

};

