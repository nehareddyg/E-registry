app.controller('ApplicationController', function ($scope,$rootScope,
                                               USER_ROLES,$location,
                                               AuthService) {
    $scope.currentUser = null;
    $scope.CurrentPatientId = null;
    $scope.nav = true;
    $scope.home_bool = true;
    $scope.userRoles = USER_ROLES;
    $scope.isAuthorized = AuthService.isAuthorized;
    console.log($scope.userRoles);
    console.log($scope.isAuthorized);
    $scope.home = function () {
        $location.path('/home');
        $rootScope.patient = null;
        $scope.CurrentPatientId = null;
    };
    $scope.logout = function () {
        $location.path('/');
        $rootScope.patient = null;
        $scope.CurrentPatientId = null;
        $scope.curretUser = null;
        $scope.nav = true;
    };
    $scope.setCurrentUser = function (user) {
        $scope.currentUser = user;
        if (user.role == 'specializedDoctor' || user.role == 'fieldDoctor') {
            $scope.home_bool = false;
        }
        $scope.nav = false;
    };
    $scope.setCurrentPatientId = function (id) {
        $scope.CurrentPatientId = id;
    };
})