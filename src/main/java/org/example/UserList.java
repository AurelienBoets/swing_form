package org.example;

import org.example.model.User;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class UserList {
    private JPanel panel;
    private JTable table;
    private DefaultTableModel tableModel;

    private User userSelection;

    public UserList() {
        panel = new JPanel(new BorderLayout());
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(blackBorder, "Tableau des données");
        panel.setBorder(titledBorder);

        String[] columnNames = {"Nom", "Email", "Genre"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton detailButton=new JButton("Details");
        detailButton.addActionListener(e->showDetail());
        panel.add(detailButton,BorderLayout.SOUTH);

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting() && table.getSelectedRowCount() == 1){
                    int selectedRow = table.getSelectedRow();
                    String name = tableModel.getValueAt(selectedRow, 0).toString();
                    String email = tableModel.getValueAt(selectedRow, 1).toString();
                    String gender = tableModel.getValueAt(selectedRow, 2).toString();
                    userSelection=new User(name,email,gender);
                }
            }
        });
    }

    public void addData(User user){
        tableModel.addRow(new Object[]{user.getName(), user.getMail(), user.getGender()});
    }

    public JPanel getPanel() {
        return panel;
    }

    public void showDetail(){
        if(userSelection!=null){
            JDialog dialog=new JDialog();
            dialog.setTitle("Details");
            dialog.setSize(100,150);
            dialog.setLayout(new GridBagLayout());
            dialog.setLocationRelativeTo(null);
            JLabel nameTitle=new JLabel("Nom:");
            JLabel nameValue=new JLabel(userSelection.getName());
            JLabel mailTitle=new JLabel("Email:");
            JLabel mailValue=new JLabel(userSelection.getMail());
            JLabel genderTitle=new JLabel("Genre:");
            JLabel genderValue=new JLabel(userSelection.getGender());
            GridBagConstraints constraints=new GridBagConstraints();
            constraints.anchor=GridBagConstraints.CENTER;
            constraints.gridx=0;
            constraints.gridy=0;
            dialog.add(nameTitle,constraints);
            constraints.gridx=1;
            dialog.add(nameValue,constraints);
            constraints.gridy=1;
            dialog.add(mailValue,constraints);
            constraints.gridx=0;
            dialog.add(mailTitle,constraints);
            constraints.gridy=2;
            dialog.add(genderTitle,constraints);
            constraints.gridx=1;
            dialog.add(genderValue,constraints);
            dialog.setVisible(true);
        }
    }
}
