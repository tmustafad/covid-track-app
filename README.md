# Covid Tracker Application

## The tech stack

![](springboot.jpeg)  ![](heroku.png)  ![](theymeleaf.png)

This is a single SpringBoot module which is built by maven  and fetch the global covid data from the api which is provided by  Johns Hopkins CSSE.

The fetch operation is achieved by Spring RestTemplate, a scheduled cron job is run on every night at 1 AM and gather the data.This Data is kept on Repository level in a singelton bean and UI is populated accordingly.

Theymeleaf template engine together with Bootstrap and Jquery is used on UI side.

## Third Party Covid Data API
https://covid19api.com/#

https://documenter.getpostman.com/view/10808728/SzS8rjbc?version=latest



## Instructions

To compile (also runs unit tests)

```
mvn package
```

## To run the application manually

```
mvn spring-boot:run
```
## Url to access the app on localhost

 http://localhost:9000/

## To run integration tests

```
mvn spring-boot:run
mvn verify
```

## To build and deploy the application to Heroku 

To make the application ready for deployment we need to use heroku maven plugin and the corresponding application with the same exact name should be created on heroku.

Below is the plugin declaration in pom.xml

```
           <plugin>
                <groupId>com.heroku.sdk</groupId>
                <artifactId>heroku-maven-plugin</artifactId>
                <configuration>
                    <appName>covid-track-turkmen</appName>

                    <processTypes>
                        <web>java $JAVA_OPTS -cp target/classes:target/dependency/*
                            com.turkmen.covidtrack.CovidTrackApplication
                        </web>
                    </processTypes>
                </configuration>
            </plugin>
```

Below is the command to deploy the ready-to-go app to heroku
```
mvn clean heroku:deploy

```



## Heroku Url which is accessible on web


https://covid-track-turkmen.herokuapp.com/





