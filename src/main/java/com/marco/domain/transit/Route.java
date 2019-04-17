package com.marco.domain.transit;

public class Route {
    private String routeArea;
    private String routeName;

    private Route() {
    }

    private Route(Builder builder){
        this.routeArea = builder.routeArea;
        this.routeName = builder.routeName;
    }

    public String getRouteArea() {
        return routeArea;
    }

    public String getRouteName() {
        return routeName;
    }

    public static class Builder{
        private String routeArea;
        private String routeName;

        public Builder routeArea(String routeArea){
            this.routeArea = routeArea;
            return this;
        }

        public Builder routeName(String routeName){
            this.routeName = routeName;
            return this;
        }

        public Route build(){return new Route(this);}
    }
}
