package step_definitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.util.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Duration;
import page_objects.ClassPageObject;

public class ManageAttandencePage {
	
	ManageAttandencePage attPage = new ManageAttandencePage();

	PageFactory.initElements(DriverManager.getDriver(), HomePage.getInstance();
	PageFactory.initElements(DriverManager.getDriver(), LoginPage.getInstance());
PageFactory.initElements(DriverManager.getDriver(), DashboardPage.getInstance());
	@When("Admin clicks Attendence on the navigation bar")
	public void admin_clicks_Attendence_on_the_navigation_bar() {
		attPage.clickattendenceBtn();
	}

	@Then("Admin should see the Manage attendence in header")
	public void admin_should_see_the_manage_attendence_in_header() {
	String actualText = mp.validateHeader();
	  Assert.assertEquals(actualText, "Manage Attendance");
	}

	@Then("Maximum navigation time in milliseconds,default to {int} seconds")
	public void maximum_navigation_time_in_milliseconds_default_to_seconds(long navigationTime) {
		attPage.validateNavTime();
	 Assert.assertEquals(navigationTime, 30);
	}

	@Then("HTTP response>={int}.Then the link is broken")
	public void http_response_then_the_link_is_broken(Integer int1) throws InterruptedException, IOException{
		attPage.validateBrokenLink();
	}

	@Then("Admin should see LMS-Learning management system as title")
	public void admin_should_see_lms_learning_management_system_as_title() {
	   String actualText = mp.validateTitle();
	   Assert.assertEquals(actualText, "LMS-Learning Management System");
	}

	@Then("Manage attendence header should be in left side of page")
	public void manage_attendence_header_should_be_in_left_side_of_page() {

	int x = attendanceHeader.getLocation().getX();
	int y = attendanceHeader.getLocation().getY();
	int eleHeight = attendanceHeader.getSize().getHeight();
	int eleWidth = attendanceHeader.getSize().getWidth();
	boolean leftAlignment = (((x+eleWidth)<= winWidth/2) && (y + eleHeight)<= winHeight/2);
	Assert.assertTrue(leftAlignment);
	  
	}

	@Then("Admin should see correct spelling for the all the fields")
	public void admin_should_see_correct_spelling_for_the_all_the_fields() {
	   String stuText = mp.validateStuField();
	   Assert.assertEquals(stuText, "Student");
	   
	   String pgmText = mp.validateProgramField();
	   Assert.assertEquals(pgmText, "Program");
	   String batchText = mp.validateBatchField();
	   Assert.assertEquals(batchText, "Batch");
	   
	   String classText = mp.validateClassField();
	   Assert.assertEquals(classText, "Class");
	   
	   String userText = mp.validateUserField();
	   Assert.assertEquals(userText, "User");
	   
	   String assText= mp.validateAssignmentField();
	   Assert.assertEquals(assText, "Assignment");
	   
	   String attText = mp.validateAttendanceField();
	   Assert.assertEquals(attText, "Attendance");
	   
	   String logoutText = mp.validateLogoutField();
	   Assert.assertEquals(logoutText, "Logout");
	   
	  
	}

	@Then("Admin should see disabled delete icon below the {string}")
	public void admin_should_see_disabled_delete_icon_below_the(String string) {
	   
		attPage.verifyDeleteIcon(); 
	   
	}

	@Then("Admin should see search bar on the attendance page")
	public void admin_should_see_search_bar_on_the_attendance_page() {
	String actualText =   attPage.verifySearchbar();
	   Assert.assertEquals(actualText,"Search...");
	}

	@Then("Admin should see +Add New Attendance button on the attendance page")
	public void admin_should_see_add_new_attendance_button_on_the_attendance_page() {
	String actualText =  attPage.verifyNewAttendance();
	Assert.assertEquals(actualText, "+ A New Attendance");
	}

	@Then("Admin should see data table on the Manage Attendance Page With column headers")
	public void admin_should_see_data_table_on_the_Manage_Attendance_page_With_column_headers() {
	List Elements = attPage.ValidateColumnHeaders();
	Assert.assertEquals(Elements,"(Check box symbol,Class ID, Student Id,Preasent, Edit /Delete");
	}

	@Then("Edit Icon in each row of data table only  when entries are available")
	public void edit_icon_in_each_row_of_data_table_only_when_entries_are_available() {
		attPage.validateEditIcon();
	}

	@Then("Edit Icon will not be present in data table")
	public void edit_icon_will_not_be_present_in_data_table() {
		attPage.validateEditIcon();
	}

	@Then("Delete Icon in each row of data table only  when entries are available")
	public void delete_icon_in_each_row_of_data_table_only_when_entries_are_available() {
		attPage.validateDeleteIcon();
	}

	@Then("Admin cant see delete  Icon in data table")
	public void admin_cant_see_delete_icon_in_data_table() {
		attPage.validateDeleteIcon();
	}

	@Then("Admin should see sort icon near the column headers except for Edit and Delete")
	public void admin_should_see_sort_icon_near_the_column_headers_except_for_edit_and_delete() {
		attPage.validateSortIcon();
	}

	@Then("Admin should see check box in the all rows  of data table")
	public void admin_should_see_check_box_in_the_all_rows_of_data_table() {
		attPage.validateCheckbox();
	}

	@Then("Above the footer Admin should see the text as {string} below the table, x- starting record number on that page,y-ending record number on that page,z-Total number of records  Note: with or without entries")
	public void above_the_footer_admin_should_see_the_text_as_below_the_table_x_starting_record_number_on_that_page_y_ending_record_number_on_that_page_z_total_number_of_records_note_with_or_without_entries(String string) {
	   String actualText = attPage.validateEntries();
	   Assert.assertEquals(actualText, "showing entries");
	}

	@Then("Admin should see the pagination controls under the data table")
	public void admin_should_see_the_pagination_controls_under_the_data_table() {
		attPage.validatePagination();
	}

	@Then("Admin should see the text with total number classes in the data table. \\( {string})")
	public void admin_should_see_the_text_with_total_number_classes_in_the_data_table(String string) {
	List<WebElement> row =  new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/table/tbody/tr")));
	int number = row.size();
	   String actualText = attPage.validateTotalAttendances();
	   Assert.assertEquals(actualText, "In total there are"+number+"attendances");
	}
	}


