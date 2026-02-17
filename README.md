<h1 align="center"> HELLO, WORLD! </h1>

<h1 align="center"> Welcome to our DS&A Project for MILESTONE 2! </h1>

----

## 🎓 Team: Codeon
**Students:**

👤 Jonalyn Tumpong (lr.jtumpong@mmdc.mcl.edu.ph)  
👤 Noeme Escarlan (lr.nescarlan@mmdc.mcl.edu.ph)  
👤 Shaira Marie Darantinao (lr.smdarantinao@mmdc.mcl.edu.ph)  

**Institution:** Mapúa Malayan Digital College  
**Course:** MO-IT102 - Data Structures and Algorithms  
**Section:** S2101  

## Description
A minimal Java inventory manager tailored for MotorPH. It keeps inventory sorted by brand (alphabetical/ascending) by default, using `TreeMap<String, List<Item>>`. Supports add, delete, search, and printing inventory in brand order.

## Features
- Always-sorted brands via `TreeMap` (A→Z).
- Add/delete stock entries by brand + engine number.
- Search by brand/engine number; returns model or “not found.”
- Simple console demo in `main` to show workflow.
- Easy to extend (add more item fields, validation, persistence).

## Project Structure
```
InventoryManagement2/
└─ Inventory.java   # main class and demo
```

## Requirements
- Java 11+ (tested with Java 17+)
- No external dependencies

## Quick Start
```bash
javac Inventory.java
java Inventory
```

### Expected sample output
```
Search Honda 142QVT5IUR: CB500
After deletion: Stock not found
Brand: Honda
  Engine: HX9001 | Model: CBR600
Brand: Yamaha
  Engine: P2CTS80XE | Model: R3
```

## Code Overview
- `Inventory` holds `TreeMap<String, List<Item>> stockByBrand`.
- `addStock(brand, engineNumber, model)`: inserts item under brand.
- `deleteStock(brand, engineNumber)`: removes item; drops brand key if empty.
- `searchStock(brand, engineNumber)`: returns model or a not-found message.
- `printAll()`: prints inventory sorted by brand.

## Extending
- Keep per-brand items sorted by `engineNumber` or `model`:
  ```java
  items.sort(Comparator.comparing(Item::getEngineNumber));
  ```
- Add fields to `Item` (e.g., quantity, price).
- Add persistence (JSON/CSV/DB) for saving/loading inventory.

## Acknowledgments
Built to meet MotorPH requirements (sorted-by-brand by default, simple CRUD + search).

---

### <img align ='center' src='https://media2.giphy.com/media/UQDSBzfyiBKvgFcSTw/giphy.gif?cid=ecf05e47p3cd513axbek3f56ti3jzizq8hincw20jauyyfyw&rid=giphy.gif' width ='29' /> Here's some humor for you:
<img src="https://readme-jokes.vercel.app/api" alt="Error fetching resource, Refresh again to view Jokes Card" width = '11000' />

