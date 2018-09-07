FROM openjdk:9

RUN apt-get update && apt-get install -y maven npm gulp
COPY *.js *.json *.xml trafficsimulation/
COPY src trafficsimulation/src
WORKDIR trafficsimulation
RUN mvn -DskipTests package && cp target/trafficsimulation-0.0.1-SNAPSHOT.jar . && mvn clean
RUN rm -rf /root/.m2
RUN apt-get remove -y maven npm gulp && apt-get autoremove -y && apt-get clean && rm -rf *.js *.json *.xml src target
COPY src/main/resources/org/lightjason/trafficsimulation/common/*.asl /root/.lightjason/trafficsimulation/
RUN echo -e "main:\n    simulationspeed: 1500\n    messagedelay:\n      default: 3500\n      agentprint: 3000\n\n\n# agent definition (asl is relative to search path)\nagent:\n    environment:\n      visible: true\n    area:\n      visible: true\n    defaultvehicle:\n      visible: true\n    uservehicle_baseline:\n      visible: true\n    uservehicle_example:\n      visible: true\n\n\n# HTTP server binding for UI\nui:\n    openbrowser: true\n    port: 8080\n    host: 0.0.0.0\n    cookieexpire_in_seconds: 20\n    music: false\n\n# simulation units\nunits:\n    cellsize_in_meter: 3.5\n    time_in_minutes: 0.05" > /root/.lightjason/trafficsimulation/configuration.yaml

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "trafficsimulation-0.0.1-SNAPSHOT.jar"]
