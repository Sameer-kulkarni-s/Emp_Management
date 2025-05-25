package Emp_Management.View;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;


public class Mainimp extends JFrame implements Mainview {


    private JButton showButton = new JButton("Show");
    private JButton newButton = new JButton("New");
    private JButton updateButton = new JButton("Update");
    private JButton deleteButton = new JButton("Delete");
    private JButton forwardButton = new JButton("⮚");
    private JButton backwardButton = new JButton("⮘");

    private JTextField textId = new JTextField();
    private JTextField textName = new JTextField();
    private JTextField textDate = new JTextField();
    private JTextField textCheckIn = new JTextField();
    private JTextField textCheckOut = new JTextField();
    private JTextField textHoursWorked = new JTextField();

    public static class ExitButtonPerformer implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Exiting using Method 1");
        }
    }
      public void onClickExitButton(ActionEvent event) {
        System.out.println("Exiting using Method 4");
        dispose();
    }

    public Mainimp() {
        setTitle("Employee Attendance Management");
        setSize(500, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addComponent();
        pack();
        setVisible(true);
    }

    private void addComponent() {
        setLayout(new BorderLayout());

        JPanel bottomPanel = new JPanel(new FlowLayout());
        add(bottomPanel, BorderLayout.SOUTH);

        JPanel centerPanel = new JPanel(new GridLayout(6, 2));
        centerPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(centerPanel, BorderLayout.CENTER);

        centerPanel.add(new JLabel("Employee ID:"));
        centerPanel.add(textId);
        centerPanel.add(new JLabel("Name:"));
        centerPanel.add(textName);
        centerPanel.add(new JLabel("Date (yyyy-MM-dd):"));
        centerPanel.add(textDate);
        centerPanel.add(new JLabel("Check-In Time (HH:mm):"));
        centerPanel.add(textCheckIn);
        centerPanel.add(new JLabel("Check-Out Time (HH:mm):"));
        centerPanel.add(textCheckOut);
        centerPanel.add(new JLabel("Hours Worked:"));
        centerPanel.add(textHoursWorked);

        JButton exitButton = new JButton("Exit");

        bottomPanel.add(backwardButton);
        bottomPanel.add(showButton);
        bottomPanel.add(newButton);
        bottomPanel.add(updateButton);
        bottomPanel.add(deleteButton);
        bottomPanel.add(forwardButton);
        bottomPanel.add(exitButton);

        exitButton.addActionListener(new ExitButtonPerformer());
        exitButton.addActionListener(e -> System.out.println("Exiting using Method 3"));
        exitButton.addActionListener(this::onClickExitButton);
    }


    // Display method for one record
    public void showEmployee(int id, String name, String date, String checkIn, String checkOut, String hoursWorked) {
        textId.setText(String.valueOf(id));
        textName.setText(name);
        textDate.setText(date);
        textCheckIn.setText(checkIn);
        textCheckOut.setText(checkOut);
        textHoursWorked.setText(hoursWorked);
    }

    public void clearFields() {
        textId.setText("");
        textName.setText("");
        textDate.setText("");
        textCheckIn.setText("");
        textCheckOut.setText("");
        textHoursWorked.setText("");
    }

    // Button listeners
    public void setShowButtonActionListener(ActionListener listener) {
        showButton.addActionListener(listener);
    }

    public void setNewButtonActionListener(ActionListener listener) {
        newButton.addActionListener(listener);
    }

    public void setUpdateButtonActionListener(ActionListener listener) {
        updateButton.addActionListener(listener);
    }

    public void setDeleteButtonActionListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }

    public void setBackwardButtonActionListener(ActionListener listener) {
        backwardButton.addActionListener(listener);
    }

    public void setForwardButtonActionListener(ActionListener listener) {
        forwardButton.addActionListener(listener);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showWarning(String message) {
        JOptionPane.showMessageDialog(this, message, "Warning", JOptionPane.WARNING_MESSAGE);
    }

    public boolean confirm(String message) {
        return JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, message, "Confirm", JOptionPane.YES_NO_OPTION);
    }

    @Override
    public void showid(int id) {
        textId.setText( String.valueOf(id) );
    }

    @Override
    public void showname(String name) {
        textName.setText( name);
    }

    @Override
    public void showdate(LocalDate date) {
        textDate.setText( String.valueOf(date) );
    }

    @Override
    public void Showcheckin(LocalTime check_in) {
        textCheckIn.setText( String.valueOf(check_in) );
    }

    @Override
    public void Showcheckout(LocalTime chcek_out) {
        textCheckOut.setText( String.valueOf(chcek_out) );
    }

    @Override
    public void Showhours(BigDecimal hours_worked) {
        textHoursWorked.setText( String.valueOf(hours_worked) );
    }

    @Override
    public boolean confirmationDialog(String message) {
        return JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, message, "Question", JOptionPane.YES_NO_OPTION);
    }
// Getter methods
public int getid() {
    return Integer.parseInt(textId.getText());
}

public String getname() {
    return textName.getText();
}

public LocalDate getdate() {
    return LocalDate.parse(textDate.getText());
}


public LocalTime getcheck_in() {
    return LocalTime.parse(textCheckIn.getText());
}

public LocalTime getcheck_out() {
    return LocalTime.parse(textCheckOut.getText());
}

     @Override
     public BigDecimal gethours_worked() {
        try {
            return new BigDecimal(textHoursWorked.getText());
        } catch (NumberFormatException e) {
            showWarning("Please enter a valid number for hours worked.");
            return BigDecimal.ZERO;
        }
    }

}

   

