package com.fastpay.webservice.client;

/**
 * 
 * @author Vikash Sinha<vikash.nit1983@gmail.com>
 *
 */
public interface ServiceFacade {

  public String performGetCitiesByCountry(String county) throws FastPayServiceException;

  public String performGetWeather(String cityName,String countryName) throws FastPayServiceException;

}
