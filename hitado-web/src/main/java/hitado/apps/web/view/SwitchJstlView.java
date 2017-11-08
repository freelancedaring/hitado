package hitado.apps.web.view;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.JstlView;

public class SwitchJstlView extends JstlView {

    Logger logger = LoggerFactory.getLogger(SwitchJstlView.class);

    @Override
    public String getUrl() {
        String extensionUrl = super.getUrl();
        extensionUrl = extensionUrl.replaceAll("WEB-INF", "WEB-INF/extensions");
        InputStream in = getServletContext().getResourceAsStream(extensionUrl);

        if (in != null) {
            logger.info("found extension at:" + extensionUrl);
            return extensionUrl;
        } else {
            logger.info("no extension");
            return super.getUrl();
        }
    }

}
