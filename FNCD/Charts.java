package FNCD;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.ArrayList;


public class Charts extends ApplicationFrame {

        public Charts( String applicationTitle , String chartTitle, DefaultCategoryDataset dataSet , String xLabel, String yLabel) {
            super(applicationTitle);
            JFreeChart lineChart = ChartFactory.createLineChart(
                    chartTitle,
                    xLabel,yLabel,
                    dataSet,
                    PlotOrientation.VERTICAL,
                    true,true,false);

            ChartPanel chartPanel = new ChartPanel( lineChart );
            chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
            setContentPane( chartPanel );
        }

        public static DefaultCategoryDataset createDataset1(ArrayList<Double> vehiclesSold) {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
            for(int i=0;i<vehiclesSold.size();i++)
            {
                dataset.addValue(vehiclesSold.get(i),"Vehicles Sold", String.valueOf(i));
            }

            return dataset;
        }
        public static DefaultCategoryDataset createDataset2(ArrayList<Double> salaryEarned){
            DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
            for(int i=0;i<salaryEarned.size();i++)
            {
                dataset.addValue(salaryEarned.get(i),"Staff Salary", String.valueOf(i));
            }
            return dataset;
        };
        public static DefaultCategoryDataset createDataSet3(ArrayList<Double> FNCDEarned)
        {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
            for(int i=0;i< FNCDEarned.size();i++)
            {
                dataset.addValue(FNCDEarned.get(i)," FNCD Earned", String.valueOf(i));
            }
            return dataset;
        }



        public static void plot( FNCD fncd) {

            Charts chart1 = new Charts(
                    "Days vs. Vehicles Sold of"+ fncd.getName() ,
                    "Number of Days vs number of vehicles sold of" + fncd.getName(), createDataset1(fncd.getVehicleSold()),"Days","Vehicles Sold");

            chart1.pack( );
            RefineryUtilities.centerFrameOnScreen( chart1 );
            chart1.setVisible( true );


            Charts chart2 = new Charts(
                    "Days vs. Salary earned by"+ fncd.getName() ,
                    "Number of Days vs amount of salaries earned in each day by staff of "+ fncd.getName(), createDataset2(fncd.getStaffEarned()),"Days","Salary Earned by Staff");

            chart2.pack( );
            RefineryUtilities.centerFrameOnScreen( chart2 );
            chart2.setVisible( true );

            Charts chart3 = new Charts(
                    "Days vs. Amount earned by"+ fncd.getName() ,
                    "Number of Days vs amount earned by "+ fncd.getName(), createDataSet3(fncd.getFNCDEarned()),"Days","FNCD Earned");

            chart3.pack( );
            RefineryUtilities.centerFrameOnScreen( chart3 );
            chart3.setVisible( true );

        }
    }

