package com.example.spring.gitcommitid;

import com.example.spring.gitcommitid.vault.Secrets;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;

/**
 * @author xinj.x
 */
public class VaultTest {
  public static void main(String[] args) {
    VaultTemplate vaultTemplate = new VaultTemplate(new VaultEndpoint(), new TokenAuthentication(""));
    Secrets secrets = new Secrets();
    secrets.setUsername("hello");
    secrets.setPassword("world");

    vaultTemplate.write("secret/myapp", secrets);

    VaultResponseSupport<Secrets> response = vaultTemplate.read("secret/myapp", Secrets.class);
    System.out.println(response.getData().getUsername());

    vaultTemplate.delete("secret/myapp");
  }
}
