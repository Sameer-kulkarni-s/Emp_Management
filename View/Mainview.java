package Emp_Management.View;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public interface Mainview {


    void showid(int id);
    void showname(String name);
    void showdate(LocalDate date);
    void Showcheckin(LocalTime check_in);
    void Showcheckout(LocalTime chcek_out);
    void Showhours(BigDecimal hours_worked);

    void showMessage(String message);
    void showWarning(String message);
    boolean confirmationDialog(String message);

    int getid();
    String getname();
    LocalDate getdate();
    LocalTime getcheck_in();
    LocalTime getcheck_out();
    BigDecimal gethours_worked();


    void setShowButtonActionListener(ActionListener listener);
    void setNewButtonActionListener(ActionListener listener);
    void setDeleteButtonActionListener(ActionListener listener);
    void setBackwardButtonActionListener(ActionListener listener);
    void setForwardButtonActionListener(ActionListener listener);
}


