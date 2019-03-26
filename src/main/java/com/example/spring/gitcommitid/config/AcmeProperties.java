package com.example.spring.gitcommitid.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

/**
 * @author xinj.x
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "acme")
public class AcmeProperties {
  /**
   * type
   */
  private String type;
  @NestedConfigurationProperty
  private Security security = new Security();
  /**
   * describe if it is enabled
   */
  private Boolean enabled;
  /**
   * the remote address
   */
  private InetAddress remoteAddress;

  @Data
  public static class Security {
    /**
     * username
     */
    private String username;
    /**
     * password
     */
    private String password;
  }
}
