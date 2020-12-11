/*@author Álvaro Souza e Natan Moura 
 *@version 1.0
*/

package application;
	
import controller.LoginController;
import controller.ProdutoController;
import controller.VendaDeliveryController;
import controller.VendaLocalController;
import controller.CadastroClienteController;
import controller.FuncionarioController;
import model.Gerente;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/view/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Super Market");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Inicia módulo de cadastro produto
	@FXML
	public void startProdutoCadastro(ActionEvent event) {
		ProdutoController prodC = new ProdutoController();
		prodC.iniciar();
	}
	
	//Inicia módulo de login
	@FXML
	public void startLogin(ActionEvent event) {
		LoginController logC = new LoginController();
		logC.iniciar();
	}
	
	//Inicia módulo de cadastro cliente
	@FXML
	public void startClienteCadastro(ActionEvent event) {
		CadastroClienteController cliC = new CadastroClienteController();
		cliC.iniciar();
	}
		
	//Inicia módulo de venda local	
	@FXML
	public void startVendaLocal(ActionEvent event) {
		VendaLocalController vlC = new VendaLocalController();
		vlC.iniciar();
	}
	
	//Inicia módulo de venda delivery	
	@FXML
	public void startVendaDelivery(ActionEvent event) {
		VendaDeliveryController vdlC = new VendaDeliveryController();
		vdlC.iniciar();
	}
	
	//Inicia módulo about
	@FXML
	public void startAbout(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Sobre.");
		alert.setHeaderText(null);
		alert.setContentText("Sistema criado por Natan Moura e Álvaro Souza.\nVersão 1.0\nDisciplina: MATA55 - POO (UFBA)");
		alert.showAndWait();
	}
	
	
	public static void main(String[] args) {
		FuncionarioController.listaFuncionariosGeral.add(new Gerente("ADM","001",00,00,"00","00","00")); //Adiciona ADM ao sistema
		launch(args);
	}
}
