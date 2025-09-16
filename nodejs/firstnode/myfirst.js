// let name = 'Vitor';
// const age = 21;

// function greet() {
//     return 'Hello ' + 'Vitor';
// }

// const sum = (a, b) => a + b;

// const user = {
//     name: 'Vitor',
//     age: 25,

//     greetObject() {
//         return 'Hi ${this.name}';
//     }
// };

// const array = [1,2,3,4,5,6,7,8,9,10];

// function use() {
//     array.forEach(i =>  console.log(i));
// }

function fetchData(callback) {
    setTimeout(() => {
        callback('Data received');
    }, 5000);
}

// const fetchDataPromise = () => {
//     return new Promise((resolver) => {
//         setTimeout(() => resolver('Promise resolved!'), 5000);
//     });
// };

async function getData() {
    const result = await new Promise((resolver) => {
        setTimeout(() => resolver('Promise resolved!'), 5000);
    });
    console.log(result);
}

let http = require('http');

http.createServer(function (req, res) {
    res.writeHead(200, {'content-type': 'text/html'});

    getData();
    res.end('TEST NODEJS');
}).listen(8080);