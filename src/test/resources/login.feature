Feature: login

  Scenario: you try to login
  Given The user is on the website homepage
  When The user puts in their information and clicks login
  Then The user should be on the user page
