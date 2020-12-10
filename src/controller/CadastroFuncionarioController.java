package controller;

import java.net.URL;
import java.util.ResourceBundle;


import application.Main;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.CaixaLocal;
import model.Gerente;
import model.Motoboy;
import model.Supervisor;

public class CadastroFuncionarioController implements Initializable, Controller{
	
	//Definindo TextFields do Cadastro
    @FXML
    private TextField nomeText;
    @FXML
    private TextField cpfText;
    @FXML
    private TextField idadeText;
    @FXML
    private TextField salText;
    @FXML
    private TextField idText;
    @FXML
    private TextField horcText;
    @FXML
    private TextField horsText;
    @FXML
    private TextField placaText;
    
  //Definindo ChoiceBox
    @FXML
    private ChoiceBox<String> tipoFun;
    

	@Override
	public void concluir() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Aviso!");
		alert.setHeaderText(null);
		alert.setContentText("Funcionário cadastrado com sucesso!");
		try {
			if(FuncionarioController.buscarCPF(cpfText.getText())==null) {
				//Adiciona funcionário a depender do cargo
				String tipo = tipoFun.getSelectionModel().getSelectedItem();
				if(tipo.equals("Motoboy")) {
					if(placaText.getText().equals("")) {
						alert.setContentText("Placa inválida!");
					}
					else {
						Motoboy motoboy = new Motoboy(nomeText.getText(),cpfText.getText(),Integer.parseInt(idadeText.getText()),Double.parseDouble(salText.getText()),idText.getText(),horcText.getText(),horsText.getText(),placaText.getText());
						FuncionarioController.listaFuncionariosGeral.add(motoboy);
					}
				}
				else if(tipo.equals("Caixa")) {
					CaixaLocal caixa = new CaixaLocal(nomeText.getText(),cpfText.getText(),Integer.parseInt(idadeText.getText()),Double.parseDouble(salText.getText()),idText.getText(),horcText.getText(),horsText.getText(),0);
					FuncionarioController.listaFuncionariosGeral.add(caixa);
				}
				else if(tipo.equals("Supervisor")) {
					Supervisor supervisor = new Supervisor(nomeText.getText(),cpfText.getText(),Integer.parseInt(idadeText.getText()),Double.parseDouble(salText.getText()),idText.getText(),horcText.getText(),horsText.getText());
					FuncionarioController.listaFuncionariosGeral.add(supervisor);
				}
				else if(tipo.equals("Gerente")){
					Gerente gerente = new Gerente(nomeText.getText(),cpfText.getText(),Integer.parseInt(idadeText.getText()),Double.parseDouble(salText.getText()),idText.getText(),horcText.getText(),horsText.getText());
					FuncionarioController.listaFuncionariosGeral.add(gerente);
				}
			}
			else {
				alert.setContentText("CPF já cadastrado!");
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
				Parent root = FXMLLoader.load(Main.class.getResource("/View/CadastroFuncionario.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(Main.class.getResource("/View/application.css").toExternalForm());
				menuStage.setScene(scene);
				menuStage.show();
				menuStage.setTitle("Cadastro Funcionário");
			} 
			catch(Exception e) {
				e.printStackTrace();
			}	
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
        tipoFun.setItems(FXCollections.observableArrayList("Motoboy", "Gerente","Caixa","Supervisor"));
		
	}

}
