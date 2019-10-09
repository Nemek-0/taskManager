package ru.nemek.shared.dispatch;

import com.gwtplatform.dispatch.rpc.shared.Action;

public class getTaskAction implements Action<getTaskResult> { 

  long id;

  protected getTaskAction() {
    // Possibly for serialization.
  }

  public getTaskAction(long id) {
    this.id = id;
  }

  @Override
  public String getServiceName() {
    return "dispatch/";
  }

  @Override
  public boolean isSecured() {
    return false;
  }

  public long getId(){
    return id;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    getTaskAction other = (getTaskAction) obj;
    if (id != other.id)
        return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + new Long(id).hashCode();
    return hashCode;
  }

  @Override
  public String toString() {
    return "getTaskAction["
                 + id
    + "]";
  }
}
