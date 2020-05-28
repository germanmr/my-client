read -r -p "Warning!!! This will clean all images and containers in your local Docker Desktop, Would you like to continue? [y/N] " response
if [[ "$response" =~ ^([nN])$ ]]
then
  exit;
fi

echo "Clean and launch locally the docker compose"
echo "------------------------------------------------"
echo "Kill all running containers"
docker container kill $(docker ps -q)
echo "------------------------------------------------"
echo "Delete all containers that are not running"
docker container rm $(docker ps -a -q)
echo "------------------------------------------------"
echo "Delete all images"
docker rmi $(docker images -a -q) -f
echo "------------------------------------------------"
echo "Build the Jar"
mvn clean install -Dmaven.test.skip=true
echo "------------------------------------------------"
echo "Copy the docker file"
cp Dockerfile target/Dockerfile
echo "------------------------------------------------"
echo "Build the image"
docker build -t my-client target/
echo "------------------------------------------------"
echo "Starting with docker-compose"
docker-compose up