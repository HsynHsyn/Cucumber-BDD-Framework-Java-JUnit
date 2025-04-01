package projectEvri.uiAutomation.pages;


import projectEvri.uiAutomation.utilities.Driver;


/**
 * Initializes page objects for the UI automation framework.
 * This class creates instances of all page classes for test execution.
 */
public class PageInitializer extends Driver {

    public static DashboardPage dashboardPage;
    public static HomePage homePage;

    public static void initialize(){
        dashboardPage = new DashboardPage();
        homePage = new HomePage();
    }


}
