curl http://localhost:8080/suppliers
curl -d "name=Colombian&supID=101&price=7.99&sales=0&total=100"   -X POST http://localhost:8080/addCoffee
curl -d "name=Espresso&supID=101&price=9.99&sales=0&total=100"   -X POST http://localhost:8080/addCoffee

curl http://localhost:8080/coffees/101