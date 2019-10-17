package ru.nemek.client.application.home;


import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Modal;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.gwt.CellTable;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.DateTimePicker;
import ru.nemek.shared.dto.TaskDTO;

import java.util.ArrayList;

public class HomeView extends ViewWithUiHandlers<HomeUiHandlers> implements HomePresenter.MyView {
    interface Binder extends UiBinder<Widget, HomeView> {
    }

    @UiField
    CellTable<TaskDTO> cellTable;
    @UiField
    Modal modal;
    @UiField
    TextBox taskTextBox;
    @UiField
    DateTimePicker dateTimePicker;
    @UiField
    Button saveTaskButton;



    @Inject
    HomeView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        initTable();
    }


    private void initTable(){
        final Column<TaskDTO, Boolean> checkColumn = new Column<TaskDTO, Boolean>(new CheckboxCell(true, false)) {
            @Override
            public Boolean getValue(TaskDTO task) {
                return false;
            }
        };
        cellTable.addColumn(checkColumn, "Done?");

        final TextColumn<TaskDTO> nameTaskColumn = new TextColumn<TaskDTO>() {
            @Override
            public String getValue(TaskDTO task) {
                return task.getTask();
            }
        };
        cellTable.addColumn(nameTaskColumn, "Task");

        final TextColumn<TaskDTO> dueColumn = new TextColumn<TaskDTO>() {
            @Override
            public String getValue(TaskDTO task) {
                return task.getDue().toString();
            }
        };
        cellTable.addColumn(dueColumn, "Due");
    }

    @UiHandler("saveTaskButton")
    public void saveTask(ClickEvent event){
        getUiHandlers().saveTask(this.taskTextBox.getText(), this.dateTimePicker.getValue());
        this.modal.hide();
    }

    @Override
    public void addTaskInTable(TaskDTO task) {
        ArrayList<TaskDTO> tasks = new ArrayList<TaskDTO>();
        tasks.add(task);
        this.cellTable.setRowData(tasks);
    }

    @Override
    public void updateTable(ArrayList<TaskDTO> tasks) {
        this.cellTable.setRowData(tasks);
    }
}
