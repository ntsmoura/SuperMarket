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
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.ProdutoTable;
import model.Supervisor;
import model.CaixaLocal;
import model.Cartao;
import model.Cliente;
import model.ClienteDelivery;
import model.CompraLocal;
import model.Dinheiro;
import model.FormaPagamento;
import model.Produto;
import model.ProdutoPesado;
import model.ProdutoQuantidade;
import model.Funcionario;
import model.Gerente;


public class VendaLocalController implements Initializable, Controller{
	
	public static ArrayList<CompraLocal> listaComprasLocais = new ArrayList<CompraLocal>(); //Lista de compras j� feitas
	private ArrayList<Produto> listaProdutosCompraAtual = new ArrayList<Produto>(); //Guarda produtos da compra que est� ocorrendo
	private Cliente cliente;
	public static CompraLocal compraAtual;
	
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
    @FXML
    private TextField cpfText;
    @FXML
    private TextField cnpjText;
    @FXML
    private ChoiceBox<String> atendChoice;
    
    //Definindo labels
    @FXML
    private Label clienteLabel;
    
	public static Stage vendaLocalStage = new Stage();

	@Override
	public void concluir() {
		CaixaLocal atendente = (CaixaLocal) FuncionarioController.buscarCPF(atendChoice.getValue());
		if(atendente == null || cliente == null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Aviso!");
			alert.setHeaderText(null);
			alert.setContentText("Algum valor inv�lido!");
			alert.showAndWait();
		}
		else {
			try {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Importante.");
				alert.setHeaderText("Selecionar forma de pagamento!");
				alert.setContentText("Escolha:");
		
				ButtonType buttonTypeOne = new ButtonType("Dinheiro");
				ButtonType buttonTypeTwo = new ButtonType("D�bito");
				ButtonType buttonTypeThree = new ButtonType("Cr�dito");
				ButtonType buttonTypeCancel = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);
		
				alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeCancel);
		
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == buttonTypeOne){
					TextInputDialog dialog = new TextInputDialog("");
					dialog.setTitle("Dinheiro");
					dialog.setHeaderText("Preencha valor recebido!");
					dialog.setContentText("R$:");
					Optional<String> result2 = dialog.showAndWait();
					if (result2.isPresent()){
					    double recebido = Double.parseDouble(result2.get());
					    double troco = recebido - this.calculaTotalCompra();
					    Dinheiro din = new Dinheiro("Dinheiro",this.calculaTotalCompra(),troco,recebido);
					    finalizarCompra(din,cliente,atendente);
					}
				} else if (result.get() == buttonTypeTwo) {
					Cartao debito = new Cartao("D�bito",this.calculaTotalCompra(),1,true);
					finalizarCompra(debito,cliente,atendente);
				} else if (result.get() == buttonTypeThree) {
					TextInputDialog dialog = new TextInputDialog("");
					dialog.setTitle("Cr�dito");
					dialog.setHeaderText("Preencha quantidade de parcelas!");
					dialog.setContentText("N�:");
					Optional<String> result3 = dialog.showAndWait();
					if (result3.isPresent()){
					    int parcelas = Integer.parseInt(result3.get());
					    Cartao credito = new Cartao("Cr�dito",this.calculaTotalCompra(),parcelas,false);
					    finalizarCompra(credito,cliente,atendente);
					}
				} else {
				    // ... user chose CANCEL or closed the dialog
				}
			}
			catch(Exception e) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Aviso!");
				alert.setHeaderText(null);
				alert.setContentText("Algum valor inv�lido!");
				alert.showAndWait();
			}
		}
	}
	
	//Finaliza compra
	private void finalizarCompra(FormaPagamento forma, Cliente cliente, CaixaLocal atendente) {
			CompraLocal compra = new CompraLocal(java.util.Calendar.getInstance().getTime(),listaProdutosCompraAtual.size(),this.calculaTotalCompra(),forma,
					listaProdutosCompraAtual,cliente,atendente);
			atendente.setQuantidadeDeVendas(atendente.getQuantidadeDeVendas()+1);
			listaProdutosCompraAtual.clear();
			compraAtual = compra;
			listaComprasLocais.add(compra);
			cliente = null;
			NotaFiscalController nota = new NotaFiscalController();
			nota.iniciar();
	}

	@Override
	public void iniciar() {
		try {
			Parent root = FXMLLoader.load(Main.class.getResource("/view/VendaLocal.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Main.class.getResource("/view/application.css").toExternalForm());
			vendaLocalStage.setScene(scene);
			vendaLocalStage.show();
			vendaLocalStage.setTitle("Venda Local");
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
				alert.setContentText("Algum valor inv�lido!");
				alert.showAndWait();
			}
		}
		if(!found) {
			alert.setContentText("Produto n�o encontrado!");
			alert.showAndWait();
		}
		else {
			if(!tabelaVenda.getItems().isEmpty()) {
				tabelaVenda.getItems().clear();
			}
			tabelaVenda.setItems(listaDeProdutos());
		}
	}
	
	//Deleta produto da lista de produtos atual mediante autoriza��o
	public void deletarProduto() {
		TextInputDialog dialog = new TextInputDialog("");
		dialog.setTitle("Autoriza��o necess�ria!");
		dialog.setHeaderText("Solicita��o de exclus�o.");
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
		    			alert.setContentText("Exclus�o n�o autorizada.");
		    			alert.showAndWait();
		    		}
		    	}
		    }
		   if(!found) {
		    alert.setContentText("CPF n�o encontrado.");
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
        
        //Preenche lista de atendentes
        ArrayList<String> cpfAtends = new ArrayList<String>();
        
        for(Funcionario f: FuncionarioController.listaFuncionariosGeral) {
        	if(f instanceof CaixaLocal) {
        		cpfAtends.add(f.getCpf());
        	}
        }
        
        //Associa lista ao choicebox
        atendChoice.setItems(FXCollections.observableArrayList(cpfAtends));
		
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
	 
	 //Adiciona Cliente
	 public void adicionaCliente() {
		 Alert alert = new Alert(AlertType.INFORMATION);
		 alert.setTitle("Aviso!");
		 alert.setHeaderText(null);
		 if(cpfText.getText().equals("") && cnpjText.getText().equals("")) {
			 alert.setContentText("Preencha um dos campos, CPNJ ou CPF.");
 			 alert.showAndWait();
		 }
		 else if(!cpfText.getText().equals("") && !cnpjText.getText().equals("")) {
			 alert.setContentText("Preencha somente um dos campos, CPF ou CNPJ");
 			 alert.showAndWait();
		 }
		 else if(!cpfText.getText().equals("")){
			 Cliente cli = CadastroClienteController.buscarCliente(cpfText.getText());
			 if(cli==null || (cli instanceof ClienteDelivery)) {
				 alert.setContentText("Cliente n�o encontrado!");
	 			 alert.showAndWait();
			 }
			 else {
				 cliente = cli;
				 clienteLabel.setText(cliente.getNome());
			 }
		 }
		 else if(!cnpjText.getText().equals("")) {
			 Cliente cli = CadastroClienteController.buscarCliente(Long.parseLong(cnpjText.getText()));
			 if(cli==null || (cli instanceof ClienteDelivery)) {
				 alert.setContentText("Cliente n�o encontrado!");
	 			 alert.showAndWait();
			 }
			 else {
				 cliente = cli;
				 clienteLabel.setText(cliente.getNome());
			 }
		 }
	 }
	 
	 //Calcula total da compra
	 private double calculaTotalCompra() {
		 Double soma = 0.0;
		 for(Produto p : listaProdutosCompraAtual) {
        	if(p instanceof ProdutoPesado) soma+= p.getPreco()*((ProdutoPesado) p).getPeso();
        	else {
        		soma+= p.getPreco()*((ProdutoQuantidade) p).getQuantidade();
        	}
		 }
		 return soma;
	 }
	 

}
