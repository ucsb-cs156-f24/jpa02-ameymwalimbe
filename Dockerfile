FROM bellsoft/liberica-openjdk-alpine:21

WORKDIR /app

ENV NODE_VERSION=20.17.0

# Install dependencies
RUN apk add --no-cache curl bash git gcc g++ make libstdc++ maven

# Install nvm
RUN curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.40.1/install.sh | bash
ENV NVM_DIR=/root/.nvm

# Use 'source' instead of '.' to ensure nvm is loaded properly
RUN bash -c "source $NVM_DIR/nvm.sh && nvm install ${NODE_VERSION}"
RUN bash -c "source $NVM_DIR/nvm.sh && nvm use ${NODE_VERSION}"
RUN bash -c "source $NVM_DIR/nvm.sh && nvm alias default ${NODE_VERSION}"

# Ensure node is correctly installed
RUN node --version
RUN npm --version

COPY src /home/app/src
COPY lombok.config /home/app
COPY pom.xml /home/app

RUN mvn -B -DskipTests -f /home/app/pom.xml clean package

ENTRYPOINT ["sh", "-c", "java -jar /home/app/target/*.jar"]
