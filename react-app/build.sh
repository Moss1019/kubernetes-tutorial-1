
rm -r ./server/public

npm run build

mv ./build/ ./server/public/
