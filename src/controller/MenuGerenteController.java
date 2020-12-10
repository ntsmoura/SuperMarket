package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuGerenteController implements Initializable, Controller{

	@Override
	public void concluir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iniciar() {
		try {
			Stage menuStage = new Stage();
			Parent root = FXMLLoader.load(Main.class.getResource("/View/MenuGerente.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Main.class.getResource("/View/application.css").toExternalForm());
			menuStage.setScene(scene);
			menuStage.show();
			menuStage.setTitle("Menu Gerente");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		LoginController.loginStage.hide();
		
	}
	
	public void abrirGerenciaFun() {
		FuncionarioController funC = new FuncionarioController();
		funC.iniciar();
	}
	
	public void abrirFolhaPagamento() {
		FolhaPagamentoController fpC = new FolhaPagamentoController();
		fpC.iniciar();
	}


}
