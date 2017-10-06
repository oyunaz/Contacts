package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.datamodel.Contact;


public class DialogController {

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField numberField;

    @FXML
    private TextField notesField;

    public Contact getNewContact(){
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String phoneNum = numberField.getText();
        String notes = notesField.getText();

        Contact newContact = new Contact(firstName,lastName,phoneNum,notes);
        return newContact;
    }

    public void editContact(Contact contact){
        firstNameTextField.setText(contact.getFirstName());
        lastNameTextField.setText(contact.getLastName());
        numberField.setText(contact.getPhoneNum());
        notesField.setText(contact.getNotes());
    }

    public void updateContact(Contact contact){
        contact.setFirstName(firstNameTextField.getText());
        contact.setLastName(lastNameTextField.getText());
        contact.setPhoneNum(numberField.getText());
        contact.setNotes(notesField.getText());
    }




}
