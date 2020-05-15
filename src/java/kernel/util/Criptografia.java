package kernel.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Date;
import java.text.SimpleDateFormat;


public class Criptografia {
    
    public String criptografaSenhaSAM(char[] paramArrayOfChar){
        try{
            
            byte[] arrayOfByte = new String(paramArrayOfChar).getBytes();
            MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
            localMessageDigest.update(arrayOfByte);
            return new BigInteger(1, localMessageDigest.digest()).toString(16);
            
        }catch (Exception e) {
            System.out.println("Erro ao criptografar " + e);
            e.printStackTrace();
        }
        return "";
    }
      
      
    public static String criptografaToken(String paramString){

        String str1 = null;
        String str2 = null;
        String key = new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date(System.currentTimeMillis()));

        if (paramString != null){
            str1 = "";
            str2 = "";

            for (int i = 0; i < paramString.length(); i++){
                int j = paramString.charAt(i);
                char c = (char)(j + 10);
                str1 = str1 + Character.toString(c);
            }

            for (int k = 0; k < key.length(); k++){
                int l = key.charAt(k);
                char m = (char)(l + 10);
                str2 = str2 + Character.toString(m);
            }
        }
        return str1 + str2;
    }

                
    public static String descriptografaToken(String paramString){

        String str = null;

        if (paramString != null){              
            str = "";

            for (int i = 0; i < paramString.length(); i++){
                int j = paramString.charAt(i);
                char c = (char)(j - 10);
                str = str + Character.toString(c);
            }
        }
        return str;
    }
}

