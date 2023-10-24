package string_decrypt;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.apache.commons.codec.binary.Base64;
import java.util.Random;

public class HelloWorld {
	
	//static String pub_file = "D:\\TOOLS\\eclipse\\eclipse-workspace\\string_decrypt\\moj-dsa-public.key";
	//static String priv_file = "D:\\TOOLS\\eclipse\\eclipse-workspace\\string_decrypt\\moj-dsa-private.key";
	
	static String pub_file = "moj-dsa-public.key";
	static String priv_file = "moj-dsa-private.key";
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		
		String bbb = new A(new long[]{-2845820869781517439L, -3546789066538901219L, -7114443269420573969L, 8930876601256329032L}).toString();
		System.out.println(bbb);
		
		String var5 = (new A(new long[]{6432659569399295406L, 167891029966756519L})).toString();
		System.out.println(var5);
		String var8 = (new A(new long[]{-2842230209790092614L, 429126620564235789L, 7450802327086035948L})).toString();
		System.out.println(var8);
		
		String var1 = (new A(new long[]{-5713025094061750731L, -4377194328178546331L, 5279885769393189464L, 44325279849448484L, 8618984660096645564L})).toString();
		System.out.println(var1);
		
		C license = new C();
		
		String var4 = license.L();
		System.out.println(var4);
		
//		boolean ddd = Verify_licence(license, GetKey("D:\\TOOLS\\eclipse\\eclipse-workspace\\string_decrypt\\sonarsource-dsa-public.key"));
//		System.out.println(String.valueOf(ddd));
		//generate_key_pair();
		
//		ddd = Verify_licence(license, GetKey(pub_file));
//		System.out.println(String.valueOf(ddd));

		//System.out.println(license.F());
		
		license.setType("PRODUCTION");
		license.setExpiration("2063-02-23");
		license.setCompany("SL ltd");
		license.setMaxLoc(100000000);
		license.setDigest(Sign_license(license, GetKey(priv_file)));
		
		System.out.println(Sign_license(license, GetKey(priv_file)));
		System.out.println(license.F());
	}



	static boolean Verify_licence(C licence, byte[] dsa_pub_key) {
	    try {
	       byte[] lic_digest = Base64.decodeBase64(licence.I().getBytes(StandardCharsets.UTF_8));
	       String var4 = licence.L();
	       //String var5 = (new A(new long[]{6432659569399295406L, 167891029966756519L})).toString();
	       KeyFactory var6 = KeyFactory.getInstance("DSA");
	       PublicKey var7 = var6.generatePublic(new X509EncodedKeySpec(dsa_pub_key));
	       //String var8 = (new A(new long[]{-2842230209790092614L, 429126620564235789L, 7450802327086035948L})).toString();
	       Signature var9 = Signature.getInstance("SHAwithDSA");
	       var9.initVerify(var7);
	       var9.update(var4.getBytes(StandardCharsets.UTF_8));
	       return var9.verify(lic_digest);
	    } catch (Exception var10) {
	       return false;
	    }
	 }
	
	static String Sign_license(C licence, byte[] dsa_priv_key)
	{
		try {
			KeyFactory var6 = KeyFactory.getInstance("DSA");
			PrivateKey var7 = var6.generatePrivate(new PKCS8EncodedKeySpec(dsa_priv_key));
			
			Signature dsa = Signature.getInstance("SHAwithDSA");
			dsa.initSign(var7);
			dsa.update(licence.L().getBytes(StandardCharsets.UTF_8));
			byte[] signature = dsa.sign();
			return Base64.encodeBase64String(signature);
			
		} catch (NoSuchAlgorithmException | InvalidKeySpecException | InvalidKeyException | SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		
	}
	
	
	static void generate_key_pair()
	{
		try {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA", "SUN");
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			keyGen.initialize(1024, random);
			KeyPair pair = keyGen.generateKeyPair();
			PrivateKey priv = pair.getPrivate();
			PublicKey pub = pair.getPublic();
			

			
		    Path path1 = Paths.get(pub_file);
		    Path path2 = Paths.get(priv_file);
		      try {
				Files.write(path1, pub.getEncoded());
				Files.write(path2, priv.getEncoded());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
	   static byte[] GetKey(String file) {
		      //String var1 = "D:\\TOOLS\\eclipse\\eclipse-workspace\\string_decrypt\\sonarsource-dsa-public.key";

		      Path path = Paths.get(file);
		      try {
				return Files.readAllBytes(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	   }
}

class A {
	   private static final String B = new String(new char[]{'U', 'T', 'F', '8'});
	   private final String A;

	   public A(long[] var1) {
	      int var2 = var1.length;
	      byte[] var3 = new byte[8 * (var2 - 1)];
	      long var4 = var1[0];
	      Random var6 = new Random(var4);

	      for(int var7 = 1; var7 < var2; ++var7) {
	         long var8 = var6.nextLong();
	         AA(var1[var7] ^ var8, var3, 8 * (var7 - 1));
	      }

	      String var11;
	      try {
	         var11 = new String(var3, B);
	      } catch (UnsupportedEncodingException var10) {
	         throw new AssertionError(var10);
	      }

	      int var12 = var11.indexOf(0);
	      this.A = var12 != -1 ? var11.substring(0, var12) : var11;
	   }

	   private static void AA(long var0, byte[] var2, int var3) {
	      long var4 = var0;
	      int var6 = Math.min(var2.length, var3 + 8);

	      for(int var7 = var3; var7 < var6; ++var7) {
	         var2[var7] = (byte)((int)var4);
	         var4 >>= 8;
	      }

	   }

	   public String toString() {
	      return this.A;
	   }
	}
