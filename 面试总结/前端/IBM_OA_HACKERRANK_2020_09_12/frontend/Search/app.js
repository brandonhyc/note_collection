// Load HTTP module

const hostname = "127.0.0.1";
const port = 8000;
const path = require('path');
const express = require('express');
const server = express();

// Create HTTP server 
server.use(express.static(path.join(__dirname, 'view')));

// Prints a log once the server starts listening
server.listen(port, hostname, () => {
   console.log(`Server running at http://${hostname}:${port}/`);
})