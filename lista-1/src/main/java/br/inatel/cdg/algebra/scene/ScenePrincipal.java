package br.inatel.cdg.algebra.scene;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScenePrincipal {

    private Button btnTeste, btnCalcCoefLinear; //Button representa botoes
    private Label labelX1,labelY1,labelX2,labelY2; //Label representam rótulos
    private TextField fieldX1, fieldY1, fieldX2, fieldY2, fieldCa, fieldCl; //TextField Representam áreas de texto

    public void criaScenePrincipal(Stage stage){

        //Criando os labels para os pontos e os campos de texto para os dados
        labelX1 = new Label("Entre com X1: "); //rótulos
        fieldX1 = new TextField(); //área de texto onde vc digitara alguma coisa
        labelY1 = new Label("Entre com Y1: ");
        fieldY1 = new TextField();
        labelX2 = new Label("Entre com X2: ");
        fieldX2 = new TextField();
        labelY2 = new Label("Entre com Y2: ");
        fieldY2 = new TextField();

        //HBox é usado para agrupar elementos horizontalmente
        HBox grupoHorizontal = new HBox(labelX1, fieldX1, labelY1, fieldY1); //Passamos no construtor todos os elementos. Você poderá criar vários grupos horizontais
        HBox grupoHorizontal2 = new HBox(labelX2, fieldX2, labelY2, fieldY2);

        //Agora vamos criar a area que mostrará o que foi digitado
        fieldCa = new TextField();
        fieldCa.setEditable(false);//vamos deixar false para apenas mostrar texto
        fieldCa.setText("Coeficiente angular");
        fieldCl = new TextField();
        fieldCl.setEditable(false);//vamos deixar false para apenas mostrar texto
        fieldCl.setText("Coeficiente linear");

        //Criamos o botão
        btnTeste = new Button("Executar Ação");
        //Criamos a ação que o botão responderá as ser pressionado
        btnTeste.setOnAction(evento -> {
            String auxX1 = fieldX1.getText();
            String auxX2 = fieldX2.getText();
            String auxY1 = fieldY1.getText();
            String auxY2 = fieldY2.getText();
            double auxX11 = Double.parseDouble(auxX1);
            double auxX22 = Double.parseDouble(auxX2);
            double auxY11 = Double.parseDouble(auxY1);
            double auxY22 = Double.parseDouble(auxY2);
            Reta reta = new Reta();
            reta.ponto1 = new Ponto();
            reta.ponto1.x = auxX11;
            reta.ponto1.y = auxY11;
            reta.ponto2 = new Ponto();
            reta.ponto2.x = auxX22;
            reta.ponto2.y = auxY22;
            double result = reta.calcCa();
            String info = String.valueOf(result);
            fieldCa.setText(info);//Acessamos o componente textField1, pegamos o texto e colocaos em textField2
            result = reta.calcCl();
            info = String.valueOf(result);
            fieldCl.setText(info);
        });

        //VBox é usada para agrupar elementos verticalmente
        //No construtor passamos todos os elementos que serão agrupados, que podem ser outros grupos
        VBox layoutFinal = new VBox(grupoHorizontal, grupoHorizontal2, fieldCa, fieldCl,btnTeste);//Aqui vamos agrupar verticalmente o grupo (Label + Texto) o Botao e A area que aparecer o texto digitado
        //Criamos a Scene
        Scene scene = new Scene(layoutFinal, 300 , 200);

        stage.setTitle("Software Para Calculos de Álgebra Linear");
        stage.setScene(scene);
        stage.show();
    }

}