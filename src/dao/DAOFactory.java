package dao;

import dao.implementation.ApplianceDAOImpl;


/**
 * Singleton for ApplianceDAO
 */
public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final ApplianceDAO applianceDAO = new ApplianceDAOImpl();



    private DAOFactory() {}

    /**
     *
     * @return instance - singleton
     */
    public static DAOFactory getInstance() {
        return instance;
    }

    /**
     *
     * @return applianceDAO
     */
    public ApplianceDAO getApplianceDAO() {
        return applianceDAO;
    }


}
