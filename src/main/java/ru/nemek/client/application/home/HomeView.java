package ru.nemek.client.application.home;


import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.RowStyles;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Modal;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.gwt.CellTable;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.DateTimePicker;
import ru.nemek.shared.dto.TaskDTO;

import java.util.Date;
import java.util.List;

public class HomeView extends ViewWithUiHandlers<HomeUiHandlers> implements HomePresenter.MyView {
    interface Binder extends UiBinder<Widget, HomeView> {
    }

    @UiField
    CellTable<TaskDTO> cellTable;
    @UiField
    Modal modal;
    @UiField
    Modal checkModal;
    @UiField
    TextBox taskTextBox;
    @UiField
    DateTimePicker dateTimePicker;
    @UiField
    Button saveTaskButton;
    @UiField
    Button deleteTaskButton;
    @UiField
    Button inGoogle;

    @Inject
    HomeView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        initTable();
    }

    private void initTable(){
        final Column<TaskDTO, Boolean> checkColumn = new Column<TaskDTO, Boolean>(new CheckboxCell()) {
            @Override
            public Boolean getValue(TaskDTO task) {
                return false;
            }
        };
        checkColumn.setFieldUpdater(new FieldUpdater<TaskDTO, Boolean>() {
            @Override
            public void update(int i, TaskDTO taskDTO, Boolean aBoolean) {
                if(aBoolean){
                    getUiHandlers().deleteTask(taskDTO);
            }
        }
    });
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
                return task.getDue().getDate() + "." + task.getDue().getMonth() + "." + (task.getDue().getYear() + 1900);
            }
        };
        cellTable.addColumn(dueColumn, "Due");
        this.cellTable.setRowStyles(new RowStyles<TaskDTO>() {
            @Override
            public String getStyleNames(TaskDTO task, int i) {
                Date date = new Date();
                if(task.getDue().getDate() == date.getDate() && task.getDue().getMonth() == date.getMonth() && task.getDue().getYear() == date.getYear())
                    return "success"; // если это тот же день то цвет зелёный
                if(task.getDue().before(date))
                    return "danger";// если дата прошла то цвет красный
                return "";
            }
        });
    }

    @UiHandler("saveTaskButton")
    public void saveTask(ClickEvent event){
        TaskDTO task = createTask(taskTextBox.getText(), dateTimePicker.getValue());
        getUiHandlers().saveTask(task);
        this.modal.hide();
        taskTextBox.setText("");
        dateTimePicker.setValue(null);
    }

    private TaskDTO createTask(String text, Date value) {
        return new TaskDTO(text, value);
    }

    @UiHandler("inGoogle")
    public void authGoogle(ClickEvent event){
        Window.Location.replace("/AuthServlet");
    }

    @Override
    public void updateTable(List<TaskDTO> tasks) {
        this.cellTable.setRowData(tasks);
    }
}
