//package com.marco.repository.transit.transitrepo;
//
//import com.marco.domain.transit.Route;
//import com.marco.factory.transit.RouteFactory;
//import org.junit.*;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Optional;
//import java.util.Set;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class RouteRepositoryImplTest {
//    @Autowired
//    private RouteRepository repository;
//    private Route route;
//
//    private Route getRepo(){
//        for(Route routeA : repository.findAll()){
//            if(routeA.getRouteAreaCode() == route.getRouteAreaCode()){
//                return routeA;
//            }
//        }
//        return null;
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        route = RouteFactory.buildRoute(1, "NorthernLine");
//    }
//
//    @Test
//    public void d_getAllRoutes() {
//        Set<Route> arrayList = (Set<Route>) repository.findAll();
//        Assert.assertEquals(1, arrayList.size());
//    }
//
//    @Test
//    public void a_create() {
//        Route routeTest = this.repository.save(route);
//
//        Assert.assertEquals(route, routeTest);
//    }
//
//    @Test
//    public void c_update() {
//        Assert.assertNotNull(getRepo());
//        String routeName = "SouthernLine";
//        Route updated = new Route.Builder().copy(getRepo()).routeName(routeName).build();
//
//        this.repository.save(updated);
//
//        Assert.assertEquals(routeName, updated.getRouteName());
//        System.out.println("Route updated");
//    }
//
//    @Test
//    public void e_delete() {
//        repository.deleteById(route.getRouteAreaCode());
//        Set<Route> routes = (Set<Route>) repository.findAll();
//        Assert.assertEquals(0, routes.size());
//    }
//
//    @Test
//    public void b_read() {
//        Optional<Route> routeRead = repository.findById(1);
//        Assert.assertTrue(routeRead.isPresent());
//        Assert.assertEquals(route.getRouteAreaCode(), routeRead.get().getRouteAreaCode());
//    }
//}