package ru.nemek.shared.dispatch;



import com.gwtplatform.dispatch.rpc.shared.Result;

public class getTaskResult implements Result { 

  ru.nemek.shared.dto.TaskDTO tasks;

  protected getTaskResult() {
    // Possibly for serialization.
  }

  public getTaskResult(ru.nemek.shared.dto.TaskDTO tasks) {
    this.tasks = tasks;
  }

  public ru.nemek.shared.dto.TaskDTO getTasks(){
    return tasks;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    getTaskResult other = (getTaskResult) obj;
    if (tasks == null) {
      if (other.tasks != null)
        return false;
    } else if (!tasks.equals(other.tasks))
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + (tasks == null ? 1 : tasks.hashCode());
    return hashCode;
  }

  @Override
  public String toString() {
    return "getTaskResult["
                 + tasks
    + "]";
  }
}
