package lv.initex.race.singleRace.services;

import javax.swing.*;
import java.awt.event.MouseAdapter;

public class AddListener {

    public static void addListener(JTable table) {
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                int row = table.getSelectedRow();
                int col = table.getSelectedColumn();
                if (col > 2 && col < 27) {
                    int checkValue = (int) table.getValueAt(row, col);

                    switch (checkValue) {
                        case 0:
                            table.setValueAt(2, row, col);
                            break;
                        case 2:
                            table.setValueAt(50, row, col);
                            break;
                        case 50:
                            table.setValueAt(0, row, col);
                            break;
                    }
                }
            }
        });
    }
}
