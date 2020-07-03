## Thought Process: 
In an inventory management system, must have features are: 
- A way to keep a track of items stored
- Minimum quantity of items to maintain
- Keep a track of self-manufactured and bought items
- Keep a track of incoming and outgoing transactions
- Price per unit for each item
Nice to have features are:
- A track of all suppliers and customers
- A track of shipments coming in and going out
- Quantity sold and/or bought for each consumer and supplier
- The price of the transaction

## Implemented (Transaction):
- Get by id -> localhost:8080/transaction/list
- Get all -> localhost:8080/transaction/{id}
- (Post) Add one object -> localhost:8080/transaction/add
- Delete by id -> localhost:8080/transaction/delete/{id}
- Delete all -> localhost:8080/transaction/delete/all

## Body of post:
````
{
	"productId": 23,
	"orderId": 28,
	"productQuantity": 5,
	"pricePerUnit": 10.0,
	"bought": true,
	"received": true,
	"counterPartyId": 1
}
````

## Implemented (Inventory):
- Get by id -> localhost:8080/inventory/list
- Get all -> localhost:8080/inventory/{id}
- (Post) Add one object -> localhost:8080/inventory/add
- Delete by id -> localhost:8080/inventory/delete/{id}
- Delete all -> localhost:8080/inventory/delete/all

## Body of post:
````
{
	"productId": 23,
	"productname": "MNO",
	"quantityStored": 18,
	"minQuantityToMaintain": 16,
	"manufactured": false
}
````

## TODO:
- Apply the "Nice to have features"
- Update one table based on the data of another
- Implement testing automation

## CQL tables:
- create table Customer(productId int, customerId int, customerName text, customerAddress text, pricePerUnit double, PRIMARY KEY (customerId, productId, customerName, pricePerUnit ) );

- create table Inventory(productId int, productname text, quantityStored int, minQuantityToMaintain int, manufactured Boolean, PRIMARY KEY (productId, productname, minQuantityToMaintain ) );

- create table Shipment(shipmentId int, incoming Boolean, itemQuantity int, counterPartyId int, productId int, PRIMARY KEY (shipmentId, counterPartyId, incoming ) );

- create table Supplier(productId int, supplierId int, supplierName text, supplierAddress text, pricePerUnit double, PRIMARY KEY (productId, supplierId ) );

- create table Transaction(productId int, orderId int, productQuantity int, pricePerUnit double, bought boolean, received boolean, counterPartyId int, PRIMARY KEY (productId, orderId, bought, received ) );

## CQL data (as per java constructors):
- CUSTOMERS:
````
customers.add(new Customer(12,	1, "CustomerA", "A,B,C", 10));
customers.add(new Customer(12,	2, "CustomerB", "X,B,C", 20));
customers.add(new Customer(13,	3, "CustomerC", "A,F,G", 22));
customers.add(new Customer(15,	4, "CustomerD", "Q,X,C", 56));
customers.add(new Customer(18,	5, "CustomerE", "Q,F,R", 98));
customers.add(new Customer(13,	6, "CustomerF", "Z,S,Q", 22));
customers.add(new Customer(18,	7, "CustomerG", "A,G,H", 98));
````

- SHIPMENT:
````
shipments.add(new Shipment(56, false, 10, 1, 12));
shipments.add(new Shipment(55, false, 13, 6, 13));
shipments.add(new Shipment(23, false, 18, 5, 18));
shipments.add(new Shipment(28, true, 5, 1, 23));
shipments.add(new Shipment(11, true, 6, 2, 10));
shipments.add(new Shipment(30, true, 89, 3, 11));
shipments.add(new Shipment(99, true, 22, 4, 20));
````

SUPPLIER:
````
suppliers.add(new Supplier(23, 1, "SupplierA", "P,Q,R", 10));
suppliers.add(new Supplier(10, 2, "SupplierB", "L,K,J", 20));
suppliers.add(new Supplier(11, 3, "SupplierC", "R,Y", 22));
suppliers.add(new Supplier(20, 4, "SupplierD", "F,Y,W", 56));
suppliers.add(new Supplier(23, 5, "SupplierE", "P,R,T", 98));
suppliers.add(new Supplier(23, 6, "SupplierF", "Z,K,L", 22));
suppliers.add(new Supplier(10, 7, "SupplierG", "I,N,G", 29));
suppliers.add(new Supplier(11, 8, "SupplierH", "U,I,O", 98));
suppliers.add(new Supplier(11, 9, "SupplierI", "Q,J,U", 11));
````

- INVENTORY:
````
inventories.add(new Inventory(12, "ABC", 90, 2, true));
inventories.add(new Inventory(13, "DEF", 23, 6, true));
inventories.add(new Inventory(15, "GHI", 11, 8, true));
inventories.add(new Inventory(18, "JKL", 11, 8, true));
inventories.add(new Inventory(23, "MNO", 18, 16, false));
inventories.add(new Inventory(10, "PQR", 22, 16, false));
inventories.add(new Inventory(11, "STU", 100, 20, false));
inventories.add(new Inventory(20, "VWX", 11, 11, false));
inventories.add(new Inventory(21, "YZ", 55, 10, true));
````

- TRANSACTION:
````
transactions.add(new Transaction(13, 55, 13, 22, false, true, 6));
transactions.add(new Transaction(12, 56, 10, 10, false, true, 1));
transactions.add(new Transaction(18, 23, 18, 98, false, true, 5));
transactions.add(new Transaction(23, 28, 5, 10, true, true, 1));
transactions.add(new Transaction(11, 30, 89, 22, true, true, 3));
transactions.add(new Transaction(20, 99, 22, 56, true, true, 4));
````