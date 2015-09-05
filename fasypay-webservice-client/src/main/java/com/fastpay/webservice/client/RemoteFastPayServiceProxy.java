package com.fastpay.webservice.client;

/**
 * 
 * @author Vikash Sinha<vikash.nit1983@gmail.com>
 *
 */
public interface RemoteFastPayServiceProxy {

  public String performGetCitiesByCountry(String countyName) throws FastPayServiceException;

  public String performGetWeather(String cityName,String countyName) throws FastPayServiceException;

}
