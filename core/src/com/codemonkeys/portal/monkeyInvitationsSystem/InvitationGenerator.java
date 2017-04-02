package com.codemonkeys.portal.monkeyInvitationsSystem;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by Gagiu on 4/1/2017.
 */
public class InvitationGenerator
{
    private MonkeyHash hash = new MonkeyHash();

    public void setHash()
    {
      hash.CreateHash(nextSessionId());
      System.out.println(hash.invitation);
      System.out.println("");
    }

  private SecureRandom random = new SecureRandom();

  public String nextSessionId() {
    return new BigInteger(10, random).toString(32);
  }
}
