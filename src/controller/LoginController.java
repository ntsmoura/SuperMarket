package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Funcionario;
import model.Gerente;

public class LoginController implements Initializable, Controller{
	
	@FXML
	private TextField cpfText;
	
	@FXML
	private Label warnText;
	
	public static Stage loginStage = new Stage();

	@Override
	public void concluir() {
		int j = 0;
		for(int i = 0; i<FuncionarioController.listaFuncionariosGeral.size();i++) {
			Funcionario func = FuncionarioController.listaFuncionariosGeral.get(i);
			if(cpfText.getText().equals(func.getCpf())) {
				if (func instanceof Gerente) { //Checa se cpf é de gerente
					j = 1;
					MenuGerenteController mGCc = new MenuGerenteController();
					mGCc.iniciar();
				}
			}
		}
		if (j==0) warnText.setText("Acesso negado!");
	}

	@Override
	public void iniciar() {
		try {
			Parent root = FXMLLoader.load(Main.class.getResource("/View/Login.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Main.class.getResource("/View/application.css").toExternalForm());
			loginStage.setScene(scene);
			loginStage.show();
			loginStage.setTitle("Login");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	

}
