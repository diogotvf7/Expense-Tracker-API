# ========================
# Stage 1: Build Stage
# ========================
FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /app

# 1. Copy the Maven wrapper and settings first (for caching dependencies)
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

# 2. Give execution rights to the wrapper
RUN chmod +x mvnw

# 3. Download dependencies (this layer will be cached if pom.xml doesn't change)
RUN ./mvnw dependency:go-offline

# 4. Copy the actual source code
COPY src ./src

# 5. Build the JAR
# We skip tests here because the DB container isn't available during build time.
RUN ./mvnw clean package -DskipTests

# ========================
# Stage 2: Run Stage
# ========================
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copy ONLY the JAR file from the "builder" stage above
COPY --from=builder /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]