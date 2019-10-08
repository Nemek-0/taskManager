package ru.nemek.shared.dispatch;

import com.gwtplatform.dispatch.rpc.shared.Action;

public class getTasksAction implements Action<getTasksResult> { 


  public getTasksAction() {
    // Possibly for serialization.
  }

  @Override
  public String getServiceName() {
    return "dispatch/";
  }

  @Override
  public boolean isSecured() {
    return false;
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public String toString() {
    return "getTasksAction["
    + "]";
  }
}
