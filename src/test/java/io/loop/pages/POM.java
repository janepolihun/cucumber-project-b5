package io.loop.pages;

public class POM {

    private LoginPage loginPage;
    private GoogleSearchPage googleSearchPage;
    private HomePage homePage;
    private ProductPage productPage;
    private WikiSearchPage wikiSearchPage;
    private ReceivedDocPage receivedDocPage;
    private LeftNavigatePage leftNavigatePage;
    //private LeftNavigatePageDay14 day14_leftNavigatePagesDocuport;
    private MyUploadsPage myUploadsPage;

    public LoginPage getLoginPage() {
        if (loginPage == null){
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public GoogleSearchPage getGoogleSearchPage() {
        if (googleSearchPage == null){
            googleSearchPage = new GoogleSearchPage();
        }
        return googleSearchPage;
    }

    public HomePage getHomePage() {
        if(homePage == null){
            homePage = new HomePage();
        }
        return homePage;
    }

    public ProductPage getProductPage() {
        if(productPage == null){
            productPage = new ProductPage();
        }
        return productPage;
    }

    public WikiSearchPage getWikiSearchPage() {
        if(wikiSearchPage == null){
            wikiSearchPage = new WikiSearchPage();
        }
        return wikiSearchPage;
    }

    public ReceivedDocPage getReceivedDocPage() {
        if (receivedDocPage == null){
            receivedDocPage = new ReceivedDocPage();
        }
        return receivedDocPage;
    }

    public LeftNavigatePage getleftNavigatePage() {
        if (leftNavigatePage == null){
            leftNavigatePage = new LeftNavigatePage();
        }
        return leftNavigatePage;
    }

//    public LeftNavigatePageDay14 getLeftNavigatePageDay14() {
//
//        if (day14_leftNavigatePagesDocuport == null){
//            day14_leftNavigatePagesDocuport = new LeftNavigatePageDay14();
//        }
//        return day14_leftNavigatePagesDocuport;
//    }

    public MyUploadsPage getMyUploadsPage() {
         if (myUploadsPage == null){
             myUploadsPage = new MyUploadsPage();
         }
        return myUploadsPage;

    }
}
