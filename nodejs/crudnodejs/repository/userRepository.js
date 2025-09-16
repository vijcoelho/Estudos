// let list = [];

// async function findAll() {
//     return list;
// }

// async function findById(id) {
//     return list.find(u => u.id === id);
// }

// async function create(user) {
//     list.push(user);
//     return user;
// }

// async function update(id, data) {
//     const index = list.findIndex(u => u.id === id);
//     if (index === -1) return null;

//     list[index] = { ...list[index], ...data };
//     return list[index];
// }

// async function remove(id) {
//     const index = list.findIndex(u => u.id === id);
//     if (index === -1) return null;

//     list.splice(index, 1);
//     return true;
// }

// module.exports = { findAll, findById, create, update, remove };

const AppDataSource = require("../config/db/db");
const User = require("../entity/user");

async function findAll() {
  const repository = AppDataSource.getRepository(User)
  return repository.find();
}

async function findById(id) {
  const repository = AppDataSource.getRepository(User);
  return repository.findOneBy({ id: Number(id) });
}

async function create(user) {
  const repository = AppDataSource.getRepository(User);
  return repository.save(user);
}

async function update(id, data) {
  const repository = AppDataSource.getRepository(User);
  await repository.update({ id: Number(id) }, data);
  return repository.findOneBy({ id: Number(id) });
}

async function remove(id) {
  const repository = AppDataSource.getRepository(User);
  await repository.delete({ id: Number(id) });
  return true;
}

module.exports = { findAll, findById, create, update, remove };