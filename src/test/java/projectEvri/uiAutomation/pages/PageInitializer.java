package projectEvri.uiAutomation.pages;


import projectEvri.uiAutomation.utilities.Driver;

public class PageInitializer extends Driver {

    /**
     * PageInitializer is responsible for initializing page objects.
     * It creates instances of all page classes to be used in test execution.
     */
    public static DashboardPage dashboardPage;
    public static HomePage homePage;

    public static void initialize(){
        dashboardPage = new DashboardPage();
        homePage = new HomePage();
    }



}
