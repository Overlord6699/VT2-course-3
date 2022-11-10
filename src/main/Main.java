package main;

import entity.Appliance;
import entity.property.PropertiesForSearch;
import entity.property.SearchPropertiesContainer;
import service.ApplianceSearcher;
import service.ServiceFactory;

import java.util.List;

/**
 * @author Ilya
 * @version  1.100
 */



public class Main {
    /**
     * Application start point
     * @param args - command line parameters
     */
    public static void main(String[] args) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ApplianceSearcher service = serviceFactory.getApplianceService();

        //поиск самого дешёвого холодильника
        SearchPropertiesContainer fridgeInfo = new SearchPropertiesContainer(PropertiesForSearch.Fridge.class.getSimpleName());
        Appliance cheapestRefrigerator = service.findApplianceWithLowestPrice(fridgeInfo);
        ApplianceDataPrinter.print(cheapestRefrigerator);
        System.out.println("------------------------");

        //поиск стиральных машин LG со скоростью 3000
        SearchPropertiesContainer productsInfo = new SearchPropertiesContainer(PropertiesForSearch.WashingMachine.class.getSimpleName());
        productsInfo.addSearchProperty(PropertiesForSearch.WashingMachine.FIRM.toString(), "LG");
        productsInfo.addSearchProperty(PropertiesForSearch.WashingMachine.SPEED.toString(), 3000);
        List<Appliance> LGProducts = service.findApplianceByProperties(productsInfo);
        ApplianceDataPrinter.print(LGProducts);
        System.out.println("------------------------");

        //поиск электрического чайника
        SearchPropertiesContainer kettleInfo = new SearchPropertiesContainer(PropertiesForSearch.Kettle.class.getSimpleName());
        kettleInfo.addSearchProperty(PropertiesForSearch.Kettle.TYPE.toString(), "ELECTRICAL"); //здесь духовка, а не пылесос
        List<Appliance> electricalKettles = service.findApplianceByProperties(kettleInfo);
        ApplianceDataPrinter.print(electricalKettles);
        System.out.println("------------------------");

        //поиск всех духовок
        SearchPropertiesContainer ovenInfo = new SearchPropertiesContainer(PropertiesForSearch.Oven.class.getSimpleName());
        List<Appliance> ovens = service.findApplianceByProperties(ovenInfo);
        ApplianceDataPrinter.print(ovens);
        System.out.println("------------------------");
    }
}