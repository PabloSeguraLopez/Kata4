package software.eii.ulpgc.psl.kata3.View;

import javax.swing.*;
import java.awt.*;

public class Mainframe extends JFrame {
    private JFreeChartBarDisplay barDisplay;

    public Mainframe() throws HeadlessException {
        setTitle("Grafico de barras");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(createBarDisplay());
    }

    private Component createBarDisplay() {
        this.barDisplay = new JFreeChartBarDisplay();
        return barDisplay;
    }
    public BarDisplay barDisplay(){
        return barDisplay;
    }
}
