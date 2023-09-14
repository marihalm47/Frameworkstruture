Feature: Manage Attendance Page Verification
Background: Admin logged on the LMS portal
    Given Admin is on dashboard page after Login in to the LMS url "https://tutorialsninja.com/demo/index.php"
    When Admin clicks Attendence on the navigation bar
    
 Scenario: Validate the header of the page
    Then Admin should see the Manage attendence in header
    
 Scenario: Validate response time from dashboard page to attendence page
    Then Maximum navigation time in milliseconds,default to 30 seconds
    
 Scenario: Validate the broken link
    Then HTTP response>=400.Then the link is broken
    
 Scenario: Verify LMS title
     Then Admin should see LMS-Learning management system as title
     
 Scenario: Verify the alignment of the Manage attendence header
     Then Manage attendence header should be in left side of page
     
 Scenario: Validate text in manage attendence page
     Then Admin should see correct spelling for the all the fields
     
 Scenario: Verify delete icon below the header
     Then Admin should see disabled delete icon below the "Manage Attendance"
     
 Scenario: Verify search bar on the attendence page
     Then Admin should see search bar on the attendance page
     
 Scenario: Verify add new Attendence button on
     Then Admin should see +Add New Attendance button on the attendance page
     
 Scenario: Verify date table on the attendence page
     Then  Admin should see data table on the Manage Attendance Page With column headers
     
 Scenario: Verify Edit icon in the data table
     Then Edit Icon in each row of data table only  when entries are available
     
 Scenario: Verify edit icon when no data in the table
     Then Edit Icon will not be present in data table
     
 Scenario: Verify delete icon in the data table
     Then Delete Icon in each row of data table only  when entries are available
     
Scenario: Verify delete icon when no data in the table
     Then Admin cant see delete  Icon in data table
     
 Scenario: Verify sort icon the data table
     Then Admin should see sort icon near the column headers except for Edit and Delete
     
 Scenario: Verify check box in the data table
     Then Admin should see check box in the all rows  of data table 
     
 Scenario: Validate the number entries displaying
     Then Above the footer Admin should see the text as "Showing x to y of z entries" below the table, x- starting record number on that page,y-ending record number on that page,z-Total number of records  Note: with or without entries
          
  Scenario: Verify Pagination control below the data
     Then Admin should see the pagination controls under the data table
     
   Scenario: Validate footer text
     Then Admin should see the text with total number classes in the data table. ( " In total there are number of classes")
