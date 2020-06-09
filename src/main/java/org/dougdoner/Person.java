package org.dougdoner;

public class Person {

    private String initials;
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.initials = String.format("%s. %s.", Character.toString(firstName.charAt(0)).toUpperCase(), Character.toString(lastName.charAt(0)).toUpperCase());
    }

    public boolean equalsInitials(String initials) {
        return this.initials.equals(initials);
    }

    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }
}
