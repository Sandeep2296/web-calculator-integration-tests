# web-calculator-integration-tests
web calculator integration test assignment

This project contains integration tests for a web-based simple calculator application. The tests verify the functionality and reliability of the calculator's basic arithmetic operations through automated testing.

## Test Framework Features

### Reporting
- ExtentReports integration for detailed test reporting
- Test reports are generated in the `test-output` folder after test execution

### Environment Configuration
- Environment can be configured using `-Denv` parameter:
  - `-Denv=prod` - Runs tests against production environment
  - `-Denv=staging` - Runs tests against staging environment
  - Default: staging environment (if no environment is specified)

### Browser Configuration
- Browser can be configured using `-Dbrowser` parameter:
  - `-Dbrowser=firefox` - Runs tests in Firefox
  - `-Dbrowser=chrome` - Runs tests in Chrome
  - Default: Chrome (if no browser is specified)

## Current Test Status
- Production Environment: 4 test failures (application issues)
- Staging Environment: 14 test failures
