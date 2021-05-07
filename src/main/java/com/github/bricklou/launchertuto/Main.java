package com.github.bricklou.launchertuto;

import javafx.application.Application;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("javafx.application.Application");
            Application.launch(Launcher.class, args);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Erreur:\n" + e.getMessage() + " not found",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
