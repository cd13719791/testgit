package mblog.shiro.tags;

import java.io.IOException;
import java.util.Map;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;

/**
 * <p>
 * Equivalent to {@link org.apache.shiro.web.tags.RoleTag}
 * </p>
 */
public abstract class RoleTag extends SecureTag {
	String getName(Map<Object, Object> params) {
		return getParam(params, "name");
	}

	@Override
	public void render(Environment env, Map<Object, Object> params, TemplateDirectiveBody body) throws IOException, TemplateException {
		boolean show = showBody(getName(params));
		if (show) {
			renderBody(env, body);
		}
	}

	protected abstract boolean showBody(String roleName);
}
