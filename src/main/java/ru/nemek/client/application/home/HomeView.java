package ru.nemek.client.application.home;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import ru.nemek.shared.dto.Task;

import javax.inject.Inject;


public class HomeView extends ViewWithUiHandlers<HomeUiHandlers> implements HomePresenter.MyView {
    interface Binder extends UiBinder<Widget, HomeView> {
    }

    @UiField
    Button googleButton;
    @UiField(provided = true)
    FlexTable taskTable = new FlexTable();
    @UiField
    Button newTaskButton;
    @UiField
    DialogBox dialogBox;

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
        DatePicker dueBox = new DatePicker();
        dialogContents.add(taskBox);
        dialogContents.add(dueBox);

        // Add a close button at the bottom of the dialog
        Button saveButton = new Button("Сохранить");
        saveButton.addClickHandler(clickEvent -> {
            getUiHandlers().addTask(taskBox.getText(), dueBox.getValue());
            taskBox.setText("");
            dialogBox.hide();
            updateTable();
        });
        dialogContents.add(saveButton);

        Button closeButton = new Button("Отмена");
        closeButton.addClickHandler(clickEvent -> dialogBox.hide());
        dialogContents.add(closeButton);

        // Return the dialog box
        return dialogBox;
    }


    public void addTask(Task task){
        int row = taskTable.getRowCount();
        CheckBox checkBox = new CheckBox();
        checkBox.addValueChangeHandler(valueChangeEvent -> taskTable.removeRow(row));
        this.taskTable.setWidget(row, 0, new CheckBox());
        this.taskTable.setText(row, 1, task.getTask());
        this.taskTable.setText(row, 2, task.getDue().toString());
    }

    private void updateTable(){
        for(Task task: getUiHandlers().updateTable()){
            addTask(task);
        }

    }
}
