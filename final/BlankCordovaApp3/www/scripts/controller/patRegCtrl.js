app2.controller('PatRegController', ['$scope', 'patientRegistry', function ($scope, patientRegistry) {
  
    $scope.reset = function () {
        $scope.patient = "";
        //$scope.patient = angular.copy({});
        $scope.form.$setPristine();
        $scope.form.$setUntouched();
    };

    $scope.submitForm = function (patient) {
        var alerts = ["Successful Submission", "Failed Submission"];
        patientRegistry.create(patient).then(function successCallback(res) {
            $scope.showMe = true;
            console.log(res.status);
            $scope.alert = alerts[0];
        }, function errorCallback(res) {
            $scope.showMe = true;
            $scope.alert = alerts[1];
        });
        $scope.reset();
    }
}]);