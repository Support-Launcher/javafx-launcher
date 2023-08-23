package com.github.bricklou.launchertuto.ui.panel;

import com.github.bricklou.launchertuto.ui.PanelManager;
import javafx.scene.layout.GridPane;

public interface IPanel {
    void init(PanelManager panelManager);
    GridPane getLayout();
    void onShow();
    String getName();
    String getStylesheetPath();
}
