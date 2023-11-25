# Karizma Recettes Backend

## Description

This is the backend component of the Karizma Recettes application. It provides functionality for managing recipes, including CRUD operations, authentication, data validation, and error handling.

## Getting Started

### Prerequisites

- Java (https://www.oracle.com/java/technologies/javase-downloads.html)
- Maven (https://maven.apache.org/)

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/edwinref/karizmaRecettesBackend.git
    ```

2. Navigate to the project directory:

    ```bash
    cd karizmaRecettesBackend
    ```

3. Build the project using Maven:

    ```bash
    mvn clean install
    ```

4. Run the application:

    ```bash
    java -jar target/karizma-recettes-backend.jar
    ```

The backend will be accessible at `http://localhost:8080`.

## Features

- **Recipe Management:** Allows users to create, read, update, and delete recipes.
- **Data Model:** Each recipe has a unique identifier, a name, a list of ingredients, preparation steps, preparation duration, and an optional photo.
- **Authentication:** Implements basic authentication, allowing users to access and manage their own recipes.
- **Data Validation:** Ensures all inputs are validated before processing (e.g., no empty recipe names).
- **Error Handling:** Provides clear and informative responses in case of errors (e.g., recipe not found, validation rule violation).

## Contributing

If you would like to contribute, please follow the [Contributor Covenant](CONTRIBUTING.md).

## License

This project is licensed under the [MIT License](LICENSE).

## Acknowledgements

Mention any third-party libraries, tutorials, or resources used or inspired by in this section.
