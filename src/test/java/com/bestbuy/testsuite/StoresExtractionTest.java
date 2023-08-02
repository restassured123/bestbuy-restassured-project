package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/Stores")
                .then().statusCode(200);
    }

    //Extract the limit
    @Test
    public void test001() {
        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }

    //Extract the total
    @Test
    public void test002() {
        int total = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    //Extract the name of 5th store
    @Test
    public void test003() {
        String name = response.extract().path("data[4].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of 5th store is : " + name);
        System.out.println("------------------End of Test---------------------------");

    }

    //Extract the names of all the store
    @Test
    public void test004() {
        List<String> allStoreName = response.extract().path("data.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of 5th store is : " + allStoreName);
        System.out.println("------------------End of Test---------------------------");
    }

    //Extract the storeId of all the store
    @Test
    public void test005() {
        List<Integer> allStoreId = response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Extract the storeId of all the store : " + allStoreId);
        System.out.println("------------------End of Test---------------------------");
    }

    //Print the size of the data list
    @Test
    public void test006() {
        List<Integer> dataList = response.extract().path("data.list");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of the Data List is : " + dataList.size());
        System.out.println("------------------End of Test---------------------------");

    }

    //Get all the value of the store where store name = St Cloud
    @Test
    public void test007() {
        List<Integer> storeName = response.extract().path("data.findAll{it.name == 'St Cloud'}");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get all the value of the store where store name = St Cloud : " + "\n" + storeName);
        System.out.println("------------------End of Test---------------------------");
    }

    //Get the address of the store where store name = Rochester
    @Test
    public void test008() {
        String storeAddress = response.extract().path("data[8].address");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get the address of the store where store name = Rochester : " + storeAddress);
        System.out.println("------------------End of Test---------------------------");
    }

    //Get all the services of 8th store
    @Test
    public void test009() {
        List<Integer> allServices = response.extract().path("data[8].services");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get all the services of 8th store : " + "\n" + allServices);
        System.out.println("------------------End of Test---------------------------");
    }

    //Get storeservices of the store where service name = Windows Store
    @Test
    public void test010() {
        List<HashMap<String, ?>> services = response.extract().path("data.services*.find{it.name=='Windows Store'}.storeservices");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get storeservices of the store where service name = Windows Store" + services);
        System.out.println("------------------End of Test---------------------------");
    }

    //11. Get all the storeId of all the store
    @Test
    public void test11() {
        List<Object> storeId = response.extract().path("data.services.storeservices.storeId");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get all the storeId of all the store : " + storeId);
        System.out.println("------------------End of Test---------------------------");
    }

    //12. Get id of all the store
    @Test
    public void test12() {
        List<Integer> storeId = response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get id of all the store : " + storeId);
        System.out.println("------------------End of Test---------------------------");
    }

    //13. Find the store names Where state = ND
    @Test
    public void test13() {
        List<String> storeNames = response.extract().path("data.findAll{it.state == 'ND'}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get id of all the store : " + storeNames);
        System.out.println("------------------End of Test---------------------------");
    }

    //14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void test14() {
        List<Integer> totalNumberOfServices = response.extract().path("data.findAll{it.name=='Rochester'}.services");
        //List<Integer> totalNumberOfServices= response.extract().path("data[8].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Find the Total number of services for the store where store name = Rochester : " + "\n" + totalNumberOfServices);
        System.out.println("------------------End of Test---------------------------");
    }

    //15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void test15() {
        String createAtAllServices = response.extract().path("data[2].services[8].createdAt");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Find the createdAt for all services whose name = 'Windows Store' : " + createAtAllServices);
        System.out.println("------------------End of Test---------------------------");
    }

    //16. Find the name of all services Where store name = “Fargo”
    @Test
    public void test16() {
        List<String> nameOfAllServices = response.extract().path("data[7].services.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the name of all services Where store name = 'Fargo' :  " + nameOfAllServices);
        System.out.println("------------------End of Test---------------------------");

    }

    //  17. Find the zip of all the store
    @Test
    public void test17() {
        List<Integer> zipOfAllStore = response.extract().path("data.zip");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Find the zip of all the store :" + zipOfAllStore);
        System.out.println("------------------End of Test---------------------------");

    }
     //18. Find the zip of store name = Roseville
     @Test
     public void test18() {
         String zipOfStoreRoseville = response.extract().path("data[2].zip");

         System.out.println("------------------StartingTest---------------------------");
         System.out.println("Find the zip of store name = Roseville : " + zipOfStoreRoseville);
         System.out.println("------------------End of Test---------------------------");

     }
    //19. Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void test19() {
        List<Integer> storeServicesDetails = response.extract().path("data.findAll{it.services.name == 'Magnolia Home Theater'}.storeservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Find the storeservices details of the service name = Magnolia Home Theater : " + storeServicesDetails);
        System.out.println("------------------End of Test---------------------------");
    }
    //20. Find the lat of all the stores
    @Test
    public void test20() {
        List<Integer> allDataIat = response.extract().path("data.lat");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Find the lat of all the stores : " + allDataIat);
        System.out.println("------------------End of Test---------------------------");
    }

}

