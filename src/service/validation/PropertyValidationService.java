package service.validation;

import entity.*;
import entity.property.*;

import java.util.HashMap;
import java.util.Map;

/**
 * This class validates properties for different appliances
 */

public class PropertyValidationService {
    /**
     * Map contains pairs: name of property - validation method
     */
    private static final Map<String, PropertyValidator> validatorMap = new HashMap<>();

    static {
        validatorMap.put(PropertiesForSearch.Appliance.FIRM.toString(), PropertyValidationService::validateFirm);
        validatorMap.put(PropertiesForSearch.Appliance.PRICE.toString(), PropertyValidationService::validatePrice);

        validatorMap.put(PropertiesForSearch.Oven.CONSUMPTION.toString(), PropertyValidationService::validatePowerConsumption);
        validatorMap.put(PropertiesForSearch.Oven.WEIGHT.toString(), PropertyValidationService::validateWeight);
        validatorMap.put(PropertiesForSearch.Oven.CAPACITY.toString(), PropertyValidationService::validateCapacity);
        validatorMap.put(PropertiesForSearch.Oven.HEIGHT.toString(), PropertyValidationService::validateHeight);
        validatorMap.put(PropertiesForSearch.Oven.WIDTH.toString(), PropertyValidationService::validateWidth);
        validatorMap.put(PropertiesForSearch.Oven.MAX_DEGREE.toString(),PropertyValidationService::simpleIntValidate);
        validatorMap.put(PropertiesForSearch.Oven.NUM_OF_BURNERS.toString(), PropertyValidationService::simpleIntValidate);


        validatorMap.put(PropertiesForSearch.Laptop.OS.toString(), PropertyValidationService::validateOS);
        validatorMap.put(PropertiesForSearch.Laptop.BATTERY.toString(), PropertyValidationService::validateBatteryCapacity);
        validatorMap.put(PropertiesForSearch.Laptop.MEMORY.toString(), PropertyValidationService::validateMemory);
        validatorMap.put(PropertiesForSearch.Laptop.CPU_NAME.toString(), PropertyValidationService::validateCPU);
        validatorMap.put(PropertiesForSearch.Laptop.DISPLAY.toString(), PropertyValidationService::validateDisplay);

        validatorMap.put(PropertiesForSearch.Fridge.CONSUMPTION.toString(), PropertyValidationService::validatePowerConsumption);
        validatorMap.put(PropertiesForSearch.Fridge.WIDTH.toString(), PropertyValidationService::validateWidth);
        validatorMap.put(PropertiesForSearch.Fridge.WEIGHT.toString(), PropertyValidationService::validateWeight);
        validatorMap.put(PropertiesForSearch.Fridge.HEIGHT.toString(), PropertyValidationService::validateHeight);
        validatorMap.put(PropertiesForSearch.Fridge.CAPACITY.toString(), PropertyValidationService::validateCapacity);


        validatorMap.put(PropertiesForSearch.Speakers.CONSUMPTION.toString(), PropertyValidationService::validatePowerConsumption);
        validatorMap.put(PropertiesForSearch.Speakers.POWER.toString(), PropertyValidationService::validateSpeakersPower);
        validatorMap.put(PropertiesForSearch.Speakers.VOLUME.toString(), PropertyValidationService::validateSpeakersVolume);
        validatorMap.put(PropertiesForSearch.Speakers.FREQUENCY.toString(), PropertyValidationService::validateFrequencyRange);

        validatorMap.put(PropertiesForSearch.WashingMachine.POWER.toString(), PropertyValidationService::validatePower);
        validatorMap.put(PropertiesForSearch.WashingMachine.CONSUMPTION.toString(), PropertyValidationService::validateConsumption);
        validatorMap.put(PropertiesForSearch.WashingMachine.WEIGHT.toString(), PropertyValidationService::validateWeight);
        validatorMap.put(PropertiesForSearch.WashingMachine.SPEED.toString(), PropertyValidationService::simpleIntValidate);
        validatorMap.put(PropertiesForSearch.WashingMachine.NUM_OF_MODES.toString(), PropertyValidationService::simpleIntValidate);

        validatorMap.put(PropertiesForSearch.Kettle.CAPACITY.toString(), PropertyValidationService::validateCapacity);
        validatorMap.put(PropertiesForSearch.Kettle.COLOR.toString(), PropertyValidationService::validateColor);
        validatorMap.put(PropertiesForSearch.Kettle.TYPE.toString(), PropertyValidationService::validateType);
    }

    /**
     * This method validates class of our container
     * @param container
     * @return result of category validation (true/false)
     */
    public static boolean propertyValidator(SearchPropertiesContainer container) {
        if (container.getSearchCategory().equals(Oven.class.getSimpleName())) {
            return validateOven(container.getSearchProperties());
        } else if (container.getSearchCategory().equals(Laptop.class.getSimpleName())) {
            return validateLaptop(container.getSearchProperties());
        } else if (container.getSearchCategory().equals(Fridge.class.getSimpleName())) {
            return validateFridge(container.getSearchProperties());
        } else if (container.getSearchCategory().equals(Kettle.class.getSimpleName())) {
            return validateKettle(container.getSearchProperties());
        } else if (container.getSearchCategory().equals(Speakers.class.getSimpleName())) {
            return validateSpeakers(container.getSearchProperties());
        } else if (container.getSearchCategory().equals(WashingMachine.class.getSimpleName())) {
            return validateWashingMachine(container.getSearchProperties());
        } else if (container.getSearchCategory().equals(Appliance.class.getSimpleName())) {
            return validateAppliance(container.getSearchProperties());
        }

        return false;
    }


