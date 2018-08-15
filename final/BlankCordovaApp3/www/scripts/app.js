
var app1 = angular.module('Authentication', []);
var app = angular.module('PatRegApp', ['Authentication', 'Patient','ui.date','ngRoute']);
var app2 = angular.module('Patient', ['CaseForm','FollowUp']);
var app3 = angular.module('CaseForm', ['ngFileSaver']);
app3.config(['$compileProvider',
    function ($compileProvider) {
        $compileProvider.aHrefSanitizationWhitelist(/^\s*(https?|ftp|mailto|tel|file|blob):/);
    }]);
/*
app3.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;

            element.bind('change', function () {
                scope.$apply(function () {
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);
*/
var app4 = angular.module('FollowUp', []);

app.config(function ($routeProvider) {
    $routeProvider
    .when('/', {
        controller: 'LoginController',
        templateUrl: 'scripts/views/login.html',
    })
    .when('/patientReg', {
        controller: 'PatRegController',
        templateUrl: 'scripts/views/patientReg.html',
    })
    .when('/home', {
        controller: 'HomeController',
        templateUrl: 'scripts/views/home.html',
    })
    .when('/patient/:id', {
        controller: 'PatientController',
        templateUrl: 'scripts/views/patientDetails.html'
    })
    .when('/viewCaseForm', {
         controller: 'viewCaseFormCtrl',
         templateUrl: 'scripts/views/viewCaseForm.html'
    })
    .when('/caseForm', {
        controller: 'newCaseFormCtrl',
         templateUrl: 'scripts/views/caseForm.html'
    })
    .when('/followUpList', {
         controller: 'followUpListCtrl',
         templateUrl: 'scripts/views/followUpList.html'
    })
    .when('/newFollowUp', {
        controller: 'newFollowUpCtrl',
        templateUrl: 'scripts/views/newFollowUp.html'
    })
    .when('/viewFollowUp', {
        controller: 'viewFollowUpCtrl',
        templateUrl: 'scripts/views/followUpDetails.html'
    })
    .otherwise({
         redirectTo: '/home'
       });
});

