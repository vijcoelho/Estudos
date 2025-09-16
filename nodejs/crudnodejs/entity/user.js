// class User {
//     id Int,
//     name String,


//     constructor({id, name, email}) {
//         this.id = id;
//         this.name = name;
//         this.email = email;
//     }
// }

// module.exports = User;

const { EntitySchema, Table } = require("typeorm");

module.exports = new EntitySchema({
    name: "User",
    tableName: "user_node",
    columns: {
        id: { 
            primary: true,
            type: "int",
            generated: true 
        },
        name: { type: "varchar" },
        email: { type: "varchar" },
        password: { type: "varchar" },
    },
});