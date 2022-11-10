package service;

import service.impl.ApplianceSearchService;

/**
 * Singleton for Factory, that contains concrete implementation of ApplianceSearcher
 */
public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final ApplianceSearcher applianceService = new ApplianceSearchService();

    /**
     * Private constructor for singleton
     */
    private ServiceFactory() {}

    public ApplianceSearcher getApplianceService() {
        return applianceService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
