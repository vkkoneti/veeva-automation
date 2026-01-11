Feature: DP1 Home Page Slider Validation
@dp1
  Scenario: Validate slider count, titles and duration on DP1 home page
    Given I open DP1 home page
    When I capture all slider details
    Then slider count, titles and duration should be valid

