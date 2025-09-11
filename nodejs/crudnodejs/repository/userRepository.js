let list = [];

async function findAll() {
    return list;
}

async function findById(id) {
    return list.find(u => u.id === id);
}

async function create(user) {
    list.push(user);
    return user;
}

async function update(id, data) {
    const index = list.findIndex(u => u.id === id);
    if (index === -1) return null;

    list[index] = { ...list[index], ...data };
    return list[index];
}

async function remove(id) {
    const index = list.findIndex(u => u.id === id);
    if (index === -1) return null;

    list.splice(index, 1);
    return true;
}

module.exports = { findAll, findById, create, update, remove };