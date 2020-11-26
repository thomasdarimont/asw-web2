// in Visual Studio Code -> Press F5 -> select nodejs
// open http://localhost:8000 in your browser 

// imports the http-server middleware
const http = require("http");

// the request handler which gets called for every request
const requestHandler = (request, response) => {

    // extract information from http request
    const { rawHeaders, httpVersion, method, socket, url } = request;

    console.log("%s | Got request: method=%s url=%s headers=%s", new Date(), method, url, JSON.stringify(rawHeaders));

    const message = "Hello World from NodeJS! " + new Date().toISOString();

    // write http response
    response.writeHead(200, {"Content-type": "text/html"});
    response.end(`<h2>${message}</h2>`);
};

// Configure HTTP server with our request handler as default handler
const server = http.createServer(requestHandler)

// Listen on Port 8000
server.listen(8000);

console.log("Server running at http://localhost:8000")