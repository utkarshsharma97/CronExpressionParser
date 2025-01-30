# Cron Expression Parser

A command-line application that parses a cron string and expands each field to show the times at which it will run. The application provides a clear, formatted output showing the schedule represented by the cron expression.

## Features

- Parses standard cron expressions with 5 time fields and a command
- Supports all standard cron special characters (*, /, -, ,)
- Validates input for each field
- Provides clear, formatted output
- Built using SOLID principles and design patterns

## Quick Start

### Prerequisites
- Java 11 or higher installed on your system
- Check your Java version using:
 `java --version`
### Installation & Running
- Download the latest JAR file from the [CronExpressionParser Releases](https://github.com/utkarshsharma97/CronExpressionParser/releases/tag/v1.0.0) page

- Run the application using: `$ java -jar CronExpressionParser.jar "0 0 1,2,3,15 * 1-5 /usr/bin/find"`
- Expected Output:
  ```
  minute        0
  hour          0
  day of month  1 2 3 15
  month         1 2 3 4 5 6 7 8 9 10 11 12
  day of week   1 2 3 4 5
  command       /usr/bin/find
  ```

## Why Java?
Java was chosen for this project for several reasons:

**Platform Independence:** Java's "Write Once, Run Anywhere" capability ensures the application runs consistently across different platforms.

**Strong OOP Support:** Java's robust object-oriented features allowed us to implement clean, maintainable code using:

- **Abstract classes and interfaces**
- **Design patterns (Factory, Strategy)**
- **SOLID principles**
  
**Type Safety:** Java's strong type system helps catch errors at compile-time rather than runtime.

**Rich Testing Framework:** JUnit integration makes it easy to implement comprehensive unit tests.

**Performance:** Java's JIT compiler provides excellent performance for command-line applications.

**Enterprise Standard:** Java is widely used in enterprise environments where cron expressions are commonly used.
