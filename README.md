## Selenium Java & TestNG Automation Framework

### Overview

This repository contains a robust Test Automation Framework leveraging Selenium WebDriver, Java, and TestNG. It streamlines web application testing with modularity, maintainability, and scalability in mind.

### Features

- Modular test structure powered by TestNG
- Page Object Model (POM) design pattern
- Cross-browser testing capabilities
- Simple configuration and detailed reporting
- Easily extensible for new tests and pages

### Prerequisites

- Java JDK 8 or newer
- Maven
- ChromeDriver or GeckoDriver (for browser automation)
- IDE (e.g., IntelliJ IDEA, Eclipse)

### Getting Started

1. **Clone the repository:**
    ```bash
    git clone https://github.com/your-username/web-automation-playground.git
    ```
2. **Install dependencies:**
    ```bash
    mvn clean install
    ```
3. **Configure browser drivers** in `.env`.
4. **Run tests:**
    ```bash
    mvn test
    ```

### Project Structure

```
src/
  main/
    java/
      pages/         # Page Object classes
      utils/         # Utility classes
  test/
    java/
      tests/         # TestNG test classes
    resources/
      features/
```

### Reporting

Test execution reports are available in the `target/surefire-reports` directory after each run.

### Contributing

Contributions are welcome! Fork the repository and submit a pull request for enhancements or bug fixes.