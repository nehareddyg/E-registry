app4.controller('newFollowUpCtrl', ['$scope', '$rootScope', '$location', '$filter', 'createFolUp', function ($scope, $rootScope, $location, $filter, createFolUp) {
    $scope.dateOptions = { // pass jQueryUI DatePicker options through
        changeYear: false,
        changeMonth: false,
        dateFormat: 'D, d MM, yy'
    }
    $scope.reset = function () {
        $scope.data = angular.copy({});
        $scope.form.$setPristine();
        $scope.form.$setUntouched();
    };

    $scope.submitForm = function (data) {
        var formatDate = $filter('date')(data.date, "yyyy-MM-dd");
        console.log(formatDate);
        console.log($rootScope.patient.id);
        console.log($scope.currentUser.id);
        createFolUp.create(data, formatDate, $rootScope.patient.id, $scope.currentUser.id).then(function successCallback(res) {
            console.log(res.status);
        });
        $scope.reset();
    }

    $scope.back = function () {
        $location.path('/followUpList');
    };
}]);