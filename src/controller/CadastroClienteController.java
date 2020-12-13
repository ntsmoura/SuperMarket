package controller;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Cliente;
import model.ClienteDelivery;
import model.ClienteLocal;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CadastroClienteController implements Initializable, Controller {

	//Lista clientes
	public static ArrayList<Cliente> listaClientesGeral = new ArrayList<Cliente>();

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
				if(buscarCliente(cpfText.getText())==null) {
					if(telefoneText.getText().equals("") && endText.getText().equals("")) {
						ClienteLocal cli = new ClienteLocal(nomeText.getText(), cpfText.getText(), estCheck.isSelected());
						listaClientesGeral.add(cli);
						alert.setContentText("Pessoa física local cadastrada!");
					}
					else {
						ClienteDelivery cli = new ClienteDelivery(nomeText.getText(), cpfText.getText(), telefoneText.getText(), endText.getText());
						listaClientesGeral.add(cli);
						alert.setContentText("Pessoa física delivery cadastrada!");
					}
				}
				else {
					alert.setContentText("CPF já cadastrado!");
				}
			}
			else if(!cnpjText.getText().equals("")) {
				if(buscarCliente(Long.parseLong(cnpjText.getText())) == null){
					if(telefoneText.getText().equals("") && endText.getText().equals("")) {
						ClienteLocal cli = new ClienteLocal(nomeText.getText(), Long.parseLong(cnpjText.getText()),
								estCheck.isSelected());
						listaClientesGeral.add(cli);
						alert.setContentText("Pessoa jurídica local cadastrada!");
					}
					else {
						ClienteDelivery cli = new ClienteDelivery(nomeText.getText(), Long.parseLong(cnpjText.getText()),
								telefoneText.getText(), endText.getText());
						listaClientesGeral.add(cli);
						alert.setContentText("Pessoa jurídica delivery cadastrada!");
					}
				}
				else {
					alert.setContentText("CNPJ já cadastrado!");
				}
			}
			alert.showAndWait();
		} catch (Exception e) {
			alert.setContentText("Algum valor inválido!");
			alert.showAndWait();
		}
	}

	//Inicia módulo de cadastro de cliente
	@Override
	public void iniciar() {
		try {
			Stage menuStage = new Stage();
			Parent root = FXMLLoader.load(Main.class.getResource("/view/CadastroCliente.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Main.class.getResource("/view/application.css").toExternalForm());
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
	
	//@return Cliente com CPF relacionado
	public static Cliente buscarCliente(String cpf) {
		for(Cliente c: listaClientesGeral) {
			if(c!=null && c.getCpf().equals(cpf)) return c;
		}
		return null;
	}
	
	//@return Cliente com CNPJ relacionado
	public static Cliente buscarCliente(long cnpj) {
		for(Cliente c: listaClientesGeral) {
			if(c.getCnpj() == cnpj) return c;
		}
		return null;
	}

}
