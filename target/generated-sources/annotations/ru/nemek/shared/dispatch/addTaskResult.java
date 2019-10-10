package ru.nemek.shared.dispatch;



import com.gwtplatform.dispatch.rpc.shared.Result;

public class addTaskResult implements Result { 

  ru.nemek.shared.dto.TaskDTO result;

  protected addTaskResult() {
    // Possibly for serialization.
  }

  public addTaskResult(ru.nemek.shared.dto.TaskDTO result) {
    this.result = result;
  }

  public ru.nemek.shared.dto.TaskDTO getResult(){
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    addTaskResult other = (addTaskResult) obj;
    if (result == null) {
      if (other.result != null)
        return false;
    } else if (!result.equals(other.result))
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + (result == null ? 1 : result.hashCode());
    return hashCode;
  }

  @Override
  public String toString() {
    return "addTaskResult["
                 + result
    + "]";
  }
}
