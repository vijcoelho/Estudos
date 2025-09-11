const userService = require("../service/userService");

async function getAll(req, res) {
    const users = await userService.findAll();
    res.json(users);
}

async function getById(req, res) {
    const user = await userService.findById(req.params.id);
    if (!user) return res.status(404).json({
        message: "User not found."
    });

    res.json(user);
}

async function create(req, res) {
    const user = await userService.create(req.body);
    res.status(201).json(user);
}

async function update(req, res) {
    const user = await userService.update(req.params.id, req.body);
    if (!user) return res.status(404).json({
        message: "User not found to update."
    });

    res.json(user);
}

async function remove(req, res) {
    const ok = await userService.remove(req.params.id);
    if (!ok) return res.status(404).json({
        message: "User not found to delete."
    });

    res.status(204).send();
}

module.exports = { getAll, getById, create, update, remove };