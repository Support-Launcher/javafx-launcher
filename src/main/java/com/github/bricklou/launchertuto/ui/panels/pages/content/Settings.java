package com.github.bricklou.launchertuto.ui.panels.pages.content;

import com.github.bricklou.launchertuto.Launcher;
import com.github.bricklou.launchertuto.ui.PanelManager;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import fr.theshark34.openlauncherlib.util.Saver;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;

public class Settings extends ContentPanel {
    private final Saver saver = Launcher.getInstance().getSaver();
    GridPane contentPane = new GridPane();

    @Override
    public String getName() {
        return "settings";
    }

    @Override
    public String getStylesheetPath() {
        return "css/content/settings.css";
    }

    @Override
    public void init(PanelManager panelManager) {
        super.init(panelManager);

        // Background
        this.layout.getStyleClass().add("settings-layout");
        this.layout.setPadding(new Insets(40));
        setCanTakeAllSize(this.layout);

        // Content
        contentPane.getStyleClass().add("content-pane");
        setCanTakeAllSize(contentPane);
        this.layout.getChildren().add(contentPane);

        // Titre
        Label title = new Label("Paramètres");
        title.setFont(Font.font("Consolas", FontWeight.BOLD, FontPosture.REGULAR, 25f));
        title.getStyleClass().add("settings-title");
        setLeft(title);
        setCanTakeAllSize(title);
        setTop(title);
        title.setTextAlignment(TextAlignment.LEFT);
        title.setTranslateY(40d);
        title.setTranslateX(25d);
        contentPane.getChildren().add(title);

        // RAM
        Label ramLabel = new Label("Mémoire max");
        ramLabel.getStyleClass().add("settings-labels");
        setLeft(ramLabel);
        setCanTakeAllSize(ramLabel);
        setTop(ramLabel);
        ramLabel.setTextAlignment(TextAlignment.LEFT);
        ramLabel.setTranslateX(25d);
        ramLabel.setTranslateY(100d);
        contentPane.getChildren().add(ramLabel);

        // RAM Slider
        SystemInfo systemInfo = new SystemInfo();
        GlobalMemory memory = systemInfo.getHardware().getMemory();

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getStyleClass().add("ram-selector");
        for(int i = 512; i <= Math.ceil(memory.getTotal() / Math.pow(1024, 2)); i+=512) {
            comboBox.getItems().add(i/1024.0+" Go");
        }
        double val = 1024;
        if(saver.get("maxRam") != null){
            try {
                val = Double.parseDouble(saver.get("maxRam"))*1024;
            } catch (NumberFormatException error) {
                saver.set("maxRam", String.valueOf(val));
                saver.save();
            }
            
        }else {
            saver.set("maxRam", String.valueOf(val));
            saver.save();
        }
        if (comboBox.getItems().contains(val/1024.0+" Go")) {
            comboBox.setValue(val / 1024.0 + " Go");
        } else {
            comboBox.setValue("1.0 Go");
        }

        setLeft(comboBox);
        setCanTakeAllSize(comboBox);
        setTop(comboBox);
        comboBox.setTranslateX(35d);
        comboBox.setTranslateY(130d);
        contentPane.getChildren().add(comboBox);

        /*
         * Save Button
         */
        Button saveBtn = new Button("Enregistrer");
        saveBtn.getStyleClass().add("save-btn");
        FontAwesomeIconView iconView = new FontAwesomeIconView(FontAwesomeIcon.SAVE);
        iconView.getStyleClass().add("save-icon");
        saveBtn.setGraphic(iconView);
        setCanTakeAllSize(saveBtn);
        setBottom(saveBtn);
        setCenterH(saveBtn);
        saveBtn.setOnMouseClicked(e -> saver.set("maxRam", comboBox.getValue().replace(" Go", "")));
        contentPane.getChildren().add(saveBtn);
    }
}
