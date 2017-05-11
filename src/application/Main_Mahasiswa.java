package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    TextField nameInput, nimInput, fakultasInput, jurusanInput, alamatInput, kotaInput, kode_posInput, hobbyInput;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Menu Tables - JavaFX");

        TableColumn<Mahasiswa, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
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
        
        TableColumn<Mahasiswa, String> kode_posColumn = new TableColumn<>("Kode Pos");
        kode_posColumn.setMinWidth(100);
        kode_posColumn.setCellValueFactory(new PropertyValueFactory<>("kode_pos"));
        
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
        fakultasInput.setMinWidth(100);
        
        jurusanInput = new TextField();
        jurusanInput.setPromptText("Jurusan");
        jurusanInput.setMinWidth(100);
        
        alamatInput = new TextField();
        alamatInput.setPromptText("Alamat");
        alamatInput.setMinWidth(100);
        
        kotaInput = new TextField();
        kotaInput.setPromptText("Kota");
        kotaInput.setMinWidth(100);
        
        kode_posInput = new TextField();
        kode_posInput.setPromptText("Kode Pos");
        
        hobbyInput = new TextField();
        hobbyInput.setPromptText("Hobby");
        hobbyInput.setMinWidth(100);
        
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, nimInput, fakultasInput, jurusanInput, alamatInput, kotaInput, kode_posInput, hobbyInput, addButton, deleteButton);

        table = new TableView<>();
        table.setItems(getMahasiswa());
        table.getColumns().addAll(nameColumn, nimColumn, fakultasColumn, jurusanColumn, alamatColumn, kotaColumn, kode_posColumn, hobbyColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    public void addButtonClicked(){
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setName(nameInput.getText());
        mahasiswa.setNIM(Integer.parseInt(nimInput.getText()));
        mahasiswa.setFakultas(fakultasInput.getText());
        mahasiswa.setJurusan(jurusanInput.getText());
        mahasiswa.setAlamat(alamatInput.getText());
        mahasiswa.setKota(kotaInput.getText());
        mahasiswa.setKode_Pos(Integer.parseInt(kode_posInput.getText()));
        mahasiswa.setHobby(hobbyInput.getText());
        table.getItems().add(mahasiswa);
        nameInput.clear();
        nimInput.clear();
        fakultasInput.clear();
        jurusanInput.clear();
        alamatInput.clear();
        kotaInput.clear();
        kode_posInput.clear();
        hobbyInput.clear();
    }

    public void deleteButtonClicked(){
        ObservableList<Mahasiswa> mahasiswaSelected, allMahasiswas;
        allMahasiswas = table.getItems();
        mahasiswaSelected = table.getSelectionModel().getSelectedItems();

        mahasiswaSelected.forEach(allMahasiswas::remove);
    }

    public ObservableList<Mahasiswa> getMahasiswa(){
        ObservableList<Mahasiswa> mahasiswas = FXCollections.observableArrayList();
        mahasiswas.add(new Mahasiswa("Dedi", 31, "Teknik", "Informatika", "Munjungan", "Trenggalek", 65, "Makan"));
        mahasiswas.add(new Mahasiswa("Andi", 32, "Teknik", "IF", "Mojokerto", "Mojo", 543, "Oyi"));
        return mahasiswas;
    }

}
