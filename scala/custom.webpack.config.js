var webpack = require('webpack');

// Default to the config Scala.js generates:
module.exports = require('./scalajs.webpack.config');

// Override...
//
// This is required because we're targeting node for pg's need for require("net")
module.exports.target = 'node';
