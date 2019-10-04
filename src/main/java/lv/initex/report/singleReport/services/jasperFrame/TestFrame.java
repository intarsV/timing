package lv.initex.report.singleReport.services.jasperFrame;

import lv.initex.database.LogoRepository;
import lv.initex.domain.Logo;
import lv.initex.domain.LogoImage;
import lv.initex.mainWindow.MainWindowView;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TestFrame {

    private LogoRepository database;

    @Autowired
    public TestFrame(LogoRepository database) {
        this.database = database;
    }

    public void previewList() {
        List<Logo> logoList = database.logoList();

        List<LogoImage> imageList = new ArrayList<>();
        for (Logo l : logoList) {
            Image image=proc(l);
            LogoImage logoImage=new LogoImage();
            logoImage.setLogo(image);
            imageList.add(logoImage);
        }

        try {
            String reportUrl = "/reportTemplates/Test.jasper";

            InputStream reportFile = JasperReport.class.getResourceAsStream(reportUrl);

            JRDataSource jrDataSource = new JRBeanCollectionDataSource(imageList);

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

    private Image proc(Logo logoByte) {
        InputStream logo = new ByteArrayInputStream(logoByte.getImage());
        try {
            return ImageIO.read(logo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
