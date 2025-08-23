Feature: Checkout Scenario

    Background: Customers landend to login page
        Given User landing to logged ecommerce
        When User input email "daffa.virdianto@gmail.com" and password "daffa123"
        Then User redirect to homepage

    Scenario: Customers buy a product
        When Customer view a product "Pure Cotton Neon Green Tshirt"
        And Customer add the quantity of products
        Then Verify Product successfully added "Pure Cotton Neon Green Tshirt" on cart page
        When Customer redirect to checkout page
        When Customer redirect to payment page
        And Customer set payment details
        And Customer send payment
        Then Verify successfully payment on payment page