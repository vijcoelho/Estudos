const userRepository = require("../repository/userRepository");
const { v4: uuidv4 } = require("uuid");
const User = require("../entity/user");

async function findAll() {
    return userRepository.findAll();
}

async function findById(id) {
    return userRepository.findById(id);
}

async function create(data) {
    const user = {
        name: data.name,
        email: data.email,
        password: data.password
    };

    return userRepository.create(user);
}

async function update(id, data) {
    return userRepository.update(id, data);
}

async function remove(id) {
    return userRepository.remove(id);
}

module.exports = { findAll, findById, create, update, remove };