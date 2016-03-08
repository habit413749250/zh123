package jugame.jiaoyi_ff.bean;

import java.io.IOException;
import java.io.Writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.core.Environment;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

 /**
  * freemarker异常处理
  * 
  * @author caixb
  *
  */
public class FreemarkerExceptionHandler implements TemplateExceptionHandler {

	Logger logger = LoggerFactory.getLogger(FreemarkerExceptionHandler.class);
	public void handleTemplateException(TemplateException te, Environment env,Writer out) throws TemplateException {
		logger.error("", te);
		try {
			out.write("<script language=\"javascript\" type=\"text/javascript\">window.location.href=\"/public/freemarker500.html\"; </script>");
		} catch (IOException e) {
			logger.error("", e);
		}
	}
}