package application;

import java.util.Arrays;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class exemploAlerta extends Application {

	private Button botao01 = new Button("Exemplo 01");
	private Button botao02 = new Button("Exemplo 02");
	private Button botao03 = new Button("Exemplo 03");
	private Button botao04 = new Button("Exemplo 04");
	private Button botao05 = new Button("Exemplo 05");
	private Button botao06 = new Button("Exemplo 06");
	private Button botao07 = new Button("Exemplo 07");
	
	@Override
	public void init() throws Exception {
		
		super.init();
		
		botao01.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Informação");
				alert.setHeaderText(null);
				alert.setContentText("Você clicou no Exemplo 01");
				alert.show();
			}
		});
		
		botao02.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ERRO!");
				alert.setHeaderText(null);
				alert.setContentText("Butão do Erro! Vacilão!");
				alert.show();
			}});
		
		botao03.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Está Certo disso?");
				alert.setHeaderText(null);
				alert.setContentText("Pergunta de 1 Milhao!");
				Optional<ButtonType> resposta = alert.showAndWait();
				if(resposta.get().equals(ButtonType.OK)) {
					System.out.println("OK");
				}
				else if(resposta.get().equals(ButtonType.CANCEL)) {
					System.out.println("Cancelar");
				}
				
			}});
		
		botao04.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("INFORMAÇÃO");
				alert.setHeaderText("Detalhes");
				alert.setContentText("Botão 4: veja detalhes...");
				
				Label label = new Label("Outros detalhes");
				alert.getDialogPane().setExpandableContent(label);
				
				alert.show();
			}});
		
		//outros botões
		botao05.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.NONE);
				alert.setTitle("INFORMAÇÃO");
				alert.setHeaderText("Outros botões");
				alert.setContentText("Selecione uma das opções");
				
				ButtonType buttonSim = new ButtonType("Sim");
				ButtonType buttonNao = new ButtonType("Não");
				ButtonType buttonTalvez = new ButtonType("Talvez");
				ButtonType buttonCerteza = new ButtonType("Certeza", ButtonData.CANCEL_CLOSE);
				
				alert.getButtonTypes().addAll(buttonSim,
											  buttonNao,
											  buttonTalvez,
											  buttonCerteza);
				
				Optional<ButtonType> resposta = alert.showAndWait();
				System.out.println(resposta.get().getText());
				
			
				alert.show();
			}
		});

		botao06.setOnAction(new EventHandler<ActionEvent>() {
		
			public void handle(ActionEvent event) {
				TextInputDialog dialog = new  TextInputDialog("Palmas");
				dialog.setTitle("Município");
				dialog.setHeaderText("Cabeçalho qulquer");
				dialog.setContentText("Informe o nome da sua cidade");
				
				Optional<String> resultado = dialog.showAndWait();
				if(resultado.isPresent())
					System.out.println("A cidade digitada foi: " + resultado.get());
			}
		});
	
	
		botao07.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				ChoiceDialog<String> dialog = 
						new ChoiceDialog<String>(
								"Palmas",
								Arrays.asList("Araguaina",
											  "Paraíso",
											  "Palmas"));
				Optional<String> resultado = dialog.showAndWait();
				System.out.println(resultado.get());
								
			}
		});
	
	}
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
			
			VBox root = new VBox();
			root.getChildren().addAll(botao01,botao02,botao03,botao04,botao05,botao06,botao07);
			
			root.setAlignment(Pos.CENTER);
			root.setSpacing(10);
			
			Scene scene = new Scene(root, 300, 300);
		
			primaryStage.setScene(scene);
			primaryStage.show();
		
			
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	

}
