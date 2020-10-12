package com.jitendera.covidninteenbyjmietiarya;

public class StateModel {

   // private String flag;
    private String state;
    private String cases;
    //private String todayCases;
    private String deaths;
   // private String todayDeaths;
    private String recovered;
    private String active;
    private String ActiveForeign;

    public String getActiveForeign() {
        return ActiveForeign;
    }

    public void setActiveForeign(String activeForeign) {
        ActiveForeign = activeForeign;
    }



    public StateModel(String state, String cases,String activeForeign, String recovered, String deaths,
                       String active){
      //  this.flag = flag;
        this.state = state;
        this.cases = cases;
      //  this.todayCases = todayCases;
        this.deaths = deaths;
    //    this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.active = active;
        this.ActiveForeign = activeForeign;

       // this.critical = critical;
    }

    //------------------------------getter and setter for state model---------------------------------------

   /* public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }*/

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

  /*  public String getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(String todayCases) {
        this.todayCases = todayCases;
    }*/

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

   /* public String getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(String todayDeaths) {
        this.todayDeaths = todayDeaths;
    }*/

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

   /* public String getCritical() {
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }*/



}
