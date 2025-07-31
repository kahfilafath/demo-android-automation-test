Feature: Cart
  as a user I'd like to successfully add item to cart

  @TC001
  Scenario: Verify user could add item to the cart (case user has not login yet)
    Given user on My Demo App Catalog Page
    When user click product "Sauce Lab Back Packs" on Catalog Page
