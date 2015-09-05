package com.fastpay.webservice.client;

/**
 * 
 * @author Vikash Sinha<vikash.nit1983@gmail.com>
 *
 */
public class FastPayServiceException extends Exception{
  /**
   * 
   */
  private static final long serialVersionUID = 449839453767494151L;

  /**
   * The Constructor.
   */
  public FastPayServiceException() {
    super("Fast Pay Webservice Client Exception encountered.");
  }

  /**
   * The Constructor.
   *
   * @param message the message
   */
  public FastPayServiceException(String message) {
    super(message);
  }

  /**
   * The Constructor.
   *
   * @param message the message
   * @param cause   the cause
   */
  public FastPayServiceException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * The Constructor.
   *
   * @param cause the cause
   */
  public FastPayServiceException(Throwable cause) {
    super("Fast Pay Webservice Exception Client encountered. Cause: " + cause.getMessage(), cause);
  }

}
