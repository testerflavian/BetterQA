Feature: I will test some functionalities on BetterQA

  @S1
  Scenario: Check that a list of movies is displayed when you open the app.
    Given I open the app
    When I complete the password and the app is loaded
    Then A list of movies is displayed

   @S2
   Scenario: Check that the release date is correctly displayed.
     Given I open the application
     When I open the movie The Shawshank Redemption
     Then The release date is correctly displayed

   @S3
   Scenario: Check that The Shawshank Redemption is no longer visible when you search for Star Trek.
     Given I open BetterQA
     When I search for Star Trek
     Then Star Trek: First Contact is displayed and The Shawshank Redemption is no longer visible

   @S4
   Scenario Outline: Check that the Released on, popularity, vote average and vote count fields have the expected values.
     Given I open app BetterQA
     When I search for "<movie_name>"
     Then Check that released date is "<release_date>", popularity is "<popularity>", vote average is "<vote_average>" and vote count is "<vote_count>"

Examples:
     |movie_name              |release_date|popularity|vote_average|vote_count|
     |The Shawshank Redemption|1994-09-22  |68.699    |9.3         |2587691   |
     |Hacksaw Ridge           |2016-10-07  |186.393   |8.2         |10914     |

     @S5
     Scenario: Check what happens when you press enter on search but you don't search for nothing.
       Given I open application BetterQA
       When I search for nothing and press enter
       Then The page should refresh or stay the same

