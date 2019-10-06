package com.marco.domain.transit;

import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Route {
    @Id
    private int routeAreaCode;
    private String routeName;

    private Route() {
    }

    private Route(Builder builder){
        this.routeAreaCode = builder.routeAreaCode;
        this.routeName = builder.routeName;
    }

    public int getRouteAreaCode() {
        return routeAreaCode;
    }

    public String getRouteName() {
        return routeName;
    }

    public static class Builder{
        private int routeAreaCode;
        private String routeName;

        public Builder routeAreaCode(int routeAreaCode){
            this.routeAreaCode = routeAreaCode;
            return this;
        }

        public Builder routeName(String routeName){
            this.routeName = routeName;
            return this;
        }

        public Builder copy(Route route){
            this.routeAreaCode = route.routeAreaCode;
            this.routeName = route.routeName;

            return this;
        }

        public Route build(){return new Route(this);}
    }
}
