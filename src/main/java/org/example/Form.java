package org.example;

import org.example.model.User;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Enumeration;

public class Form {
    private final JPanel panel;
    private final JTextField nameInput;
    private final JTextField mailInput;
    private final ButtonGroup genderInput;

    public Form(Window window){
        panel=new JPanel(new GridBagLayout());
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(blackBorder, "Formulaire d'ajout");
        panel.setBorder(titledBorder);
        JLabel nameLabel=new JLabel("Nom:");
        JLabel mailLabel=new JLabel("Email:");
        JLabel genderLabel=new JLabel("Genre:");
        nameInput=new JTextField(20);
        mailInput=new JTextField(20);
        JRadioButton manRadio=new JRadioButton("Homme");
        JRadioButton womanRadio=new JRadioButton("Femme");
        genderInput=new ButtonGroup();
        genderInput.add(manRadio);
        genderInput.add(womanRadio);
        JButton submitButton=new JButton("Ajouter");
        submitButton.addActionListener(e-> {
            if(getGender()!=null && !getMail().isEmpty()&& !getName().isEmpty()) {
                User user = new User(getName(), getMail(), getGender());
                window.addUser(user);
                nameInput.setText("");
                mailInput.setText("");
                genderInput.clearSelection();
            }
        });

        GridBagConstraints constraints=new GridBagConstraints();
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.anchor=GridBagConstraints.CENTER;
        constraints.insets=new Insets(5,5,5,5);
        panel.add(nameLabel,constraints);
        constraints.gridy=1;
        panel.add(mailLabel,constraints);
        constraints.gridy=2;
        panel.add(genderLabel,constraints);
        constraints.gridx=1;
        constraints.gridy=0;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        panel.add(nameInput,constraints);
        constraints.gridy=1;
        panel.add(mailInput,constraints);
        constraints.gridy=2;
        constraints.gridwidth=1;
        panel.add(manRadio,constraints);
        constraints.gridx=2;
        panel.add(womanRadio,constraints);
        constraints.gridx=1;
        constraints.gridy=3;
        panel.add(submitButton,constraints);
    }

    public JPanel getPanel() {
        return panel;
    }

    public String getName() {
        return nameInput.getText();
    }


    public String getMail() {
        return mailInput.getText();
    }

    public String getGender(){
        String selectedGender = null;
        for (Enumeration<AbstractButton> buttons = genderInput.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                selectedGender = button.getText();
                break;
            }
        }
        return selectedGender;
    }


}
