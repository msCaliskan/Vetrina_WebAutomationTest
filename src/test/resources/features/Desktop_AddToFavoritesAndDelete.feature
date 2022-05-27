Feature: Desktop | Add to favorites and delete
  @smoke
  Scenario: The user can add to favorites and delete

    Given The user visits JeansLab homepage
    And The user verifies redirected to homepage
    And The user clicks login button
    When The user enters valid credentials
    And The user clicks "Giriş Yap" buttonn
    And The user navigates to "ERKEK" "JEAN" category
    When The user verifies redirected to "/erkek-giyim-jean" page
    And The user clicks anyone product
    And The user clicks hearth button
    And The user clicks login button
    Then The user clicks "Favori Listem" button
    And The user verifies redirected to "/account/favorites" page
    When The user clicks hearth button
    And The user verifies " Favori listenizde ürün bulunmamaktadır." message
    Then The user clicks "Çıkış Yap" button
    And The user verifies redirected to homepage
