# Veeva Automation Framework

## Overview

This project is an automation framework built for the assignment provided.  
It includes UI automation (DP1 & DP2 validations) and a skeleton API test.

---

## Features

- UI Automation using **Selenium + Cucumber + TestNG**
- Config-driven with **Gradle**
- API automation skeleton with **Rest Assured**
- CI/CD setup via **GitHub Actions**
- Clear Page Object Model structure
- Separate step definitions and test runners

---

## Setup

### 1. Clone Repo
git clone https://github.com/vkkoneti/veeva-automation.git

### 2. Run Tests
./gradlew clean test

Tests should run in headless mode using the CI config.

---

## CI/CD

This project uses GitHub Actions for CI.  
On push or pull request, the pipeline:

- Sets up Java environment
- Runs all tests
- Publishes test reports

Workflow file:  
`.github/workflows/ci.yml`

---

## Reports

After execution, test reports will be available at:
build/reports/
build/test-results/


---

## DP1 Slider Test

Validates carousel slides on NBA team page:
- Slide count
- Slide titles
- Slide duration

---

## DP2 Footer Test

Validates footer links on NBA team page:
- Footer visibility
- Each link text & href

---

## API Automation

Contains a basic Rest Assured test as skeleton:
- Validates GET /users API (status & data)

---

## Known Limitations

- Shop pages are bot-protected and not reliably automatable with Selenium
- This has been addressed in framework docs



### Structure
- UI Automation: Page Object Model
- API Automation: Rest Assured Skeleton
- Config Driven: properties file

### How to Run
1. Update config.properties
2. Run TestRunner
3. API tests run via TestNG

