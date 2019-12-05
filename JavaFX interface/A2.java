import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.geometry.Insets;
import javax.swing.Box;

public class A2 extends Application {	
	
	public void applyPriceCalculation()
	{
		price=0;
		try
		{
			String textbox2=text2.getText();
			String textbox3=text3.getText();

			Double textbox2value= Double.parseDouble(textbox2);
			Double textbox3value= Double.parseDouble(textbox3);
			price=textbox2value*textbox3value;
			label10.setText(Double.toString(price));
			
			overall = price + price2 + price3;
			label13.setText(Double.toString(overall));
		}
		catch(NumberFormatException  e)
		{
			label10.setText("");
			overall =price2 + price3;
			label13.setText(Double.toString(overall));
		}	
	}
	public void applyPriceCalculation2()
	{
		price2=0;
		try
		{
			String textbox5=text5.getText();
			String textbox6=text6.getText();
	
			textbox5value= Double.parseDouble(textbox5);
			textbox6value= Double.parseDouble(textbox6);
			price2=textbox5value*textbox6value;	
			label11.setText(Double.toString(price2));
				
			overall = price + price2 + price3;
			label13.setText(Double.toString(overall));
		}
		catch(NumberFormatException  e)
		{
			label11.setText("");
			overall =price + price3;
			label13.setText(Double.toString(overall));
		}	
	}
	public void applyPriceCalculation3()
	{
		price3=0;
		try
		{ 
			
			String textbox8=text8.getText();
			String textbox9=text9.getText();
			
			Double textbox8value= Double.parseDouble(textbox8);
			Double textbox9value= Double.parseDouble(textbox9);
			price3=textbox8value*textbox9value;
			label12.setText(Double.toString(price3));	
		
			overall = price + price2 + price3;
			label13.setText(Double.toString(overall));
		}
		catch(NumberFormatException  e)
		{
			label12.setText("");
			overall =price + price2;
			label13.setText(Double.toString(overall));
		}

	}
	
	public double textbox5value=0;
	public double textbox6value=0;
	public double overall =0;
	public double price=0;
	public double price2=0;
	public double price3=0;
	
	Text label1= new Text("	Item");
	Text label2= new Text("	#");
	Text label3= new Text("	Value");
	Text label4= new Text("	Price");
	Text label5= new Text("TOTAL: 	");
	Text label7= new Text("	");
	Text label8= new Text("	");
	Text label9= new Text("	");
	
	Text label10= new Text("");
	Text label11= new Text("");
	Text label12= new Text("");
	Text label13= new Text("");
	
	Text labelS1= new Text("		");
	Text labelS2= new Text("		");
	
	TextField text1 = new TextField();
	TextField text2 = new TextField();
	TextField text3 = new TextField();
	
	TextField text4 = new TextField();
	TextField text5 = new TextField();
	TextField text6 = new TextField();
	
	TextField text7 = new TextField();
	TextField text8 = new TextField();
	TextField text9 = new TextField();


