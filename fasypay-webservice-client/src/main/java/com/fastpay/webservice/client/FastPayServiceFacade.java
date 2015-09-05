package com.fastpay.webservice.client;

/**
 * 
 * @author Vikash Sinha<vikash.nit1983@gmail.com>
 *
 */
public class FastPayServiceFacade implements ServiceFacade {

  public String performGetCitiesByCountry(String county)
  throws FastPayServiceException {
    RemoteFastPayServiceProxy remote=new RemoteFastPayServiceProxyImpl();
    return  remote.performGetCitiesByCountry("India");
  }

  public String performGetWeather(String cityName, String countyName)
  throws FastPayServiceException {
    RemoteFastPayServiceProxy remote=new RemoteFastPayServiceProxyImpl();
    return remote.performGetWeather(cityName,countyName);
  }

}
