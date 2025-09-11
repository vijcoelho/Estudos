const express = require("express");
const userRoutes = require("./routes/userRoutes")

const app = express();
app.use(express.json());

app.use("/api/user", userRoutes);

const PORT = 3000;
app.listen(PORT, () => console.log(`Server is running on port ${PORT}`));