	@Override
    public void start(Stage primaryStage) {
		
		text1.setOnKeyReleased(e -> applyPriceCalculation());
		text2.setOnKeyReleased(e -> applyPriceCalculation());
        text3.setOnKeyReleased(e -> applyPriceCalculation());
		text4.setOnKeyReleased(e -> applyPriceCalculation2());
        text5.setOnKeyReleased(e -> applyPriceCalculation2());
		text6.setOnKeyReleased(e -> applyPriceCalculation2());
		text7.setOnKeyReleased(e -> applyPriceCalculation3());
		text8.setOnKeyReleased(e -> applyPriceCalculation3());
		text9.setOnKeyReleased(e -> applyPriceCalculation3());
		
		text1.setPrefWidth(250);
		text4.setPrefWidth(250);
		text7.setPrefWidth(250);
		
		text2.setPrefWidth(100);
		text3.setPrefWidth(100);
		text5.setPrefWidth(100);
		
		text6.setPrefWidth(100);
		text8.setPrefWidth(100);
		text9.setPrefWidth(100);
		
		VBox root = new VBox();
		root.setSpacing(0);
		
		HBox hbox1 = new HBox(); 
		hbox1.setPadding(new Insets(5, 10, 5, 10));
	
		HBox hbox2 = new HBox(); 
		hbox2.setPadding(new Insets(5, 10, 5, 10));
		
		HBox hbox3 = new HBox(); 
		hbox3.setPadding(new Insets(0, 10, 0, 10));
		
		HBox hbox4 = new HBox(); 
		hbox4.setPadding(new Insets(0, 10, 0, 10));
		
		HBox hbox5 = new HBox(); 
		hbox5.setPadding(new Insets(5, 10, 5, 10));
		
		
		VBox vbox1 = new VBox();
		vbox1.getChildren().add(label1);
		vbox1.getChildren().add(text1);
		hbox1.getChildren().add(vbox1);
		
		VBox vbox2 = new VBox();
		vbox2.getChildren().add(label2);
		vbox2.getChildren().add(text2);
		hbox1.getChildren().add(vbox2);
		
		VBox vbox3 = new VBox();
		vbox3.getChildren().add(label3);
		vbox3.getChildren().add(text3);	
		hbox1.getChildren().add(vbox3);
		
		VBox vbox4 = new VBox();
		vbox4.setSpacing(10);
		vbox4.setAlignment(Pos.CENTER_RIGHT);		
		vbox4.getChildren().add(label4);
		vbox4.getChildren().add(label10); //price total for line 1
		hbox1.getChildren().add(vbox4);
	
		
		VBox vbox5 = new VBox();
		vbox5.getChildren().add(text4);
		hbox2.getChildren().add(vbox5);	
		
		VBox vbox6 = new VBox();
		vbox6.getChildren().add(text5);
		hbox2.getChildren().add(vbox6);	
		
		VBox vbox7 = new VBox();
		vbox7.getChildren().add(text6);
		hbox2.getChildren().add(vbox7);	
		
		VBox vbox8 = new VBox(); 	
		vbox8.getChildren().add(labelS1);
		vbox8.setAlignment(Pos.CENTER_RIGHT);
		vbox8.getChildren().add(label11); //price total for line 2
		hbox2.getChildren().add(vbox8);
		
		VBox vbox9 = new VBox();
		vbox9.getChildren().add(text7);
		hbox3.getChildren().add(vbox9);	
		
		VBox vbox10 = new VBox();
		vbox10.getChildren().add(text8);
		hbox3.getChildren().add(vbox10);	
		
		VBox vbox11 = new VBox();
		vbox11.getChildren().add(text9);
		hbox3.getChildren().add(vbox11);
		
		VBox vbox12 = new VBox();
		vbox12.getChildren().add(labelS2);
		vbox12.setAlignment(Pos.CENTER_RIGHT);		
		vbox12.getChildren().add(label12); //price total for line 3
		hbox3.getChildren().add(vbox12);	
	
		VBox vbox13 = new VBox();
		vbox13.setPadding(new Insets(10, 20, 10, 20));
		vbox13.getChildren().add(label5);
		hbox4.getChildren().add(vbox13);
		
		VBox vboxTotal = new VBox(); 
		vboxTotal.setPadding(new Insets(10, 20, 10, 20));		
		vboxTotal.setAlignment(Pos.CENTER_RIGHT);	
		label13.setFont(new Font("Verdana", 16));
		vboxTotal.getChildren().add(label13); //price total for all lines
		hbox4.getChildren().add(vboxTotal);	 
		
		root.getChildren().add(hbox1);
		root.getChildren().add(hbox2);
		root.getChildren().add(hbox3);
		root.getChildren().add(hbox4);
		root.getChildren().add(hbox5);
	
		Scene scene = new Scene(root, 500, 220);
		
		primaryStage.setTitle("Price Calculation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	


    public static void main(String[] args) {
        launch(args);
    }
}