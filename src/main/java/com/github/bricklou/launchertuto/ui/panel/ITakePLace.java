package com.github.bricklou.launchertuto.ui.panel;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public interface ITakePLace {
    default void setCanTakeAllSize(Node node) {
        GridPane.setHgrow(node, Priority.ALWAYS);
        GridPane.setVgrow(node, Priority.ALWAYS);
    }

    default void setCanTakeAllWidth(Node... nodes) {
        for (Node n : nodes) {
            GridPane.setVgrow(n, Priority.ALWAYS);
        }
    }
}
