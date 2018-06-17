package javacrm.zinovev;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {

    private Stage primaryStage;
    private ObservableList<User> usersData = FXCollections.observableArrayList();;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        CreateGUI();
    }

    public static void main(String[] args) {
        launch(Main.class, args);
    }

    private void CreateGUI(){
        BorderPane pane = new BorderPane();
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10.0);
        Text heaferMenu = new Text("Main Menu: ");
        Button dashBoardButton = new Button("Dash board");
        Button customersButton = new Button("Сustomers");
        Button ordersButton = new Button("Orders");
        Button goodsButton = new Button("Goods");
        vBox.getChildren().addAll(heaferMenu, dashBoardButton, customersButton, ordersButton, goodsButton);
        pane.setLeft(vBox);

        initData();

        TableView<User> tableUsers =  new TableView();
        TableColumn<User, Integer> idColumn = new TableColumn("id");
        TableColumn<User, String> loginColumn = new TableColumn("login");
        TableColumn<User, String> passwordColumn = new TableColumn("password");
        TableColumn<User, String> emailColumn = new TableColumn("email");

        idColumn.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        loginColumn.setCellValueFactory(new PropertyValueFactory<User, String>("login"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<User, String>("email"));

        tableUsers.setEditable(true);

        tableUsers.getColumns().addAll(idColumn, loginColumn, passwordColumn, emailColumn);

        tableUsers.setItems(usersData);

        pane.setCenter(tableUsers);


        final TextField iD = new TextField();
        iD.setPromptText("id");
        iD.setMaxWidth(loginColumn.getPrefWidth());
        final TextField login = new TextField();
        login.setMaxWidth(passwordColumn.getPrefWidth());
        login.setPromptText("Ligin");
        final TextField password = new TextField();
        password.setMaxWidth(emailColumn.getPrefWidth());
        password.setPromptText("Password");
        final TextField addEmail = new TextField();
        addEmail.setMaxWidth(emailColumn.getPrefWidth());
        addEmail.setPromptText("Email");

        Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                usersData.add(new User(
                        Integer.valueOf(iD.getText()),
                        login.getText(),
                        password.getText(),
                        addEmail.getText()
                ));
                iD.clear();
                login.clear();
                password.clear();
                addEmail.clear();
            }
        });
        Button removeButton = new Button("Remove");
        removeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                User selectedItem = tableUsers.getSelectionModel().getSelectedItem();
                tableUsers.getItems().remove(selectedItem);
                };
        });

        final TextField search = new TextField();
        search.setPromptText("search");
        search.setMaxWidth(loginColumn.getPrefWidth());
        Button searchButton = new Button("Searche");
        HBox hBox = new HBox();
        hBox.getChildren().addAll(iD, login, password, addEmail, addButton, removeButton, search, searchButton);
        hBox.setAlignment(Pos.CENTER);
        pane.setTop(hBox);

        Scene scene = new Scene(pane, 800, 400);

        this.primaryStage.setTitle("Java CRM ");
        this.primaryStage.setScene(scene);
        this.primaryStage.centerOnScreen();
        this.primaryStage.show();
    }

    private void initData() {
        this.usersData.add(new User(1, "Alex", "qwerty", "alex@mail.com"));
        this.usersData.add(new User(2, "Bob", "dsfsdfw", "bob@mail.com"));
        this.usersData.add(new User(3, "Jeck", "dsfdsfwe", "Jeck@mail.com"));
        this.usersData.add(new User(4, "Mike", "iueern", "mike@mail.com"));
        this.usersData.add(new User(5, "Colin", "woeirn", "colin@mail.com"));
    }
}
