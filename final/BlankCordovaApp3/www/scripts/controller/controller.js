app1.controller('LoginController', ['$scope','$rootScope','$location', 'AUTH_EVENTS', 'AuthService', function ($scope,$rootScope,$location,AUTH_EVENTS,AuthService) {
    $scope.pop = "pp";
    $scope.credentials = {
        practitioner: '',
        username: '',
        passwd:''
    };
    $scope.login = function () {
        console.log($scope.credentials.practitioner);
        AuthService.login($scope.credentials).then(function (user) {
            $rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
            $scope.setCurrentUser(user);
            if (user.role == 'specializedDoctor' || user.role == 'fieldDoctor') {
                $location.path('/home');
            }
            else {
                $location.path('/patientReg');
            }
        }, function () {
            $rootScope.$broadcast(AUTH_EVENTS.loginFailed);
            alert('Invalid credentials');
        });
    };
       
}]);
