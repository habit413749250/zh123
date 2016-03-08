package jugame.jiaoyi_ff.bean;
import java.net.URL;

import cn.jugame.util.Config;
import freemarker.cache.URLTemplateLoader;



/**
 * 远程模板加载
 * 
 */
public class ExURLTemplateLoader extends URLTemplateLoader {

    private final String remotePrefix = Config.getValue("remote.resource");
    @Override
    protected URL getURL(String name) {
        URL url = null;
        if (name.indexOf("remote:") >= 0) {
            String urlString = name.replaceFirst("^.*/remote:", remotePrefix);
            try {
                url = new URL(urlString);
            } catch (Exception e) {

            }
        }
        return url;
    }
}