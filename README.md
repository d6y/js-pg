# Demo of accessing PostgreSQL from node

Two examples:

1. Using Scala JS
2. Using plain JS

In both cases we are targeting the node.js runtime, not a web browser,
and using [node-postgres](https://node-postgres.com/).

# scalajs

NB: In this build I'm using [scalajs-bundler](https://scalacenter.github.io/scalajs-bundler/) to download
the [node postgres](https://node-postgres.com/) node library. I don't _think_ this detail is important, and if you wanted you could install `pg` locally and depend on it some other way.

See _main.scala_ for the details of the database to connect to. I'm running `SELECT NOW()` from localhost
connected to a database called "richard". You'll probably want to change that.

To run from sbt:

```
$ cd scala
$ sbt run
...much output...
[info] Fast optimizing /Users/richard/Developer/js-pg/scala/target/scala-2.12/scalajs-bundler/main/js-pg-fastopt.js
[info] Running Main
Connecting...
Running query...
undefined
Result count: 1
Result row 0: MapLike.DefaultValuesIterable(Tue Jan 29 2019 15:00:14 GMT+0000 (Greenwich Mean Time))
```

To build:

```
$ sbt fastOptJS::webpack
```

Then:

```
$ cd target/scala-2.12/scalajs-bundler/main/
$ node js-pg-fastopt-bundle.js
Connecting...
Running query...
undefined
Result count: 1
Result row 0: MapLike.DefaultValuesIterable(Tue Jan 29 2019 15:01:31 GMT+0000 (Greenwich Mean Time))
```

## Audit

As part of `fastOptJS::webpack` you might see `npm` report vulnerabilities. To see them:

```
$ cd target/scala-2.12/scalajs-bundler/main/
$ npm audit
```

# nodejs

As a test that I could connect at all,
the nodejs folder contains a plain JavaScript call to a local database.

Use as:

```
$ cd nodeljs
$ npm install pg
$ node main.js
```

You'll probably have to edit the `main.js` connection details,
but the output should be something like:

```
$ node main.js
null Result {
  command: 'SELECT',
  rowCount: 1,
  oid: null,
  rows: [ { now: 2019-01-29T11:32:14.162Z } ],
  fields:
   [ Field {
       name: 'now',
       tableID: 0,
       columnID: 0,
       dataTypeID: 1184,
       dataTypeSize: 8,
       dataTypeModifier: -1,
       format: 'text' } ],
  _parsers: [ [Function: parseDate] ],
  RowCtor: null,
  rowAsArray: false,
  _getTypeParser: [Function: bound ] }
```

