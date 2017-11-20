// Karma configuration
// Generated on Thu Nov 20 2014 14:51:15 GMT+1100 (AEDT)
var path = require('path')

module.exports = function (config) {
  config.set({

    // base path that will be used to resolve all patterns (eg. files, exclude)
    basePath: '.',

    // frameworks to use
    // available frameworks: https://npmjs.org/browse/keyword/karma-adapter
    frameworks: ['mocha', 'chai', 'pact'],

    // list of files / patterns to load in the browser
    files: [
      // if you are using this example to setup your own project load pact from the node_modules directory
      'node_modules/pact-web/pact-web.js',
      // Example Using NPM package
      // 'node_modules/pact-web/pact-web.js',
      'client.js',
      'client-spec.js'
    ],

    // list of files to exclude
    exclude: [],

    // preprocess matching files before serving them to the browser
    // available preprocessors: https://npmjs.org/browse/keyword/karma-preprocessor
    preprocessors: {},

    // test results reporter to use
    // possible values: 'dots', 'progress'
    // available reporters: https://npmjs.org/browse/keyword/karma-reporter
    reporters: ['progress'],

    // Pact Providers
    pact: [{
      port: 1234,
      consumer: 'KarmaMochaConsumer',
      provider: 'KarmaMochaProvider',
      logLevel: 'DEBUG',
      cors:true,
      log: path.resolve(process.cwd(), 'logs', 'pact.log'),
      dir: path.resolve(process.cwd(), 'pacts'),
      pactUrls: path.resolve(process.cwd(), 'pacts'),
      spec: 2
    }],

    // web server port
    port: 9876,

    plugins: [
      'karma-*',
      '@pact-foundation/karma-pact'
    ],

    // increase mocha timeout to deal with starting mock server(s)
    client: {
      mocha: {
        timeout: 10000
      }
    },

    // enable / disable colors in the output (reporters and logs)
    colors: true,

    // level of logging
    // possible values: config.LOG_DISABLE || config.LOG_ERROR || config.LOG_WARN || config.LOG_INFO || config.LOG_DEBUG
    logLevel: config.LOG_INFO,

    // enable / disable watching file and executing tests whenever any file changes
    autoWatch: true,

    // start these browsers
    // available browser launchers: https://npmjs.org/browse/keyword/karma-launcher
    browsers: ['Chrome_no_sec'],

    customLaunchers: {
      Chrome_no_sec: {
        base: 'Chrome',
        flags: ['--disable-web-security']
      }
    },

    // Continuous Integration mode
    // if true, Karma captures browsers, runs the tests and exits
    singleRun: false
  })
}
