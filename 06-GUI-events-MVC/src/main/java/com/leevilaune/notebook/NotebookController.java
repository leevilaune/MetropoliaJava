package com.leevilaune.notebook;

import com.leevilaune.notebook.model.Note;
import com.leevilaune.notebook.model.Notebook;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class NotebookController {

    @FXML
    private TextField noteTitle;
    @FXML
    private TextArea noteContent;
    @FXML
    private Button addButton;
    @FXML
    private ListView<String> readNotesPane;
    @FXML
    private TextArea loadedNoteContent;
    @FXML
    private TextField loadedNoteTitle;

    private Notebook notebook;
    private VBox notesPane;

    public NotebookController(){
        this.notebook = new Notebook();
        this.notesPane = new VBox();
    }
    @FXML
    public void initialize() {
        this.readNotesPane.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        loadNote();
                    }
                });
    }

    @FXML
    public void addNote(){
        System.out.println("addNote() called");
        System.out.println(this.noteTitle.getText() + ": " + this.noteContent.getText());
        this.notebook.addNote(new Note(this.noteTitle.getText(), this.noteContent.getText()));
        this.readNotesPane.getItems().add(this.noteTitle.getText());
    }
    @FXML
    public void loadNote(){
        String title = this.readNotesPane.getSelectionModel().getSelectedItem();
        if(title!=null){
            Note note = this.notebook.getNote(title);
            this.loadedNoteTitle.setText(note.getTitle());
            this.loadedNoteContent.setText(note.getContent());
        }
    }

}
