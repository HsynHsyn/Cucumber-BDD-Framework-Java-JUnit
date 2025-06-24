
Feature: Parcel Shipping and Checkout Validation
  As a customer, I want to send a parcel via Evri and ensure that the product name appears in the basket
  so that I can proceed to the checkout payment page at the final stage.

  Acceptance Criteria (ACs);
  AC1: User should enter parcel details before proceeding.
  AC2: User must select a valid delivery option.
  AC3: AC3: User must provide product name.
  AC4: The user must enter sender and recipient addresses.
  AC5: The user must provide personal details.
  AC6: The product name should appear in the basket, and the user should be able to proceed to the checkout page.

  Scenario Outline: Verify that user sends a parcel and sees item name in the basket

    # AC1: User should enter parcel details before proceeding.
    Given user logged into the Evri Company webpage and landed on the home page
    When user enters "<From postcode>", "<To postcode>" and selects "<Weight (kg)>"
    And user clicks on the Send a parcel button
    Then user proceeds to the Delivery Options page

    # AC2: User must select a valid delivery option.
    Given user selects Parcel size as Standard parcel
    And user selects Delivery speed as Standard
    And user selects Drop off or collection as the drop-off or collection
    When user selects Parcel delivery location Deliver to a ParcelShop
    And user clicks on the Continue button
    Then user proceeds to the What's in it? page

    # AC3: User must provide product name.
    When user enters "<Parcel contents>" into the Parcel contents area
    And user enters "<Price>" into the How much is it worth? area
    And user clicks on the Continue button
    Then user proceeds to the Where's it going? page

    # AC4: The user must enter sender and recipient addresses.
    When user enters recipient details "<Recipient first name>", "<Recipient last name>"
    And user enters recipient address "<Address line 1>", "<To postcode>"
    And user clicks on the Continue button
    Then user proceeds to the Your details page

    # AC5: The user must provide personal details.
    When user enters sender first name "Evren", last name "Oz", email "evren_oz@example.com", phone "123 456 7890"
    And user enters return address "M1 1AD", "123 Baker Street"
    And user clicks on the Add to Basket button
    Then user proceeds to the Basket page

    # AC6: The product name should appear in the Basket and proceed to Checkout page.
    When user should see parcel content name "<Parcel contents>" on the Basket page
    And user clicks on the terms and conditions checkbox
    And user clicks on the Continue to payment button
    Then user proceeds to Checkout page

    Examples:
      | From postcode | To postcode | Weight (kg) | Parcel contents | Price | Recipient first name | Recipient last name | Address line 1 |
      | M1 1AD        | WN7 3AE     | Under 1kg   | Laptop          | 100   | John                 | Doe                 | Leigh          |
