package javacrm.zinovev;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class TopField {

    private static HBox hBox = new HBox();

    public TopField(){
        CreateGUI();
    }

    private void CreateGUI(){
        final TextField iD = new TextField();
        iD.setPromptText("id");
        iD.setMaxWidth(UserTabelView.getIdColumn().getPrefWidth());
        final TextField login = new TextField();
        login.setMaxWidth(UserTabelView.getLoginColumn().getPrefWidth());
        login.setPromptText("Ligin");
        final TextField password = new TextField();
        password.setMaxWidth(UserTabelView.getPasswordColumn().getPrefWidth());
        password.setPromptText("Password");
        final TextField addEmail = new TextField();
        addEmail.setMaxWidth(UserTabelView.getEmailColumn().getPrefWidth());
        addEmail.setPromptText("Email");

        Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                UserTabelView.getUsersData().add(new User(
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
                User selectedItem = UserTabelView.getTableUsers().getSelectionModel().getSelectedItem();
                UserTabelView.getTableUsers().getItems().remove(selectedItem);
            };
        });

        final TextField search = new TextField();
        search.setPromptText("search");
        search.setMaxWidth(UserTabelView.getIdColumn().getPrefWidth());
        Button searchButton = new Button("Searche");
        hBox.getChildren().addAll(iD, login, password, addEmail, addButton, removeButton, search, searchButton);
        hBox.setAlignment(Pos.CENTER);
    }

    public static HBox gethBox() {
        return hBox;
    }
}
