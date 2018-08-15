app4.controller('followUpListCtrl', ['$scope', '$filter','$rootScope', '$location', 'getFolUpList', function ($scope, $filter, $rootScope, $location, getFolUpList) {
    getFolUpList.getDetails($rootScope.patient.id).then(function (res) {
        $scope.List = res.data;
    });
    $scope.view = function () {
        $location.path('/viewFollowUp');
    };
    $scope.back = function () {
        $location.path('/patient/:id');
    };
    $scope.newFollowUp = function () {
        $location.path('/newFollowUp');
    };
}]);