package ru.nemek.client.application.home;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import ru.nemek.shared.dto.TaskDTO;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;


public class HomeView extends ViewWithUiHandlers<HomeUiHandlers> implements HomePresenter.MyView {
    interface Binder extends UiBinder<Widget, HomeView> {
    }

    @UiField
    Button googleButton;
    @UiField
    FlexTable taskTable = new FlexTable();
    @UiField
    Button newTaskButton;
    @UiField
    DialogBox dialogBox;
    @UiField
    TextBox textBox;

    @Inject
    HomeView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        initFlexTable();
        dialogBox = createDialogBox();
    }

    @UiHandler("googleButton")
    public void GoogleButton(ClickEvent eventfirst) {
        getUiHandlers().GoogleButton();
    }
    @UiHandler("newTaskButton")
    public void showDialogBox(ClickEvent event){
        dialogBox.center();
        dialogBox.show();
    }

    public void isLogin(Boolean isLogin) {
        if(isLogin){
            googleButton.setVisible(false);
        }
    }

    public FlexTable getFlexTable() {
        return taskTable;
    }

    public void setFlexTable(FlexTable flexTable) {
        this.taskTable = flexTable;
    }

    private void initFlexTable() {
        taskTable.setText(0,0,"Done?");
        taskTable.setText(0,1,"Task");
        taskTable.setText(0,2,"Due");
    }

    private DialogBox createDialogBox(){
        DialogBox dialogBox = new DialogBox();
        dialogBox.ensureDebugId("dialogBox");

        // Create a table to layout the content
        VerticalPanel dialogContents = new VerticalPanel();
        dialogContents.setSpacing(4);
        dialogBox.setWidget(dialogContents);

        HTML details = new HTML();
        dialogContents.add(details);
        dialogContents.setCellHorizontalAlignment(
                details, HasHorizontalAlignment.ALIGN_CENTER);

        TextBox taskBox = new TextBox();
        DatePicker dateBox = new DatePicker();
        dialogContents.add(taskBox);
        dialogContents.add(dateBox);

        // Add a close button at the bottom of the dialog
        Button saveButton = new Button("Сохранить");
        saveButton.addClickHandler(clickEvent -> {
            newTask(taskBox.getText(), dateBox.getValue());
            taskBox.setText("");
            dialogBox.hide();
        });
        dialogContents.add(saveButton);

        Button closeButton = new Button("Отмена");
        closeButton.addClickHandler(clickEvent -> dialogBox.hide());
        dialogContents.add(closeButton);

        // Return the dialog box
        return dialogBox;
    }


    public void addTask(TaskDTO task){
        int row = taskTable.getRowCount();
        this.taskTable.setWidget(row, 0, new CheckBox());
        this.taskTable.setText(row, 1, task.getTask());
        this.taskTable.setText(row, 2, task.getDue().toString());
    }

    public void updateTable(ArrayList<TaskDTO> tasks){
        for(TaskDTO task: tasks){
            addTask(task);
        }
    }

    private void newTask(String taskString, Date due){
        getUiHandlers().addTask(taskString, due);
    }

    public void setTextBox(String str){
        this.textBox.setText(str);
    }
}
