package ru.nemek.client.application.history;

import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import org.gwtbootstrap3.client.ui.gwt.ButtonCell;
import org.gwtbootstrap3.client.ui.gwt.CellTable;
import ru.nemek.shared.dto.TaskDTO;

import javax.inject.Inject;
import java.util.ArrayList;


public class HistoryView extends ViewWithUiHandlers<HistoryUiHandlers> implements HistoryPresenter.MyView {


    interface Binder extends UiBinder<Widget, HistoryView> {
    }


    @UiField
    CellTable<TaskDTO> cellTable;

    private ArrayList<TaskDTO> tasks = new ArrayList<>();

    @Inject
    HistoryView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        initCellTable();
    }

    private void initCellTable(){

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
                //return new SimpleDateFormat("dd.MM.yyyy").format(task.getDue());
                return task.getDue().getDate() + "." + task.getDue().getMonth() + "." + (task.getDue().getYear() + 1900);
            }
        };
        cellTable.addColumn(dueColumn, "Due");

        final Column<TaskDTO, String> buttonColumn = new Column<TaskDTO, String>(new ButtonCell()) {
            @Override
            public String getValue(TaskDTO taskDTO) {
                return "Return";
            }
        };
        buttonColumn.setFieldUpdater(new FieldUpdater<TaskDTO, String>() {
            @Override
            public void update(int i, TaskDTO taskDTO, String s) {
                getUiHandlers().returnTask(taskDTO);
                tasks.remove(i);
                UpdateTable(tasks);
            }
        });
        cellTable.addColumn(buttonColumn, "Return");
    }

    @Override
    public void UpdateTable(ArrayList<TaskDTO> list) {
        this.cellTable.setRowData(list);
    }

    @Override
    public void addTaskInTable(TaskDTO task) {
        this.tasks.add(task);
        UpdateTable(tasks);
    }
}
