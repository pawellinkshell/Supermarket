package pl.koszela.jan.layer.ui.alerts;

import org.springframework.stereotype.Component;

/**
 * Created on 16.08.2017.
 *
 * @author Jan Koszela
 */
@Component("alerts")
public class AlertManager {

  public static final String SUCCESS = "alert-success";
  public static final String WARNING = "alert-warning";
  public static final String ERROR = "alert-danger";
  public static final String INFO = "alert-info";

  private String type = null;
  private String result = null;
  private String message = null;

  public void setAlert(final String alertType, String message) {
    this.type = alertType;
    switch (alertType) {
      case SUCCESS:
        this.result = "Success";
        break;
      case WARNING:
        this.result = "Warning";
        break;
      case ERROR:
        this.result = "Problem";
        break;
      case INFO:
        this.result = "Note";
        break;
    }

    this.message = message;
  }

  public String getMessage() {
    return this.message;
  }

  public String getType(){
    return this.type;
  }

  public String getResult() {
    return result;
  }

  public void cleanAlert() {
    this.type = null;
    this.result = null;
    this.message = null;
  }

  @Override
  public String toString() {
    return "AlertManager{" +
        "type='" + type + '\'' +
        ", result='" + result + '\'' +
        ", message='" + message + '\'' +
        '}';
  }
}
