package piechart_awt;

import static javafx.application.Application.launch;
import javafx.embed.swing.SwingNode;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PieChart_AWT extends ApplicationFrame {

    public PieChart_AWT(String title) {
        super(title);
        setContentPane(createDemoPanel());
    }

    private static PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("wyomi", new Double(20));
        dataset.setValue("", new Double(20));
        dataset.setValue("MotoG", new Double(40));
        dataset.setValue("Nokia Lumia", new Double(10));
        return dataset;
    }

    private static JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart("Mobile Sales", // chart title
                dataset,
                true,
                true,
                false
        );
        return chart;
    }
    // data
    // include legend

    public static SwingNode createDemoPanel() {
        SwingNode swingNode = new SwingNode ();
       JFreeChart chart = createChart(createDataset());
       JPanel panel = new ChartPanel(chart);
       swingNode.setContent(panel);
       return swingNode;
    }

    public static void main(String[] args) {
       launch(args);
    }
}