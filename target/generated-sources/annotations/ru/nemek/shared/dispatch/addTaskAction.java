package ru.nemek.shared.dispatch;

import com.gwtplatform.dispatch.rpc.shared.Action;

public class addTaskAction implements Action<addTaskResult> { 

  ru.nemek.shared.dto.TaskDTO task;

  protected addTaskAction() {
    // Possibly for serialization.
  }

  public addTaskAction(ru.nemek.shared.dto.TaskDTO task) {
    this.task = task;
  }

  @Override
  public String getServiceName() {
    return "dispatch/";
  }

  @Override
  public boolean isSecured() {
    return false;
  }

  public ru.nemek.shared.dto.TaskDTO getTask(){
    return task;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    addTaskAction other = (addTaskAction) obj;
    if (task == null) {
      if (other.task != null)
        return false;
    } else if (!task.equals(other.task))
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + (task == null ? 1 : task.hashCode());
    return hashCode;
  }

  @Override
  public String toString() {
    return "addTaskAction["
                 + task
    + "]";
  }
}
