package com.codemonkeys.portal.monkeyInvitationsSystem;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Gagiu on 4/1/2017.
 */
public class MonkeyHash
{

    public String invitation;
    public void CreateHash(String s)
    {
      MessageDigest messageDigest = null;
      try {
        messageDigest = MessageDigest.getInstance("SHA-256");
      } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
      }
      messageDigest.update(s.getBytes());
      String hashedInvitation = new String(messageDigest.digest());
      if(IsValid(hashedInvitation)) {
        invitation = hashedInvitation;
      }
      else
      {
        CreateHash(s);
      }
    }

    private boolean IsValid(String s)
    {
      return s.length() > 5;
    }

}
