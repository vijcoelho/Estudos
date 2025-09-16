// const { Pool } = require("pg");

// const pool = new Pool({
//     host: "localhost",
//     port: 5432,
//     user: "vitor",
//     password: "1234",
//     database: "crudnodejs",
//     synchronize: true
// })

// module.exports = pool;

require("reflect-metadata");

const { DataSource } = require("typeorm");
const User = require("../../entity/user");

const AppDataSource = new DataSource({
    type: "postgres",
    host: "localhost",
    port: 5432,
    username: "vitor",
    password: "1234",
    database: "crudnodejs",
    synchronize: true,
    logging: false,
    entities: [User],
});

module.exports = AppDataSource;