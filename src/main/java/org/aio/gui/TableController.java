package org.aio.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class TableController implements Initializable {
    @FXML
    private TableView <Client> lst_clients;
    @FXML
    private TableColumn<Client, String> col_prenom;
    @FXML
    private TableColumn<Client, String> col_nom;
    @FXML
    private TableColumn<Client, String> col_ville;

    public TextField txt_prenom;
    public TextField txt_nom;
    public TextField txt_ville;
    public Button btn_annuler;
    public Button btn_sauver;
    public Button btn_supprimer;

    ObservableList<Client> model = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb){
        //initialisation du modèle
        model.add(new Client("Josh", "Homme", "Joshua Tree"));
        model.add(new Client("Dave", "Grohl", "Warren"));
        model.add(new Client("Krist", "Novoselic", "Compton"));
        model.add(new Client("Robert", "Trujillo", "Santa Monica"));

        //On rend le tableau non-éditable
        lst_clients.setEditable(false);

        // Jonction du tableau avec les données
        col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_ville.setCellValueFactory(new PropertyValueFactory<>("ville"));

        // On indique au TableView quelle modèle observer pour trouver les données
        lst_clients.setItems(model);

    }

    public void annuler(ActionEvent actionEvent) {
        txt_nom.clear();
        txt_prenom.clear();
        txt_ville.clear();
    }

    public void sauver(ActionEvent actionEvent) {
        String new_prenom =txt_prenom.getText();
        String new_nom =txt_nom.getText();
        String new_ville =txt_ville.getText();
        model.add(new Client(new_prenom,new_nom,new_ville));
        lst_clients.setItems(model);
    }

    public void supprimer(ActionEvent actionEvent) {

        model.remove(lst_clients.getSelectionModel().getSelectedIndex());

    }
}
