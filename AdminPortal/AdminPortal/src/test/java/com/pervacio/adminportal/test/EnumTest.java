package com.pervacio.adminportal.test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.junit.Test;

public class EnumTest {

	@Test
	public void test() {


	decrypt("", "", "3FE91C3FE200EE40ADF0BEDB9DE115BFCBC779D0AD3BBBA98CCC61A0B6858DD7");
	}


	public  String GenerateHash(String input) throws NoSuchAlgorithmException {
        MessageDigest objSHA = MessageDigest.getInstance("SHA-256");
        byte[] bytSHA = objSHA.digest(input.getBytes());
        BigInteger intNumber = new BigInteger(1, bytSHA);
        String strHashCode = intNumber.toString(16);

        // pad with 0 if the hexa digits are less then 64.
        while (strHashCode.length() < 64) {
            strHashCode = "0" + strHashCode;
        }
        return strHashCode;
    }


/*	public void encrypt(String src, String dest, String password)
    {
        try
        {
            int buffersize=8*1024;
            File input=new File(src);
            File output=new File(dest);
            FileInputStream fis=new FileInputStream(input);
            FileOutputStream fos=new FileOutputStream(output);
            byte buffer[]=new byte[buffersize];
            KeySpec ks=new PBEKeySpec(password.toCharArray());
            SecretKeyFactory skf=SecretKeyFactory.getInstance(algo);
            SecretKey key=skf.generateSecret(ks);
            MessageDigest md=MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] digest=md.digest();
            byte[] salt=Arrays.copyOf(digest, 16);
            AlgorithmParameterSpec aps=new PBEParameterSpec(salt, 20);
            Cipher cipher=Cipher.getInstance(algo);
            cipher.init(Cipher.ENCRYPT_MODE, key, aps);
            int reader=0;
            while((reader=fis.read(buffer))!=-1)
            {
                byte[] out=cipher.update(buffer, 0, reader);
                fos.write(out, 0, reader);
            }
            fos.write(cipher.doFinal());
            fos.close();
            fis.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }*/

    public void decrypt(String src, String dest, String password)
    {/*
    	String algo="PBEWITHSHA256AND256BITAES-CBC-BC";
        try
        {
        	            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

            int buffersize=8*1024;
                 byte buffer[]=new byte[buffersize];
            KeySpec ks=new PBEKeySpec(password.toCharArray());
            SecretKeyFactory skf=SecretKeyFactory.getInstance(algo);
            SecretKey key=skf.generateSecret(ks);
            MessageDigest md=MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] digest=md.digest();
            byte[] salt=Arrays.copyOf(digest, 16);
            AlgorithmParameterSpec aps=new PBEParameterSpec(salt, 20);
            Cipher cipher=Cipher.getInstance(algo);
            cipher.init(Cipher.DECRYPT_MODE, key, aps);
            int reader=0;
            System.out.println(cipher.doFinal());
            while((reader=fis.read(buffer))!=-1)
            {
                byte[] out=cipher.update(buffer, 0, reader);
                fos.write(out, 0, reader);
            }
            fos.write(cipher.doFinal());
            fos.close();
            fis.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    */}

}
