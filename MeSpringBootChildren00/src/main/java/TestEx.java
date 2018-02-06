import org.springframework.beans.BeanUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.annotation.AnnotationUtils;

import javax.annotation.PostConstruct;
import java.beans.PropertyDescriptor;
import java.util.LinkedHashSet;
import java.util.Set;

public class TestEx {
    @PostConstruct
    public void printTheProperties() {
        // String prefix = AnnotationUtils.findAnnotation(My.class, ConfigurationProperties.class).prefix();
        // System.out.println(getProperties(My.class, prefix));
    }

    /**
     * Inspect an object recursively and return the dot separated property paths.
     * Inspired by org.springframework.boot.bind.PropertiesConfigurationFactory.getNames()
     */
    private Set<String> getProperties(Class target, String prefix) {
        Set<String> names = new LinkedHashSet<String>();
        if (target == null) {
            return names;
        }
        if (prefix == null) {
            prefix = "";
        }
        PropertyDescriptor[] descriptors = BeanUtils.getPropertyDescriptors(target);
        for (PropertyDescriptor descriptor : descriptors) {
            String name = descriptor.getName();
            if (name.equals("class")) {
                continue;
            }
            if (BeanUtils.isSimpleProperty(descriptor.getPropertyType())) {
                names.add(prefix + "." + name);
            } else {
                //recurse my pretty, RECURSE!
                Set<String> recursiveNames = getProperties(descriptor.getPropertyType(), prefix + "." + name);
                names.addAll(recursiveNames);
            }

        }
        return names;
    }
}


