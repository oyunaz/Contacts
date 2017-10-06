package sample.datamodel;

import javafx.beans.property.SimpleStringProperty;

public class Contact {

   private SimpleStringProperty firstName = new SimpleStringProperty("");
    private SimpleStringProperty lastName = new SimpleStringProperty("");
    private SimpleStringProperty phoneNum = new SimpleStringProperty("");
    private SimpleStringProperty notes = new SimpleStringProperty("");

    public Contact() {
    }

    public Contact(String firstName, String lastName, String phoneNum, String notes) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.phoneNum.set(phoneNum);
        this.notes.set(notes);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getPhoneNum() {
        return phoneNum.get();
    }

    public SimpleStringProperty phoneNumProperty() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum.set(phoneNum);
    }

    public String getNotes() {
        return notes.get();
    }

    public SimpleStringProperty notesProperty() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes.set(notes);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName=" + firstName +
                ", lastName=" + lastName +
                ", phoneNum=" + phoneNum +
                ", notes=" + notes +
                '}';
    }
}
