import java.util.ArrayList; // Import ArrayList class for dynamic list data structures
import java.util.List; // Import List interface for representing ordered collections
import java.util.Scanner; // Import Scanner utility class for processing console keyboard input
public class TimeManagementSystem { // Define the primary class for Educational Institution Time Management System
    static class User { // Define the User model class for role-based authentication
        String username; // Declare field to store the unique login username
        String password; // Declare field to store the user login password
        String role; // Declare field to store access role: ADMIN, FACULTY, or STUDENT
        String fullName; // Declare field to store user display full name
        User(String username, String password, String role, String fullName) { // Define constructor to initialize User attributes
            this.username = username; // Assign username parameter to instance variable
            this.password = password; // Assign password parameter to instance variable
            this.role = role; // Assign role parameter to instance variable
            this.fullName = fullName; // Assign fullName parameter to instance variable
        } // Close User constructor block
    } // Close User model class definition
    static class ClassSchedule { // Define the ClassSchedule model class for timetable management
        String courseCode; // Declare field to store course code identifier
        String courseName; // Declare field to store title of the course
        String facultyUsername; // Declare field to store assigned faculty username
        String dayOfWeek; // Declare field to store scheduled day of the week
        String timeSlot; // Declare field to store class timing interval
        String roomNumber; // Declare field to store assigned classroom or laboratory number
        ClassSchedule(String courseCode, String courseName, String facultyUsername, String dayOfWeek, String timeSlot, String roomNumber) { // Define constructor for ClassSchedule
            this.courseCode = courseCode; // Assign courseCode parameter to instance variable
            this.courseName = courseName; // Assign courseName parameter to instance variable
            this.facultyUsername = facultyUsername; // Assign facultyUsername parameter to instance variable
            this.dayOfWeek = dayOfWeek; // Assign dayOfWeek parameter to instance variable
            this.timeSlot = timeSlot; // Assign timeSlot parameter to instance variable
            this.roomNumber = roomNumber; // Assign roomNumber parameter to instance variable
        } // Close ClassSchedule constructor block
    } // Close ClassSchedule model class definition
    static class FacultyWorkLog { // Define the FacultyWorkLog model class for tracking faculty working hours
        String facultyUsername; // Declare field to identify the faculty member
        String date; // Declare field to store the date of logged work
        double hours; // Declare field to store the duration of work in hours
        String activity; // Declare field to describe the academic work performed
        FacultyWorkLog(String facultyUsername, String date, double hours, String activity) { // Define constructor for FacultyWorkLog
            this.facultyUsername = facultyUsername; // Assign facultyUsername parameter to instance variable
            this.date = date; // Assign date parameter to instance variable
            this.hours = hours; // Assign hours parameter to instance variable
            this.activity = activity; // Assign activity parameter to instance variable
        } // Close FacultyWorkLog constructor block
    } // Close FacultyWorkLog model class definition
    static class AttendanceRecord { // Define the AttendanceRecord model class for student attendance tracking
        String studentUsername; // Declare field to store student username
        String courseCode; // Declare field to store course identifier
        String date; // Declare field to store the date of attendance session
        boolean isPresent; // Declare field to indicate whether student was present or absent
        AttendanceRecord(String studentUsername, String courseCode, String date, boolean isPresent) { // Define constructor for AttendanceRecord
            this.studentUsername = studentUsername; // Assign studentUsername parameter to instance variable
            this.courseCode = courseCode; // Assign courseCode parameter to instance variable
            this.date = date; // Assign date parameter to instance variable
            this.isPresent = isPresent; // Assign isPresent status to instance variable
        } // Close AttendanceRecord constructor block
    } // Close AttendanceRecord model class definition
    static class AcademicActivity { // Define the AcademicActivity model class for institutional calendar events
        String title; // Declare field to store event title
        String date; // Declare field to store event date
        String time; // Declare field to store event time slot
        String venue; // Declare field to store event venue
        String organizer; // Declare field to store event coordinator or department
        AcademicActivity(String title, String date, String time, String venue, String organizer) { // Define constructor for AcademicActivity
            this.title = title; // Assign title parameter to instance variable
            this.date = date; // Assign date parameter to instance variable
            this.time = time; // Assign time parameter to instance variable
            this.venue = venue; // Assign venue parameter to instance variable
            this.organizer = organizer; // Assign organizer parameter to instance variable
        } // Close AcademicActivity constructor block
    } // Close AcademicActivity model class definition
    private static final List<User> users = new ArrayList<>(); // Initialize in-memory list storage for registered users
    private static final List<ClassSchedule> schedules = new ArrayList<>(); // Initialize in-memory list storage for class schedules
    private static final List<FacultyWorkLog> workLogs = new ArrayList<>(); // Initialize in-memory list storage for faculty work logs
    private static final List<AttendanceRecord> attendances = new ArrayList<>(); // Initialize in-memory list storage for attendance records
    private static final List<AcademicActivity> activities = new ArrayList<>(); // Initialize in-memory list storage for academic activities
    private static void seedInitialData() { // Define method to pre-populate mock data for quick testing
        users.add(new User("admin", "admin123", "ADMIN", "Dr. Robert Vance (Dean)")); // Add default administrator account
        users.add(new User("prof_smith", "fac123", "FACULTY", "Prof. Alice Smith")); // Add faculty member account for Prof. Smith
        users.add(new User("prof_john", "fac123", "FACULTY", "Prof. John Miller")); // Add faculty member account for Prof. Miller
        users.add(new User("stu_emma", "stu123", "STUDENT", "Emma Watson")); // Add student account for Emma
        users.add(new User("stu_david", "stu123", "STUDENT", "David Clark")); // Add student account for David
        schedules.add(new ClassSchedule("CS101", "Data Structures", "prof_smith", "Monday", "09:00 AM - 10:30 AM", "Lab-201")); // Add schedule for CS101 on Monday
        schedules.add(new ClassSchedule("CS102", "Operating Systems", "prof_john", "Monday", "11:00 AM - 12:30 PM", "Hall-104")); // Add schedule for CS102 on Monday
        schedules.add(new ClassSchedule("CS101", "Data Structures", "prof_smith", "Wednesday", "09:00 AM - 10:30 AM", "Lab-201")); // Add schedule for CS101 on Wednesday
        schedules.add(new ClassSchedule("CS103", "Database Systems", "prof_smith", "Thursday", "02:00 PM - 03:30 PM", "Room-305")); // Add schedule for CS103 on Thursday
        workLogs.add(new FacultyWorkLog("prof_smith", "2026-10-06", 3.0, "Lectures and Lab Supervision")); // Add sample faculty work log for Prof. Smith
        workLogs.add(new FacultyWorkLog("prof_smith", "2026-10-07", 2.5, "Curriculum Planning and Office Hours")); // Add second work log for Prof. Smith
        workLogs.add(new FacultyWorkLog("prof_john", "2026-10-06", 4.0, "OS Lab and Assignment Grading")); // Add sample work log for Prof. Miller
        attendances.add(new AttendanceRecord("stu_emma", "CS101", "2026-10-05", true)); // Add present record for Emma in CS101
        attendances.add(new AttendanceRecord("stu_emma", "CS101", "2026-10-07", true)); // Add second present record for Emma in CS101
        attendances.add(new AttendanceRecord("stu_emma", "CS102", "2026-10-05", false)); // Add absent record for Emma in CS102
        attendances.add(new AttendanceRecord("stu_david", "CS101", "2026-10-05", true)); // Add present record for David in CS101
        attendances.add(new AttendanceRecord("stu_david", "CS101", "2026-10-07", false)); // Add absent record for David in CS101
        activities.add(new AcademicActivity("Annual Tech Symposium", "2026-10-15", "10:00 AM - 04:00 PM", "Auditorium", "Computer Science Dept")); // Add symposium activity
        activities.add(new AcademicActivity("Mid-Semester Examinations", "2026-10-20", "09:00 AM - 01:00 PM", "Examination Halls", "Academic Controller")); // Add exam activity
    } // Close seedInitialData method block
    private static User authenticateUser(String username, String password) { // Define method to validate credentials and return user object
        for (User user : users) { // Iterate through the list of registered users
            if (user.username.equalsIgnoreCase(username) && user.password.equals(password)) { // Check if username and password match
                return user; // Return the matching user object on authentication success
            } // Close if conditional block
        } // Close for loop iteration block
        return null; // Return null if no matching user credentials were found
    } // Close authenticateUser method block
    public static void main(String[] args) { // Define main entry point method of the Java application
        seedInitialData(); // Call seedInitialData method to load default institution dataset
        Scanner scanner = new Scanner(System.in); // Instantiate Scanner object to read console input from keyboard
        boolean running = true; // Declare control flag to manage the application execution lifecycle
        while (running) { // Begin main application execution loop
            System.out.println("\n========================================================"); // Print decorative header boundary line
            System.out.println("  TIME MANAGEMENT SYSTEM FOR EDUCATIONAL INSTITUTIONS   "); // Print main application title banner
            System.out.println("========================================================"); // Print decorative header boundary line
            System.out.println("1. Login to Portal"); // Print option 1 for user authentication
            System.out.println("2. View Demo Login Credentials"); // Print option 2 to show sample login usernames and passwords
            System.out.println("3. Exit System"); // Print option 3 to exit the program
            System.out.print("Select an option (1-3): "); // Prompt user to enter their menu choice
            String choice = scanner.nextLine().trim(); // Read user selection string and remove leading/trailing spaces
            if (choice.equals("1")) { // Handle option 1: Login workflow
                System.out.print("Enter Username: "); // Prompt for username input
                String inputUser = scanner.nextLine().trim(); // Read username string from console
                System.out.print("Enter Password: "); // Prompt for password input
                String inputPass = scanner.nextLine().trim(); // Read password string from console
                User loggedUser = authenticateUser(inputUser, inputPass); // Call authentication method with provided credentials
                if (loggedUser == null) { // Check if authentication failed
                    System.out.println("[ERROR] Invalid credentials! Access denied."); // Print authentication error notice
                } else { // Handle successful authentication
                    System.out.println("[SUCCESS] Welcome, " + loggedUser.fullName + " | Role: " + loggedUser.role); // Print welcome message
                    if (loggedUser.role.equalsIgnoreCase("ADMIN")) { // Route to admin menu if role is ADMIN
                        handleAdminMenu(scanner, loggedUser); // Invoke admin dashboard handler
                    } else if (loggedUser.role.equalsIgnoreCase("FACULTY")) { // Route to faculty menu if role is FACULTY
                        handleFacultyMenu(scanner, loggedUser); // Invoke faculty dashboard handler
                    } else if (loggedUser.role.equalsIgnoreCase("STUDENT")) { // Route to student menu if role is STUDENT
                        handleStudentMenu(scanner, loggedUser); // Invoke student dashboard handler
                    } // Close role routing conditional block
                } // Close authentication verification block
            } else if (choice.equals("2")) { // Handle option 2: Display demo credentials
                displayDemoAccounts(); // Call displayDemoAccounts helper method
            } else if (choice.equals("3")) { // Handle option 3: Exit application
                running = false; // Update control flag to terminate loop
                System.out.println("Thank you for using Educational Time Management System. Goodbye!"); // Print farewell message
            } else { // Handle invalid menu option entry
                System.out.println("[WARNING] Invalid choice! Please select 1, 2, or 3."); // Print invalid option notice
            } // Close choice selection conditional block
        } // Close main execution while loop block
        scanner.close(); // Close Scanner resource stream
    } // Close main method block
    private static void displayDemoAccounts() { // Define helper method to display sample user credentials
        System.out.println("\n--- DEMO LOGIN CREDENTIALS ---"); // Print section banner
        System.out.println("ADMIN:   Username: admin       | Password: admin123"); // Print admin sample account
        System.out.println("FACULTY: Username: prof_smith  | Password: fac123"); // Print faculty sample account 1
        System.out.println("FACULTY: Username: prof_john   | Password: fac123"); // Print faculty sample account 2
        System.out.println("STUDENT: Username: stu_emma    | Password: stu123"); // Print student sample account 1
        System.out.println("STUDENT: Username: stu_david   | Password: stu123"); // Print student sample account 2
    } // Close displayDemoAccounts method block
    private static void handleAdminMenu(Scanner scanner, User admin) { // Define method to handle administrator functionalities
        boolean inAdminSession = true; // Declare session loop control flag for admin
        while (inAdminSession) { // Begin admin menu loop
            System.out.println("\n--- ADMIN DASHBOARD (" + admin.fullName + ") ---"); // Print admin dashboard header
            System.out.println("1. Create / Add Class Schedule"); // Print schedule creation option
            System.out.println("2. View Master Institutional Timetable"); // Print timetable viewing option
            System.out.println("3. Track Faculty Working Hours Summary"); // Print faculty hours tracking option
            System.out.println("4. Schedule Institutional Academic Activity"); // Print academic activity scheduling option
            System.out.println("5. View All Academic Activities"); // Print academic activities viewing option
            System.out.println("6. View Master Student Attendance Records"); // Print master attendance viewing option
            System.out.println("7. Logout to Main Menu"); // Print logout option
            System.out.print("Enter choice (1-7): "); // Prompt user for dashboard selection
            String adminChoice = scanner.nextLine().trim(); // Read admin option choice
            if (adminChoice.equals("1")) { // Handle adding new class schedule
                addNewSchedule(scanner); // Call helper method to create schedule entry
            } else if (adminChoice.equals("2")) { // Handle viewing full timetable
                displayAllSchedules(); // Call helper method to print all schedules
            } else if (adminChoice.equals("3")) { // Handle tracking faculty working hours
                displayFacultyHoursSummary(); // Call helper method to display hours report
            } else if (adminChoice.equals("4")) { // Handle scheduling academic activity
                addNewAcademicActivity(scanner, admin.fullName); // Call helper method to add event
            } else if (adminChoice.equals("5")) { // Handle viewing academic activities
                displayAcademicActivities(); // Call helper method to view activities
            } else if (adminChoice.equals("6")) { // Handle viewing all student attendances
                displayAllAttendances(); // Call helper method to view all attendance records
            } else if (adminChoice.equals("7")) { // Handle admin logout
                inAdminSession = false; // Exit admin session loop
                System.out.println("Logged out from Admin portal successfully."); // Print logout confirmation message
            } else { // Handle invalid admin menu entry
                System.out.println("[WARNING] Invalid choice! Please select 1 through 7."); // Print warning message
            } // Close admin choice conditional block
        } // Close admin session while loop block
    } // Close handleAdminMenu method block
    private static void handleFacultyMenu(Scanner scanner, User faculty) { // Define method to handle faculty functionalities
        boolean inFacultySession = true; // Declare session loop control flag for faculty
        while (inFacultySession) { // Begin faculty menu loop
            System.out.println("\n--- FACULTY DASHBOARD (" + faculty.fullName + ") ---"); // Print faculty dashboard header
            System.out.println("1. View My Teaching Class Schedule"); // Print teaching schedule viewing option
            System.out.println("2. Log Daily Working Hours & Academic Tasks"); // Print working hours logging option
            System.out.println("3. View My Total Working Hours Summary"); // Print hours summary viewing option
            System.out.println("4. Mark Student Attendance for a Course"); // Print mark student attendance option
            System.out.println("5. View Student Attendance for My Courses"); // Print attendance records viewing option
            System.out.println("6. View Institutional Academic Calendar"); // Print academic activities viewing option
            System.out.println("7. Logout to Main Menu"); // Print logout option
            System.out.print("Enter choice (1-7): "); // Prompt faculty for dashboard selection
            String facultyChoice = scanner.nextLine().trim(); // Read faculty choice string
            if (facultyChoice.equals("1")) { // Handle viewing faculty-specific teaching schedule
                displayFacultySchedule(faculty.username); // Call method with faculty username
            } else if (facultyChoice.equals("2")) { // Handle logging working hours
                logFacultyWorkHours(scanner, faculty.username); // Call method to log faculty work hours
            } else if (facultyChoice.equals("3")) { // Handle viewing logged hours summary
                displayFacultyWorkHistory(faculty.username); // Call method to print logged hours report
            } else if (facultyChoice.equals("4")) { // Handle recording student attendance
                markAttendance(scanner); // Call helper method to mark student attendance
            } else if (facultyChoice.equals("5")) { // Handle viewing attendance records for courses
                displayFacultyCourseAttendances(faculty.username); // Call method to view course attendance
            } else if (facultyChoice.equals("6")) { // Handle viewing academic calendar events
                displayAcademicActivities(); // Call helper method to view activities
            } else if (facultyChoice.equals("7")) { // Handle faculty logout
                inFacultySession = false; // Exit faculty session loop
                System.out.println("Logged out from Faculty portal successfully."); // Print logout confirmation message
            } else { // Handle invalid faculty menu entry
                System.out.println("[WARNING] Invalid choice! Please select 1 through 7."); // Print warning message
            } // Close faculty choice conditional block
        } // Close faculty session while loop block
    } // Close handleFacultyMenu method block
    private static void handleStudentMenu(Scanner scanner, User student) { // Define method to handle student functionalities
        boolean inStudentSession = true; // Declare session loop control flag for student
        while (inStudentSession) { // Begin student menu loop
            System.out.println("\n--- STUDENT DASHBOARD (" + student.fullName + ") ---"); // Print student dashboard header
            System.out.println("1. View My Weekly Class Schedule"); // Print class schedule viewing option
            System.out.println("2. Track My Attendance Record & Percentage"); // Print attendance tracking option
            System.out.println("3. View Upcoming Academic Activities & Events"); // Print academic activities viewing option
            System.out.println("4. Logout to Main Menu"); // Print logout option
            System.out.print("Enter choice (1-4): "); // Prompt student for dashboard selection
            String studentChoice = scanner.nextLine().trim(); // Read student choice string
            if (studentChoice.equals("1")) { // Handle viewing class timetable
                displayAllSchedules(); // Call helper method to view active schedules
            } else if (studentChoice.equals("2")) { // Handle viewing personal attendance records
                displayStudentAttendance(student.username); // Call method to display student attendance report
            } else if (studentChoice.equals("3")) { // Handle viewing academic activities
                displayAcademicActivities(); // Call helper method to view institutional activities
            } else if (studentChoice.equals("4")) { // Handle student logout
                inStudentSession = false; // Exit student session loop
                System.out.println("Logged out from Student portal successfully."); // Print logout confirmation message
            } else { // Handle invalid student menu entry
                System.out.println("[WARNING] Invalid choice! Please select 1 through 4."); // Print warning message
            } // Close student choice conditional block
        } // Close student session while loop block
    } // Close handleStudentMenu method block
    private static void addNewSchedule(Scanner scanner) { // Define helper method to create and register a new class schedule
        System.out.println("\n--- ADD CLASS SCHEDULE ---"); // Print header banner for adding schedule
        System.out.print("Enter Course Code (e.g., CS104): "); // Prompt for course code
        String code = scanner.nextLine().trim(); // Read course code from input
        System.out.print("Enter Course Name: "); // Prompt for course name
        String name = scanner.nextLine().trim(); // Read course name from input
        System.out.print("Enter Faculty Username (e.g., prof_smith): "); // Prompt for faculty username
        String facUser = scanner.nextLine().trim(); // Read faculty username from input
        System.out.print("Enter Day of Week (e.g., Monday): "); // Prompt for scheduled day
        String day = scanner.nextLine().trim(); // Read day of week from input
        System.out.print("Enter Time Slot (e.g., 10:00 AM - 11:30 AM): "); // Prompt for timing slot
        String time = scanner.nextLine().trim(); // Read time slot from input
        System.out.print("Enter Room / Lab Number (e.g., Room-402): "); // Prompt for classroom number
        String room = scanner.nextLine().trim(); // Read classroom number from input
        schedules.add(new ClassSchedule(code, name, facUser, day, time, room)); // Instantiate and add new schedule to list
        System.out.println("[SUCCESS] Class schedule added successfully for " + code + "!"); // Print success confirmation
    } // Close addNewSchedule method block
    private static void displayAllSchedules() { // Define helper method to print master class schedules
        System.out.println("\n----------------- MASTER CLASS TIMETABLE -----------------"); // Print timetable header banner
        if (schedules.isEmpty()) { // Check if schedule list is empty
            System.out.println("No class schedules registered yet."); // Print notice when empty
            return; // Return early from method
        } // Close if conditional block
        System.out.printf("%-10s %-22s %-14s %-12s %-22s %-10s\n", "COURSE", "NAME", "FACULTY", "DAY", "TIME SLOT", "ROOM"); // Print formatted table columns
        System.out.println("---------------------------------------------------------------------------------------------"); // Print table divider line
        for (ClassSchedule cs : schedules) { // Iterate over all registered class schedules
            System.out.printf("%-10s %-22s %-14s %-12s %-22s %-10s\n", cs.courseCode, cs.courseName, cs.facultyUsername, cs.dayOfWeek, cs.timeSlot, cs.roomNumber); // Print table row
        } // Close for loop iteration block
    } // Close displayAllSchedules method block
    private static void displayFacultySchedule(String facultyUsername) { // Define method to filter and print schedules for specific faculty
        System.out.println("\n------------- YOUR TEACHING SCHEDULE -------------"); // Print teaching schedule header banner
        boolean found = false; // Declare flag to track if any assigned classes exist
        System.out.printf("%-10s %-22s %-12s %-22s %-10s\n", "COURSE", "NAME", "DAY", "TIME SLOT", "ROOM"); // Print formatted table columns
        System.out.println("-----------------------------------------------------------------------------"); // Print table divider line
        for (ClassSchedule cs : schedules) { // Iterate over all schedules in the system
            if (cs.facultyUsername.equalsIgnoreCase(facultyUsername)) { // Check if schedule belongs to the faculty user
                System.out.printf("%-10s %-22s %-12s %-22s %-10s\n", cs.courseCode, cs.courseName, cs.dayOfWeek, cs.timeSlot, cs.roomNumber); // Print schedule details
                found = true; // Mark found flag as true
            } // Close if conditional block
        } // Close for loop iteration block
        if (!found) { // Check if no matching schedules were located
            System.out.println("No classes assigned to your profile."); // Print notice indicating absence of assigned classes
        } // Close if conditional block
    } // Close displayFacultySchedule method block
    private static void logFacultyWorkHours(Scanner scanner, String facultyUsername) { // Define method for faculty to log their hours
        System.out.println("\n--- LOG FACULTY WORKING HOURS ---"); // Print logging header banner
        System.out.print("Enter Date (YYYY-MM-DD): "); // Prompt for date input
        String date = scanner.nextLine().trim(); // Read date string from console
        System.out.print("Enter Hours Worked (e.g., 3.5): "); // Prompt for hours duration
        double hours; // Declare variable to store hours value
        try { // Begin try block for numeric conversion
            hours = Double.parseDouble(scanner.nextLine().trim()); // Parse user input into double value
        } catch (NumberFormatException e) { // Catch formatting exception for invalid numbers
            System.out.println("[ERROR] Invalid number format for hours worked!"); // Print error message
            return; // Abort method execution on invalid input
        } // Close try-catch block
        System.out.print("Enter Activity Description (e.g., Lecture, Lab, Research): "); // Prompt for activity description
        String activity = scanner.nextLine().trim(); // Read activity description string
        workLogs.add(new FacultyWorkLog(facultyUsername, date, hours, activity)); // Create and store new faculty work log entry
        System.out.println("[SUCCESS] Working hours logged successfully!"); // Print confirmation message
    } // Close logFacultyWorkHours method block
    private static void displayFacultyWorkHistory(String facultyUsername) { // Define method to display personal work logs and total hours
        System.out.println("\n------------- YOUR WORKING HOURS HISTORY -------------"); // Print work history header banner
        double totalHours = 0.0; // Declare accumulator variable for total hours
        System.out.printf("%-12s %-8s %-40s\n", "DATE", "HOURS", "ACTIVITY DESCRIPTION"); // Print formatted table columns
        System.out.println("-----------------------------------------------------------------"); // Print table divider line
        for (FacultyWorkLog log : workLogs) { // Iterate over all faculty work logs
            if (log.facultyUsername.equalsIgnoreCase(facultyUsername)) { // Check if log entry matches current faculty user
                System.out.printf("%-12s %-8.2f %-40s\n", log.date, log.hours, log.activity); // Print log entry row
                totalHours += log.hours; // Add logged hours to accumulator total
            } // Close if conditional block
        } // Close for loop iteration block
        System.out.println("-----------------------------------------------------------------"); // Print summary divider line
        System.out.printf("Total Working Hours Completed: %.2f hours\n", totalHours); // Print calculated total hours
    } // Close displayFacultyWorkHistory method block
    private static void displayFacultyHoursSummary() { // Define method for admin to inspect all faculty work hours
        System.out.println("\n------------- INSTITUTIONAL FACULTY WORK HOURS REPORT -------------"); // Print report header banner
        if (workLogs.isEmpty()) { // Check if work log list is empty
            System.out.println("No faculty working hours logged yet."); // Print notice when empty
            return; // Return early from method
        } // Close if conditional block
        System.out.printf("%-14s %-12s %-8s %-40s\n", "FACULTY", "DATE", "HOURS", "ACTIVITY DESCRIPTION"); // Print formatted table columns
        System.out.println("-----------------------------------------------------------------------------"); // Print table divider line
        for (FacultyWorkLog log : workLogs) { // Iterate through all registered faculty work logs
            System.out.printf("%-14s %-12s %-8.2f %-40s\n", log.facultyUsername, log.date, log.hours, log.activity); // Print work log entry row
        } // Close for loop iteration block
    } // Close displayFacultyHoursSummary method block
    private static void markAttendance(Scanner scanner) { // Define method to mark student attendance for a class session
        System.out.println("\n--- MARK STUDENT ATTENDANCE ---"); // Print attendance marking header banner
        System.out.print("Enter Course Code (e.g., CS101): "); // Prompt for course code
        String course = scanner.nextLine().trim(); // Read course code from input
        System.out.print("Enter Student Username (e.g., stu_emma): "); // Prompt for student username
        String student = scanner.nextLine().trim(); // Read student username from input
        System.out.print("Enter Date (YYYY-MM-DD): "); // Prompt for session date
        String date = scanner.nextLine().trim(); // Read date from input
        System.out.print("Is Student Present? (Y/N): "); // Prompt for presence boolean flag
        String statusInput = scanner.nextLine().trim(); // Read status input from console
        boolean isPresent = statusInput.equalsIgnoreCase("Y"); // Determine boolean presence from user input
        attendances.add(new AttendanceRecord(student, course, date, isPresent)); // Create and store new attendance record
        System.out.println("[SUCCESS] Attendance marked as " + (isPresent ? "PRESENT" : "ABSENT") + " for " + student + "!"); // Print status feedback
    } // Close markAttendance method block
    private static void displayFacultyCourseAttendances(String facultyUsername) { // Define method to display attendance for faculty's courses
        System.out.println("\n------------- ATTENDANCE RECORDS FOR YOUR COURSES -------------"); // Print attendance header banner
        List<String> facultyCourses = new ArrayList<>(); // Initialize list to track course codes taught by faculty
        for (ClassSchedule cs : schedules) { // Iterate through schedules to identify faculty courses
            if (cs.facultyUsername.equalsIgnoreCase(facultyUsername) && !facultyCourses.contains(cs.courseCode)) { // Match faculty username without duplicates
                facultyCourses.add(cs.courseCode); // Add course code to faculty courses list
            } // Close if conditional block
        } // Close for loop iteration block
        System.out.printf("%-12s %-10s %-12s %-10s\n", "STUDENT", "COURSE", "DATE", "STATUS"); // Print formatted table columns
        System.out.println("---------------------------------------------"); // Print table divider line
        boolean found = false; // Declare flag to check if matching attendance exists
        for (AttendanceRecord ar : attendances) { // Iterate through all attendance records
            if (facultyCourses.contains(ar.courseCode)) { // Check if attendance record matches a course taught by faculty
                System.out.printf("%-12s %-10s %-12s %-10s\n", ar.studentUsername, ar.courseCode, ar.date, ar.isPresent ? "PRESENT" : "ABSENT"); // Print row
                found = true; // Mark found flag as true
            } // Close if conditional block
        } // Close for loop iteration block
        if (!found) { // Check if no records were found
            System.out.println("No attendance records found for your scheduled courses."); // Print message when no records exist
        } // Close if conditional block
    } // Close displayFacultyCourseAttendances method block
    private static void displayStudentAttendance(String studentUsername) { // Define method to calculate and display student attendance
        System.out.println("\n------------- YOUR ATTENDANCE RECORD -------------"); // Print attendance record header banner
        int totalClasses = 0; // Initialize total classes counter variable
        int attendedClasses = 0; // Initialize attended classes counter variable
        System.out.printf("%-10s %-12s %-10s\n", "COURSE", "DATE", "STATUS"); // Print formatted table columns
        System.out.println("------------------------------------"); // Print table divider line
        for (AttendanceRecord ar : attendances) { // Iterate through all recorded attendances
            if (ar.studentUsername.equalsIgnoreCase(studentUsername)) { // Check if record belongs to current student
                System.out.printf("%-10s %-12s %-10s\n", ar.courseCode, ar.date, ar.isPresent ? "PRESENT" : "ABSENT"); // Print attendance entry
                totalClasses++; // Increment total classes count
                if (ar.isPresent) { // Check if student was present
                    attendedClasses++; // Increment attended classes count
                } // Close if conditional block
            } // Close if conditional block
        } // Close for loop iteration block
        System.out.println("------------------------------------"); // Print summary divider line
        if (totalClasses > 0) { // Check if total classes count is greater than zero
            double percentage = ((double) attendedClasses / totalClasses) * 100.0; // Calculate attendance percentage
            System.out.printf("Total Sessions: %d | Attended: %d | Attendance Percentage: %.2f%%\n", totalClasses, attendedClasses, percentage); // Print summary metrics
        } else { // Handle case with no attendance recorded
            System.out.println("No attendance records found for your account."); // Print message indicating zero records
        } // Close if-else conditional block
    } // Close displayStudentAttendance method block
    private static void displayAllAttendances() { // Define method for admin to inspect all institutional attendance records
        System.out.println("\n------------- MASTER STUDENT ATTENDANCE RECORDS -------------"); // Print master attendance header banner
        if (attendances.isEmpty()) { // Check if attendance records list is empty
            System.out.println("No attendance records found in system."); // Print message when empty
            return; // Return early from method
        } // Close if conditional block
        System.out.printf("%-14s %-10s %-12s %-10s\n", "STUDENT", "COURSE", "DATE", "STATUS"); // Print formatted table columns
        System.out.println("--------------------------------------------------"); // Print table divider line
        for (AttendanceRecord ar : attendances) { // Iterate through all attendance entries
            System.out.printf("%-14s %-10s %-12s %-10s\n", ar.studentUsername, ar.courseCode, ar.date, ar.isPresent ? "PRESENT" : "ABSENT"); // Print record details
        } // Close for loop iteration block
    } // Close displayAllAttendances method block
    private static void addNewAcademicActivity(Scanner scanner, String adminName) { // Define method to schedule an academic activity
        System.out.println("\n--- SCHEDULE ACADEMIC ACTIVITY ---"); // Print scheduling activity header banner
        System.out.print("Enter Activity Title: "); // Prompt for activity title
        String title = scanner.nextLine().trim(); // Read title string from input
        System.out.print("Enter Date (YYYY-MM-DD): "); // Prompt for activity date
        String date = scanner.nextLine().trim(); // Read date string from input
        System.out.print("Enter Time Slot: "); // Prompt for activity time slot
        String time = scanner.nextLine().trim(); // Read time string from input
        System.out.print("Enter Venue: "); // Prompt for venue location
        String venue = scanner.nextLine().trim(); // Read venue string from input
        System.out.print("Enter Organizing Body: "); // Prompt for organizing entity
        String organizer = scanner.nextLine().trim(); // Read organizer string from input
        activities.add(new AcademicActivity(title, date, time, venue, organizer.isEmpty() ? adminName : organizer)); // Add activity to list
        System.out.println("[SUCCESS] Academic activity '" + title + "' scheduled successfully!"); // Print confirmation message
    } // Close addNewAcademicActivity method block
    private static void displayAcademicActivities() { // Define method to display all scheduled academic activities
        System.out.println("\n----------------------- ACADEMIC ACTIVITIES & EVENTS CALENDAR -----------------------"); // Print calendar header banner
        if (activities.isEmpty()) { // Check if activities list is empty
            System.out.println("No academic activities currently scheduled."); // Print message when list is empty
            return; // Return early from method
        } // Close if conditional block
        System.out.printf("%-26s %-12s %-22s %-18s %-22s\n", "ACTIVITY TITLE", "DATE", "TIME", "VENUE", "ORGANIZER"); // Print formatted table columns
        System.out.println("---------------------------------------------------------------------------------------------------------"); // Print divider line
        for (AcademicActivity act : activities) { // Iterate through all academic activities
            System.out.printf("%-26s %-12s %-22s %-18s %-22s\n", act.title, act.date, act.time, act.venue, act.organizer); // Print activity details row
        } // Close for loop iteration block
    } // Close displayAcademicActivities method block
} // Close TimeManagementSystem class definition
