# https://serengetitech.com/tech/how-to-dockerize-your-angular-14-application/
FROM node:latest AS build
WORKDIR /app
COPY . .
RUN npm install && npm run build

FROM nginx
COPY --from="build" /app/dist/frontend/browser /usr/share/nginx/html
COPY nginx.conf /etc/nginx/nginx.conf
EXPOSE 80
EXPOSE 443
