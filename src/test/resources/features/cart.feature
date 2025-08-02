Feature: Checkout
  as a user I'd like to successfully checkout and purchase order on My Demo App

  @TC001
  Scenario: Verify user could successfully purchase the order (case user has not login yet)
    Given user on My Demo App Catalog Page
    When user click product "Sauce Lab Back Packs" on Catalog Page
    And user add 2 product qty on Product Detail Page
    And user click button add to cart on Product Detail Page
    Then user verify the total product price on Cart Page
    When user click checkout button on Cart Page
    And user fill out username and password on Login Page
    And user fill out recipient data on Checkout Page:
      | FullName       | Address Line 1 | Address Line 2 | City    | State/Region | Zip Code | Country        |
      | Rebbeca Winter | Mandorley 112  | Entrance 1     | Truro   | Cornwall     | 89750    | United Kingdom |
    And user click button payment on Checkout Page
    When user fill out payment credential on Payment Page
    And user review the order summary prior place order on Review Order Page
    Then user successfully purchase the order by seeing "Checkout Complete" message on Thank You Page

