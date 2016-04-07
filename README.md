# Cordova android plugin for share browser web url with in the app.(Content Handler Plugin)
 
## Master branch:
 
 ```
cordova plugin add https://github.com/LokeshPatel/Cordova-Plugin-ContentHandler.git
 ```
## local folder:

 ``` 
cordova plugin add Cordova-Plugin-ContentHandler --searchpath path

```

## 1) Check is app run (Active) with share option : on Resume function

 ```
     navigator.contenthandle.isAppActiveWithShareIntent(function(a){
       console.log(a); // if app Active with share event
      },function(a){
        console.log(a);  // if app Active other event
       });
 ``` 


## 2) Get web page url

 ```
     navigator.contenthandle.getWebUrl(function(a){
       console.log(a.webUrl)
      },function(a){
       console.log(a)
       });
 ``` 


