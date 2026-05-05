
Futtatáshoz src-ből indulva
---
```cmd
Get-ChildItem -Recurse -Filter *.class | Remove-Item -Force
javac -cp ".;..\lib\sqlite-jdbc-3.7.2.jar" *.java
java -cp ".;..\lib\sqlite-jdbc-3.7.2.jar" Main
```
