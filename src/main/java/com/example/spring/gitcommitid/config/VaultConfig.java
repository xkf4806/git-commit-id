package com.example.spring.gitcommitid.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.ClientCertificateAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;

import java.net.URI;

/**
 * @author xinj.x
 */
@Configuration
public class VaultConfig extends AbstractVaultConfiguration {

  @Value("${vault.uri}")
  private URI vaultUri;

  @Override
  public VaultEndpoint vaultEndpoint() {
    return VaultEndpoint.from(vaultUri);
  }

  @Override
  public ClientAuthentication clientAuthentication() {
    return new ClientCertificateAuthentication(restOperations());
  }
}
