Feature: Desktop | Filter feature

  @smoke
  Scenario: Filtering with selected options

    Given The user visits Vetrina homepage
    And The user verifies redirected to homepage
    And The user navigates to "Kadın" "Bot" category
    When The user verifies redirected to "/kadin-ayakkabi-bot" page
    And The user clicks "Marka" button
    And The user chooses "CASADEI" value
    Then The user verifies redirected to "/kadin-ayakkabi-bot?defaultMinPrice=0&pageIndex=0&defaultMaxPrice=0&lastSelectedFilter=Marka&Marka=904" page
    And The user clicks "Beden" button with JS
    And The user chooses "38" value
    And The user verifies redirected to "/kadin-ayakkabi-bot?defaultMinPrice=0&pageIndex=0&defaultMaxPrice=0&lastSelectedFilter=size&Marka=904&size=8428" page
    And The user clicks "Renk" button with JS
    And The user chooses "KAHVERENGİ" value
    Then The user verifies redirected to "/kadin-ayakkabi-bot?defaultMinPrice=0&pageIndex=0&defaultMaxPrice=0&lastSelectedFilter=color&Marka=904&color=8742&size=8428" page
    And The user clicks "38" button with JS
    And The user clicks "CASADEI" button with JS
    Then The user verifies redirected to "/kadin-ayakkabi-bot?Marka=&color=8742&defaultMaxPrice=0&defaultMinPrice=0&lastSelectedFilter=color&size=" page