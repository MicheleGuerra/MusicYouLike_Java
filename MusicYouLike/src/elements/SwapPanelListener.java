package elements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class SwapPanelListener extends MouseAdapter {
    private JPanel panelToHidden;
    private JPanel panelToShow;

    public SwapPanelListener(JPanel pPanelToHidden, JPanel pPanelToShow) {
        this.panelToHidden = pPanelToHidden;
        this.panelToShow = pPanelToShow;
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        panelToShow.setVisible(true);
        panelToHidden.setVisible(false);
    }
}
