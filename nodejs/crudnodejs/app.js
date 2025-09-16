require("reflect-metadata");
const express = require("express");
const AppDataSource = require("./config/db/db");
const userRoutes = require("./routes/userRoutes");

const app = express();
app.use(express.json());

AppDataSource.initialize()
  .then(() => {
    console.log("Data Source initialized!");

    app.use("/api/user", userRoutes);

    app.get("/conn", async (req, res) => {
      const result = await AppDataSource.query("SELECT NOW()");
      res.json({ server: "ok", db_time: result[0].now });
    });

    const PORT = 3000;
    app.listen(PORT, () => console.log(`Server running on port ${PORT}`));
  })
  .catch((err) => {
    console.error("Error during Data Source initialization", err);
});
