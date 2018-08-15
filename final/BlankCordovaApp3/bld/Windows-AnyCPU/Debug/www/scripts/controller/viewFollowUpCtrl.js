app4.controller('viewFollowUpCtrl', ['$scope', '$rootScope', '$location', '$filter', 'getFolUp', function ($scope, $rootScope, $location, $filter, getFolUp) {
    getFolUp.getDetails($rootScope.patient.id).then(function (res) {
        ///hard coding
        $scope.data = res.data[0].followUpReport;
        $scope.location = res.data[0].location;
        $scope.date = res.data[0].date;
        $scope.data.nextDate = $filter('date')(res.data[0].followUpReport.nextDate, 'MMM d, y');
        $scope.name = res.data[0].practitioner.name;
    });
    $scope.back = function () {
        $location.path('/followUpList');
    };
}]);