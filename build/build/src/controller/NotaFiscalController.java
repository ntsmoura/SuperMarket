package controller;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.CompraLocal;
import model.Dinheiro;
import model.FormaPagamento;
import model.Cartao;

public class NotaFiscalController implements Initializable, Controller{
	
	//Labels
	@FXML
	private Label dataLabel;
	@FXML
	private Label qtdLabel;
	@FXML
	private Label totalLabel;
	@FXML
	private Label pagamentoLabel;
	@FXML
	private Label parcelasLabel;
	@FXML
	private Label trocoLabel;
	@FXML
	private Label clienteLabel;
	@FXML
	private Label atendenteLabel;
	


	//Inicia tela
	@Override
	public void iniciar() {
		try {
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(Main.class.getResource("/view/NotaFiscal.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Main.class.getResource("/view/application.css").toExternalForm());
			stage.setScene(scene);
			stage.setTitle("Nota Fiscal");
	        stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		VendaLocalController.vendaLocalStage.close();
		CompraLocal c = VendaLocalController.compraAtual;
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");  
        String strDate = dateFormat.format(c.getDataHoraRealizada());  
        dataLabel.setText(strDate);
        qtdLabel.setText(String.valueOf(c.getQuantidadeItens()));
        totalLabel.setText(String.valueOf(c.getTotalCompra()));
        FormaPagamento pagamento = c.getPagamento();
        pagamentoLabel.setText(pagamento.getDescricao());
        if(pagamento instanceof Dinheiro) {
        	parcelasLabel.setText("É dinheiro.");
        	trocoLabel.setText(String.valueOf(((Dinheiro) pagamento).getTroco()));
        }
        else {
        	parcelasLabel.setText(String.valueOf(((Cartao)pagamento).getParcelas()));
        	trocoLabel.setText("Não tem troco.");
        }
        clienteLabel.setText(c.getCliente().getNome());
        atendenteLabel.setText(c.getAtendente().getNome());
		
	}

	@Override
	public void concluir() {
		// TODO Auto-generated method stub
		
	}

}
