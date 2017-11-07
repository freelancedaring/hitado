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
        InputStream is = getClass().getClassLoader()
                .getResourceAsStream(extensionUrl);
        if (is == null) {
            logger.info("no extension");
            return super.getUrl();
        } else {
            logger.info("found extension at:" + extensionUrl);
            return extensionUrl;
        }
    }

}
