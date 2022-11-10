package service.impl;

import dao.ApplianceDAO;
import dao.DAOFactory;
import entity.Appliance;
import entity.property.SearchPropertiesContainer;
import org.xml.sax.SAXException;
import service.ApplianceSearcher;
import service.validation.PropertyValidationService;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

/**
 * Implementation of Searching Service
 */
public class ApplianceSearchService implements ApplianceSearcher {

    private final DAOFactory daoFactory = DAOFactory.getInstance();
    private final ApplianceDAO applianceDAO = daoFactory.getApplianceDAO();

    /**
     * Appliance searching
     * @param container - container with appliance properties
     * @return list of appliances or null
     */
    @Override
    public List<Appliance> findApplianceByProperties(SearchPropertiesContainer container) {
        if (!PropertyValidationService.propertyValidator(container)) {
            return null;
        }

        List<Appliance> appliances = null;

        try {
            appliances = applianceDAO.findAppliance(container);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        return appliances;
    }

    /**
     * This method allows to find the appliance with the lowest price
     * @param container - container with appliance properties
     * @return the cheapest appliance or null
     */
    @Override
    public Appliance findApplianceWithLowestPrice(SearchPropertiesContainer container) {
        List<Appliance> appliances = findApplianceByProperties(container);

        if (appliances == null) {
            return null;
        }
        if(appliances.isEmpty())
            return null;

        return appliances.stream()
                .min((a, b) -> (int) (a.getPrice() - b.getPrice()))
                .get();
    }
}
