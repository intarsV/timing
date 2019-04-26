package lv.initex.report.teamReport.services.jasperFrame;

import lv.initex.domain.reportDomain.team.TeamRaceStageList;
import lv.initex.mainWindow.MainWindowView;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.util.List;

public class CreateTeamResultFrame {

    public static void previewList(List<TeamRaceStageList> list) {
        try {
            String reportUrl = "/reportTemplates/TeamStageResults.jasper";
            InputStream reportFile=JasperReport.class.getResourceAsStream(reportUrl);
            JRDataSource jrDataSource = new JRBeanCollectionDataSource(list);

            JasperPrint jasperPrint = null;

            jasperPrint = JasperFillManager.fillReport(reportFile, null, jrDataSource);

            JInternalFrame frame = new JInternalFrame("Heat result list");
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
