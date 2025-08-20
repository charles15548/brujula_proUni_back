# Imagen base con JDK 21
FROM eclipse-temurin:21-jdk

# Carpeta de trabajo
WORKDIR /app

# Copiamos todo el proyecto
COPY . .

# Damos permisos al wrapper y construimos el JAR
RUN chmod +x mvnw && ./mvnw clean package -DskipTests

# Arrancamos la app
CMD ["java", "-jar", "target/brujula_proUni_back-0.0.1-SNAPSHOT.jar"]
