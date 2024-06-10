# Define la imagen base de Java
FROM openjdk:latest

# Establecer el directorio de trabajo
WORKDIR /app

# Copia los archivos Java al contenedor
COPY . /app

# Compila los archivos Java
RUN javac ConversorRemoto.java ConversorRemotoImpl.java ServidorRMI.java

# Expone el puerto utilizado por RMI (1099)
EXPOSE 1099

# Inicia el servidor RMI al ejecutar el contenedor
CMD ["java", "ServidorRMI"]
