package com.util;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.errors.IntrusionException;
import org.owasp.esapi.errors.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidationUtil {
	private ValidationUtil() {
		throw new IllegalStateException("ValidationUtil class");
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private final static Integer VALID_ALL_CHAR_UNICODE_COUNT = 100000;

	
	public static String validateAlphanumeric(String alphanumeric) {
		try {
			return ESAPI.validator().getValidInput("Validation", alphanumeric, "Alphanumeric", 1000, true);
		} catch (Exception e) {
			LOGGER.error("Validation Error for Alphanumeric Value =" + alphanumeric, e);
			return "";
		}
	}

	public static String validateNumeric(String numeric) {
		try {
			return ESAPI.validator().getValidInput("Validation", numeric, "Numeric", 1000, true);
		} catch (Exception e) {
			LOGGER.error("Validation Error for Numeric Value =" + numeric, e);
			return "0";
		}
	}

	public static String validateValidAllChars(String validAllChars) {
		try {
			return ESAPI.validator().getValidInput("Validation", validAllChars, "ValidAllChars", 1000, true);
		} catch (Exception e) {
			LOGGER.error("Validation Error for ValidAllChars Value =" + validAllChars, e);
			return "";
		}
	}

	public static String validateValidAllChars2000(String validAllChars2000) {
		try {
			return ESAPI.validator().getValidInput("Validation", validAllChars2000, "ValidAllChars2000", 2000, true);
		} catch (Exception e) {
			LOGGER.error("Validation Error for ValidAllChars2000 Value =" + validAllChars2000, e);
			return "";
		}
	}

	public static String validateValidAllChars4000(String validAllChars4000) {
		try {
			return ESAPI.validator().getValidInput("Validation", validAllChars4000, "ValidAllChars4000", 4000, true);
		} catch (Exception e) {
			LOGGER.error("Validation Error for ValidAllChars4000 Value =" + validAllChars4000, e);
			return "";
		}
	}

	public static String validateValidAllCharsUnicode(String validAllCharsUnicode) {
		try {
			return ESAPI.validator().getValidInput("Validation", validAllCharsUnicode, "ValidAllCharsUnicode", 4000,
					true);
		} catch (Exception e) {
			LOGGER.error("Validation Error for ValidAllCharsUnicode Value =" + validAllCharsUnicode, e);
			return "";
		}
	}

	public static void mapValidation(Map input){
		
			if(input!=null) {
				input.forEach((k,v)->{
			try {
				ESAPI.validator().getValidInput("Validation", v!=null?String.valueOf(v):null, "ValidAllCharsUnicode",VALID_ALL_CHAR_UNICODE_COUNT, true);
			} catch (ValidationException | IntrusionException e) {
				LOGGER.error("Validation Error for ValidAllCharsUnicode Value ="+ e);

			}
				});
		
			}
		}
	
	
	}



