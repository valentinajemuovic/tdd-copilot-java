# TDD with AI (Java)

[![Java CI with Gradle](https://github.com/valentinacupac/tdd-ai-java/actions/workflows/gradle.yml/badge.svg)](https://github.com/valentinacupac/tdd-ai-java/actions/workflows/gradle.yml)

# Case Study

I want to build an eshop system. Could you guide me in development of this system using TDD and Hexagonal Architecture.

Let's start with this User Story:  

As a Customer, I want to make an online order for pizza, so that I don't have to go to the physical store. 

Acceptance Criteria:

```
GIVEN System has unit prices for different pizza types
AND Customer has selected a pizza type and quantity
WHEN Customer places an order for that pizza
THEN System should show the newly generated order number
AND System should show the order price (calculated as unit price multiplied by quantity)
AND System should save the newly created order
```

```
GIVEN Customer has selected non-positive quantity
WHEN Customer attempts to place an order
THEN System should show an error message "You must order at least one pizza"  
```

```
GIVEN Customer has selected a pizza type and quantity
AND Customer has selected country "US"
THEN System applies 10% discount to the order price
```

## Instructions

```bash
./gradlew build
```

```bash
./gradlew pitest
```