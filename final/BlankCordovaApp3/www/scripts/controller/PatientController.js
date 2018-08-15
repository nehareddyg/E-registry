app2.controller('PatientController', ['$scope','$rootScope','$location', function ($scope,$rootScope,$location) {
    $scope.caseForm = function () {
        if (!$rootScope.patient.isCaseFormFilled) {
            $location.path('/caseForm');
        }
        else {
            $location.path('/viewCaseForm');
        }
    };
    $scope.followUp = function () {
        $location.path('/followUpList');
    };
    $scope.prescription = function () {
        $location.path('/Prescription');
    };
}]);