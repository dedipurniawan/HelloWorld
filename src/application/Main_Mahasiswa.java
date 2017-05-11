package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main_Mahasiswa extends Application {

    Stage window;
    TableView<Mahasiswa> table;
    TextField nameInput, nimInput, fakultasInput, jurusanInput, alamatInput, kotaInput, kodeInput, hobbyInput;
    Button addButton = new Button("Add");
    Button editButton = new Button("Edit");
    Button deleteButton = new Button("Delete");
    Button saveButton = new Button("Save");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Menu Tables - JavaFX");

        TableColumn<Mahasiswa, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Mahasiswa, String> nimColumn = new TableColumn<>("NIM");
        nimColumn.setMinWidth(100);
        nimColumn.setCellValueFactory(new PropertyValueFactory<>("nim"));
        
        TableColumn<Mahasiswa, String> fakultasColumn = new TableColumn<>("Fakultas");
        fakultasColumn.setMinWidth(100);
        fakultasColumn.setCellValueFactory(new PropertyValueFactory<>("fakultas"));
        
        TableColumn<Mahasiswa, String> jurusanColumn = new TableColumn<>("Jurusan");
        jurusanColumn.setMinWidth(100);
        jurusanColumn.setCellValueFactory(new PropertyValueFactory<>("jurusan"));
        
        TableColumn<Mahasiswa, String> alamatColumn = new TableColumn<>("Alamat");
        alamatColumn.setMinWidth(100);
        alamatColumn.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        
        TableColumn<Mahasiswa, String> kotaColumn = new TableColumn<>("Kota");
        kotaColumn.setMinWidth(100);
        kotaColumn.setCellValueFactory(new PropertyValueFactory<>("kota"));
        
        TableColumn<Mahasiswa, String> kodeColumn = new TableColumn<>("Kode");
        kodeColumn.setMinWidth(100);
        kodeColumn.setCellValueFactory(new PropertyValueFactory<>("kode"));
        
        TableColumn<Mahasiswa, String> hobbyColumn = new TableColumn<>("Hobby");
        hobbyColumn.setMinWidth(100);
        hobbyColumn.setCellValueFactory(new PropertyValueFactory<>("hobby"));


        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);

        nimInput = new TextField();
        nimInput.setPromptText("NIM");

        fakultasInput = new TextField();
        fakultasInput.setPromptText("Fakultas");
        fakultasInput.setMinWidth(50);
        
        jurusanInput = new TextField();
        jurusanInput.setPromptText("Jurusan");
        jurusanInput.setMinWidth(50);
        
        alamatInput = new TextField();
        alamatInput.setPromptText("Alamat");
        alamatInput.setMinWidth(100);
        
        kotaInput = new TextField();
        kotaInput.setPromptText("Kota");
        kotaInput.setMinWidth(50);
        
        kodeInput = new TextField();
        kodeInput.setPromptText("Kode Pos");
        
        hobbyInput = new TextField();
        hobbyInput.setPromptText("Hobby");
        hobbyInput.setMinWidth(50);
        
        addButton.setOnAction(e -> addButtonClicked());
        editButton.setOnAction(e -> editButtonClicked());
        deleteButton.setOnAction(e -> deleteButtonClicked());        
        saveButton.setOnAction(e -> saveButtonClicked());
        saveButton.setVisible(false);

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, nimInput, fakultasInput, jurusanInput, alamatInput, kotaInput, kodeInput, hobbyInput);
        
        table = new TableView<>();
        table.setItems(getMahasiswa());
        table.getColumns().addAll(nameColumn, nimColumn, fakultasColumn, jurusanColumn, alamatColumn, kotaColumn, kodeColumn, hobbyColumn);

        HBox hBoxB = new HBox();
        hBoxB.setPadding(new Insets(10,10,10,10));
        hBoxB.setSpacing(10);
        hBoxB.getChildren().addAll(addButton,editButton, deleteButton, saveButton);
                
        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox, hBoxB);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    public void addButtonClicked() {
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setName(nameInput.getText());
        mahasiswa.setNIM(Integer.parseInt(nimInput.getText()));
        mahasiswa.setFakultas(fakultasInput.getText());
        mahasiswa.setJurusan(jurusanInput.getText());
        mahasiswa.setAlamat(alamatInput.getText());
        mahasiswa.setKota(kotaInput.getText());
        mahasiswa.setKode(kodeInput.getText());
        mahasiswa.setHobby(hobbyInput.getText());
        table.getItems().add(mahasiswa);
        nameInput.clear();
        nimInput.clear();
        fakultasInput.clear();
        jurusanInput.clear();
        alamatInput.clear();
        kotaInput.clear();
        kodeInput.clear();
        hobbyInput.clear();
    }
    
    public void editButtonClicked(){
    	ObservableList<Mahasiswa> mahasiswaSelected, allMahasiswas;
        allMahasiswas = table.getItems();
        mahasiswaSelected = table.getSelectionModel().getSelectedItems();
        addButton.setDisable(true);
        deleteButton.setDisable(true);
        editButton.setDisable(true);
        saveButton.setVisible(true);
        nameInput.setText(mahasiswaSelected.get(0).getName());
        nimInput.setText(""+mahasiswaSelected.get(0).getNim());
        fakultasInput.setText(mahasiswaSelected.get(0).getFakultas());
        jurusanInput.setText(mahasiswaSelected.get(0).getJurusan());
        alamatInput.setText(mahasiswaSelected.get(0).getAlamat());
        kotaInput.setText(mahasiswaSelected.get(0).getKota());
        kodeInput.setText(mahasiswaSelected.get(0).getKode());
        hobbyInput.setText(mahasiswaSelected.get(0).getHobby());
    }
        
    public void saveButtonClicked(){
    	ObservableList<Mahasiswa> mahasiswaSelected, allMahasiswas;
        allMahasiswas = table.getItems();
        mahasiswaSelected = table.getSelectionModel().getSelectedItems();
    	Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setName(nameInput.getText());
        mahasiswa.setNIM(Integer.parseInt(nimInput.getText()));
        mahasiswa.setFakultas(fakultasInput.getText());
        mahasiswa.setJurusan(jurusanInput.getText());
        mahasiswa.setAlamat(alamatInput.getText());
        mahasiswa.setKota(kotaInput.getText());
        mahasiswa.setKode(kodeInput.getText());
        mahasiswa.setHobby(hobbyInput.getText());
        mahasiswaSelected.forEach(allMahasiswas::remove);
        table.getItems().add(mahasiswa);
        nameInput.clear();
        nimInput.clear();
        fakultasInput.clear();
        jurusanInput.clear();
        alamatInput.clear();
        kotaInput.clear();
        kodeInput.clear();
        hobbyInput.clear();
        addButton.setDisable(false);
        editButton.setDisable(false);
        deleteButton.setDisable(false);
        saveButton.setVisible(false);
    }

    public void deleteButtonClicked(){
        ObservableList<Mahasiswa> mahasiswaSelected, allMahasiswas;
        allMahasiswas = table.getItems();
        mahasiswaSelected = table.getSelectionModel().getSelectedItems();
        mahasiswaSelected.forEach(allMahasiswas::remove);
    }

    public ObservableList<Mahasiswa> getMahasiswa(){
        ObservableList<Mahasiswa> mahasiswas = FXCollections.observableArrayList();
        mahasiswas.add(new Mahasiswa("Dedi", 31, "Teknik", "Informatika", "Munjungan", "Trenggalek", "65", "Makan"));
        mahasiswas.add(new Mahasiswa("Andi", 32, "Teknik", "Informatika", "Mojo", "Mojokerto", "43", "Mangan"));
        return mahasiswas;
    }
}
