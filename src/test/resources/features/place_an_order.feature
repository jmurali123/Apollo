
Feature: Place an order

  Scenario Outline: Add product to the cart
    Given I am on the Apollo home page
    When I add a product "<Product_name>" to the cart of "<type>" and size "<size>"
    Examples:
      | Product_name                                       | type      | size |
      | Pampers Active Baby Taped Diapers Medium, 62 Count | Baby Care | Small|



  Scenario Outline: Add product using categories
    Given I am on the Apollo home page
    And I navigate to "<type>" producttype  and filter "<filtertype>"
    When I select category "<category_name>" and "<subcategory_name>"
    And I add a product "<Product_name>" to the cart

    Examples:
      |type|filtertype|category_name|subcategory_name|Product_name|
      |Baby Care|Category|diapering|diapers|Pampers New Baby Taped Diapers, 72 Count|


  Scenario Outline: Add and delete product

    Given I am on the Apollo home page
    When I add a product "<Product_name>" to the cart of "<type>" and size "<size>"
    And I delete the cart items
    Then the cart should be empty
    Examples:
      | Product_name                                       | type      | size |
      | Pampers Active Baby Taped Diapers Medium, 62 Count | Baby Care | Small|




