package com.fastpay.webservice.client;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * http://www.webservicex.com/globalweather.asmx?WSDL
 * @author Vikash Sinha<vikash.nit1983@gmail.com>
 *
 */
public class GlobalWeatherTest extends TestCase{
  
  private ServiceFacade serviceFacade;
  
  protected void setUp() {
    serviceFacade=new FastPayServiceFacade();
}
  @Test
  public void testGetCitiesByCountry() throws FastPayServiceException {
     System.out.println("#########################Inside testSalutationGetCitiesByCountry()#########################");
     String countryName= "IND";
     String citiesAsString= serviceFacade.performGetCitiesByCountry(countryName);
     System.out.println(citiesAsString);
     assertNotNull(citiesAsString);
     System.out.println("#########################END testSalutationGetCitiesByCountry()#########################");
  }
  
  @Test
  public void testPerformGetWeather() throws FastPayServiceException {
     System.out.println("#########################Inside testPerformGetWeather()#########################");
     String countryName= "India";
     String cityName="Bombay / Santacruz";
     String weatherAsString= serviceFacade.performGetWeather(cityName, countryName);
     System.out.println(weatherAsString);
     assertNotNull(weatherAsString);
     System.out.println("#########################END testPerformGetWeather()#########################");
     
  }
}
