# 💻 Laptop Service Management System

A Java-based Laptop Service Management System developed using Hibernate ORM and MySQL. This project manages customers, their laptops, and laptop service requests through CRUD (Create, Read, Update, Delete) operations.

## 🔗 GitHub Repository

**Project Link:** https://github.com/JeyaSuryaBuilds/LaptopServiceManagement

## 📌 Project Overview

The Laptop Service Management System is designed to organize laptop repair and maintenance activities. It allows users to manage customer information, register laptops, and maintain service request records.

The project demonstrates Java programming, Hibernate ORM integration, MySQL database connectivity, and database operations using the DAO design pattern.

## ✨ Features

- 👤 **Customer Management**
  - Add new customers
  - View all customers
  - Update customer details
  - Delete customer records

- 💻 **Laptop Management**
  - Register laptops
  - View registered laptops
  - Update laptop problem details
  - Delete laptop records

- 🔧 **Service Request Management**
  - Create service requests
  - View service request details
  - Update service status and service cost
  - Delete service requests

- 🗄️ **Database Management**
  - MySQL database integration
  - Hibernate ORM for database operations
  - Entity relationships using foreign keys

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java 21 | Application development |
| Hibernate ORM 6.6.5.Final | Object-relational mapping |
| MySQL 8.0 | Database management |
| Maven | Dependency management |
| Eclipse IDE | Development environment |
| JDBC | Database connectivity |

## 🏗️ Project Architecture

The project follows a layered structure using Entity, DAO, Utility, and Main packages.

```text
LaptopServiceManagement/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── laptopservice/
│       │           ├── dao/
│       │           │   ├── CustomerDAO.java
│       │           │   ├── LaptopDAO.java
│       │           │   └── ServiceRequestDAO.java
│       │           │
│       │           ├── entity/
│       │           │   ├── Customer.java
│       │           │   ├── Laptop.java
│       │           │   └── ServiceRequest.java
│       │           │
│       │           ├── main/
│       │           │   └── Main.java
│       │           │
│       │           └── util/
│       │               └── HibernateUtil.java
│       │
│       └── resources/
│           └── hibernate.cfg.xml
│
├── pom.xml
├── .gitignore
└── README.md
```

## 🗄️ Database Design

**Database Name:** `laptop_service_db`

### 1. Customers

Stores customer information.

| Column | Description |
|---|---|
| id | Customer ID |
| name | Customer name |
| phone | Contact number |
| email | Email address |
| address | Customer address |

### 2. Laptops

Stores laptop details and links each laptop to a customer.

| Column | Description |
|---|---|
| id | Laptop ID |
| brand | Laptop brand |
| model | Laptop model |
| serialNumber | Unique laptop serial number |
| problem | Reported laptop problem |
| customer_id | Reference to the customer |

### 3. Service Requests

Stores service and repair information for registered laptops.

| Column | Description |
|---|---|
| id | Service request ID |
| serviceType | Type of service |
| description | Service description |
| cost | Service cost |
| status | Current service status |
| laptop_id | Reference to the laptop |

### Entity Relationships

- One customer can own multiple laptops.
- Each laptop belongs to a customer.
- One laptop can have multiple service requests.
- Each service request belongs to a laptop.

## ⚙️ Prerequisites

Before running the project, install:

- Java Development Kit (JDK) 21
- Eclipse IDE
- MySQL Server 8.0
- MySQL Workbench
- Apache Maven

## 🚀 Installation and Setup

### Step 1: Clone the Repository

```bash
git clone https://github.com/JeyaSuryaBuilds/LaptopServiceManagement.git
```

### Step 2: Open the Project in Eclipse

1. Open Eclipse IDE.
2. Select **File → Import**.
3. Choose **Maven → Existing Maven Projects**.
4. Select the cloned project folder.
5. Click **Finish**.

### Step 3: Create the Database

Open MySQL Workbench and execute:

```sql
CREATE DATABASE laptop_service_db;
```

### Step 4: Configure Hibernate

Create or configure `hibernate.cfg.xml` with your local MySQL connection details.

Update the following properties:

- Database URL: `jdbc:mysql://localhost:3306/laptop_service_db`
- Database username: Your MySQL username
- Database password: Your MySQL password

**Security Note:** Never commit actual database passwords, API keys, or other credentials to a public repository.

### Step 5: Resolve Maven Dependencies

In Eclipse:

1. Right-click the project.
2. Select **Maven → Update Project**.
3. Click **OK**.

### Step 6: Run the Application

1. Open `Main.java`.
2. Run it as a Java Application.
3. View the operation results in the Eclipse Console.

## 🔄 CRUD Operations

The application supports the following operations:

| Module | Create | Read | Update | Delete |
|---|---|---|---|---|
| Customer | Add customer | View customers | Update phone | Delete customer |
| Laptop | Register laptop | View laptops | Update problem | Delete laptop |
| Service Request | Create request | View requests | Update status and cost | Delete request |

## 🎯 Learning Outcomes

This project demonstrates:

- Java object-oriented programming
- Hibernate ORM configuration and entity mapping
- MySQL database integration
- One-to-many database relationships
- DAO design pattern
- Transaction management
- CRUD operations using Hibernate
- Maven dependency management
- Git and GitHub version control

## 🔮 Future Enhancements

- Add a web-based user interface.
- Implement user authentication and authorization.
- Add service history and repair tracking.
- Generate service invoices and reports.
- Integrate a dashboard for monitoring service requests.

## 👨‍💻 Author

**Jeyasurya**

GitHub: [JeyaSuryaBuilds](https://github.com/JeyaSuryaBuilds)

Project Repository: [Laptop Service Management System](https://github.com/JeyaSuryaBuilds/LaptopServiceManagement)

---

⭐ If you find this project useful, consider starring the repository!
