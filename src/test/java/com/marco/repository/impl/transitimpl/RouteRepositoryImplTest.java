package com.marco.repository.impl.transitimpl;

import com.marco.domain.transit.Route;
import com.marco.factory.transit.RouteFactory;
import com.marco.repository.repositoryinterfaces.transitrepo.RouteRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RouteRepositoryImplTest {
    private RouteRepository repository;
    private Route route;

    @Before
    public void setUp() throws Exception {
        this.repository = RouteRepositoryImpl.getRepository();
        route = RouteFactory.getRoute(1, "NorthernLine");
        this.repository.create(route);
    }

    @After
    public void tearDown() throws Exception {
        ArrayList<Route> arrayList = repository.getAllRoutes();
        arrayList.clear();
    }

    @Test
    public void getAllRoutes() {
        ArrayList<Route> arrayList = repository.getAllRoutes();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void create() {
        Route route = RouteFactory.getRoute(2, "SouthernLine");
        Route routeTest = this.repository.create(route);

        Assert.assertEquals(route, routeTest);
    }

    @Test
    public void update() {
        Route route = RouteFactory.getRoute(1, "NorthernLine");
        this.repository.update(route);

        ArrayList<Route> routes = repository.getAllRoutes();
        Assert.assertTrue(routes.contains(route));
        System.out.println("Route updated");
    }

    @Test
    public void delete() {
        repository.delete(route);
        ArrayList<Route> routes = repository.getAllRoutes();
        Assert.assertEquals(0, routes.size());
    }

    @Test
    public void read() {
        Route routeList = repository.read(1);
        Assert.assertEquals(routeList, route);
    }
}