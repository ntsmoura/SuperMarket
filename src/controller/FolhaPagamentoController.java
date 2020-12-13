/*@author Álvaro Souza e Natan Moura
 *@version 1.0
 */
package controller;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FolhaPagamentoController implements Initializable, Controller {

	//Definir colunas da tabela
	@FXML
	private TableView<FolhaDePagamentoTable> tabelaFolhaPag;
	@FXML
	private TableColumn<FolhaDePagamentoTable, String> nomeCol;
	@FXML
	private TableColumn<FolhaDePagamentoTable, String> cargoCol;
	@FXML
	private TableColumn<FolhaDePagamentoTable, Double> salarioCol;
	@FXML
	private TableColumn<FolhaDePagamentoTable, Integer> comissoesCol;
	@FXML
	private TableColumn<FolhaDePagamentoTable, String> totalCol;

	@Override
	public void concluir() {
		// TODO Auto-generated method stub

	}

	//Inicia a tela referente Folha de pagamento
	public void iniciar() {
		try {
			Stage menuStage = new Stage();
			Parent root = FXMLLoader.load(Main.class.getResource("/view/FolhaPagamento.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Main.class.getResource("/view/application.css").toExternalForm());
			menuStage.setScene(scene);
			menuStage.show();
			menuStage.setTitle("Folha de pagamento");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Inicializa a tabela - Folha - de pagamento dos funcionários
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nomeCol.setCellValueFactory(new PropertyValueFactory<>("nomeCol"));
		cargoCol.setCellValueFactory(new PropertyValueFactory<>("cargoCol"));
		salarioCol.setCellValueFactory(new PropertyValueFactory<>("salarioCol"));
		comissoesCol.setCellValueFactory(new PropertyValueFactory<>("comissoesCol"));
		totalCol.setCellValueFactory(new PropertyValueFactory<>("totalCol"));
		tabelaFolhaPag.setItems(listaDeFuncionarios());
	}

	//@return Lista contendo informações para construção de uma tabela contendo os funcionários do Supermercado
	private ObservableList<FolhaDePagamentoTable> listaDeFuncionarios() {
		ArrayList<FolhaDePagamentoTable> listTable = new ArrayList<FolhaDePagamentoTable>();
		for (Funcionario f : FuncionarioController.listaFuncionariosGeral) {
			if (f instanceof Gerente) {
				listTable.add(new FolhaDePagamentoTable(f.getNome(), "Gerente", f.getSalario(), 0.0, f.getSalario()));
			} else if (f instanceof Supervisor) {
				listTable.add(new FolhaDePagamentoTable(f.getNome(), "Supervisor", f.getSalario(), 0.0, f.getSalario()));
			} else if (f instanceof CaixaLocal) {
				listTable.add(new FolhaDePagamentoTable(f.getNome(), "Caixa Local", f.getSalario(), ((CaixaLocal) f).calculaComissao(), f.calculaSalario()));
				((CaixaLocal) f).setQuantidadeDeVendas(0); //Zera quantidade de vendas dos caixas para novo m�s
			} else if (f instanceof Motoboy) {
				listTable.add(new FolhaDePagamentoTable(f.getNome(), "Motoboy", f.getSalario(), 0.0, f.calculaSalario()));
			}

		}
		return FXCollections.observableArrayList(listTable);
	}

}
