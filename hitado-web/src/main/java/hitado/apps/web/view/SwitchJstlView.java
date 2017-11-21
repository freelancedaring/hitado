package hitado.apps.web.view;

import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.servlet.view.JstlView;

public class SwitchJstlView extends JstlView {

    private static ConcurrentHashMap<String, String> EXTENSION_URL = new ConcurrentHashMap<>();

    @Override
    public String getUrl() {
        String newUrl = "";
        if (EXTENSION_URL.get(getBeanName()) == null) {
            newUrl = resolveURL(super.getUrl());
            EXTENSION_URL.put(getBeanName(), newUrl);
        } else {
            newUrl = EXTENSION_URL.get(getBeanName());
        }
        return newUrl;
    }

    protected String resolveURL(String oldUrl) {
        String extensionUrl = oldUrl.replaceAll("WEB-INF",
                "WEB-INF/extensions");
        InputStream in = getServletContext().getResourceAsStream(extensionUrl);

        if (in != null) {
            logger.info("found extension at:" + extensionUrl);
            return extensionUrl;
        } else {
            logger.info("no extension");
            return oldUrl;
        }
    }

}
