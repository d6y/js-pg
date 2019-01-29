//
//Take from the excellent: https://node-postgres.com/
//

const { Client } = require('pg')

const client = new Client({
  user     : 'richard',
  host     : 'localhost',
  database : 'richard',
  password : '',
  port     : 5432,
})

client.connect()

client.query('SELECT NOW()', (err, res) => {
  console.log(err, res)
  client.end()
})
