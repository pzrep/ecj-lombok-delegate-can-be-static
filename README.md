Grab ECJs and Lombok

```
wget --continue https://repo.maven.apache.org/maven2/org/eclipse/jdt/ecj/3.46.100/ecj-3.46.100.jar
wget --continue https://repo.maven.apache.org/maven2/org/projectlombok/lombok/1.18.48/lombok-1.18.48.jar
wget --continue https://download.eclipse.org/eclipse/downloads/drops4/I20261002-2300/ecj-I20261002-2300.jar
```

```
ECJVERSION=${1:-3.46.100} # I20261002-2300
```

Compile original code

```
rm -rf bin && mkdir -p bin

java \
  -javaagent:lombok-1.18.48.jar=ECJ \
  -jar ecj-${ECJVERSION}.jar \
  -cp lombok-1.18.48.jar \
  --release 21 \
  -properties ecj.prefs \
  -d bin src/eji/*

java -cp bin eji.Client
```

Make the method `static`

```
sed -i 's/public int/public static int/' src/eji/MyImplementation.java
```

and compile again

```
rm -rf bin && mkdir -p bin

java \
  -javaagent:lombok-1.18.48.jar=ECJ \
  -jar ecj-${ECJVERSION}.jar \
  -cp lombok-1.18.48.jar \
  --release 21 \
  -properties ecj.prefs \
  -d bin src/eji/*
```