    /**
     * Appliance validation
     * @param properties
     * @return
     */
    private static boolean validateAppliance(Map<String, Object> properties) {
        for (String key : properties.keySet()) {
            try {
                PropertiesForSearch.Appliance.valueOf(key);
            } catch (IllegalArgumentException | NullPointerException e) {
                return false;
            }
        }
        return validateCriteria(properties);
    }

    /**
     * Oven validation
     * @param criteria
     * @return
     */
    private static boolean validateOven(Map<String, Object> criteria) {
        for (String key : criteria.keySet()) {
            try {
                PropertiesForSearch.Oven.valueOf(key);
            } catch (IllegalArgumentException | NullPointerException e) {
                return false;
            }
        }
        return validateCriteria(criteria);
    }

    /**
     * Laptop validation
     * @param criteria
     * @return
     */
    private static boolean validateLaptop(Map<String, Object> criteria) {
        for (String key : criteria.keySet()) {
            try {
                PropertiesForSearch.Laptop.valueOf(key);
            } catch (IllegalArgumentException | NullPointerException e) {
                return false;
            }
        }
        return validateCriteria(criteria);
    }

    /**
     * Refrigerator validation
     * @param criteria
     * @return
     */
    private static boolean validateFridge(Map<String, Object> criteria) {
        for (String key : criteria.keySet()) {
            try {
                PropertiesForSearch.Fridge.valueOf(key);
            } catch (IllegalArgumentException | NullPointerException e) {
                return false;
            }
        }
        return validateCriteria(criteria);
    }

    /**
     * Speakers validation
     * @param criteria
     * @return
     */
    private static boolean validateSpeakers(Map<String, Object> criteria) {
        for (String key : criteria.keySet()) {
            try {
                PropertiesForSearch.Speakers.valueOf(key);
            } catch (IllegalArgumentException | NullPointerException e) {
                return false;
            }
        }
        return validateCriteria(criteria);
    }

    /**
     * Tablet validation
     * @param criteria
     * @return
     */
    private static boolean validateKettle(Map<String, Object> criteria) {
        for (String key : criteria.keySet()) {
            try {
                PropertiesForSearch.Kettle.valueOf(key);
            } catch (IllegalArgumentException | NullPointerException e) {
                return false;
            }
        }
        return validateCriteria(criteria);
    }

    /**
     * Cleaner validation
     * @param criteria
     * @return
     */
    private static boolean validateWashingMachine(Map<String, Object> criteria) {
        for (String key : criteria.keySet()) {
            try {
                PropertiesForSearch.WashingMachine.valueOf(key);
            } catch (IllegalArgumentException | NullPointerException e) {
                return false;
            }
        }
        return validateCriteria(criteria);
    }

    /**
     * Method validates needed appliance criteria and real criteria for searching
     * @param criteria - all criteria for needed appliance
     * @return result of validation
     */
    private static boolean validateCriteria(Map<String, Object> criteria) {
        for (Map.Entry<String, Object> entry : criteria.entrySet()) {
            if (!validatorMap.get(entry.getKey()).isValid(entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    private static boolean validateFirm(Object value) {
        return simpleStringValidate(value);
    }
    private static boolean validatePrice(Object value) {
        return simpleDoubleValidate(value);
    }

    private static boolean validatePowerConsumption(Object value) {
        return simpleDoubleValidate(value);
    }
    private static boolean validateWeight(Object value) {
        return simpleDoubleValidate(value);
    }
    private static boolean validateCapacity(Object value) {
        return simpleDoubleValidate(value);
    }
    private static boolean validateHeight(Object value) {
        return simpleDoubleValidate(value);
    }
    private static boolean validateWidth(Object value) {
        return simpleDoubleValidate(value);
    }
    private static boolean validateBatteryCapacity(Object value) {
        return simpleDoubleValidate(value);
    }
    private static boolean validateOS(Object value) {
        return simpleStringValidate(value);
    }
    private static boolean validateCPU(Object value) {
        return simpleStringValidate(value);
    }
    private static boolean validateDisplay(Object value) {
        return simpleDoubleValidate(value);
    }
    private static boolean validateSpeakersPower(Object value) {
        return simpleIntValidate(value);
    }
    private static boolean validateFrequencyRange(Object value) {
        return simpleIntValidate(value);
    }
    private static boolean validateSpeakersVolume(Object value) {
        return simpleDoubleValidate(value);
    }
    private static boolean validateMemory(Object value) {
        return simpleIntValidate(value);
    }
    private static boolean validateColor(Object value) {
        return simpleStringValidate(value);
    }
    private static boolean validateType(Object value) {
        return simpleStringValidate(value);
    }
    private static boolean validatePower(Object value) {
        return simpleIntValidate(value);
    }
    private static boolean validateConsumption(Object value) {
        return simpleDoubleValidate(value);
    }

    /**
     * Double validation
     * @param value
     * @return
     */
    private static boolean simpleDoubleValidate(Object value) {
        if (value instanceof Double) {
            return (Double) value > 0.0;
        }
        return false;
    }

    /**
     * String validation
     * @param value
     * @return
     */
    private static boolean simpleStringValidate(Object value) {
        if (value instanceof String) {
            return !((String) value).isEmpty();
        }
        return false;
    }

    /**
     * Int validation
     * @param value
     * @return
     */
    private static boolean simpleIntValidate(Object value) {
        if (value instanceof Integer) {
            return (Integer) value > 0;
        }
        return false;
    }
}
