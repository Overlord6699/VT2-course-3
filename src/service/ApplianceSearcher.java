package service;

import entity.Appliance;
import entity.property.SearchPropertiesContainer;

import java.util.List;

/**
 * Interface of Searching Service
 */
public interface ApplianceSearcher {
    List<Appliance> findApplianceByProperties(SearchPropertiesContainer container);

    Appliance findApplianceWithLowestPrice(SearchPropertiesContainer container);
}
