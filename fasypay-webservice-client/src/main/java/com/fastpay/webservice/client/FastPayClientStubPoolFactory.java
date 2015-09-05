package com.fastpay.webservice.client;
import java.net.URL;

import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.pool.BasePoolableObjectFactory;
import org.apache.log4j.Logger;

/**
 * 
 * @author Vikash Sinha<vikash.nit1983@gmail.com>
 * Using Connection Pooling
 */
public class FastPayClientStubPoolFactory extends BasePoolableObjectFactory {

  private static final Logger _logger = Logger.getLogger(FastPayClientStubPoolFactory.class);
  // Get the URL from DB by server id.
  private static final String END_POINT_URL="http://www.webservicex.com/globalweather.asmx?WSDL";


  public FastPayClientStubPoolFactory() {
  }

  @Override
  public Object makeObject() throws Exception  {
    GlobalWeather serviceLocator = new GlobalWeather(new URL(END_POINT_URL));
    //String endPointAddressUrl = getEndPointAddressUrl();
    GlobalWeatherSoap stub = (GlobalWeatherSoap) serviceLocator.getGlobalWeatherSoap();
    return stub;
  }

  @Override
  public boolean validateObject(Object obj) {
    try {
      String existingEndPointAddressUrl=getEndPointAddressUrl();
      String newEndPointAddressUrl=getEndPointAddressUrl();
      boolean isValid = StringUtils.equalsIgnoreCase(newEndPointAddressUrl, existingEndPointAddressUrl);
      if (!isValid) {
        _logger.trace("GlobalWeatherSoap is invalid. ExistingEndPointAddressUrl: " + existingEndPointAddressUrl + "NewEndPointAddressUrl: " + newEndPointAddressUrl);
      }
      return isValid;
    } catch (Exception e) {
      _logger.error("Error in validateObject: " + e.getMessage(), e);
      return false;
    }
  }


  private String getEndPointAddressUrl() throws Exception {
    return END_POINT_URL;
  }
}
