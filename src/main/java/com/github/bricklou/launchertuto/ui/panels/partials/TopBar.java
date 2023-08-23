package com.github.bricklou.launchertuto.ui.panels.partials;

import com.github.bricklou.launchertuto.ui.PanelManager;
import com.github.bricklou.launchertuto.ui.panel.Panel;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class TopBar extends Panel {
    private GridPane topBar;

    @Override
    public String getName() {
        return "TopBar";
    }

    @Override
    public String getStylesheetPath() {
        return null;
    }

    @Override
    public void init(PanelManager panelManager) {
        super.init(panelManager);
        this.topBar = this.layout;
        this.layout.setStyle("-fx-background-color: rgb(35, 40, 40);");
        setCanTakeAllWidth(this.topBar);

        /*
         * TopBar separation
         */
        // TopBar: left side
        ImageView imageView = new ImageView();
        imageView.setImage(new Image("images/icon.png"));
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(25);
        setLeft(imageView);
        this.layout.getChildren().add(imageView);

        // TopBar: center
        Label title = new Label("JavaFx Launcher");
        title.setFont(Font.font("Consolas", FontWeight.BOLD, FontPosture.REGULAR, 18f));
        title.setStyle("-fx-text-fill: white;");
        setCenterH(title);
        this.layout.getChildren().add(title);

        // TopBar: right side
        GridPane topBarButton = new GridPane();
        topBarButton.setMinWidth(100d);
        topBarButton.setMaxWidth(100d);
        setCanTakeAllSize(topBarButton);
        setRight(topBarButton);
        this.layout.getChildren().add(topBarButton);

        /*
         * TopBar buttons configuration
         */
        final MaterialDesignIconView closeBtn = new MaterialDesignIconView(MaterialDesignIcon.WINDOW_CLOSE);
        final MaterialDesignIconView fullscreenBtn = new MaterialDesignIconView(MaterialDesignIcon.WINDOW_MAXIMIZE);
        final MaterialDesignIconView minimizeBtn = new MaterialDesignIconView(MaterialDesignIcon.WINDOW_MINIMIZE);
        setCanTakeAllWidth(closeBtn, fullscreenBtn, minimizeBtn);

        closeBtn.setFill(Color.WHITE);
        closeBtn.setOpacity(.7f);
        closeBtn.setSize("18px");
        closeBtn.setOnMouseEntered(e -> closeBtn.setOpacity(1.f));
        closeBtn.setOnMouseExited(e -> closeBtn.setOpacity(.7f));
        closeBtn.setOnMouseClicked(e -> System.exit(0));
        closeBtn.setTranslateX(70f);

        fullscreenBtn.setFill(Color.WHITE);
        fullscreenBtn.setOpacity(0.70f);
        fullscreenBtn.setSize("14px");
        fullscreenBtn.setOnMouseEntered(e -> fullscreenBtn.setOpacity(1.0f));
        fullscreenBtn.setOnMouseExited(e -> fullscreenBtn.setOpacity(0.7f));
        fullscreenBtn.setOnMouseClicked(e -> this.panelManager.getStage().setMaximized(!this.panelManager.getStage().isMaximized()));
        fullscreenBtn.setTranslateX(50.0d);

        minimizeBtn.setFill(Color.WHITE);
        minimizeBtn.setOpacity(0.70f);
        minimizeBtn.setSize("18px");
        minimizeBtn.setOnMouseEntered(e -> minimizeBtn.setOpacity(1.0f));
        minimizeBtn.setOnMouseExited(e -> minimizeBtn.setOpacity(0.7f));
        minimizeBtn.setOnMouseClicked(e -> this.panelManager.getStage().setIconified(true));
        minimizeBtn.setTranslateX(26.0d);

        topBarButton.getChildren().addAll(closeBtn, fullscreenBtn, minimizeBtn);
    }
}
