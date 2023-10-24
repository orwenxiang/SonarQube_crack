# SonarQube_crack 10.2.1.78527

This is en example how to NOT use asymmetric encryption and signing.
Easy to analyse and break protection.

Here is different than in previous versions because sonarsource-dsa-public.key is not present in \lib\sonar-application-10.2.1.78527.jar. Oryginal public key is embedded directly in java code as obfuscated Base64 string.

Steps:
1. download SonarQube version 10.2.1.78527 Developer or Entrprise: https://www.sonarsource.com/products/sonarqube/downloads/
2. Install
3. Download Java project "generate_and_sign_license"
4. Open in Eclipse, compile and run to generate license Base64 string
5. Replace E.class in \lib\sonar-application-10.2.1.78527.jar in the location com/sonarsource/C/B/E.class
6. Run SonarQube, provide generated license
7. Done

Important:

If You work on Windows, export runable jar from Eclipse and run it under linux.
This is because EOL encoding. It MUST be Linux EOL: \n (0x0a)

run jar by command: java -jar ./HelloWorld.jar

