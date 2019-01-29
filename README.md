# Demo of accessing PostgreSQL from JavaScript

# scalajs

TODO


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


