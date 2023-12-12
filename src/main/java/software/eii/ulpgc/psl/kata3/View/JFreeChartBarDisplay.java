package software.eii.ulpgc.psl.kata3.View;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.Map;
import java.util.stream.Collectors;

public class JFreeChartBarDisplay extends JPanel implements BarDisplay{
    @Override
    public void show(Map<String, Integer> data) {
        JFreeChart barChart = ChartFactory.createBarChart(
                "Cantidad de pokemon por estadísticas totales en rangos",
                "Rangos",
                "Cantidad",
                datasetWith(data),
                PlotOrientation.VERTICAL,
                false,
                false,
                false
        );
        add(new ChartPanel(barChart));
    }

    private CategoryDataset datasetWith(Map<String, Integer> data) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String range :
                data.keySet().stream().sorted().collect(Collectors.toList())) {
            dataset.addValue(data.get(range), "Pokemon", range);
        }
        return dataset;
    }
}
