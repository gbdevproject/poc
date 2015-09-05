package com.fastpay.webservice.client;
import java.util.HashMap;
import java.util.Map;

import net.webservicex.GlobalWeatherSoap;

import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.log4j.Logger;

/**
 * 
 * @author Vikash Sinha<vikash.nit1983@gmail.com>
 *
 */
public class RemoteFastPayServiceProxyImpl implements RemoteFastPayServiceProxy{

  // http://www.mysamplecode.com/2013/06/sftp-apache-commons-file-download.html
  private static final Logger _logger = Logger.getLogger(RemoteFastPayServiceProxyImpl.class);
  private static final Map<String, GenericObjectPool> fastPayClientStubPoolMap = new HashMap<String, GenericObjectPool>();
  //private Integer webServiceTimeoutMilli = 120000;
  private Integer stubPoolMaxActiveCount = 50;
  private Integer stubPoolMaxIdleCount = 20;
  private boolean testOnBorrow = true;
  private static final String SERVER_ID="FAST_PAY";
  public RemoteFastPayServiceProxyImpl(){}



  public String performGetCitiesByCountry(String countryName) throws FastPayServiceException {
    _logger.info("performGetCitiesByCountry starts...");
    String result = null;
    try {
      GlobalWeatherSoap stub = getFastPayWebserviceClientStub(SERVER_ID);
      try {
        result = stub.getCitiesByCountry(countryName);
      } finally {
        releaseFastPayWebserviceClientStub(SERVER_ID, stub);
      }
    } catch (Exception e) {
      throw new FastPayServiceException("Error in executing performGetCitiesByCountry(): " + e.getMessage(), e);
    }
    _logger.info("performGetCitiesByCountry ends...");
    return result;
  }

  public String performGetWeather(String cityName,String countryName) throws FastPayServiceException{
    _logger.info("performGetCitiesByCountry starts...");
    String result = null;
    String serverId = SERVER_ID;
    try {
      GlobalWeatherSoap stub = getFastPayWebserviceClientStub(serverId);
      try {
        result = stub.getWeather(cityName,countryName);
      } finally {
        releaseFastPayWebserviceClientStub(serverId, stub);
      }
    } catch (Exception e) {
      throw new FastPayServiceException("Error in executing performGetCitiesByCountry(): " + e.getMessage(), e);
    }
    _logger.info("performGetCitiesByCountry ends...");
    return result;
  }


  private GlobalWeatherSoap getFastPayWebserviceClientStub(String serverId) throws FastPayServiceException {
    try {
      GenericObjectPool genericObjectPool = fastPayClientStubPoolMap.get(serverId);
      if (genericObjectPool == null) {
        synchronized (fastPayClientStubPoolMap) {
          genericObjectPool = fastPayClientStubPoolMap.get(serverId);
          if (genericObjectPool == null) {
            FastPayClientStubPoolFactory factory = new FastPayClientStubPoolFactory();
            genericObjectPool = new GenericObjectPool(factory, stubPoolMaxActiveCount);
            genericObjectPool.setMaxIdle(stubPoolMaxIdleCount);
            genericObjectPool.setTestOnBorrow(testOnBorrow);
            fastPayClientStubPoolMap.put(serverId, genericObjectPool);
          }
        }
      }
      return (GlobalWeatherSoap) genericObjectPool.borrowObject();
    } catch (Throwable th) {
      throw new FastPayServiceException("Error getting web service client for serverId: " + serverId + ", Error: " + th.getMessage(), th);
    }
  }

  private void releaseFastPayWebserviceClientStub(String serverId, GlobalWeatherSoap stub) throws FastPayServiceException {
    try {
      _logger.info("Release stub object ..");
      fastPayClientStubPoolMap.get(serverId).returnObject(stub);
    } catch (Throwable th) {
      throw new FastPayServiceException("Error returning web service client to the pool for serverId: " + serverId + ", Error: " + th.getMessage(), th);
    }
  }

}
