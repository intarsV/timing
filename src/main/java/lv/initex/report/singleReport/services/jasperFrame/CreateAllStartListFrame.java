package lv.initex.report.singleReport.services.jasperFrame;

import lv.initex.domain.SubEvent;
import lv.initex.domain.reportDomain.single.RaceResultList;
import lv.initex.mainWindow.MainWindowView;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class CreateAllStartListFrame {

    public static void previewList(List<RaceResultList> list, SubEvent subEvent, long startTime, long split) {
        try {
            String reportUrl = "/reportTemplates/AllStartList.jasper";
            InputStream reportFile=JasperReport.class.getResourceAsStream(reportUrl);
            JRDataSource jrDataSource = new JRBeanCollectionDataSource(list);
            SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
            format.setTimeZone(TimeZone.getTimeZone("UTC"));

            JasperPrint jasperPrint = null;
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("subEvent",subEvent.getSubEvent());
            parameters.put("startTime", startTime);
            parameters.put("split",split);
            parameters.put("format",format);

            jasperPrint = JasperFillManager.fillReport(reportFile, parameters, jrDataSource);

            JInternalFrame frame = new JInternalFrame("Start list");
            frame.setSize(1500, 700);
            frame.getContentPane().add(new JRViewer(jasperPrint));
            frame.setVisible(true);
            frame.setClosable(true);
            frame.setResizable(true);

            JDesktopPane desktop = MainWindowView.getDesktop();
            Dimension desktopSize = desktop.getSize();
            Dimension jInternalFrameSize = frame.getSize();
            int width = (desktopSize.width - jInternalFrameSize.width) / 2;
            int height = (desktopSize.height - jInternalFrameSize.height) / 2;
            frame.setLocation(width, height);
            desktop.add(frame);

            try {
                frame.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }

        } catch (JRException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
