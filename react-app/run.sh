
./build.sh

docker rmi reactdemo
docker build -t reactdemo .

docker run --rm -ti -p 3000:3000 reactdemo
