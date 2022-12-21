const express = require("express");
const app = express();
const port = 8000;


const { faker } = require('@faker-js/faker');


const createUSER = () => {
    const newFakeUser = {
        id: faker.datatype.uuid(),
        password: faker.internet.password(),
        phoneNumber: faker.phone.number(),
        lastName: faker.name.lastName(),
        firstName: faker.name.firstName(),
        Email: faker.internet.email(),
    };
    return newFakeUser;
};


const createCompany = () => {
    const newFakeCompany = {
        id: faker.datatype.uuid(),
        name: faker.company.name(),
        street: faker.address.street(),
        country: faker.address.country(),
        city: faker.address.city(),
        state: faker.address.state(),
        zipcode: faker.address.zipCode()
    };
    return newFakeCompany;
};


app.get("/api/users/new", (req, res) => {
    res.send(createUSER());
});
app.get("/api/companies/new", (req, res) => {
    res.send(createCompany());
});
app.get("/api/user/company", (req, res) => {
    res.send({ USER: createCompany(), Company: createUSER() });
});


app.listen(port, () => console.log(`Listening on port: ${port}`));