# Web Application Learning

This repository contains my learning project where I developed a web application using HTML, CSS, JavaScript, HTTP, MySQL, and the SSM (Spring, Spring MVC, MyBatis) framework. The project demonstrates a layered architecture with clear separation of concerns, including Controller, Service, and Mapper layers, following the MVC (Model-View-Controller) design pattern. Maven is used for project management and dependency handling.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Architecture](#architecture)
- [Setup](#setup)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Introduction

This learning project is designed to showcase the integration of front-end technologies (HTML, CSS, JavaScript) with back-end technologies (Spring, Spring MVC, MyBatis) and a relational database (MySQL). The project follows a layered architecture and the MVC design pattern to ensure a clean separation of concerns and maintainability. Maven is used to manage dependencies and build the project.

## Features

- **Responsive UI:** Built with HTML, CSS, and JavaScript.
- **RESTful API:** Implemented using Spring MVC.
- **Business Logic Layer:** Encapsulated in the Service layer.
- **Persistence Layer:** Managed by MyBatis (Mapper layer).
- **Database:** MySQL for data storage.
- **HTTP Communication:** Utilizes HTTP for client-server communication.

## Technology Stack

- **Front-end:** HTML, CSS, JavaScript
- **Back-end:** Spring, Spring MVC, MyBatis
- **Database:** MySQL
- **Build Tool:** Maven
- **Architecture:** Layered architecture, MVC design pattern

## Architecture

The project follows a layered architecture, divided into the following components:

- **Controller Layer:** Handles HTTP requests and responses.
- **Service Layer:** Contains business logic and service methods.
- **Mapper Layer:** Interfaces with the database using MyBatis.
- **Model Layer:** Represents the data structure.

## Setup

1. Clone the repository:
    ```sh
    git clone https://github.com/ShawnJeffersonWang/SSM-Learning.git
    cd SSM-Learning
    ```

2. Ensure you have Java, Maven, and MySQL installed on your system.

3. Configure your database settings in `application.properties`.

4. Install the necessary dependencies:
    ```sh
    mvn clean install
    ```

5. Run the application:
    ```sh
    mvn spring-boot:run
    ```

## Usage

Once the application is running, you can access it via your web browser and interact with the various features.

### Example Endpoints

- **Get All Items:** `/api/items`
- **Get Item by ID:** `/api/items/{id}`
- **Create Item:** `/api/items`
- **Update Item:** `/api/items/{id}`
- **Delete Item:** `/api/items/{id}`

## Contributing

Contributions are welcome! Please fork this repository and submit pull requests with your changes.

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Create a new Pull Request.

## License

This project is licensed under the Apache 2.0 License. See the [LICENSE](LICENSE) file for details.
