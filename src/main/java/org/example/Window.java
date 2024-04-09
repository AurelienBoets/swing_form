package org.example;

import org.example.model.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Window extends JFrame {
    private static final List<User> users=new ArrayList<>();
    private final UserList userList=new UserList();
    private final Form form;

    public void addUser(User user){
        users.add(user);
        userList.addData(user);
    }
    public Window(){
        setTitle("Users");
        setSize(1200,800);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 1));
        form=new Form(this);
        add(form.getPanel());
        add(userList.getPanel());
        setVisible(true);
    }

}
