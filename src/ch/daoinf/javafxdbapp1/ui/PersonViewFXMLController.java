/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.daoinf.javafxdbapp1.ui;

import ch.daoinf.javafxdbapp1.model.Person;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Martin
 */
public class PersonViewFXMLController implements Initializable {

    @FXML
    private StackPane personStackPane;
    @FXML
    private TableView  personTable;
    @FXML
    private Button addPerson;
    
    private ObservableList persons;
    private Person currentPerson;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // populate with data from database
        updatePersonList();
        // setup table view
        setupTable();
        // setup button
        setupButton();
        
        
    }    

    private void setupTable() {
        // cloumn firstName
        TableColumn firstnameColumn = new TableColumn<Person, String>();
        firstnameColumn.setText("First Name");
        firstnameColumn.setMinWidth(100);
        firstnameColumn.setCellFactory(new PropertyValueFactory("firstname"));
        
        // cloumn firstName
        TableColumn lastnameColumn = new TableColumn<Person, String>();
        lastnameColumn.setText("Last Name");
        lastnameColumn.setMinWidth(100);
        lastnameColumn.setCellFactory(new PropertyValueFactory("lastname"));
        
        personTable.getColumns().addAll(firstnameColumn, lastnameColumn);
        personTable.setItems(persons);
    }
    
}
