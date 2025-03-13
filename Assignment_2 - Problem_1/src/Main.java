public class Main{
    public static void main(String[] args){
        System.out.println("------------- ASSIGNMENT 2 -------------");

        // Test the addPage() method
        BrowserHistory visitedPages = new BrowserHistory(); // Initialize a Browser History.
        visitedPages.addPage("https//ahsesi.apps.com_01", "10:03 AM_01");
        visitedPages.addPage("https//ahsesi.apps.com_02", "10:03 AM_02");
        visitedPages.addPage("https//ahsesi.apps.com_03", "10:03 AM_03");
        visitedPages.addPage("https//ahsesi.apps.com_04", "10:03 AM_04");

        System.out.println("Before removal...!");
        visitedPages.displayHistoryForward();

        System.out.println("\n");

        // Test the removePage() method
        visitedPages.removePage("10:03 AM_02");
        System.out.println("After removal...!");
        visitedPages.displayHistoryForward();

        // Test the displayHistoryBackward() method:
        System.out.println("\n");
        visitedPages.displayHistoryBackward();

        System.out.println("\n\nEND OF PROGRAM!\n");
    }
}