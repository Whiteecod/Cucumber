#Senaryo
#CitizenShip sayfasına gidiniz.
#Create işlemini parameter yöntemi ile doğrulayınız.
#Daha sonra aynı bilgilerle tekrar Create yapılamadığını doğrulayınız. (negatif test)

Feature: Citizenship Functionality

  Background:  # before senaryo
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login succesfully
    And Navigate to CitizenShip page

  Scenario Outline: CitizenShip create
    When User a CitizenShip name as "<name>" short name as "<short>"
    Then Success message should be displayed

    When User a CitizenShip name as "<name>" short name as "<short>"
    Then Already exist message should be displayed

    When User delete the "<name>"
    Then Success message should be displayed
    Examples:
      | name  | short |
      | kuU212q2lk2  | kqu2222U2 |
      #| kuUlk3  | kuU3 |
     # | kuUlk4  | kuU4 |


    #testNG de ki dataProvider burada Scenario Outline olarak karşımıza çıkıyor
  # Scenario outline ın her bir örnek satırı için senaryo tümü bir kez çalışır.
  # 5 satır var ise eğer bütün parametreler çalışır.

