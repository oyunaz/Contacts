package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import sample.datamodel.Contact;
import sample.datamodel.ContactData;

import java.io.IOException;
import java.util.Optional;

public class Controller {

    @FXML
    private BorderPane mainBorderPain;

    @FXML
    private TableView<Contact> contactsTable;

    private ContactData data;

    public void initialize(){
        data = new ContactData();
        data.loadContacts();
        contactsTable.setItems(data.getContacts());
    }

    @FXML
    public void showAddContactDialog(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPain.getScene().getWindow());
        dialog.setTitle("Add new contact");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("contactdialog.fxml"));
        try{
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }catch (IOException e){
            System.out.printf("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            DialogController contactController = fxmlLoader.getController();
            Contact newContact = contactController.getNewContact();
            data.addContact(newContact);
            data.saveContacts();
        }
    }

    @FXML
    public void showEditContactDialog(){
        Contact selectedContact = contactsTable.getSelectionModel().getSelectedItem();
        if (selectedContact == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No contact selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select contact you want to edit");
            alert.showAndWait();
            return;
        }

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPain.getScene().getWindow());
        dialog.setTitle("Edit contact");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("contactdialog.fxml"));
        try{
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }catch (IOException e){
            System.out.printf("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        DialogController contactController = fxmlLoader.getController();
        contactController.editContact(selectedContact);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            contactController.updateContact(selectedContact);
            data.saveContacts();
        }
    }











}