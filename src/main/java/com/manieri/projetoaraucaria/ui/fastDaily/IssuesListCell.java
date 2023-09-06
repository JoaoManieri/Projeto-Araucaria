package com.manieri.projetoaraucaria.ui.fastDaily;

import com.manieri.projetoaraucaria.model.Issues;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class IssuesListCell extends ListCell<Issues> {
    @Override
    protected void updateItem(Issues issues, boolean empty) {
        super.updateItem(issues, empty);

        if (empty || issues == null) {
            setText(null);
        } else {
            setText(issues.getSubject());
        }
    }

    public static Callback<ListView<Issues>, ListCell<Issues>> forListView() {
        return param -> new IssuesListCell();
    }
}
