package javacrm.zinovev;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class UserTabelView {

    private static TableView<User> tableUsers =  new TableView();;
    private static TableColumn<User, Integer> idColumn;
    private static TableColumn<User, String> loginColumn;
    private static TableColumn<User, String> passwordColumn;
    private static TableColumn<User, String> emailColumn;
    private static ObservableList<User> usersData = FXCollections.observableArrayList();

    public UserTabelView(){
        CreateGUI();
    }

    private void CreateGUI(){
        idColumn = new TableColumn("id");
        loginColumn = new TableColumn("login");
        passwordColumn = new TableColumn("password");
        emailColumn = new TableColumn("email");
        idColumn.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        loginColumn.setCellValueFactory(new PropertyValueFactory<User, String>("login"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
        tableUsers.setEditable(true);
        tableUsers.getColumns().addAll(idColumn, loginColumn, passwordColumn, emailColumn);
        tableUsers.setEditable(true);
        initData();
        tableUsers.setItems(usersData);
    }

    public static TableView<User> getTableUsers() {
        return tableUsers;
    }

    public static TableColumn<User, Integer> getIdColumn() {
        return idColumn;
    }

    public static TableColumn<User, String> getEmailColumn() {
        return emailColumn;
    }

    public static TableColumn<User, String> getLoginColumn() {
        return loginColumn;
    }

    public static TableColumn<User, String> getPasswordColumn() {
        return passwordColumn;
    }

    public void initData() {
        usersData.add(new User(1, "Alex", "qwerty", "alex@mail.com"));
        usersData.add(new User(2, "Bob", "dsfsdfw", "bob@mail.com"));
        usersData.add(new User(3, "Jeck", "dsfdsfwe", "Jeck@mail.com"));
        usersData.add(new User(4, "Mike", "iueern", "mike@mail.com"));
        usersData.add(new User(5, "Colin", "woeirn", "colin@mail.com"));
    }

    public static ObservableList<User> getUsersData(){
        return usersData;
    }
}
