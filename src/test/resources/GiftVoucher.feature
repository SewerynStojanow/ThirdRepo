Feature: Logging with Admin, we will navigate to Vouchers page and
  after checking if a Voucher with given name exists ,we create a
  Voucher and make sure it is created.

  Scenario: Logging in and navigating to Vouchers page

    Given we are logged in as Admin on the <Admin Dashboard page>
    When we click <Sales> <Gift Vouchers> <Gift Vouchers>
    Then we end up on the <Gift Vouchers> page. <Gift Vouchers list> is visible

  Scenario: Creating a Voucher

    Given A Voucher with given Name does exist - delete it
    When it doesn't - create one
    Then make sure the Voucher is created
    Then we are on the <Gift Vouchers> page , <Gift Vouchers list> is visible
    Then A Voucher with the Name we entered exists - delete it