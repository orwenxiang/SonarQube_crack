package string_decrypt;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import org.apache.commons.codec.binary.Base64;

public class C {
   public static final String N = "Company";
   public static final String F = "Features";
   public static final String A = "Digest";
   public static final String C = "Edition";
   public static final String S = "EditionLabel";
   public static final String M = "Expiration";
   public static final String R = "MaxLoc";
   public static final String H = "Plugins";
   public static final String X = "ServerId";
   public static final String J = "Support";
   public static final String B = "Type";
   public static final String V = "EVALUATION";
   public static final String G = "PRODUCTION";
   public static final String I = "TEST";
   private String Digest;
   private String Edition;
   private String EditionLabel;
   private String Expiration;
   private long MaxLoc;
   private final List<String> Plugins;
   private final String Features;
   private final String ServerId;
   private final boolean Support;
   private String Type;
   private String Company;

   C() {
      this.Digest = "MCwCFAgZBVuZidk9ZxILUaEDFMMmzFg9AhRpbAwKnUQDm4pOqxyCwhc4A/wAOA==";
      this.Edition = "developer";
      this.EditionLabel = "Developer Edition";
      this.Expiration = "2023-02-23";
      this.MaxLoc = 1000000;
      List<String> plug = new ArrayList<String>();
      plug.add("license");
      plug.add("branch");
      plug.add("developer");
      plug.add("abap");
      plug.add("cpp");
      plug.add("plsql");
      plug.add("swift");
      plug.add("tsql");
      plug.add("vbnet");
      
//      plug.add("csharp");
//      plug.add("flex");
//      plug.add("go");
//      plug.add("iac");
//      plug.add("kotlin");
//      plug.add("php");
//      plug.add("python");
//      plug.add("ruby");
//      plug.add("sonarscala");
//      plug.add("web");
//      plug.add("xml");
//      plug.add("text");
//      plug.add("security");
//      plug.add("jacoco");
//      plug.add("java");
//      plug.add("javascript");
      
      this.Plugins = Collections.unmodifiableList(plug);
      this.Features = "Analysis of Java,Analysis of JavaScript,Analysis of C#,Analysis of TypeScript,Analysis of Flex,Analysis of Python,Analysis of PHP,Analysis of XML,Analysis of Web,Branch Analysis,SonarLint Smart Notifications,Analysis of ABAP,Analysis of C/C++,Analysis of Objective-C,Analysis of PL/SQL,Analysis of Swift,Analysis of T-SQL,Analysis of VB.NET";
      this.ServerId = "*";
      this.Support = false;
      this.Type = "EVALUATION";
      this.Company = "Repower Poland";
   }


public enum ReleaseEdition {
   COMMUNITY,
   DEVELOPER,
   ENTERPRISE,
   DATACENTER;
}


	public void setEdition(String arg)
	{
		   this.Edition = arg;
	}
	   
	public void setEditionLabel(String arg)
	{
		this.EditionLabel = arg;
	}
	   

   public void setType(String arg)
   {
	   this.Type = arg;
   }
   
   public void setDigest(String arg)
   {
	   this.Digest = arg;
   }
   
   public void setExpiration(String arg)
   {
	   this.Expiration = arg;
   }
   
   public void setMaxLoc(long arg)
   {
	   this.MaxLoc = arg;
   }
   
   public void setCompany(String arg)
   {
	   this.Company = arg;
   }
   
   public LocalDate K() {
      try {
         return LocalDate.parse(this.Expiration);
      } catch (DateTimeParseException var2) {
         return LocalDate.MIN;
      }
   }

   public String F() {
      Properties var1 = new Properties();
      var1.setProperty("Company", this.Company);
      var1.setProperty("Digest", this.Digest);
      var1.setProperty("Edition", this.Edition);
      var1.setProperty("EditionLabel", this.EditionLabel);
      var1.setProperty("Expiration", this.Expiration);
      var1.setProperty("MaxLoc", String.valueOf(this.MaxLoc));
      var1.setProperty("Plugins", (String)this.Plugins.stream().collect(Collectors.joining(",")));
      var1.setProperty("Features", this.Features);
      var1.setProperty("ServerId", this.ServerId);
      var1.setProperty("Support", String.valueOf(this.Support));
      var1.setProperty("Type", this.Type);
      StringWriter var2 = new StringWriter();
      try {
		var1.store(var2, "");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      return Base64.encodeBase64String(var2.toString().getBytes(StandardCharsets.UTF_8));
   }
   
   

   public String L() {
      ArrayList<String> var1 = new ArrayList<String>();
      var1.add(this.Expiration);
      var1.add(this.Edition);
      var1.add(this.EditionLabel);
      var1.add(String.valueOf(this.MaxLoc));
      var1.addAll(this.Plugins);
      var1.add(this.Features);
      var1.add(this.ServerId);
      var1.add(String.valueOf(this.Support));
      var1.add(this.Type);
      var1.add(this.Company);
      return (String)var1.stream().collect(Collectors.joining("|"));
   }

   public String I() {
      return this.Digest;
   }
}
