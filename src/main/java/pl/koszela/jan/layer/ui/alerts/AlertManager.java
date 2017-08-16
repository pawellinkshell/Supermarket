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

  private String currentAlertType = null;
  private String currentMessage = null;

  public void setAlert(final String alertType, String message) {
    this.currentAlertType = alertType;
    this.currentMessage = message;
  }

  public String getAlert() {
    return this.currentMessage;
  }

  public String getType(){
    return this.currentAlertType;
  }

  public void cleanAlert() {
    this.currentAlertType = null;
    this.currentMessage = null;
  }
}
