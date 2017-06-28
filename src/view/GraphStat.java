package view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class GraphStat {

	public GraphStat(String[] chartLabels, int[] chartValues){
		{
			DefaultPieDataset dataset = new DefaultPieDataset();
			for (int i = 0; i < chartLabels.length; i++){ // Get array of Labels, and add to Dataset with Values
				dataset.setValue(chartLabels[i], chartValues[i]);
			}

			JFreeChart chart = ChartFactory.createPieChart("Statistiques Tache", dataset, true, // Create a Pie Chart
					true, //
					false //
					);
			PieSectionLabelGenerator labelGen = new StandardPieSectionLabelGenerator("{0} = {2}");
			PiePlot plot = (PiePlot) chart.getPlot();
			plot.setLabelGenerator(labelGen);
			ChartPanel chartP = new ChartPanel(chart);
			ChartFrame frame = new ChartFrame("Tache", chart); // Create frame to show graph
			frame.pack();
			frame.setVisible(true);
		}
	}
}