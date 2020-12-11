package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Compra;

public class MenuGerenteController implements Initializable, Controller{

	@Override
	public void concluir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iniciar() {
		try {
			Stage menuStage = new Stage();
			Parent root = FXMLLoader.load(Main.class.getResource("/view/MenuGerente.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Main.class.getResource("/view/application.css").toExternalForm());
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
	
	public void gerarReceitaMes() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Receita do mês.");
		alert.setHeaderText(null);
		alert.setContentText("O total adquirido em vendas esse mês é de R$: " + this.calculaTotalVendas());
		alert.showAndWait();
	}
	
	private double calculaTotalVendas() {
		ArrayList<Compra> vendas = new ArrayList<Compra>();
		vendas.addAll(VendaLocalController.listaComprasLocais);
		vendas.addAll(VendaDeliveryController.listaComprasDelivery);
		double total = 0.0;
		for(Compra c : vendas) {
			total+= c.getTotalCompra();
		}
		//Limpa vendas mensais
		VendaLocalController.listaComprasLocais.clear();
		VendaDeliveryController.listaComprasDelivery.clear();
		return total;
	}


}
