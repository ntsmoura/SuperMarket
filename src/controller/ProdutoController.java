package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


import application.Main;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Produto;
import model.ProdutoPesado;
import model.ProdutoQuantidade;

public class ProdutoController implements Initializable, Controller{
	
	public static ArrayList<Produto> listaProdutosGeral = new ArrayList<Produto>(); //Lista produtos
	
	@FXML
	private ChoiceBox<String> tipoProduto;
	
	//Definindo textFields do produto
	@FXML
    private TextField marcaText;
	
	@FXML
    private TextField descricaoText;
	
	@FXML
    private TextField precoText;
	@FXML
    private TextField codigoText;
	
	//Inicializa tela de cadastro produto
	public void iniciar() {
		try {
			Stage produtoStage = new Stage();
			Parent root = FXMLLoader.load(Main.class.getResource("/View/CadastroProduto.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Main.class.getResource("/View/application.css").toExternalForm());
			produtoStage.setScene(scene);
			produtoStage.show();
			produtoStage.setTitle("Cadastro Produto");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void concluir() {
		String tipo = tipoProduto.getSelectionModel().getSelectedItem();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Aviso!");
		alert.setHeaderText(null);
		//Trata erros em digitação ou falta de escolha de tipo
		try {
			//Adiciona produto na lista conforme tipo específico
			if(tipo.equals("Pesado")) {
				ProdutoPesado prod = new ProdutoPesado(descricaoText.getText(),marcaText.getText(),Double.parseDouble(precoText.getText()),codigoText.getText(),0);
				listaProdutosGeral.add(prod);
			}
			else if (tipo.equals("Quantidade")){
				ProdutoQuantidade prod = new ProdutoQuantidade(descricaoText.getText(),marcaText.getText(),Double.parseDouble(precoText.getText()),codigoText.getText(),0);
				listaProdutosGeral.add(prod);
			}
			alert.setContentText("Produto cadastrado com sucesso!");
			alert.showAndWait();
		}
		catch (Exception e) {
			alert.setContentText("Algum valor inválido!");
			alert.showAndWait();
		}
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tipoProduto.setItems(FXCollections.observableArrayList("Pesado", "Quantidade")); //Inicializa choicebox com valores determinados
		
	}

}
