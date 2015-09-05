# fasypay-webservice-client

1)First POC used Global Weather 

      END_POINT_URL="http://www.webservicex.com/globalweather.asmx?WSDL

  The following operations are supported. 

      a) GetCitiesByCountry :Get all major cities by country name(full / part).
      b) GetWeather :Get weather report for all major cities around the world.
  
  We have written a junit to test the above operations
  
  GlobalWeatherTest: Use this junit test case to test the above operations.
  
      a) testGetCitiesByCountry
      b) testPerformGetWeather
  
  FastPayClientStubPoolFactory.java: Make connection pooling for a web service.
  
  We have used the following design pattern.
  
      a) Proxy Design Pattern: A remote proxy provides a local representative for an object that resides in a different address space. 
      b) Service Façade : A service façade component is used to abstract a part of the service architecture with negative coupling potential.
 
      
