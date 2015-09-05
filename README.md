# fasypay-webservice-client
1)First POC used Global Weather 
  END_POINT_URL="http://www.webservicex.com/globalweather.asmx?WSDL

  The following operations are supported. 

      a) GetCitiesByCountry :Get all major cities by country name(full / part).
      b) GetWeather :Get weather report for all major cities around the world.
  
  We have written a junit to test the above operations
    GlobalWeatherTest: Use this junit test case(GlobalWeatherTest.java) to test the above operations.
      1. testGetCitiesByCountry
      2. testPerformGetWeather
  
  FastPayClientStubPoolFactory.java: Make connection pooling for a web service.
