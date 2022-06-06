Feature: Desktop | Price Alert
  @smoke
  Scenario: The user can select to PriceAlert and delete

    Given The user visits Vetrina homepage
    And The user verifies redirected to homepage
    And The user clicks login button
    When The user enters valid credentials
    And The user clicks "Giriş Yap" buttonn
    And The user navigates to "Erkek" "Loafer" category
    When The user verifies redirected to "/erkek-ayakkabi-loafer" page
    And The user clicks anyone product
    Then The user clicks "Fiyatı Düşünce Haber Ver" button
    And The user enters valid price
    Then The user clicks "Kaydet" button
    And The user verifies "İlgili ürün indirime girdiğinde sizleri bilgilendireceğiz. İlginiz için teşekkürler." message
    And The user closess popUps
    And The user clicks login button
    Then The user clicks "Fiyat Alarmı" button
    And The user verifies redirected to "/account/price-subscription" page
    And The user remove product
    And The user verifies "Fiyat alarmınız bulunmamaktadır." message
    Then The user clicks "Çıkış Yap" button
    And The user verifies redirected to homepage