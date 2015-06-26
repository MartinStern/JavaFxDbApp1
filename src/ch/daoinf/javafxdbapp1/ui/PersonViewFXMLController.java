/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.daoinf.javafxdbapp1.ui;

import ch.daoinf.javafxdbapp1.model.Person;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
    
    final EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JavaFxDbApp1PU"); // Name kommt aus persitance.xml
    final EntityManager em = emFactory.createEntityManager();
            
            
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // populate with data from database
        populatePersonList();
        // setup table view
        setupTable();
        // setup button
        //setupButton();
        
        
    }    

    private void setupTable() {
        // cloumn firstName
        TableColumn firstnameColumn = new TableColumn<Person, String>();
        firstnameColumn.setText("First Name");
        firstnameColumn.setMinWidth(100);
        firstnameColumn.setCellValueFactory(new PropertyValueFactory("firstname"));
        
        // cloumn firstName
        TableColumn lastnameColumn = new TableColumn<Person, String>();
        lastnameColumn.setText("Last Name");
        lastnameColumn.setMinWidth(100);
        lastnameColumn.setCellValueFactory(new PropertyValueFactory("lastname"));
        
        personTable.getColumns().addAll(firstnameColumn, lastnameColumn);
        personTable.setItems(persons);
    }
    
    private void populatePersonList(){
        Query query = em.createNamedQuery("Person.findAll");
        List result = query.getResultList();
        
        if (persons == null){
            persons = FXCollections.observableArrayList(result);
        } else  {
            persons.clear();
            persons.addAll(result);
        }
    }
}
