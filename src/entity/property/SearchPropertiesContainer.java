package entity.property;

import java.util.HashMap;
import java.util.Map;

/**
 * Container with properties, that we want to find among appliances
 */
public class SearchPropertiesContainer {
    private final String category;
    private final Map<String, Object> searchProperties = new HashMap<String, Object>();

    public SearchPropertiesContainer(final String category) {
        this.category = category;
    }


    public Map<String, Object> getSearchProperties() {
        return searchProperties;
    }

    /**
     * Add another property to container
     * @param searchProperty
     * @param value
     */
    public void addSearchProperty(String searchProperty, Object value) {
        searchProperties.put(searchProperty, value);
    }


    public String getSearchCategory() {
        return category;
    }
}
