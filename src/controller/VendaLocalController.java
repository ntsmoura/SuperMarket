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
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.ProdutoTable;
import model.Supervisor;
import model.CompraLocal;
import model.Produto;
import model.ProdutoPesado;
import model.ProdutoQuantidade;
import model.Funcionario;
import model.Gerente;


public class VendaLocalController implements Initializable, Controller{
	
	ArrayList<CompraLocal> listaComprasLocais = new ArrayList<CompraLocal>(); //Lista de compras já feitas
	ArrayList<Produto> listaProdutosCompraAtual = new ArrayList<Produto>(); //Guarda produtos da compra que está ocorrendo
	
	//Definindo colunas e tabela
	@FXML
	private TableView<ProdutoTable> tabelaVenda;
    @FXML
    private TableColumn<ProdutoTable, String> descricao;
    @FXML
    private TableColumn<ProdutoTable, Integer> qtd;
    @FXML
    private TableColumn<ProdutoTable, Double> peso;
    @FXML
    private TableColumn<ProdutoTable, Double> precoUnit;
    @FXML
    private TableColumn<ProdutoTable, Double> precoTotal;
    
	    
	//Definiindo Text Fields
    @FXML
    private TextField codigoText;
    @FXML
    private TextField qtdEPesoText;

	@Override
	public void concluir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iniciar() {
		try {
			Stage menuStage = new Stage();
			Parent root = FXMLLoader.load(Main.class.getResource("/View/VendaLocal.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Main.class.getResource("/View/application.css").toExternalForm());
			menuStage.setScene(scene);
			menuStage.show();
			menuStage.setTitle("Venda Local");
		} 
		catch(Exception e) {
			e.printStackTrace();
		}	
		
	}
	
	//Adiciona produto na lista da compra atual
	public void adicionarProduto() {
		boolean found = false;
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Aviso!");
		alert.setHeaderText(null);
		for(Produto p : ProdutoController.listaProdutosGeral) {
			try {
				if(p.getCodigoDeBarras().equals(codigoText.getText())) {
					found = true;
					if(p instanceof ProdutoPesado) {
						ProdutoPesado pPesado = new ProdutoPesado(p.getDescricao(),p.getMarca(),p.getPreco(),p.getCodigoDeBarras(),Double.parseDouble(qtdEPesoText.getText()));
						listaProdutosCompraAtual.add(pPesado);
					}
					else {
						ProdutoQuantidade pQtd = new ProdutoQuantidade(p.getDescricao(),p.getMarca(),p.getPreco(),p.getCodigoDeBarras(),Integer.parseInt(qtdEPesoText.getText()));
						listaProdutosCompraAtual.add(pQtd);
					}
	
				}
			}
			catch(Exception e){
				alert.setContentText("Algum valor inválido!");
				alert.showAndWait();
			}
		}
		if(!found) {
			alert.setContentText("Produto não encontrado!");
			alert.showAndWait();
		}
		else {
			if(!tabelaVenda.getItems().isEmpty()) {
				tabelaVenda.getItems().clear();
			}
			tabelaVenda.setItems(listaDeProdutos());
		}
	}
	
	//Deleta produto da lista de produtos atual mediante autorização
	public void deletarProduto() {
		TextInputDialog dialog = new TextInputDialog("");
		dialog.setTitle("Autorização necessária!");
		dialog.setHeaderText("Solicitação de exclusão.");
		dialog.setContentText("Digite o CPF:");
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Aviso!");
		alert.setHeaderText(null);
		boolean found = false;
	
		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
		    for(Funcionario f: FuncionarioController.listaFuncionariosGeral) {
		    	if(f.getCpf().equals(result.get())) {
		    		found = true;
		    		if(f instanceof Supervisor || f instanceof Gerente) {
		    			listaProdutosCompraAtual.remove(tabelaVenda.getSelectionModel().getSelectedIndex());
		    			tabelaVenda.getItems().clear();
		    			tabelaVenda.setItems(listaDeProdutos());
		    		}
		    		else {
		    			alert.setContentText("Exclusão não autorizada.");
		    			alert.showAndWait();
		    		}
		    	}
		    }
		   if(!found) {
		    alert.setContentText("CPF não encontrado.");
			alert.showAndWait();
		   }
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		descricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        qtd.setCellValueFactory(new PropertyValueFactory<>("qtd"));
        peso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        precoUnit.setCellValueFactory(new PropertyValueFactory<>("precoUnit"));
        precoTotal.setCellValueFactory(new PropertyValueFactory<>("precoTotal"));
		
	}
	
	//Prepara lista de produtos
	 private ObservableList<ProdutoTable> listaDeProdutos() {
	        ArrayList<ProdutoTable> listTable = new ArrayList<ProdutoTable>();
	        for(Produto p : listaProdutosCompraAtual) {
	        	if(p instanceof ProdutoPesado) listTable.add(new ProdutoTable(p.getDescricao(),0,((ProdutoPesado) p).getPeso(),p.getPreco(),p.getPreco()*((ProdutoPesado) p).getPeso()));
	        	else {
	        		listTable.add(new ProdutoTable(p.getDescricao(),((ProdutoQuantidade) p).getQuantidade(),0.0,p.getPreco(),p.getPreco()*((ProdutoQuantidade) p).getQuantidade()));
	        	}
	        }
	        return FXCollections.observableArrayList(listTable);
	    }

}
