package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.CaixaLocal;
import model.Funcionario;
import model.FuncionarioTable;
import model.Gerente;
import model.Motoboy;
import model.Supervisor;

public class FuncionarioController implements Initializable, Controller {
	
	public static ArrayList<Funcionario> listaFuncionariosGeral = new ArrayList<Funcionario>();
	
	
	//Definindo colunas e tabela
	@FXML
    private TableView<FuncionarioTable> tabelaFun;
    @FXML
    private TableColumn<FuncionarioTable, String> nomeCol;
    @FXML
    private TableColumn<FuncionarioTable, String> cpfCol;
    @FXML
    private TableColumn<FuncionarioTable, Double> salCol;
    @FXML
    private TableColumn<FuncionarioTable, Integer> numCol;
    @FXML
    private TableColumn<FuncionarioTable, String> horcCol;
    @FXML
    private TableColumn<FuncionarioTable, String> horsCol;
    

	@Override //Conclui cadastro de funcionário
	public void concluir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iniciar() {
		try {
			Stage menuStage = new Stage();
			Parent root = FXMLLoader.load(Main.class.getResource("/View/GerenciaFuncionario.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Main.class.getResource("/View/application.css").toExternalForm());
			menuStage.setScene(scene);
			menuStage.show();
			menuStage.setTitle("Menu Funcionário");
		} 
		catch(Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		nomeCol.setCellValueFactory(new PropertyValueFactory<>("nomeCol"));
        cpfCol.setCellValueFactory(new PropertyValueFactory<>("cpfCol"));
        salCol.setCellValueFactory(new PropertyValueFactory<>("salCol"));
        numCol.setCellValueFactory(new PropertyValueFactory<>("numCol"));
        horcCol.setCellValueFactory(new PropertyValueFactory<>("horC"));
        horsCol.setCellValueFactory(new PropertyValueFactory<>("horS"));
        tabelaFun.setItems(listaDeFuncionarios());

		
	}
	
	
	//Prepara lista de Funcionarios
	 private ObservableList<FuncionarioTable> listaDeFuncionarios() {
	        ArrayList<FuncionarioTable> listTable = new ArrayList<FuncionarioTable>();
	        for(Funcionario f : listaFuncionariosGeral) {
	        	listTable.add(new FuncionarioTable(f.getNome(),f.getCpf(),f.getSalario(),f.getNumeroDeIdentificacao(),f.getHoraDeChegada(),f.getHoraDeSaida()));
	        }
	        return FXCollections.observableArrayList(listTable);
	    }
	 
	 //Cadastra novo funcionario
	 public void cadastrarFuncionario() {
		CadastroFuncionarioController cfC = new CadastroFuncionarioController();
		cfC.iniciar();
	}

	 //Deleta funcionario selecionado
	 public void deletarSelecionado() {
		 Alert alert = new Alert(AlertType.CONFIRMATION);
		 alert.setTitle("Confirmação");
		 alert.setHeaderText(null);
		 alert.setContentText("Você tem certeza?");

		 Optional<ButtonType> result = alert.showAndWait();
		 if (result.get() == ButtonType.OK){
			 listaFuncionariosGeral.remove(tabelaFun.getSelectionModel().getSelectedIndex());
			 Alert alert2 = new Alert(AlertType.INFORMATION);
			 alert2.setTitle("Aviso!");
			 alert2.setHeaderText(null);
			 alert2.setContentText("Funcionário deletado!");
			 alert2.showAndWait();
		 } else {
		     
		 }
		
	 }
	 
	 //Promove funcionário
	 public void promoverSelecionado() {
			 Alert alert2 = new Alert(AlertType.INFORMATION);
			 alert2.setTitle("Aviso!");
			 alert2.setHeaderText(null);
			 Funcionario f = listaFuncionariosGeral.get(tabelaFun.getSelectionModel().getSelectedIndex()); //Realiza casting implicito para funcionario
			 if(f instanceof Gerente) {
				 alert2.setContentText("Funcionário possui cargo máximo!");
			 }
			 else if (f instanceof Supervisor) {
				 Gerente g = new Gerente(f.getNome(),f.getCpf(),f.getIdade(),f.getSalario(),f.getNumeroDeIdentificacao(),f.getHoraDeChegada(),f.getHoraDeSaida()); //Novo objeto com base nas informações do anterior
				 g.setSalario(g.calculaSalario()); //Aumenta Salário conforme taxa promocional
				 listaFuncionariosGeral.add(g); 
				 listaFuncionariosGeral.remove(tabelaFun.getSelectionModel().getSelectedIndex());
				 alert2.setContentText("Funcionário promovido a Gerente!");
			 }
			 else if (f instanceof CaixaLocal){
				 Supervisor s = new Supervisor(f.getNome(),f.getCpf(),f.getIdade(),f.getSalario(),f.getNumeroDeIdentificacao(),f.getHoraDeChegada(),f.getHoraDeSaida()); //Novo objeto com base nas informações do anterior
				 s.setSalario(s.calculaSalario()); //Aumenta Salário conforme taxa promocional
				 listaFuncionariosGeral.add(s);
				 listaFuncionariosGeral.remove(tabelaFun.getSelectionModel().getSelectedIndex());
				 alert2.setContentText("Funcionário promovido a Supervisor!");
			 }
			 else if (f instanceof Motoboy){
				 CaixaLocal c =  new CaixaLocal(f.getNome(),f.getCpf(),f.getIdade(),f.getSalario(),f.getNumeroDeIdentificacao(),f.getHoraDeChegada(),f.getHoraDeSaida(),0); //Novo objeto com base nas informações do anterior
				 listaFuncionariosGeral.add(c);
				 listaFuncionariosGeral.remove(tabelaFun.getSelectionModel().getSelectedIndex());
				 alert2.setContentText("Funcionário promovido a Caixa!");
			 }
			 alert2.showAndWait();
			 System.out.println(listaFuncionariosGeral.get(1).getSalario());
		 } 
	 
	//Atualiza lista de funcionarios
	public void atualizarLista() {
		tabelaFun.getItems().clear();
		tabelaFun.setItems(listaDeFuncionarios());
	}
	
	//Busca funcionario por CPF
	public static Funcionario buscarCPF(String cpf) {
		for(Funcionario f: listaFuncionariosGeral) {
			if(f.getCpf().equals(cpf)) return f;
		}
		return null;
	}
	 
}
