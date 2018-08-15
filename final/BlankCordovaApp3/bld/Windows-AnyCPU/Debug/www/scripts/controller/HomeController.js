app2.controller('HomeController', ['$scope', 'patient', '$rootScope', '$location', function ($scope, patient, $rootScope, $location) {
    $scope.patientId = "";
    $scope.search = function () {
        console.log($scope.patientId);
        patient.getDetails($scope.patientId).then(function (res) {
            $rootScope.CurrentPatientId=res.data.patient.id;
            $rootScope.patient=res.data.patient;
            $location.path('/patient/:id');
        }, function () {
            alert('Invalid Patient Id');
        });
    };
}]);