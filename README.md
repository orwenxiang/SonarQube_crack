# SonarQube_crack

This is en example how to not use assimetric encryption and signing.

Steps:
1. download SonarQube Developer or Entrprise: https://www.sonarsource.com/products/sonarqube/downloads/
2. Install
3. Download Java project "generate_and_sign_license"
4. Open in Eclipse, compile and run selected functions
5. Generate own DSA keys
6. Change name of Your generated public key to sonarsource-dsa-public.key and Replace it in side jar: \sonarqube-ent-9.9.0.65466\lib\sonar-application-9.9.0.65466.jar
7. Inside "generate_and_sign_license" You have also functions to create roper signed license
8. Run SonarQube, provide generated license
9. Done

Important:

If You work on Windows, export runable jar from Eclipse i run it under linux.
This is because EOL encoding. It MUST be Linux EOL: \n (0x0a)
run jar by command: java -jar ./HelloWorld.jar

