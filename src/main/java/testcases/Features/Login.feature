Feature: Log in to Mitigram

@Regression
Scenario: Verify Log in with valid credentials

Given User has launched Mitigram website
And User clicks Log in button
When User enters "mailId" and "password"
And User selects Log in button from log in page