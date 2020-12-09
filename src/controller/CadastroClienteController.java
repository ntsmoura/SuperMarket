package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Cliente;
import model.ClienteDelivery;
import model.ClienteLocal;

public class CadastroClienteController implements Initializable, Controller {
	
	//Lista clientes
	ArrayList<Cliente> listaClientesGeral = new ArrayList<Cliente>();	
	
	//Definindo textFields do produto
	@FXML
	private TextField nomeText;
	@FXML
	private TextField cpfText;
	@FXML
	private TextField cnpjText;
	@FXML
	private TextField telefoneText;
	@FXML
	private TextField endText;
	
	//Definindo checkBox
	@FXML
	private CheckBox estCheck;

	//Cadastra cliente
	@Override
	public void concluir() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Aviso!");
		alert.setHeaderText(null);
		try {
			if(!cpfText.getText().equals("")) {
				if(telefoneText.getText().equals("") && endText.getText().equals("")) {
					ClienteLocal cli = new ClienteLocal(nomeText.getText(),cpfText.getText(),estCheck.isSelected());
					listaClientesGeral.add(cli);
					alert.setContentText("Pessoa física local cadastrada!");
				}
				else {
					ClienteDelivery cli = new ClienteDelivery(nomeText.getText(),cpfText.getText(),telefoneText.getText(),endText.getText());
					listaClientesGeral.add(cli);
					alert.setContentText("Pessoa física delivery cadastrada!");
				}
			}
			else if(!cnpjText.getText().equals("")) {
				if(telefoneText.getText().equals("") && endText.getText().equals("")) {
					ClienteLocal cli = new ClienteLocal(nomeText.getText(),Long.parseLong(cnpjText.getText()),estCheck.isSelected());
					listaClientesGeral.add(cli);
					alert.setContentText("Pessoa jurídica local cadastrada!");
				}
				else {
					ClienteDelivery cli = new ClienteDelivery(nomeText.getText(),Long.parseLong(cnpjText.getText()),telefoneText.getText(),endText.getText());
					listaClientesGeral.add(cli);
					alert.setContentText("Pessoa jurídica delivery cadastrada!");
				}
			}
			alert.showAndWait();
		}
		catch (Exception e) {
			alert.setContentText("Algum valor inválido!");
			alert.showAndWait();
		}		
	}

	@Override
	public void iniciar() {
		try {
			Stage menuStage = new Stage();
			Parent root = FXMLLoader.load(Main.class.getResource("/View/CadastroCliente.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Main.class.getResource("/View/application.css").toExternalForm());
			menuStage.setScene(scene);
			menuStage.show();
			menuStage.setTitle("Cadastro Cliente");
		} 
		catch(Exception e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
