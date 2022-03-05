
./build.sh

docker rmi reactdemo
docker build -t reactdemo .

docker run --rm -ti -p 3001:3001 reactdemo
